package com.appdigital.projetointegradorbandasecasasdeshow.cadastro;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

public class Cadastro_Banda extends AppCompatActivity {
    FloatingActionButton save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__banda);

        save = findViewById(R.id.fabSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
