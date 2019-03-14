package com.rhiodamuthie.sbmvclogintemplate.repository;

/**
 * Created by W on 3/15/2019.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhiodamuthie.sbmvclogintemplate.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
