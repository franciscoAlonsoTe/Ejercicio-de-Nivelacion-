package home.com.ejerciciodenivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Principal extends AppCompatActivity implements View.OnClickListener {

    private Button btnNuevo, btnIniciar, btnPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.btnNuevo=(Button) findViewById(R.id.btnNuevo);

        this.btnNuevo.setOnClickListener(this);

        this.btnIniciar=(Button) findViewById(R.id.btnIniciar);
        this.btnIniciar.setOnClickListener(this);

        this.btnPuntaje=(Button) findViewById(R.id.btnPuntaje);
        this.btnPuntaje.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNuevo:
                Intent i = new Intent(Principal.this, NuevoJugador.class);
                startActivity(i);
                break;

            case R.id.btnIniciar:
                Intent intencion = new Intent(Principal.this, IniciarJuego.class);
                startActivity(intencion);
                break;

            case R.id.btnPuntaje:
                Intent intent = new Intent(Principal.this, Puntajes.class);
                startActivity(intent);

        }

    }

}
