package home.com.ejerciciodenivelacion;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IniciarJuego extends AppCompatActivity implements View.OnClickListener{


    TextView Puntos,txtGanados, txtPerdidos, txtEmpates, nombreJugador;
    Random pc;
    Button btn, btnFinalizar;
    String [] mano = {"PIEDRA", "PAPEL","TIJERA","PIEDRA", "PAPEL","TIJERA"};
    int min = 0;
    int max = 5;
    int contaganes=0,contaperdido=0,empa=0,puntos=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);




        btn = (Button)findViewById(R.id.btncpu);
        nombreJugador = (TextView)findViewById(R.id.idNombre);
        nombreJugador.setText(NuevoJugador.nomJugador);
        btnFinalizar = (Button)findViewById(R.id.btnFinalizar);
        nombreJugador = (TextView)findViewById(R.id.idNombre);
        Puntos = (TextView)findViewById(R.id.txtPuntos);
        txtGanados = (TextView)findViewById(R.id.txtganados);
        txtPerdidos = (TextView)findViewById(R.id.txtPerdidos);
        txtEmpates = (TextView)findViewById(R.id.txtEmpatados);

        pc = new Random();
        Puntos.setText("Puntos: "+puntos);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_iniciar_juego, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    String generaricono(String x){
        String ret = null;
        if(x=="PAPEL"){
            ret = "[_]";
        }
        if(x=="TIJERA"){
            ret = "X";
        }
        if(x=="PIEDRA"){
            ret="O";
        }
        return ret;

    }
    public void cerrar(View v){
        this.finish();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.btnPiedra:

                Comparar(mano[pc.nextInt(max - min + 1) + min], "PIEDRA");

                break;
            case R.id.btnTijera:
                Comparar(mano[pc.nextInt(max - min + 1) + min], "TIJERA");


                break;
            case R.id.btnPapel:
                Comparar(mano[pc.nextInt(max - min + 1) + min], "PAPEL");

                break;



        }
        //temporizador

        new CountDownTimer(2500, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                btn.setText("   ");

            }
        }.start();

        //termina temporizador

        txtGanados.setText(String.valueOf(contaganes));
        txtPerdidos.setText(String.valueOf(contaperdido));
        txtEmpates.setText(String.valueOf(empa));
    }

    public  void Comparar(String ingreso1, String ingreso2){
        btn.setText(generaricono(ingreso1));

        if(ingreso1 == ingreso2){
            Toast.makeText(this, "EMPATE", Toast.LENGTH_SHORT).show();
            empa++;
        }else if((ingreso1=="TIJERA" && ingreso2=="PAPEL")|(ingreso1=="PIEDRA" && ingreso2=="TIJERA")|(ingreso1=="PAPEL" && ingreso2=="PIEDRA")){

            //GANADOR 1

            Toast.makeText(this, "GANA PC", Toast.LENGTH_SHORT).show();
            contaperdido++;
            puntos-=3;
            Puntos.setText("Puntos: "+ puntos);
        }else {

            //GANADOR 2

            Toast.makeText(this, "FELICIDADES HAS GANADO", Toast.LENGTH_SHORT).show();
            contaganes++;
            puntos+=6;
            Puntos.setText("Puntos: "+ puntos);
        }


    }

}
