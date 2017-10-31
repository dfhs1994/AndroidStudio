package diego.sumaresta;

import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ficherosd extends AppCompatActivity {
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficherosd);

        et1=(EditText)findViewById(R.id.etNombreA);
        et2=(EditText)findViewById(R.id.etcontenido);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void grabarArchivo(View view){
        String nombreArchivo =et1.getText().toString();
        String contenidoArchivo = et2.getText().toString();
        try{
            File[] tarjeta= getExternalFilesDirs(null);
            String ubicacion = tarjeta[1].getAbsolutePath();


            File file =new File(ubicacion,nombreArchivo);

            OutputStreamWriter myFile = new OutputStreamWriter(new FileOutputStream(file));
            myFile.write(contenidoArchivo);
            myFile.flush();
            myFile.close();
            et1.setText("");
            et2.setText("");
            Toast.makeText(this,"Guardado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"no se pudo grabar", Toast.LENGTH_SHORT).show();


        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void recuperarArchivo(View view){
        String nomarchivo = et1.getText().toString();
        File[] tarjeta = getExternalFilesDirs(null);
        String ubicacion = tarjeta[1].getAbsolutePath();
        File file = new File(ubicacion,nomarchivo);

        try{
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fileStream);
            BufferedReader br =new BufferedReader(archivo);

            String linea = br.readLine();
            String contenido= "";
            while (linea!=null){
                contenido=contenido+linea+"\n";
                linea=br.readLine();
            }
            br.close();
            archivo.close();
            et2.setText(contenido);
        }catch (Exception e) {
            Toast.makeText(this, "nose pudo leer el archivo o no existe", Toast.LENGTH_LONG).show();
        }

    }


   @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void eliminarArchivo (View view){
        String nombreArchivo = et1.getText().toString();
        File[] tarjeta = getExternalFilesDirs(null);
       String ubicacion = tarjeta[1].getAbsolutePath();
       File file = new File(ubicacion, nombreArchivo);

        if (file.exists()){
            file.delete();
            Toast.makeText(this,"archivo eliminado",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Archivo no Existe",Toast.LENGTH_SHORT).show();
        }
        finish();

    }

}
