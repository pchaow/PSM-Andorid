package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;

public class SupplierEditActivity extends AppCompatActivity {

    SupplierRepository supplierRepository = SupplierRepository.instance();

    EditText edtSupplierEditName;
    EditText edtSupplierEditAddress;
    Button btnSupplierEditOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_edit);

        edtSupplierEditAddress = (EditText) findViewById(R.id.edtSupplierEditAddress);
        edtSupplierEditName = (EditText) findViewById(R.id.edtSupplierEditName);
        btnSupplierEditOK = (Button) findViewById(R.id.btnSupplierEditOK);

        Intent i = getIntent();
        String supplierName = i.getStringExtra("SUPPLIER_NAME");
        String supplierAddress = i.getStringExtra("SUPPLIER_ADDRESS");
        final Long supplierId = i.getLongExtra("SUPPLIER_ID", 0);

        edtSupplierEditName.setText(supplierName);
        edtSupplierEditAddress.setText(supplierAddress);


        btnSupplierEditOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Supplier s = supplierRepository.findById(supplierId);

                String name = edtSupplierEditName.getText().toString();
                String address = edtSupplierEditAddress.getText().toString();
                s.setName(name);
                s.setAddress(address);
                supplierRepository.save(s);
                //finishActivity(1);
                finish();
            }
        });
    }
}
