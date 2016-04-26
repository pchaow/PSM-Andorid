package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;

public class MainActivity extends AppCompatActivity {

    Button btnProduct;
    Button btnSupplier;

    SupplierRepository supplierRepository = SupplierRepository.instance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProduct = (Button) findViewById(R.id.btnProduct);
        btnSupplier = (Button) findViewById(R.id.btnSupplier);

        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ProductActivity.class);
                startActivity(intent);

            }
        });

        btnSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SupplierActivity.class);
                startActivity(intent);
            }
        });





    }
}
