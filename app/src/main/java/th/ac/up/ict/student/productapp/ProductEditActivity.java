package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.repository.ProductRepository;

public class ProductEditActivity extends AppCompatActivity {

    ProductRepository productRepository = ProductRepository.instance();

    Button btnProductEditOk;
    EditText edtProductEditName;
    EditText edtProductEditSellPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        btnProductEditOk = (Button) findViewById(R.id.btnProductEditOk);
        edtProductEditName = (EditText) findViewById(R.id.edtProductEditName);
        edtProductEditSellPrice = (EditText) findViewById(R.id.edtProductEditSellPrice);

        Intent i = getIntent();
        final long productId = i.getLongExtra("PRODUCT_ID", 0);
        String productName = i.getStringExtra("PRODUCT_NAME");
        Double productSellPrice = i.getDoubleExtra("PRODUCT_SELLPRICE", -1);

        edtProductEditName.setText(productName);
        edtProductEditSellPrice.setText(productSellPrice.toString());


        btnProductEditOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = productRepository.findById(productId);

                String name = edtProductEditName.getText().toString();
                Double sellPrice = Double.valueOf(edtProductEditSellPrice.getText().toString());

                p.setName(name);
                p.setSellPrice(sellPrice);

                productRepository.save(p);
                finish();
            }
        });
    }
}
