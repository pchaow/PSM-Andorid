package th.ac.up.ict.student.productapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.ProductRepository;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;

public class ProductAddActivity extends AppCompatActivity {

    ProductRepository productRepository = ProductRepository.instance();

    Button btnProductAddOk;
    EditText edtProductAddName;
    EditText edtProductAddSellPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        btnProductAddOk = (Button) findViewById(R.id.btnProductAddOk);
        edtProductAddName = (EditText) findViewById(R.id.edtProductAddName);
        edtProductAddSellPrice = (EditText) findViewById(R.id.edtProductAddSellPrice);

        btnProductAddOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Product p = new Product();

                String name = edtProductAddName.getText().toString();
                Double sellPrice = Double.valueOf(edtProductAddSellPrice.getText().toString());

                p.setName(name);
                p.setSellPrice(sellPrice);

                productRepository.save(p);
                finish();
            }
        });
    }
}
