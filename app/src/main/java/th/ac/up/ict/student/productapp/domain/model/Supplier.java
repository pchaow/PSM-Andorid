package th.ac.up.ict.student.productapp.domain.model;

import com.orm.SugarRecord;

/**
 * Created by Student on 3/6/2016.
 */
public class Supplier extends SugarRecord {

    String name;
    String address;

    @Override
    public String toString() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
