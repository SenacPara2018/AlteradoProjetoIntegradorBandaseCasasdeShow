package com.appdigital.projetointegradorbandasecasasdeshow.model;

public class CasaDeShow {
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String senha;
    private String confirmarSenha;

    //========Get Set nome=====
    public void setNome(String nomeBanda) {
        this.nome = nomeBanda;
    }
    public String getNome() {
        return nome;
    }

    //========set get senha========
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    //==========Get Set Email==========
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    //==========Get Set confirmarSenha======
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    public String getConfirmarSenha() {
        return confirmarSenha;
    }


    //===========Get Set CampoTelefone======
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //============Get Set Telefone=========
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return endereco;
    }
}
