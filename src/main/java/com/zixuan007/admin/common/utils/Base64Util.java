package com.zixuan007.admin.common.utils;

/**
 * @author apple
 */
public class Base64Util {

    /**
     * 使用Base64加密算法加密字符串
     *
     * @param userId
     * @return
     */
    public static String encode(String userId) {
        byte[] b = userId.getBytes();
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        b = base64.encode(b);
        String s = new String(b);
        return s;
    }

    /**
     * 使用Base64加密算法解密字符串
     *
     * @param encodeStr
     */
    public static String decode(String encodeStr) {
        byte[] b = encodeStr.getBytes();
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        b = base64.decode(b);
        String s = new String(b);
        return s;
    }
}
