/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.service;

import com.saviour.poweryoga.dao.UserDAO;
import com.saviour.poweryoga.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
}
