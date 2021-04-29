package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatTeman extends AppCompatActivity {

    TextView tvnama, tvnomor;
    String id, nm, tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lihat_teman);

        tvnama = findViewById(R.id.tvNama);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        setTitle("Lihat Data");
        tvnama.setText(nm);
        tvnomor.setText(tlp);
    }
}