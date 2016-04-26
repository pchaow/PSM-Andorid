package th.ac.up.ict.student.productapp.domain.repository;

import java.util.ArrayList;
import java.util.Iterator;

import th.ac.up.ict.student.productapp.domain.model.Supplier;

/**
 * Created by Student on 3/6/2016.
 */
public class SupplierRepository {

    static ArrayList<Supplier> suppliers = new ArrayList<>();
    static SupplierRepository instance;

    public static SupplierRepository instance() {
        if (instance == null) {
            instance = new SupplierRepository();
        }
        return instance;
    }

    private SupplierRepository() {
    }

    public Iterator<Supplier> getSuppliers() {
        return Supplier.findAll(Supplier.class);
    }

    public Supplier findById(Long id) {
        return Supplier.findById(Supplier.class, id);
    }

    public Long save(Supplier supplier) {
        return Supplier.save(supplier);
    }

    public Boolean delete(Supplier supplier) {
        return Supplier.delete(supplier);
    }
}
