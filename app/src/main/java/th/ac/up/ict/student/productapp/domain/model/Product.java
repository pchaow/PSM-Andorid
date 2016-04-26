package th.ac.up.ict.student.productapp.domain.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Student on 3/16/2016.
 */
public class Product extends SugarRecord {

    String name;
    Double sellPrice;

    public List<Value> getValues() {
        return Value.find(Value.class, "product = ?", getId().toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
