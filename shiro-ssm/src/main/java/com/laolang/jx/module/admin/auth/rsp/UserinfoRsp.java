package com.laolang.jx.module.admin.auth.rsp;

import lombok.Data;

@Data
public class UserinfoRsp {

    private Long id;
    private Long tenantId;
    private String userType;
    private String username;
    private String nickname;
    private String phone;
    private String email;
    private String gender;
    private String avatar;
}
