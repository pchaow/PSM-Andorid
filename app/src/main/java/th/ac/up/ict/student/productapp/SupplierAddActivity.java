package th.ac.up.ict.student.productapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;
import th.ac.up.ict.student.productapp.domain.repository.SupplierWebRepository;

public class SupplierAddActivity extends AppCompatActivity {

    SupplierRepository supplierRepository = SupplierRepository.instance();
    SupplierWebRepository supplierWebRepository = SupplierWebRepository.instance();

    Button btnSupplierAddOK;
    EditText edtSupplierAddName;
    EditText edtSupplierAddAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_add);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        btnSupplierAddOK = (Button) findViewById(R.id.btnSupplierAddOK);
        edtSupplierAddName = (EditText) findViewById(R.id.edtSupplierAddName);
        edtSupplierAddAddress = (EditText) findViewById(R.id.edtSupplierAddAddress);

        btnSupplierAddOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Supplier s = new Supplier();

                String name = edtSupplierAddName.getText().toString();
                String address = edtSupplierAddAddress.getText().toString();

                s.setName(name);
                s.setAddress(address);

                String json = (new Gson()).toJson(s);
                //Log.i("json", json);
                //supplierRepository.save(s);
                supplierWebRepository.save(s);
                finish();
            }
        });

    }
}
