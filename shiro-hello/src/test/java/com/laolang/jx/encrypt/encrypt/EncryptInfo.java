package com.laolang.jx.encrypt.encrypt;

import lombok.Builder;
import lombok.Data;

/**
 * 散列信息
 */
@Builder
@Data
public class EncryptInfo {

    /**
     * 加密算法
     */
    private String algorithmName;

    /**
     * 明文
     */
    private String input;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 密文
     */
    private String password;
}
