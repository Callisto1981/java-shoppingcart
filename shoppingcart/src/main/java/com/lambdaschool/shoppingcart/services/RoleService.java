package com.lambdaschool.shoppingcart.services;


import com.lambdaschool.shoppingcart.models.Roles;
import java.util.List;

public interface RoleService
{
    List<Roles> findAll();

    Roles findRoleById(long id);

    Roles save(Roles roles);

    Roles findByName(String name);

    public void deleteAll();

    Roles update(long id, Roles roles);
}
