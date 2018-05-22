package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.doantrang.firebase.R;

import java.util.List;

import enbities.Contact;

/**
 * Created by DoanTrang on 5/21/2018.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private List<Contact> contacts;

    public ContactListAdapter(@NonNull Context context, List<Contact> contacts){
        super(context, R.layout.contact_layout,contacts);
        this.context= context;
        this.contacts=contacts;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.contact_layout, parent, false);
        TextView tvykien=(TextView) view.findViewById(R.id.tvykien);
        tvykien.setText(contacts.get(position).getYkien());
    return view;
    }
}
