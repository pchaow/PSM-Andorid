package th.ac.up.ict.student.productapp.domain.repository;

import java.util.ArrayList;
import java.util.Iterator;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.model.Supplier;

/**
 * Created by Student on 3/6/2016.
 */
public class ProductRepository {

    static ProductRepository instance;

    public static ProductRepository instance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    private ProductRepository() {
    }

    public Iterator<Product> getProducts() {
        return Product.findAll(Product.class);
    }

    public Product findById(Long id) {
        return Supplier.findById(Product.class, id);
    }

    public Long save(Product product) {
        return Supplier.save(product);
    }

    public Boolean delete(Product product) {
        return Supplier.delete(product);
    }
}
