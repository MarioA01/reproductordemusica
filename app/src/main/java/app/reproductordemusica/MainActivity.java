package app.reproductordemusica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button stop,play,siguiente,atras;
    MediaPlayer mp3[]=new MediaPlayer[4];
    TextView texto,album;
    int item=0;
    ImageView portada;
    ArrayList<String> autores=new ArrayList<String>();
    ArrayList<String> albumes=new ArrayList<String>();
    ArrayList<Integer> portadas = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.atras = findViewById(R.id.button_back);
        this.play = findViewById(R.id.button_play);
        this.stop = findViewById(R.id.button_pause);
        this.siguiente = findViewById(R.id.button_next);
        this.texto =findViewById(R.id.TextView);
        this.album =findViewById(R.id.album);
        this.portada = findViewById(R.id.portada);
        mp3[0] = MediaPlayer.create(MainActivity.this,R.raw.song1);
        mp3[1] = MediaPlayer.create(MainActivity.this,R.raw.song2);
        mp3[2] = MediaPlayer.create(MainActivity.this,R.raw.song3);
        mp3[3] = MediaPlayer.create(MainActivity.this,R.raw.song4);

       autores.add("Raul Ornelas");
       autores.add("Ed Sheeran");
       autores.add("Kurt");
       autores.add("Los Amigos Invisibles");

        albumes.add("Mi lado izquierdo");
        albumes.add("Blood Stream");
        albumes.add("Single");
        albumes.add("Repeat after me");

       portadas.add(R.drawable.portada1);
       portadas.add(R.drawable.portada2);
       portadas.add(R.drawable.portada3);
       portadas.add(R.drawable.portada4);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("");
                Toast mensaje=Toast.makeText(getApplicationContext(),"Playing",Toast.LENGTH_SHORT);
                mensaje.show();
                mp3[item].start();
                texto.setText(autores.get(item).toUpperCase());
                album.setText(albumes.get(item).toUpperCase());
                portada.setImageResource(portadas.get(item));
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp3[item].isPlaying()){
                    texto.setText("");
                    Toast mensaje=Toast.makeText(getApplicationContext(),"Pause",Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                    texto.setText(autores.get(item).toUpperCase());
                    album.setText(albumes.get(item).toUpperCase());
                    portada.setImageResource(portadas.get(item));
                }
                else {
                    texto.setText("");
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                    texto.setText(autores.get(item).toUpperCase());
                    album.setText(albumes.get(item).toUpperCase());
                    portada.setImageResource(portadas.get(item));
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(item>0){
                 if(mp3[item].isPlaying()){
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT);
                     mensaje.show();
                     mp3[item].stop();
                     mp3[0]=MediaPlayer.create(MainActivity.this,R.raw.song1);
                     mp3[1]=MediaPlayer.create(MainActivity.this,R.raw.song2);
                     mp3[2]=MediaPlayer.create(MainActivity.this,R.raw.song3);
                     mp3[3]=MediaPlayer.create(MainActivity.this,R.raw.song4);

                     item--;
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                     album.setText(albumes.get(item).toUpperCase());
                     portada.setImageResource(portadas.get(item));
                 }
                 else{
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT);
                     mensaje.show();
                     item--;
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                     album.setText(albumes.get(item).toUpperCase());
                     portada.setImageResource(portadas.get(item));
                 }

              }
              else{
                  Toast mensaje=Toast.makeText(getApplicationContext(),"Sin pista anterior",Toast.LENGTH_SHORT);
                  mensaje.show();
              }

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(item<mp3.length-1){
                    if(mp3[item].isPlaying()){
                        texto.setText("");
                        Toast mensaje=Toast.makeText(getApplicationContext(),"Next",Toast.LENGTH_SHORT);
                        mensaje.show();
                        mp3[item].stop();
                        item++;
                        mp3[item].start();
                        texto.setText(autores.get(item).toUpperCase());
                        album.setText(albumes.get(item).toUpperCase());
                        portada.setImageResource(portadas.get(item));
                     }
                    else{
                        texto.setText("");
                        item++;
                        mp3[item].start();
                        texto.setText(autores.get(item).toUpperCase());
                        album.setText(albumes.get(item).toUpperCase());
                        portada.setImageResource(portadas.get(item));
                    }
                 }
                else{
                    Toast mensaje=Toast.makeText(getApplicationContext(),"Sin pista siguiente",Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });
    }

}
