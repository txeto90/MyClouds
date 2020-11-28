package nubes.atlas.myclouds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.nubes.myclouds.R;
import nubes.atlas.myclouds.dao.NuvolsDAO;
import nubes.atlas.myclouds.model.Nuvol;

public class DicotomicaActivity extends MainMenu {

    private TextView txtDico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicotomica);
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
        txtDico = findViewById(R.id.txtDico);
    }

    //NO
    public void dret(View v){
        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t1))){
            txtDico.setText(R.string.t2);
        }else {
            if (txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t2))) {
                txtDico.setText(R.string.t3);
            }else{
                if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t3))){
                    txtDico.setText(R.string.t4);
                }else{
                    if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t4))){
                        txtDico.setText(R.string.t5);
                    }else{
                        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t5))){
                            txtDico.setText(R.string.t6);
                        }else{
                            if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t6))){
                                startNuvolData("Sc");
                            }else{
                                if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t7))){
                                    txtDico.setText(R.string.t8);
                                }else{
                                    if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t8))){
                                        txtDico.setText(R.string.t9);
                                    }else{
                                        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t9))){
                                            startNuvolData("St");
                                        }else{
                                            if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t10))){
                                                startNuvolData("Cu");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //SI
    public void esquerre(View v){
        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t1))){
            startNuvolData("Cb");
        }else{
            if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t2))){
                txtDico.setText(R.string.t10);
            }else{
                if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t3))){
                    txtDico.setText(R.string.t7);
                }else{
                    if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t4))){
                        txtDico.setText(R.string.t5);
                    }else{
                        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t5))){
                            txtDico.setText(R.string.t6);
                        }else{
                            if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t6))){
                                startNuvolData("Ac");
                            }else{
                                if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t7))){
                                    startNuvolData("Cs");
                                }else{
                                    if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t8))){
                                        startNuvolData("As");
                                    }else{
                                        if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t9))){
                                            startNuvolData("Ns");
                                        }else{
                                            if(txtDico.getText().toString().equalsIgnoreCase(getString(R.string.t10))){
                                                startNuvolData("Cb");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void startNuvolData(String abrev){
        NuvolsDAO nd = new NuvolsDAO(this);
        Nuvol n = nd.getNuvolInfo(abrev);
        Intent intent = new Intent(DicotomicaActivity.this, NuvolDataActivity.class);
        intent.putExtra("nom", n.getNom());
        intent.putExtra("abrev", n.getAbrev());
        intent.putExtra("altura", n.getAltura());
        intent.putExtra("precipitacio", n.getPrecipitacio());
        intent.putExtra("descripcio", n.getDescripcio());
        intent.putExtra("imatge", n.getImatge());
        intent.putExtra("icono", n.getIcono());
        startActivity(intent);
    }


}
