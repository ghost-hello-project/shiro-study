package com.laolang.jx.encrypt.encrypt;

import lombok.experimental.UtilityClass;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

@UtilityClass
public class EncryptUtil {

    public static final String SHA1 = "SHA1";
    public static final Integer ITERATIONS = 1;

    /**
     * sha1 散列
     *
     * @param input 输入
     * @param salt  盐
     * @return 散列后的字符串
     */
    public static String sha1(String input, String salt) {
        return new SimpleHash(SHA1, input, salt, ITERATIONS).toString();
    }

    /**
     * 生成随机盐
     *
     * @return 随机盐
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        return generator.nextBytes().toHex();
    }

    /**
     * 根据明文密码生成 SHA-1 的散列信息对象
     *
     * @param passwordPlain 明文密码
     * @return 散列后的信息
     * @see EncryptInfo
     */
    public static EncryptInfo entryptSha512Password(String passwordPlain) {
        String salt = generateSalt();
        return EncryptInfo.builder()
                .input(passwordPlain)
                .salt(salt)
                .algorithmName(SHA1)
                .password(sha1(passwordPlain, salt))
                .build();
    }
}
