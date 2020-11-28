package nubes.atlas.myclouds.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nubes.myclouds.R;

public class NuvolDataActivity extends MainMenu {

    private TextView txtNom, txtAbrev, txtAltura, txtPrecipitacio, txtDescripcio;
    private ImageView imageView, iconoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuvol_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        txtNom = findViewById(R.id.txtNom);
        txtAltura = findViewById(R.id.txtAltitud);
        txtAbrev = findViewById(R.id.txtAbrev);
        txtPrecipitacio = findViewById(R.id.txtPrecipitacion);
        txtDescripcio = findViewById(R.id.txtDescripcio);
        imageView = findViewById(R.id.imgNuvol);
        iconoView = findViewById(R.id.imgIcono);
        getData();
    }

    private void getData(){
        Bundle extras = getIntent().getExtras();
        String nom = extras.getString("nom");
        String altura = extras.getString("altura");
        String abrev = extras.getString("abrev");
        String precipitacio = extras.getString("precipitacio");
        String descripcio = extras.getString("descripcio");
        String imatge = extras.getString("imatge");
        String icono = extras.getString("icono");

        txtNom.setText(nom);
        txtAbrev.setText(abrev);
        txtAltura.setText(altura);
        txtPrecipitacio.setText(precipitacio);
        txtDescripcio.setText(descripcio);
        imageView.setImageResource(getDrawable(imatge, this));
        iconoView.setImageResource(getDrawable(icono, this));

    }

    public static int getDrawable(String imgName, Context ctx) {
        return ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());
    }
}
