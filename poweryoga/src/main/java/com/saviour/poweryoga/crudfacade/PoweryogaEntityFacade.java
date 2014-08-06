package com.saviour.poweryoga.crudfacade;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author TalakB
 */
public interface PoweryogaEntityFacade<T> {

    public T create(T entity) throws EntityExistsException, IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    public T read(Serializable primaryKey, Class c) throws IllegalStateException,
            IllegalArgumentException;

    public boolean update(T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    public boolean delete(T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException,
            PersistenceException;

    public List findWithNamedQuery(String queryName);

    public List findWithNamedQuery(String queryName, int resultLimit);

    public List findWithNamedQuery(String namedQueryName, Map<String, String> parameters);

    public List findWithNamedQuery(String namedQueryName, Map<String, String> parameters, int resultLimit);

}
