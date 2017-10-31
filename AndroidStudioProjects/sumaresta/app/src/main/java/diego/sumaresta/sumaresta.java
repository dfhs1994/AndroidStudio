package diego.sumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class sumaresta extends AppCompatActivity {

    private EditText num1, num2;
    private TextView resultado;
    private RadioButton suma, resta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumaresta);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        resultado = (TextView) findViewById(R.id.resultado);
        resta = (RadioButton) findViewById(R.id.resta);
        suma = (RadioButton) findViewById(R.id.suma);
    }

    public void resolver(View view) {

        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        if (suma.isChecked()) {
            int sumar = num1 + num2;
            resultado.setText(String.valueOf(sumar));
        } else if (resta.isChecked()) {
            int restar = num1 - num2;
            resultado.setText(String.valueOf(restar));
        }
    }
    public void volver (View view){
        finish();
    }
}