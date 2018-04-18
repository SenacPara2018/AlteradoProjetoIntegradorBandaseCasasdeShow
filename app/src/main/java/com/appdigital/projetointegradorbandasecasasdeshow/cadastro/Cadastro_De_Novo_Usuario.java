package com.appdigital.projetointegradorbandasecasasdeshow.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

public class Cadastro_De_Novo_Usuario extends AppCompatActivity {

    EditText edtnomecasashow;
    EditText edtendereco;
    Spinner spinnerbairro;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__de__novo__usuario_casadeshow);


    }
}
