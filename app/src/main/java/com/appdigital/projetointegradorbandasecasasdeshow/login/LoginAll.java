package com.appdigital.projetointegradorbandasecasasdeshow.login;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAll extends AppCompatActivity implements View.OnClickListener {

    TextView tvregistro;
    EditText etlogin, edtsenha;
    Button btsignin;
    private ProgressDialog progrerssDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_all);

        progrerssDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

        }

        tvregistro = (TextView)findViewById(R.id.tVregistrese);
        etlogin = (EditText)findViewById(R.id.editTextLogin);
        edtsenha = (EditText)findViewById(R.id.editTextSenha);
        btsignin = (Button)findViewById(R.id.buttonRegistrar);

        btsignin.setOnClickListener(this);
            tvregistro.setOnClickListener(this);

    }

    private void userLogin(){
        String login = etlogin.getText().toString().trim();
        String senha = edtsenha.getText().toString().trim();

        if(TextUtils.isEmpty(login)){
            Toast.makeText(this,"Por favor insira o email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(senha)){
            Toast.makeText(this,"Insira a sua senha",Toast.LENGTH_SHORT).show();
            return;

        }
        progrerssDialog.setMessage("Registrando Usuário...");
        progrerssDialog.show();

        firebaseAuth.signInWithEmailAndPassword(login,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     progrerssDialog.dismiss();
                     if (task.isSuccessful()){
                         finish();
                         startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

                     }
                    }
                });

    }


    @Override
    public void onClick(View v) {
        if (v ==btsignin){
            userLogin();
        }
        if (v == tvregistro){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}

