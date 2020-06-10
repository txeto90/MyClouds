package com.example.myclouds.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import com.example.myclouds.R;
import com.example.myclouds.model.Pregunta;
import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends MainMenu {

    private ArrayList<Pregunta> preguntes;
    RadioButton rd1, rd2, rd3;
    int lloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rd1 = findViewById(R.id.rdOpt1);
        rd2 = findViewById(R.id.rdOpt2);
        rd3 = findViewById(R.id.rdOpt3);

        plenarArray();
        posarPregunta(this.preguntes);
        Button btn = findViewById(R.id.btnConfirmar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat();
            }
        });


    }

    private void plenarArray(){
        preguntes = new ArrayList<>();
        preguntes.add(new Pregunta("altocumulus_img", "altocumulus"));
        preguntes.add(new Pregunta("altostratus_img", "altostratus"));
        preguntes.add(new Pregunta("cirrocumulus_img", "cirrocumulus"));
        preguntes.add(new Pregunta("cirrostratus_img", "cirrostratus"));
        preguntes.add(new Pregunta("cumulonimbus_img", "cumulonimbos"));
        preguntes.add(new Pregunta("cumulus_img", "cumulus"));
        preguntes.add(new Pregunta("nimbostratus_img", "nimbostratus"));
        preguntes.add(new Pregunta("stratus_img", "stratus"));
        preguntes.add(new Pregunta("stratocumulus_img", "stratocumulus"));
    }

    public void posarPregunta(ArrayList<Pregunta> ps ){
        lloc = new Random().nextInt(2);
        int random = new Random().nextInt(ps.size());
        int opt1 = new Random().nextInt(ps.size());
        int opt2 = new Random().nextInt(ps.size());

        ImageView iv = findViewById(R.id.imgQuiz);

        if(random != opt1 && random != opt2 && opt1 != opt2) {
            iv.setImageResource(getResources().getIdentifier(ps.get(random).getImatge(), "drawable", this.getPackageName()));
            switch (lloc){
                case 0:{
                    rd1.setText(ps.get(random).getCorrecta());
                    rd2.setText(ps.get(opt1).getCorrecta());
                    rd3.setText(ps.get(opt2).getCorrecta());
                }break;
                case 1:{
                    rd1.setText(ps.get(opt1).getCorrecta());
                    rd2.setText(ps.get(random).getCorrecta());
                    rd3.setText(ps.get(opt2).getCorrecta());
                }break;
                case 2:{
                    rd1.setText(ps.get(opt1).getCorrecta());
                    rd2.setText(ps.get(opt2).getCorrecta());
                    rd3.setText(ps.get(random).getCorrecta());
                }break;
            }

        }else{
            posarPregunta(ps);
        }
    }

    public void resultat(){
        RadioGroup rg = findViewById(R.id.radiogroup);
        if(rg.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
        }else{
            int seleccionat = rg.getCheckedRadioButtonId();
            RadioButton selectRD = findViewById(seleccionat);
            if(selectRD.getText().equals()){
                //correcta
            }else{
                //fallada
            }
        }


        /*
        switch (lloc){
            case 0:{
                rd1.setText(ps.get(random).getCorrecta());
            }break;
            case 1:{
                rd2.setText(ps.get(random).getCorrecta());
            }break;
            case 2:{
                rd3.setText(ps.get(random).getCorrecta());
            }break;
        }
        */
    }

}
