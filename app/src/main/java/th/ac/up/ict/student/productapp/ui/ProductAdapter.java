package th.ac.up.ict.student.productapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import th.ac.up.ict.student.productapp.R;
import th.ac.up.ict.student.productapp.domain.model.Product;

/**
 * Created by Student on 3/9/2016.
 */
public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.supplier_adapter, parent, false);

        TextView supplierName = (TextView) rowView.findViewById(R.id.supplierName);
        TextView supplierAddress = (TextView) rowView.findViewById(R.id.supplierAddress);

        supplierName.setText(this.products.get(position).getName());
        supplierAddress.setText(this.products.get(position).getSellPrice().toString());

        return rowView;
    }
}
