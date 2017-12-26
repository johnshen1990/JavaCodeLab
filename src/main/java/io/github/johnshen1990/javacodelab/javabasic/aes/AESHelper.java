package io.github.johnshen1990.javacodelab.javabasic.aes;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Author: zhun.shen
 * Date: 2016-05-10 18:45
 * Description:
 * TODO: 加密的方式、key生成的方式
 */
public class AESHelper {
    private static final String ENCODE = "UTF-8";


    public static byte[] encrypt(byte[] plainContent, String password) throws Exception {
        SecretKeySpec aesKey = getSecretKeySpec(password);
        Cipher cipher = getCipher();
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(plainContent);
    }

    public static byte[] decrypt(byte[] encryptedContent, String password) throws Exception {
        SecretKeySpec aesKey = getSecretKeySpec(password);
        Cipher cipher = getCipher();
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(encryptedContent);
    }

    private static Cipher getCipher() throws Exception{
        return Cipher.getInstance("AES/ECB/PKCS5Padding");
    }

    private static SecretKeySpec getSecretKeySpec(String password) throws Exception{
        return new SecretKeySpec(getKey(password), "AES");
    }

    private static byte[] getKey(String password) throws Exception{
        byte[] key = password.getBytes(ENCODE);
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        return Arrays.copyOf(key, 16); // 只取前16字节（128位）
    }

    public static void main(String[] args) {
        try {
            String password = "阿斯顿减哈就收到回复";
            String src = "中华人民共和国";
            byte[] encryptedContent = encrypt(src.getBytes(ENCODE), password);
            System.out.println("加密后十六进制:" + Hex.encodeHexString(encryptedContent));
            byte[] plainContent = decrypt(encryptedContent, password);
            System.out.println("解密后明文内容:" + new String(plainContent, ENCODE));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
