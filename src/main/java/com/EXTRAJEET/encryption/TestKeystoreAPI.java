package com.EXTRAJEET.encryption;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * This Class is used to getting key from key store and set the keys from file
 * into Key store.
 * 
 * @author Sridhar Jena
 */

public class TestKeystoreAPI {
    private static final String keyStorePassword = "001118E36d5b7be6eedc5bd5fec368494620fee8";//"success2oo6";
    private static final String alias = "0006DB5Aa74aaf88f08b1ab69b6359ee44c75d9a";//"vayusa";

    public void setKeyEntryInKeyStore(SecretKey key, KeyStore keyStore) {
        try {
            Certificate[] chain = new Certificate[1];
            char[] passwd = new char[keyStorePassword.length()];
            keyStorePassword.getChars(0, keyStorePassword.length(), passwd, 0);
            keyStore.setKeyEntry(alias, key, passwd, chain);
        } catch (KeyStoreException e) {
            System.out.println("KeyStoreException in setKeyEntryInKeyStore:"+ e);
        }
    }

    public SecretKeySpec getKeyFromKeyStore(KeyStore keyStore) {
        SecretKeySpec key = null;
        try {
            char[] passwd = new char[keyStorePassword.length()];
            keyStorePassword.getChars(0, keyStorePassword.length(), passwd, 0);
            key = (SecretKeySpec) (keyStore.getKey(alias, passwd));
        } catch (KeyStoreException e) {
            System.out.println("KeyStoreException in getKeyFromKeyStore:"+ e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException in getKeyFromKeyStore:"+ e);
        } catch (UnrecoverableKeyException e) {
            System.out.println("UnrecoverableKeyException in getKeyFromKeyStore :"+ e);
        } catch (Exception e) {
            System.out.println("Exception in getKeyFromKeyStore:"+ e);
        }
        return key;

    }

    public KeyStore newKeyStore() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JCEKS", "SunJCE");
            char[] passwd = new char[keyStorePassword.length()];
            keyStorePassword.getChars(0, keyStorePassword.length(), passwd, 0);
            keyStore.load(null, passwd);
        } catch (KeyStoreException e) {
            System.out.println("KeyStoreException in getKeyFromKeyStore:"+ e);
        } catch (NoSuchProviderException e) {
            System.out.println("NoSuchProviderException in getKeyFromKeyStore:"+ e);
        } catch (java.security.cert.CertificateException e) {
            System.out.println("CertificateException in getKeyFromKeyStore:"+ e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException in getKeyFromKeyStore:"+ e);
        } catch (IOException e) {
            System.out.println("IOException in getKeyFromKeyStore:"+ e);
        }
        return keyStore;
    }
}
