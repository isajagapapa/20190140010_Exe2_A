package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class EditTeman extends AppCompatActivity {

    private TextInputEditText tNama, tTelpon;
    private Button simpanBtn;
    String id, nm, tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teman);

        tNama = (TextInputEditText)findViewById(R.id.tietNamaed);
        tTelpon = (TextInputEditText)findViewById(R.id.tietTelponed);
        simpanBtn = (Button)findViewById(R.id.buttonSaveed);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telepon");

        setTitle("Edit Data");
        tNama.setText(nm);
        tTelpon.setText(tlp);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum lengkap !", Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues =  new HashMap<>();
                    qvalues.put("id", id);
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.updateData(qvalues);
                    callHome1();
                }
            }
        });
    }

    public void callHome1(){
        Intent intent = new Intent(EditTeman.this,MainActivity.class);
        startActivity(intent);
    }
}