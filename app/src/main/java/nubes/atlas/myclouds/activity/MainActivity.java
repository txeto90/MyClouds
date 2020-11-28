package nubes.atlas.myclouds.activity;

import android.content.Intent;
import android.os.Bundle;
import com.nubes.myclouds.R;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton ibLlista = findViewById(R.id.ibLlista);
        ImageButton ibDico = findViewById(R.id.ibDico);
        ImageButton ibJoc = findViewById(R.id.ibJoc);

        ibLlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NuvolListActivity.class));
            }
        });
        ibDico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DicotomicaActivity.class));
            }
        });
        ibJoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
            }
        });
    }


}
