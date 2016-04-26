package th.ac.up.ict.student.productapp;

import android.content.Intent;
import android.os.StrictMode;
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

import th.ac.up.ict.student.productapp.domain.model.Supplier;
import th.ac.up.ict.student.productapp.domain.repository.SupplierRepository;
import th.ac.up.ict.student.productapp.domain.repository.SupplierWebRepository;
import th.ac.up.ict.student.productapp.ui.SupplierAdapter;

public class SupplierActivity extends AppCompatActivity {

    SupplierRepository supplierRepository = SupplierRepository.instance();
    SupplierWebRepository supplierWebRepository = SupplierWebRepository.instance();

    ListView lvSupplier;

    Button btnAddSupplier;

    ArrayList<Supplier> listOfSuppliers;
    String[] menuItems = {"Edit", "Delete"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        lvSupplier = (ListView) findViewById(R.id.lvSupplier);
        updateDatabase();

        registerForContextMenu(lvSupplier);

        btnAddSupplier = (Button) findViewById(R.id.btnAddSupplier);
        btnAddSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SupplierActivity.this, SupplierAddActivity.class);
                startActivity(i);
            }
        });


        lvSupplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.lvSupplier) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Supplier supplier = listOfSuppliers.get(info.position);
            menu.setHeaderTitle(supplier.getName());
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
        Supplier supplier = listOfSuppliers.get(info.position);
        if (menuItemName.equals("Delete")) {
            supplierRepository.delete(supplier);
            updateDatabase();
        } else if (menuItemName.equals("Edit")) {

            Intent i = new Intent(SupplierActivity.this, SupplierEditActivity.class);
            i.putExtra("SUPPLIER_NAME", supplier.getName());
            i.putExtra("SUPPLIER_ADDRESS", supplier.getAddress());
            i.putExtra("SUPPLIER_ID", supplier.getId());
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

        listOfSuppliers = Lists.newArrayList(supplierWebRepository.getSuppliers());
        SupplierAdapter adapter = new SupplierAdapter(
                this, listOfSuppliers

        );
        lvSupplier.setAdapter(adapter);

    }
}









