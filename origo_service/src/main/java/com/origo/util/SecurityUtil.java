package com.origo.util;



import java.util.Date;



import javax.crypto.Cipher;

import javax.crypto.SecretKey;

import javax.crypto.SecretKeyFactory;

import javax.crypto.spec.PBEKeySpec;

import javax.crypto.spec.PBEParameterSpec;

 

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

 

import com.sun.crypto.provider.SunJCE;

 

public class SecurityUtil {

 

    private static final String ALGORITHM = "PBEWithMD5AndDES";

    private static final String MODE = "CBC";

    private static final String PADDING = "PKCS5Padding";

    private static final String PASSWORD = "Simple Web Application Platform";

 

    private static final String TRANSFORMATION = ALGORITHM + '/' + MODE + '/'

            + PADDING;

 

    private static Cipher eCipher;

    private static Cipher dCipher;

 

    private  static BASE64Encoder encoder = new BASE64Encoder();

    private  static BASE64Decoder decoder = new BASE64Decoder();

 static{
	 
	  java.security.Security.addProvider(new SunJCE());  

      int iterations = 3;

      char[] pass = PASSWORD.toCharArray();

      byte[] salt = { (byte) 0xa3, (byte) 0x21, (byte) 0x24, (byte) 0x2c,

              (byte) 0xf2, (byte) 0xd2, (byte) 0x3e, (byte) 0x19 };

      init(pass, salt, iterations);
 }

   /* public SecurityUtil() throws SecurityException {

 

        java.security.Security.addProvider(new SunJCE());

 

        int iterations = 3;

        char[] pass = PASSWORD.toCharArray();

        byte[] salt = { (byte) 0xa3, (byte) 0x21, (byte) 0x24, (byte) 0x2c,

                (byte) 0xf2, (byte) 0xd2, (byte) 0x3e, (byte) 0x19 };

 

        init(pass, salt, iterations);

    }*/ 

    public static void init(final char[] pass, final byte[] salt, final int iterations)

            throws SecurityException {
        try {
            PBEParameterSpec ps = new PBEParameterSpec(salt, 20);
            SecretKeyFactory kf = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey k = kf.generateSecret(new PBEKeySpec(pass));
            eCipher = Cipher.getInstance(TRANSFORMATION);
            eCipher.init(Cipher.ENCRYPT_MODE, k, ps);
            dCipher = Cipher.getInstance(TRANSFORMATION);
            dCipher.init(Cipher.DECRYPT_MODE, k, ps);
        } catch (Exception e) {
            throw new SecurityException(
                    "CryptoLibrary Initialization failure : " + e.getMessage());
        }
    }
    /**

     *

     */

    public boolean validate(final String value, final String encryptedValue) {

 

        // This is to support plain passwords. Should be removed once encryption

        // is added to user maintenance

        if (value.equals(encryptedValue)) {

            return true;

        }

 

        String dValue = decrypt(encryptedValue);

        return value.equals(dValue);

    }

 

    /**

     *

     * convenience method for encrypting a string.

     *

     * @param str

     *            Description of the Parameter

     *

     * @return String the encrypted string.

     *

     * @exception SecurityException

     *                Description of the Exception

     */

 

    public static synchronized String encrypt(final String str) throws SecurityException {
        String encryptedVal = null;
        try {
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = eCipher.doFinal(utf8);
            encryptedVal = encoder.encode(enc);
        } catch (Exception e) {
            throw new SecurityException("Encrypt Failed : " + e.getMessage());

        }

        return encryptedVal;
    }

 

    /**

     * convenience method for encrypting a string.

     *

     * @param str

     *            Description of the Parameter

     *

     * @return String the encrypted string.

     *

     * @exception SecurityException

     *                Description of the Exception

     */

 

    public static synchronized String decrypt(final String str) throws SecurityException {
        String decryptedVal = null;
        try {
            byte[] dec = decoder.decodeBuffer(str);
            byte[] utf8 = dCipher.doFinal(dec);
            decryptedVal = new String(utf8, "UTF8");
        } catch (Exception e) {
             throw new SecurityException("Decrypt Failed : " +e.getMessage());
            // log it
   //         System.out.println(e.getMessage());
        }
        return decryptedVal;
    }

 

    public static void main(final String[] args) {

 

        try {

 

  //          System.out.println("Start : " + new Date());

        	SecurityUtil cl = new SecurityUtil();

 

            String user = "HARI";

            String pass = "god knows";

 

            String euser = cl.encrypt(user);

            String epass = cl.encrypt(pass);

 

            String duser = cl.decrypt(euser);

            String dpass = cl.decrypt(epass);

 

            System.out.println("User: " + user + " --> " + euser + " --> "

                   + duser);

//

           System.out.println("Pass: " + pass + " --> " + epass + " --> "

                   + dpass);

//

            System.out.println("validate " + cl.validate("HARI", euser));

//

//            System.out.println("End : " + new Date());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}