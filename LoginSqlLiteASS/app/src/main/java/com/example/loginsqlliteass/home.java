package com.example.loginsqlliteass;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Mendapatkan referensi ke tombol-tombol dari layout
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        // Menambahkan OnClickListener untuk setiap tombol
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk aktivitas "LihatDataActivity"
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk aktivitas "InputDataActivity"
                Intent intent = new Intent(home.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk aktivitas "InformasiActivity"
                Intent intent = new Intent(home.this, Informasi.class);
                startActivity(intent);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk aktivitas "InformasiActivity"
                Intent intent = new Intent(home.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
