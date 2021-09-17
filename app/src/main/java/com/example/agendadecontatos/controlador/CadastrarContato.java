package com.example.agendadecontatos.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendadecontatos.repositorio.ContatoDAO;
import com.example.agendadecontatos.modelo.ContatoDTO;
import com.example.agendadecontatos.R;

public class CadastrarContato extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextTelefone;
    EditText editTextEndereco;
    Button buttonSalvar;
    Button buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_contato);
        editTextNome = findViewById(R.id.editTextNomeContato);
        editTextEmail = findViewById(R.id.editTextEmailContato);
        editTextTelefone = findViewById(R.id.editTextTelefoneContato);
        editTextEndereco = findViewById(R.id.editTextEnderecoContato);
        buttonSalvar = findViewById(R.id.buttonSalvarContato);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ContatoDTO dtoContato = new ContatoDTO(editTextNome.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextTelefone.getText().toString(),
                        editTextEndereco.getText().toString());
               ContatoDAO daoContato = new ContatoDAO(getApplicationContext());
                try {
                    if (daoContato.inserir(dtoContato) > 0) {
                        Toast.makeText(CadastrarContato.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(CadastrarContato.this, "Erro ao Inserido: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}