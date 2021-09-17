package com.example.agendadecontatos.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.agendadecontatos.repositorio.ContatoDAO;
import com.example.agendadecontatos.modelo.ContatoDTO;
import com.example.agendadecontatos.R;

import java.util.ArrayList;

public class ConsultaContato extends AppCompatActivity {
    Button buttonNovoContato;
    ListView listViewContato;
    ArrayList<ContatoDTO> arrayListContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_contato);
        buttonNovoContato = findViewById(R.id.buttonNovoContato);
        listViewContato = findViewById(R.id.listViewContato);
        ContatoDAO daoContato = new ContatoDAO(getApplicationContext());

        arrayListContato = daoContato.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListContato);

        listViewContato.setAdapter(adapter);


        cadastrarNovoContato();
    }

    private void cadastrarNovoContato() {
        buttonNovoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoContato = new Intent(getApplicationContext(), CadastrarContato.class);
                startActivity(novoContato);
            }
        });
    }
}
