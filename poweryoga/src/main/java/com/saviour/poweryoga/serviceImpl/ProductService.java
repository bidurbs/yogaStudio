package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.daoI.IProductDAO;
import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDao;

    private CRUDFacadeImpl crudfacade;

    @Transactional
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public void updateProduct(Product product) {
        crudfacade.update(product);
    }

    public Product getProductById(int Id) {
        return productDao.get(Id);
    }

    public void deleteProduct(Product product) {
        //  productDao.delete(Id);
        crudfacade.delete(product);
    }

    /**
     * This method will return list of product matched with the parameter name
     *
     * @param name Name of the product
     * @return Product List
     */
    public List<Product> searchProduct(String name) {

        try {
            Map<String, String> paramaters = new HashMap<>(1);
            paramaters.put("pname", name);
            return crudfacade.findWithNamedQuery("Product.searchProduct", paramaters);
        } catch (Exception ex) {
            return null;

        }
    }

    /**
     * This method will return list of newest 2 products
     *
     *
     * @return Product List
     */
    @Override
    public List<Product> getFeaturedProducts() {
        return crudfacade.findWithNamedQuery("Product.findAllFeatured");
    }

}
