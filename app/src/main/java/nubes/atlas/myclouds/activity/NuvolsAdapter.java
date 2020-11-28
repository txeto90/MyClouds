package nubes.atlas.myclouds.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.nubes.myclouds.R;
import nubes.atlas.myclouds.model.Nuvol;
import java.util.List;

public class NuvolsAdapter extends ArrayAdapter implements Filterable {

    @SuppressWarnings("unchecked")
    public NuvolsAdapter(Context context, List objects){
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Nuvol nuvol = (Nuvol) getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        TextView name = convertView.findViewById(R.id.txtNameList);
        ImageView img = convertView.findViewById(R.id.imgList);
        //popuate the data uti te templatre view using the data object
        name.setText(nuvol.getNom());
        img.setImageResource(NuvolDataActivity.getDrawable(nuvol.getImatge(), getContext()));

        return convertView;
    }


}
