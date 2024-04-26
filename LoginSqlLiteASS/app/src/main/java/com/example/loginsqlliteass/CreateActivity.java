package com.example.loginsqlliteass;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    protected Cursor cursor;
    DatabaseHelper database;
    Button btn_simpan;
    EditText nama,prodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new DatabaseHelper(this);
        nama = findViewById(R.id.nama);
        prodi= findViewById(R.id.prodi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidInput()) {
                    SQLiteDatabase db = database.getWritableDatabase();
                    db.execSQL("INSERT INTO mahasiswa(nama,kampus) values('" +
                            nama.getText().toString() + "','" +
                            prodi.getText().toString() + "')");
                    Toast.makeText(CreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    MainActivity.ma.RefreshList();
                    finish();
                } else {
                    Toast.makeText(CreateActivity.this, "Data Harus Lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidInput() {
        return !TextUtils.isEmpty(nama.getText().toString()) && !TextUtils.isEmpty(prodi.getText().toString());
    }
}
