package th.ac.up.ict.student.productapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import th.ac.up.ict.student.productapp.R;
import th.ac.up.ict.student.productapp.domain.model.Supplier;

/**
 * Created by Student on 3/9/2016.
 */
public class SupplierAdapter extends ArrayAdapter<Supplier> {

    private Context context;
    private List<Supplier> suppliers;

    public SupplierAdapter(Context context, List<Supplier> suppliers){
        super(context,-1,suppliers);
        this.context = context;
        this.suppliers =suppliers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.supplier_adapter,parent,false);

        TextView supplierName = (TextView) rowView.findViewById(R.id.supplierName);
        TextView supplierAddress = (TextView) rowView.findViewById(R.id.supplierAddress);

        supplierName.setText( this.suppliers.get(position).getName() );
        supplierAddress.setText( this.suppliers.get(position).getAddress() );

        return rowView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }
}
