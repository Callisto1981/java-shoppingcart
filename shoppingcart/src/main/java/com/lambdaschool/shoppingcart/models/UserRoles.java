package com.lambdaschool.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userroles")
public class UserRoles extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "roles",
    allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties(value = "users",
    allowSetters = true)
    private Roles roles;

    public UserRoles()
    {
    }

    public UserRoles(
        User user,
        Roles roles)
    {
        this.user = user;
        this.roles = roles;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Roles getRoles()
    {
        return roles;
    }

    public void setRoles(Roles roles)
    {
        this.roles = roles;
    }


}
