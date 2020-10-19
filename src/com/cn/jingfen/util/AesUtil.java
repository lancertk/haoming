package com.cn.jingfen.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/****************************************************************  
 * <p>Filename:    AesUtil.java 
 * <p>Description:	 Aes加密算法工具类
 * <p>
 * <p>Create at:   2020/2/20 15:33
 * <p> 
 * <p>Modification History:  
 * <p>Date          Author  Version   Description  
 * <p>------------------------------------------------------------------  
 * <p>2020/2/20    kehao     1.0        
 * <p>------------------------------------------------------------------
 *
 * @author kehao
 * @version 1.0
 * @since
 *******************************************************************/

public class AesUtil {
    private IvParameterSpec iv;

    public AesUtil(String iv) {
        this.iv = new IvParameterSpec(iv.getBytes());
    }

    private byte[] encrypt(String content, String strKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        return cipher.doFinal(content.getBytes());
    }

    private String decrypt(byte[] content, String strKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(content);
        return new String(original);
    }

    private SecretKeySpec getKey(String strKey) throws UnsupportedEncodingException {
        byte[] arrBTmp = strKey.getBytes("UTF-8");
        byte[] arrB = new byte[16];

        for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); ++i) {
            arrB[i] = arrBTmp[i];
        }
        return new SecretKeySpec(arrB, "AES");
    }

    private String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    private byte[] base64Decode(String base64Code) throws IOException {
        return ((base64Code.isEmpty()) ? null : new BASE64Decoder().decodeBuffer(base64Code));
    }

    public String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(encrypt(content, encryptKey));
    }

    public String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return ((encryptStr.isEmpty()) ? null : decrypt(base64Decode(encryptStr), decryptKey));
    }
}
