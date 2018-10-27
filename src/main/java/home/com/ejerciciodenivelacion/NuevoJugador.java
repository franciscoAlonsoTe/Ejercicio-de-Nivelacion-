package home.com.ejerciciodenivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoJugador extends AppCompatActivity implements View.OnClickListener {

    EditText NombreJugador;
    private Button btnRegistrar;
    public static String nomJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);

        this.btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        this.NombreJugador= (EditText) findViewById(R.id.edtNombreJugador);
        this.btnRegistrar.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_nuevo_jugador, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String NombreJugador;
        String nuevo = "nuevo";

        Intent data = new Intent();
        EditText miEditText = (EditText) findViewById(R.id.edtNombreJugador);
        this.nomJugador = miEditText.getText().toString();

        setResult(RESULT_OK, data);
        this.finish();

    }
}
