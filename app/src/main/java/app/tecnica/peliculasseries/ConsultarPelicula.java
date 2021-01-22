package app.tecnica.peliculasseries;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.tecnica.peliculasseries.utilidades.Utilidades;

public class ConsultarPelicula extends AppCompatActivity {

    EditText campoTitulo, campoAnio, campoRated;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_contenido", null,1);

        campoTitulo = (EditText) findViewById(R.id.campoTitulo);
        campoAnio= (EditText)findViewById(R.id.campoAnio);
        campoRated= (EditText)findViewById(R.id.campoRated);
    }

    public void onClick(View view) {

        SQLiteDatabase db= conn.getWritableDatabase();
        String [] parametros ={campoTitulo.getText().toString()};
        String [] campos    ={Utilidades.CAMPO_ANIO, Utilidades.CAMPO_CLASI};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_CONTENIDO,campos,Utilidades.CAMPO_TITULO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoAnio.setText(cursor.getString(0));
            campoRated.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El contenido no exixte", Toast.LENGTH_SHORT).show();
            limpiar();

        }
    }

    private void limpiar() {

        campoAnio.setText("");
        campoRated.setText("");
    }
}