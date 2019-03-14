package com.rhiodamuthie.sbmvclogintemplate.service;

/**
 * Created by W on 3/15/2019.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rhiodamuthie.sbmvclogintemplate.model.Role;
import com.rhiodamuthie.sbmvclogintemplate.model.User;
import com.rhiodamuthie.sbmvclogintemplate.repository.RoleRepository;
import com.rhiodamuthie.sbmvclogintemplate.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}
