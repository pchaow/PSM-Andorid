package th.ac.up.ict.student.productapp.domain.model;

import com.orm.SugarRecord;

/**
 * Created by Student on 3/16/2016.
 */
public class Value extends SugarRecord {

    Double price;
    Supplier supplier;
    Product product;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
