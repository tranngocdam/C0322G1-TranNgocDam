package model;

public class UserRole {
    private Integer roleId;
    private String userName;

    public UserRole(Integer roleId, String userName) {
        this.roleId = roleId;
        this.userName = userName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
