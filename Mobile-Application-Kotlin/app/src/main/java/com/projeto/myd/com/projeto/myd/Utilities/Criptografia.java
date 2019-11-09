package com.projeto.myd.com.projeto.myd.Utilities;

import java.security.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public static String sha256(String textoParaCriptografar) throws Exception {

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(textoParaCriptografar.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
