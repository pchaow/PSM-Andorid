package th.ac.up.ict.student.productapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import th.ac.up.ict.student.productapp.R;
import th.ac.up.ict.student.productapp.domain.model.Value;

/**
 * Created by Student on 3/9/2016.
 */
public class ValueAdapter extends ArrayAdapter<Value> {

    private Context context;
    private List<Value> values;

    public ValueAdapter(Context context, List<Value> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.supplier_adapter, parent, false);

        TextView supplierName = (TextView) rowView.findViewById(R.id.supplierName);
        TextView supplierAddress = (TextView) rowView.findViewById(R.id.supplierAddress);

        supplierName.setText(this.values.get(position).getSupplier().getName());
        supplierAddress.setText(this.values.get(position).getPrice().toString());

        return rowView;
    }


}
