package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Product;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author TalakB
 */
public interface IProductDAO {

    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Product product);

    public List<Product> getAll();

    public void add(Product product);

    public Product get(int id);

    public void update(Product p);

    public void delete(int id);

    public List<Product> searchProduct(String name);
}
