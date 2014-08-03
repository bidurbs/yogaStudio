package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Users;

/**
 *
 * @author TalakB
 */
public interface IUserService {

    public Users save(Users user);

    public Users authenticateUser(Users user);

}
