package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.common.collect.Lists;

import java.util.ArrayList;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.model.Value;
import th.ac.up.ict.student.productapp.domain.repository.ProductRepository;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;
import th.ac.up.ict.student.productapp.ui.SupplierAdapter;

public class ProductAddValueActivity extends AppCompatActivity {

    ProductRepository productRepository = ProductRepository.instance();
    SupplierRepository supplierRepository = SupplierRepository.instance();

    Spinner spnAddValueSupplier;
    Button btnAddValueAdd;
    EditText edtAddValuePrice;

    ArrayList<Supplier> suppliers;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add_value);

        spnAddValueSupplier = (Spinner) findViewById(R.id.spnAddValueSupplier);
        btnAddValueAdd = (Button) findViewById(R.id.btnAddValueAdd);
        edtAddValuePrice = (EditText) findViewById(R.id.edtAddValuePrice);

        Intent i = getIntent();
        final long productId = i.getLongExtra("PRODUCT_ID", 0);
        product = productRepository.findById(productId);

        updateSupplierSpinner();

        btnAddValueAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value value = new Value();
                value.setProduct(product);

                Double price = Double.valueOf(edtAddValuePrice.getText().toString());
                Supplier supplier = (Supplier) spnAddValueSupplier.getAdapter().getItem(spnAddValueSupplier.getSelectedItemPosition());

                value.setPrice(price);
                value.setSupplier(supplier);

                value.save();
                finish();
            }
        });

    }

    private void updateSupplierSpinner() {
        suppliers = Lists.newArrayList(supplierRepository.getSuppliers());
        SupplierAdapter adapter = new SupplierAdapter(this, suppliers);
        adapter.setDropDownViewResource(R.layout.supplier_adapter);

        spnAddValueSupplier.setAdapter(adapter);
    }
}
