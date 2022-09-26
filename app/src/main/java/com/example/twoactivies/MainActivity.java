package com.example.twoactivies;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tVmessage, tvTitulo;
    private EditText eTMessage;
    private Button btnSend;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tv_titulo_reply);
        tVmessage = findViewById(R.id.tv_menssagem_replay);
        eTMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.bt_send);
        String message = (String) getIntent().getSerializableExtra("KEY01");

        if(message != null){
            tvTitulo.setVisibility(View.VISIBLE);
            tVmessage.setVisibility(View.VISIBLE);
            tVmessage.setText(message);
        }


        btnSend.setOnClickListener(view -> {

            if(!eTMessage.getText().toString().isEmpty()){
                startActivity(new Intent(this, SecondActivity.class).putExtra("KEY",eTMessage.getText().toString()));
            }else{
                Toast.makeText(this,"Insira a messagem!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}