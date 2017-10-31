package diego.sumaresta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sumaresta(View view){
        Intent i = new Intent(this, sumaresta.class);
        startActivity(i);

    }
    public void check (View view){
        Intent i = new Intent(this,sumarestacheck.class);
        startActivity(i);
    }
    public void spinner_acti (View view){
        Intent i = new Intent(this, spinner.class);
        startActivity(i);
    }
    public void list_view (View view){
        Intent i =new Intent(this,list_view.class);
        startActivity(i);
    }
    public void fichero (View view) {
        Intent i = new Intent(this, fichero.class);
        startActivity(i);
    }
    public void ficherosd (View view) {
        Intent i = new Intent(this, ficherosd.class);
        startActivity(i);}
    public void sql (View view) {
        Intent i = new Intent(this, sql.class);
        startActivity(i);
    }
    public void salir (View view) {
        finish();
    }

}

