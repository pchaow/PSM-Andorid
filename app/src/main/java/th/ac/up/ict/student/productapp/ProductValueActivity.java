package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.common.collect.Lists;

import org.w3c.dom.Text;

import java.util.ArrayList;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.model.Value;
import th.ac.up.ict.student.productapp.domain.repository.ProductRepository;
import th.ac.up.ict.student.productapp.ui.ProductAdapter;
import th.ac.up.ict.student.productapp.ui.ValueAdapter;

public class ProductValueActivity extends AppCompatActivity {

    TextView txtProductName;
    TextView txtProductSellPrice;
    ListView lvValues;
    Button btnAddValues;

    ProductRepository productRepository = ProductRepository.instance();
    Product product = null;

    ArrayList<Value> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_value);

        txtProductName = (TextView) findViewById(R.id.txtProductName);
        txtProductSellPrice = (TextView) findViewById(R.id.txtProductSellPrice);
        lvValues = (ListView) findViewById(R.id.lvValues);
        btnAddValues = (Button) findViewById(R.id.btnAddValues);

        Intent i = getIntent();
        final long productId = i.getLongExtra("PRODUCT_ID", 0);
        product = productRepository.findById(productId);

        txtProductName.setText(product.getName());
        txtProductSellPrice.setText(product.getSellPrice().toString());

        updateListView();


        btnAddValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductValueActivity.this, ProductAddValueActivity.class);
                i.putExtra("PRODUCT_ID", product.getId());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();

    }

    private void updateListView() {

        values = Lists.newArrayList(product.getValues());
        ValueAdapter adapter = new ValueAdapter(
                this, values

        );
        lvValues.setAdapter(adapter);
    }
}
