package com.sprint2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;

    @JsonBackReference
    @OneToMany(mappedBy = "appRole")
    private List<UserRole> userRoleList;

    public AppRole() {
    }

    public AppRole(Integer id, String roleName, Boolean isDelete, List<UserRole> userRoleList) {
        this.id = id;
        this.roleName = roleName;
        this.isDelete = isDelete;
        this.userRoleList = userRoleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
