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

public class SecondActivity extends AppCompatActivity {

    private TextView tvMessage;
    private EditText eTReplay;
    private Button btnReply;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = findViewById(R.id.tv_menssagem_recebida);
        eTReplay = findViewById(R.id.et_message_back);
        btnReply = findViewById(R.id.bt_back);

        String message = (String) getIntent().getSerializableExtra("KEY");

        if(message != null){
          tvMessage.setText(message);
        }

        btnReply.setOnClickListener(view -> {

            if(!eTReplay.getText().toString().isEmpty()){
                startActivity(new Intent(this, MainActivity.class).putExtra("KEY01",eTReplay.getText().toString()));
                finishAffinity();
            }else{
                Toast.makeText(this,"Insira a messagem!!", Toast.LENGTH_LONG).show();
            }
        });
    }


}