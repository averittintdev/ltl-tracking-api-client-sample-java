package com.averitt.clientsamples;

import com.averitt.clientsamples.entity.ProDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestController
public class MainController
{
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private final PublicKey publicKey;

    public MainController(@Value("${public.key}") String publicKeyStr)
        throws NoSuchAlgorithmException,
               InvalidKeySpecException
    {
        byte[] publicBytes = Base64.getDecoder().decode(publicKeyStr.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        this.publicKey = keyFactory.generatePublic(keySpec);
    }

    @PutMapping("/shipments")
    public ResponseEntity<Void> updateShipment(@RequestHeader Map<String, String> headers,
                                               @RequestBody ProDetails proDetails)
    {
        log.info("Update Shipment ... proDetails : " + proDetails);

        headers.forEach((key, value) -> log.info(String.format("Header '%s' = %s", key, value)));

        String signature = "";

        String authorization = headers.get("authorization");

        Pattern signaturePattern = Pattern.compile(".signature=\"(.*)\"");
        Matcher signatureMatcher = signaturePattern.matcher(authorization);
        if (signatureMatcher.find()) {
            signature = signatureMatcher.group(1);
        }

        String digest = headers.get("digest");
        String date = headers.get("date");
        String host = headers.get("host");

        String inputStr = host + date + digest;
        log.info("inputStr : " + inputStr);
        log.info("signature : " + signature);

        byte[] input = inputStr.getBytes();
        boolean isLegit = false;

        try {
            isLegit = isLegitDigitalSignature(input, Base64.getDecoder().decode(signature), publicKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException ex) {
            log.error("",ex);
        }

        log.info("isLegit : " + isLegit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static boolean isLegitDigitalSignature(byte[] input, byte[] signatureToVerify, PublicKey publicKey)
            throws NoSuchAlgorithmException,
                   InvalidKeyException,
                   SignatureException
    {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }
}
