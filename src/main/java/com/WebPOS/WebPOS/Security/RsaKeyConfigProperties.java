package com.WebPOS.WebPOS.Security;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
@ConfigurationProperties(prefix = "rsa")

public record RsaKeyConfigProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey ) {

}