package com.lambdaschool.shoppingcart.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long roleid;
    private String rolename;


    public Roles()
    {
    }

    public Roles(String rolename)
    {
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
}
