package com.appdigital.projetointegradorbandasecasasdeshow.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etlogin, edtsenha;
    Button btlogar;
    TextView tvregistro;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        etlogin = (EditText)findViewById(R.id.editTextLogin);
        edtsenha = (EditText)findViewById(R.id.editTextSenha);
        btlogar = (Button)findViewById(R.id.buttonLogar);
        tvregistro = (TextView) findViewById(R.id.textViewRg);

        tvregistro.setOnClickListener(this);
    }

    private void registrar() {
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
        progressDialog.setMessage("Registrando Usuário...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(login,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

                        }else{
                            Toast.makeText(MainActivity.this,"Falha ao registrar, tente novamente.",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == btlogar){
            registrar();
        }
        if (v == tvregistro){
            startActivity(new Intent(this,LoginAll.class));


        }
    }
}
