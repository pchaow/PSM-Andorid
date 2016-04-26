package th.ac.up.ict.student.productapp.domain.repository;

import android.os.StrictMode;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.retrofitService.SupplierService;

/**
 * Created by Student on 3/6/2016.
 */
public class SupplierWebRepository {

    SupplierService service;
    static SupplierWebRepository instance;

    public static SupplierWebRepository instance() {
        if (instance == null) {
            instance = new SupplierWebRepository();
        }
        return instance;
    }

    private SupplierWebRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.250.1:8000/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        service = retrofit.create(SupplierService.class);
    }

    public Iterator<Supplier> getSuppliers() {

        Call<List<Supplier>> call = service.getSuppliers();
        try {
            return call.execute().body().iterator();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Supplier>().iterator();
        }

    }

    public Supplier save(Supplier supplier) {
        Call<Supplier> call = service.createSupplier(supplier);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
