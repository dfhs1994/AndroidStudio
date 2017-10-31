package diego.sumaresta;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fichero extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichero);

        et1=(EditText)findViewById(R.id.editText3);
        String[] archivos = fileList();
        if (existeArchivo(archivos, "receta.txt"));
        try {
            InputStreamReader file = new InputStreamReader(
                    openFileInput("receta.txt"));
            BufferedReader br = new BufferedReader(file);
            String linea = br.readLine();
            String todo = "";
            while (linea != null){

                todo = todo + linea + "\n";
                linea = br.readLine();
            }
            br.close();
            file.close();
            et1.setText(todo);
        }catch (Exception e){
            Toast mensaje =
                    Toast.makeText(this,"Error- no es posible cargar los datos",Toast.LENGTH_LONG);
            mensaje.show();
        }

    }
    private boolean existeArchivo(String[] archivos, String buscado){
        for (int i = 0; i< archivos.length;i++)
            if (buscado.equals(archivos[i]))
                return true;
        return false;
    }
    public void grabar (View view){
        try {
            OutputStreamWriter file =
                    new OutputStreamWriter(openFileOutput("receta.txt", Activity.MODE_PRIVATE));
            file.write(et1.getText().toString());
            file.flush();
            file.close();

            Toast mensaje = Toast.makeText(this, "Datos Grabados", Toast.LENGTH_SHORT);
            mensaje.show();
            finish();
        }catch (Exception e){
            Toast mensaje=
                    Toast.makeText(this, "ERROR, No fue posible guardar los datos",Toast.LENGTH_LONG);
            mensaje.show();
        }


    }
    public void eliminarArchivo (View view){
        File dir = getFilesDir();
        File file = new File(dir, "receta.txt");
        file.delete();
        finish();
    }
    public void volver (View view){
        finish();
    }
}
