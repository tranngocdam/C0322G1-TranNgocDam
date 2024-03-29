package com.sprint2.model;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AppRole appRole;

    @ManyToOne
    @JoinColumn(name= "user_id", referencedColumnName = "id")
    private AppUsers appUsers;

    public UserRole() {
    }

    public UserRole(Integer id, Boolean status, AppRole appRole, AppUsers appUsers) {
        this.id = id;
        this.status = status;
        this.appRole = appRole;
        this.appUsers = appUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }
}
