package app.tecnica.peliculasseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_contenido", null,1);
    }

    public void onClick(View view) {

        Intent miIntent = null;
        switch (view.getId()){
            case R.id.btnOpcionesRegistro:
                miIntent = new Intent(MainActivity.this, Registro.class);
                break;

            case R.id.btnConsultarPeliculas:
                miIntent = new Intent(MainActivity.this, ConsultarPelicula.class);
                break;

            case R.id.btnConsultarSeries:
                miIntent = new Intent(MainActivity.this, ConsultarSerie.class);
                break;





        }
        if (miIntent!=null){

            startActivity(miIntent);
        }
    }
}