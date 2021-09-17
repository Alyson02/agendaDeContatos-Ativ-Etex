package com.example.agendadecontatos.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioBase extends SQLiteOpenHelper  {
    private final  String TABELA_CONTATO = "TB_CONTATO";
    private final String TABELA_LOGIN = "TB_LOGIN";


    public RepositorioBase(@Nullable Context context ){

        super(context, "DB_Contato", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABELA_CONTATO +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";

        db.execSQL(sql);

        String sqlLogin = "CREATE TABLE "+ TABELA_LOGIN +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "USUARIO VARCHAR(50)," +
                "SENHA VARCHAR(15))";
        db.execSQL(sqlLogin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean inserir(String nomeDaTabela, ContentValues objeto){
        boolean successful = false;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.insert(nomeDaTabela, null, objeto);
            successful = true;
        }catch (Exception e){
            successful = false;
            Log.e("Erro ao salvar" + objeto, e.toString());
        }
        db.close();
        return successful;
    }
}

