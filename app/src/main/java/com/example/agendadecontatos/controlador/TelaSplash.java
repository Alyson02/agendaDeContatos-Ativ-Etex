package com.example.agendadecontatos.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.agendadecontatos.R;

import java.util.Timer;
import java.util.TimerTask;


public class TelaSplash extends AppCompatActivity {
    private static final int TEMPO = 2000; // em MILESEGUNDOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        inicializarTelaLogin();
    }

    private void inicializarTelaLogin() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent telaLogin = new Intent(getApplicationContext(), TelaLogin.class);
                startActivity(telaLogin);
            }
        }, TEMPO);

    }


}



