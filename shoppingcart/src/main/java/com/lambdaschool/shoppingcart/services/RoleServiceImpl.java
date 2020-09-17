package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.exceptions.ResourceNotFoundException;
import com.lambdaschool.shoppingcart.models.Cart;
import com.lambdaschool.shoppingcart.models.Roles;
import com.lambdaschool.shoppingcart.repositories.RoleRepository;
import com.lambdaschool.shoppingcart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    RoleRepository rolerepos;

    @Autowired
    UserRepository userrepos;


    @Autowired
    private UserAuditing userAuditing;

    @Override
    public List<Roles> findAll()
    {
        rolerepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Roles findRoleById(long id)
    {
        return rolerepos.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Role id " + id + " Not Found!"));
    }

    @Override
    public Roles findByName(String name)
    {
        Roles roles = rolerepos.findByNameIgnoreCase(name);

        if ( roles != null)
        {
            return roles;
        }
        else
        {
            throw new ResourceNotFoundException(name);
        }
    }

    @Transactional

    @Override
    public Roles save(Roles roles)
    {
        if (roles.getUsers().size() > 0)
        {
            throw new ResourceNotFoundException("User Roles are not Updated.");
        }
        return rolerepos.save(roles);
    }

    @Override
    public void deleteAll()
    {
        rolerepos.deleteAll();
    }

    @Transactional

    @Override
    public Roles update(
        long id,
        Roles roles)
    {
        if (roles.getRolename() == null)
        {
            throw new ResourceNotFoundException("No role names found");
        }

        if (roles.getUsers().size() > 0)
        {
            throw new ResourceNotFoundException("User Roles are not Updated");
        }

        Roles newRole = findRoleById(id);

        rolerepos.updateRoleName(userAuditing.getCurrentAuditor().get(), id,roles.getRolename());
        return findRoleById(id);
    }
}
