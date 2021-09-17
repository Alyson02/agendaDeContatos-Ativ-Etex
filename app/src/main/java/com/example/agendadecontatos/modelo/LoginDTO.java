package com.example.agendadecontatos.modelo;

public class LoginDTO {
    //Atributos
    private int id;
    private String nome;
    private String usuario;
    private String senha;

    //Contrutores
    public LoginDTO() {

    }

    public LoginDTO(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public boolean autenticar(String usuario, String senha){
        if(this.usuario.equals(usuario)&&this.senha.equals(senha)){
            return true;
        }
       return false;
    }

    //ToString
    @Override
    public String toString() {
        return "DtoLogin{" +
                "nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
