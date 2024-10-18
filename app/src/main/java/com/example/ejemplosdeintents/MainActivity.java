 package com.example.ejemplosdeintents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.EditText;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    private Button ejemplo1_im, ejemplo2_im, ejemplo3_im;
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // EXPLICITOS
        // Ir a otra actividad
        Button buttonExample1 = findViewById(R.id.ejemplo1_ex);
        buttonExample1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        //  Enviar datos a otra actividad
        Button buttonenviar = findViewById(R.id.ejemplo2_ex);

        buttonenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  msg
                String message = "¡Hola desde MainActivity!";

                // enviar
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message_key", message); // Enviar el mensaje con una clave "message_key"
                startActivity(intent); // Iniciar la nueva Activity
            }
        });

        Button buttonExample2 = findViewById(R.id.ejemplo3_ex);
        buttonExample2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Third.class);
            startActivity(intent);
        });



        // IMPLICITOS
        ejemplo1_im = findViewById(R.id.ejemplo1_im);
        ejemplo2_im = findViewById(R.id.ejemplo2_im);
        ejemplo3_im = findViewById(R.id.ejemplo3_im);

        // abrir una url
        ejemplo1_im.setOnClickListener(v -> {
            String url = "https://utt.edu.mx"; // Aquí pon la URL que quieras
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        // abrir la cámara

        ejemplo2_im.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        // compartir texto
        ejemplo3_im.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Ejmplo 2 de intents implicitos.");
            startActivity(Intent.createChooser(intent, "Compartir vía"));
        });
    }

}