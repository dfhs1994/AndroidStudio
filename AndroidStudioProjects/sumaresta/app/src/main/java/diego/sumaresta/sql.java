package diego.sumaresta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sql extends AppCompatActivity {
    private EditText et_rut,et_nombre,et_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        et_rut =(EditText)findViewById(R.id.etRut);
        et_nombre=(EditText)findViewById(R.id.etNombre);
        et_telefono=(EditText)findViewById(R.id.etTelefno);

    }
    public void ingresar (View v){
        adminSqlite admin =
                new adminSqlite(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String rut = et_rut.getText().toString();
        String nombre = et_nombre.getText().toString();
        String telefono = et_telefono.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("rut",rut);
        registro.put("nombre",nombre);
        registro.put("telefono", telefono);
        bd.insert("alumnos",null, registro);
        bd.close();
        et_rut.setText("");
        et_nombre.setText("");
        et_telefono.setText("");
        Toast.makeText(this,"se guardaron los datos de alumno", Toast.LENGTH_LONG).show();
    }
    public void consultarPorRut (View v){
        adminSqlite admin =
                new adminSqlite(this,"administracion",null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String rut = et_rut.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre,telefono,from alumnos where rut="+ rut,null);
        if (fila.moveToFirst()){
            et_nombre.setText(fila.getString(0));
            et_telefono.setText(fila.getString(1));
        }else
            Toast.makeText(this,"No existe informacion del Rut", Toast.LENGTH_SHORT).show();

    bd.close();
    }
    public void consultaPorNombre(View v){
        adminSqlite admin =
                new adminSqlite(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombreAlumno = et_nombre.getText().toString();
        Cursor fila =bd.rawQuery("select rut,telefono from alumnos where nombre='"+nombreAlumno+"'",null);
        if (fila.moveToFirst()){
            et_rut.setText(fila.getString(0));
            et_telefono.setText(fila.getString(1));

        }else
            Toast.makeText(this,"no existe informacion del nombre",Toast.LENGTH_SHORT).show();
        bd.close();

    }
    public void eliminarAlumno (View v){
        adminSqlite admin = new adminSqlite(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String rut = et_rut.getText().toString();
        int cant = bd.delete("alumnos","rut= '"+rut +"'",null);
        bd.close();
        et_rut.setText("");
        et_nombre.setText("");
        et_telefono.setText("");

        if (cant ==1)
            Toast.makeText(this,"se borro el alumno",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"No existeun alumno con el Rut",Toast.LENGTH_SHORT).show();
    }
    public  void  modificarAlumno (View v){
        adminSqlite admin =new adminSqlite(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String rut =et_rut.getText().toString();
        String nombre =et_nombre.getText().toString();
        String telefono =et_telefono.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("rut",rut);
        registro.put("nombre",nombre);
        registro.put("telefono",telefono);
        int cant = bd.update("alumnos",registro,"rut="+ rut,null);
        bd.close();
        if (cant==1)
            Toast.makeText(this,"se modificaron los datos del alumnos",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"no existe un alumno con ese Rut",Toast.LENGTH_SHORT).show();
    }
    public  void regresar (View view) {
        finish();
    }
}



