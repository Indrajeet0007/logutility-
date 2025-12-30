package com.EXTRAJEET.encryption;



import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TestEncrypter {
    private static SecretKeySpec skeySpec = null;
    private static SecretKey skeySpec1 = null;
    private static byte[] bytes = null;
    String request = null;
    
    public static String decrypt(String request) {
        String original = "";
        Decoder base64Decode;
        try {
            if ("".equalsIgnoreCase(request.trim()) || request.length() <= 0) {
                original = request;
            } else {
                TestKeystoreAPI ks = new TestKeystoreAPI();
                KeyStore keystore = ks.newKeyStore();
                skeySpec = new SecretKeySpec(readBytes(), "AES");
                ks.setKeyEntryInKeyStore(skeySpec, keystore);
                try {
                    skeySpec1 = ks.getKeyFromKeyStore(keystore);
                } catch (Exception e) {
                    System.out.println("Exception after get:" + e);
                }
                if (null == skeySpec1) {
                    System.out.println("ALIASE/PASSWORD DOES NOT MATCH");
                    throw new UnrecoverableKeyException();
                } else {
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.DECRYPT_MODE, skeySpec1);
                    base64Decode = Base64.getDecoder();
                    byte[] outputBytes = cipher.doFinal(base64Decode.decode(request));
                    original = new String(outputBytes);
                }
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Encrypter:NoSuchAlgorithmException is:=" + e);
        } catch (NoSuchPaddingException nbpe) {
            System.out.println("Encrypter: NoSuchPaddingException is:=" + nbpe);
        } catch (InvalidKeyException ike) {
            System.out.println("Encrypter: InvalidKeyException is:=" + ike);
        } catch (IllegalBlockSizeException ibse) {
            System.out.println("Encrypter: IllegalBlockSizeException is:=" + ibse);
        } catch (BadPaddingException bpe) {
            System.out.println("Encrypter: BadPaddingException is:=" + bpe);
        } catch (UnrecoverableKeyException e) {
            System.out.println("Encrypter: UnrecoverableKeyException is:=" + e);
        }
    	 catch (Exception e) {
        System.out.println("Encrypter:  is:=" + e);
    	}
        skeySpec = null;
//         System.out.println(" DATA DECRYPTION : " + original);
        return original;
    }

    public static byte[] readBytes() {
        byte[] b = { -93, 9, -69, 73, -73, 100, -39, 91, -47, 118, 102, -16, 112, -100, 40, -127 };
        bytes = b;
        return bytes;
    }

   }
