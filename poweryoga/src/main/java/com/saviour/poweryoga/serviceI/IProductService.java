package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Product;
import java.util.List;

/**
 *
 * @author TalakB
 */
public interface IProductService {

    public void saveProduct(Product product);

    public List<Product> getAllProducts();

    public void updateProduct(Product product);

    public Product getProductById(int Id);

    public void deleteProduct(int Id);

}
