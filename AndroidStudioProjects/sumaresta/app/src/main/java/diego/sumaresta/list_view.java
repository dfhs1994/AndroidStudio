package diego.sumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class list_view extends AppCompatActivity {

    private TextView tv_tel;
    private ListView lv_con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        tv_tel =(TextView)findViewById(R.id.text);
        lv_con =(ListView)findViewById(R.id.lista);
        String[] contactos = {"Fernando Riffo","Miguel Muñoz","Victor Huircaleo","Rodrigo Molina","Gustavo Perez","Diego Hernandez"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,contactos);
      lv_con.setAdapter(adapter);
        final String[] numeros = {"82991256","68175599","89504228","...","82637152","66294097"};
        lv_con.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_tel.setText("Telefonos = "+numeros[position]);

            }

        });
    }
    public void volver (View view){
        finish();
    }
}
