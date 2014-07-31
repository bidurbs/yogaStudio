package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author TalakB
 */
public interface IUserDAO {

    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Users user);

    public Users authenticatedUser(Users user);

    public Session getSession();

    public void setSession(Session session);

}
