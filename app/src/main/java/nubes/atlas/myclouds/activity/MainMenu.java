package nubes.atlas.myclouds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.nubes.myclouds.R;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.inici) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        if (id == R.id.guia) {
            startActivity(new Intent(this, NuvolListActivity.class));
            return true;
        }
        if (id == R.id.identificador) {
            startActivity(new Intent(this, DicotomicaActivity.class));
            return true;
        }
        if (id == R.id.joc) {
            startActivity(new Intent(this, QuizActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
