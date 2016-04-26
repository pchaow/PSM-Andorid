package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.common.collect.Lists;

import java.util.ArrayList;

import th.ac.up.ict.student.productapp.domain.model.Product;
import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.ProductRepository;
import th.ac.up.ict.student.productapp.ui.ProductAdapter;

public class ProductActivity extends AppCompatActivity {

    ProductRepository productRepository = ProductRepository.instance();

    ListView lvProduct;
    Button btnProductAdd;

    ArrayList<Product> products;

    String[] menuItems = {"Edit", "Delete"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        lvProduct = (ListView) findViewById(R.id.lvProduct);
        btnProductAdd = (Button) findViewById(R.id.btnProductAdd);

        registerForContextMenu(lvProduct);

        btnProductAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ProductActivity.this, ProductAddActivity.class);
                startActivity(i);
            }
        });


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = products.get(position);
                Intent i = new Intent(ProductActivity.this, ProductValueActivity.class);
                i.putExtra("PRODUCT_ID", product.getId());
                startActivity(i);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.lvProduct) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Product product = products.get(info.position);
            menu.setHeaderTitle(product.getName());
            for (int i = 0; i < menuItems.length; i++) {
                menu.add(ContextMenu.NONE, i, i, menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String menuItemName = menuItems[menuItemIndex];
        Product product = products.get(info.position);
        if (menuItemName.equals("Delete")) {
            productRepository.delete(product);
            updateDatabase();
        } else if (menuItemName.equals("Edit")) {
            Intent i = new Intent(ProductActivity.this, ProductEditActivity.class);
            i.putExtra("PRODUCT_NAME", product.getName());
            i.putExtra("PRODUCT_SELLPRICE", product.getSellPrice());
            i.putExtra("PRODUCT_ID", product.getId());
            startActivity(i);
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateDatabase();

    }

    private void updateDatabase() {

        products = Lists.newArrayList(productRepository.getProducts());
        ProductAdapter adapter = new ProductAdapter(
                this, products

        );
        lvProduct.setAdapter(adapter);

    }
}
