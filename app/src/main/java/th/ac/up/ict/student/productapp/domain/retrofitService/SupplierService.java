package th.ac.up.ict.student.productapp.domain.retrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import th.ac.up.ict.student.productapp.domain.model.Supplier;

/**
 * Created by chaow on 4/25/2016.
 */
public interface SupplierService {

    @GET("/api/supplier")
    Call<List<Supplier>> getSuppliers();

    @POST("/api/supplier")
    Call<Supplier> createSupplier(@Body Supplier supplier);

}
