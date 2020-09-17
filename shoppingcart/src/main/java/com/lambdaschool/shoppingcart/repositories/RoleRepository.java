package com.lambdaschool.shoppingcart.repositories;

import com.lambdaschool.shoppingcart.models.Roles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface RoleRepository extends CartRepository<Roles, Long>
{
    Roles findByNameIgnoreCase(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE roles SET name = :name, last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP WHERE roleid = :roleid", nativeQuery = true)
    void updateRoleName(String uname, long roleid, String name);
}
