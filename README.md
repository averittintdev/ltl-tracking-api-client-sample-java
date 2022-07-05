# Java Code Sample for HTTP Signature Verification

---

Initially constructed with JDK 11 and Spring Boot 2.7.0

This code shows how to validate the HTTP signature included in the HTTP header sent to the client's webhook.

To run this locally, please add the "public.key" property to the runtime argument or to the application.properties.  
The value will be the value of the public key located in the .pem with the header (-----BEGIN PUBLIC KEY-----) and 
footer (-----END PUBLIC KEY-----) removed.  Also, the end of line characters should be removed so it appears as a long
sequence of characters.

E.g.  java -jar client-samples-1.0.0.jar --public.key=MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA2cSZkxrq/NwwkkntTX9jF55tCjMSgVvx3Mu/P1SnVmVVBQCJyLl0coi7piKttUAWtZIpCe0io38A2SGIU77+wLXNZRmh+VJDqWwYcd5qc94vlgMi2LX1cTjGMPkJGreYNYiAUqtqikB2/p8Wxf94ur1avP65Qfo+EYBIjjSrIJo8zP19/dWZ2vG8CmXF+IROr+Q+urpojZDkYPM8u4Uf7cS1y65+TzvZx+tVIJEYzubLZIJUR7fRIySurvwHvA84diwRMJVpDzSbo0I9Jit49b3Exae4V1vV5ib2EGJjvJEbePENz2nZlfbHzsDofROnEvUk/3WaZ9tbwz1AdgqL1nPYCCT4ZDFUQTU9awMwVvU6Y+YZuKjn0NHyah1vycItx28CE0LsFi6OHBRMRGsSee+JpCJtGhqF1LupoKnie4v6e2TEW+vsSm47MSL5A54FL+7WgTIUrit9UA2T5rMvxQyZPCvD2Igc4zQ51AsjwX5FikTy7xsVxpjZjBflsqlFS/aV3lEbuwSz9zpJu7pV4FyPtQry8khqIZRx0jvLsuW7FN7wZEnK/2QdknHpwKLcsMqamQDQqVAm9XqMQRTHwBxb7bSiOVvWul5Rquw3RurG4RYTOSIUHW02CCn3X0Bfj7p2mouxL5rbH+lJ6kMUQlA1+EYf23EOIYs0kSzVRhkCAwEAAQ==