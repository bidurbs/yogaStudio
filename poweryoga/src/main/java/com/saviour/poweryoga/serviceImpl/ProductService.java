package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.daoI.IProductDAO;
import com.saviour.poweryoga.model.Product;
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
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private CRUDFacadeImpl crudfacade;

//    public void deleteProduct(Long Id) {
//        //  productDao.delete(Id);
//        Product prod = (Product) crudfacade.read(Id, Product.class);
//        crudfacade.delete(prod);
//    }

    /**
     * This method will return list of product matched with the parameter name
     *
     * @param name Name of the product
     * @return Product List
     */
    @Override
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

    @Override
    public void saveProduct(Product product) {
        crudfacade.create(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return crudfacade.findWithNamedQuery("Product.findAllProducts");
    }

    @Override
    public void updateProduct(Product product) {
        crudfacade.update(product);
    }

    @Override
    public Product getProductById(Long Id) {
        return (Product) crudfacade.read(Id, Product.class);
    }

    @Override
    public void deleteProduct(Product product) {
        crudfacade.delete(product);
    }

}
