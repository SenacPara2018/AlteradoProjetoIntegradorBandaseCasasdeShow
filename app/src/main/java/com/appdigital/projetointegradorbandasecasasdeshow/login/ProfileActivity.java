package com.appdigital.projetointegradorbandasecasasdeshow.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button btsair;
    TextView tvuseremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth =FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this,LoginAll.class));
        }

        FirebaseUser usuario = firebaseAuth.getCurrentUser();

        tvuseremail = (TextView)findViewById(R.id.textViewuseremail);

        tvuseremail.setText("Bem vindo!"+ usuario.getEmail());
        btsair = (Button)findViewById(R.id.btsair);
        btsair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btsair){
            firebaseAuth.signOut();
            startActivity(new Intent(this,LoginAll.class));
            finish();
        }

    }
}
