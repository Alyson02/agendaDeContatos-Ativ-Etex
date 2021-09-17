package com.example.agendadecontatos.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendadecontatos.modelo.LoginDTO;
import com.example.agendadecontatos.R;

public class TelaLogin extends AppCompatActivity {
Button buttonEnviar;
Button buttonCancelar;
EditText editTextUsuario;
EditText editTextSenha;
//Usuario e senha de teste.
LoginDTO dtoLogin = new LoginDTO("Rubens","admin","admin");
LoginDTO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenha = findViewById(R.id.editTextSenha);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editTextUsuario.getText().toString();
                String senha =  editTextSenha.getText().toString();
                logar(usuario,senha);

            }
        });
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpar os campos de texto.
                editTextUsuario.setText("");
                editTextSenha.setText("");
            }
        });

    }
     private  void logar(String usuario, String senha){
       // DtoLogin dtoLogin = dao.



        if(dtoLogin.autenticar(usuario,senha)){
            //Ir para a tela de menu.
            Intent telaMenu = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(telaMenu);
        }else{
            Toast.makeText(this, "Usuario ou Senha incorretos!", Toast.LENGTH_SHORT).show();
        }
     }


}