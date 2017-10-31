package diego.sumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class spinner extends AppCompatActivity {
    private Spinner spinner;
    private EditText et1,et2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        resultado = (TextView)findViewById(R.id.resultado);
        spinner = (Spinner)findViewById(R.id.spinner);

        String []opciones = {"Sumar","Restar"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner.setAdapter(adapter);
    }
    public void operar (View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        if (valor1.equals("") || valor2.equals("")){
            Toast not = Toast.makeText(this,"debe ingresar los dos valores",Toast.LENGTH_LONG);
            not.show();
        }else{
            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);
            String sel =spinner.getSelectedItem().toString();


            if (sel.equals("Sumar")){
                int suma= num1+num2;
                String resuelto = String.valueOf(suma);
                resultado.setText(resuelto);
            }else
                if (sel.equals("Restar")){
                    int resta =num1-num2;
                    String resuelve = String.valueOf(resta);
                    resultado.setText(resuelve);
                }
        }
    }
    public void volver (View view){
        finish();
    }
}
