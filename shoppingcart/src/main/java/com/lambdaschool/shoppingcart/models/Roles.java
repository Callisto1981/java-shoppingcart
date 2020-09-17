package com.lambdaschool.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @Column(nullable = false, unique = true)
    private String rolename;



    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "roles", allowSetters = true)
    private List<UserRoles> users = new ArrayList<>();
    public Roles()
    {
    }

    public Roles(long roleid, String rolename)
    {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public long getRoleid()
    {
        return roleid;
    }

    public void setRoleid(long roleid)
    {
        this.roleid = roleid;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    public List<UserRoles> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserRoles> users)
    {
        this.users = users;
    }
}
