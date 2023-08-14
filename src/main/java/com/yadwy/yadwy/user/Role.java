package com.yadwy.yadwy.user;

public enum Role {
    VENDOR("VENDOR"),
    CUSTOMER("CUSTOMER");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
