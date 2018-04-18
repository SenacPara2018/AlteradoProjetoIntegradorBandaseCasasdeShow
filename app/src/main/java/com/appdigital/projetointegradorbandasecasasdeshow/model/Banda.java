package com.appdigital.projetointegradorbandasecasasdeshow.model;

/**
 * Created by TARDE on 12/04/2018.
 */

public class Banda {
    private String nomeBanda;

    private String telefone;

    //========Get Set nome=====
    public void setNomeBanda(String nomeBanda) {
        this.nomeBanda = nomeBanda;
    }
    public String getNomeBanda() {
        return nomeBanda;
    }

    //===========Get Set CampoTelefone======
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Lista de Banda{ nome: " +nomeBanda+ "" +
                " Tefeone: " +telefone +"}";
    }
}
