package app.tecnica.peliculasseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.tecnica.peliculasseries.utilidades.Utilidades;

public class Registro extends AppCompatActivity {

    EditText campoTitulo, campoAnio, campoRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        campoTitulo= (EditText) findViewById(R.id.campoTitulo);
        campoAnio=(EditText) findViewById(R.id.campoAnio);
        campoRated=(EditText)findViewById(R.id.campoRated);
    }

    public void onClick(View view) {

        registrar();
        //registrar2();
    }

    private void registrar() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_contenido", null,1);
        SQLiteDatabase db=conn.getWritableDatabase();


        String insert="INSERT INTO "+ Utilidades.TABLA_CONTENIDO
                +" ("
                +Utilidades.CAMPO_TITULO+","+Utilidades.CAMPO_ANIO+","+Utilidades.CAMPO_CLASI+")" +
                "VALUES ('"+campoTitulo.getText().toString()+"', '"+campoAnio.getText().toString()+"','"
                +campoRated.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(), "Contenido registrado Exitosamente", Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void registrar2() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_contenido", null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_TITULO,campoAnio.getText().toString());
        values.put(Utilidades.CAMPO_ANIO,campoAnio.getText().toString());
        values.put(Utilidades.CAMPO_CLASI,campoRated.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_CONTENIDO, Utilidades.CAMPO_TITULO,values);
        Toast.makeText(getApplicationContext(), "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();

    }
}