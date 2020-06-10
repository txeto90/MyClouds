package com.example.myclouds.activity;

import android.content.Intent;
import android.os.Bundle;
import com.example.myclouds.dao.NuvolsDAO;
import com.example.myclouds.model.Nuvol;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.example.myclouds.R;
import java.util.ArrayList;
import java.util.Collections;

public class NuvolListActivity extends MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuvol_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NuvolsDAO animalsDAO = new NuvolsDAO(this);
        //construct data source
        final ArrayList<Nuvol> nuvols = animalsDAO.getAnimals();
        Collections.sort(nuvols, Nuvol.NomVulgar);

        //create the adapter to convert the array to views
        final NuvolsAdapter adapter = new NuvolsAdapter (this, nuvols);
        ListView myAnimalsView = findViewById(R.id.listViewAnimals);
        myAnimalsView.setAdapter(adapter);

        myAnimalsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ENVIEM LES DADES DE L'ANIMAL AMB INTENT PER A REBRELES EN LA SEGUENT ACTIVITY
                Intent intent = new Intent(NuvolListActivity.this, NuvolDataActivity.class);
                intent.putExtra("nom", nuvols.get(position).getNom());
                intent.putExtra("abrev", nuvols.get(position).getAbrev());
                intent.putExtra("altura", nuvols.get(position).getAltura());
                intent.putExtra("precipitacio", nuvols.get(position).getPrecipitacio());
                intent.putExtra("descripcio", nuvols.get(position).getDescripcio());
                intent.putExtra("imatge", nuvols.get(position).getImatge());
                intent.putExtra("icono", nuvols.get(position).getIcono());
                startActivity(intent);
            }
        });
        EditText txtSearch = findViewById(R.id.txtSearch);
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {            }
        });
    }
}


