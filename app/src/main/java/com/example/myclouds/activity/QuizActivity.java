package com.example.myclouds.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
    private RadioGroup rg;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rd1 = findViewById(R.id.rdOpt1);
        rd2 = findViewById(R.id.rdOpt2);
        rd3 = findViewById(R.id.rdOpt3);
        rg = findViewById(R.id.radiogroup);

        plenarArray();
        posarPregunta();
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

    public void posarPregunta(){
        rg.clearCheck();
        rd1.setBackgroundColor(Color.parseColor("#E0F0FA"));
        rd2.setBackgroundColor(Color.parseColor("#E0F0FA"));
        rd3.setBackgroundColor(Color.parseColor("#E0F0FA"));

        int lloc = new Random().nextInt(2);
        random = new Random().nextInt(preguntes.size());
        int opt1 = new Random().nextInt(preguntes.size());
        int opt2 = new Random().nextInt(preguntes.size());

        ImageView iv = findViewById(R.id.imgQuiz);

        if(random != opt1 && random != opt2 && opt1 != opt2) {
            iv.setImageResource(getResources().getIdentifier(preguntes.get(random).getImatge(), "drawable", this.getPackageName()));
            switch (lloc){
                case 0:{
                    rd1.setText(preguntes.get(random).getCorrecta());
                    rd2.setText(preguntes.get(opt1).getCorrecta());
                    rd3.setText(preguntes.get(opt2).getCorrecta());
                }break;
                case 1:{
                    rd1.setText(preguntes.get(opt1).getCorrecta());
                    rd2.setText(preguntes.get(random).getCorrecta());
                    rd3.setText(preguntes.get(opt2).getCorrecta());
                }break;
                case 2:{
                    rd1.setText(preguntes.get(opt1).getCorrecta());
                    rd2.setText(preguntes.get(opt2).getCorrecta());
                    rd3.setText(preguntes.get(random).getCorrecta());
                }break;
            }

        }else{
            posarPregunta();
        }
    }

    public void resultat(){
        if(rg.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
        }else{
            int seleccionat = rg.getCheckedRadioButtonId();
            RadioButton selectRD = findViewById(seleccionat);
            if(selectRD.getText().equals(preguntes.get(random).getCorrecta())){
                //correcta
                selectRD.setBackgroundColor(Color.GREEN);
            }else{
                //fallada
                selectRD.setBackgroundColor(Color.RED);
            }
            tempsEspera();
        }

    }

    Handler mHandler;
    public void tempsEspera(){
        mHandler = new Handler();
        mHandler.postDelayed(r, 3000);
    }

    private Runnable r = new Runnable() {
        public void run() {
            posarPregunta();
        }
    };

}
