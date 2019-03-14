package com.rhiodamuthie.sbmvclogintemplate.service;

import com.rhiodamuthie.sbmvclogintemplate.model.User;

/**
 * Created by W on 3/15/2019.
 */
public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
