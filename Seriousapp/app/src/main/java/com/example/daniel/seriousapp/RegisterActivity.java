package com.example.daniel.seriousapp;

import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressDialog PD;
    private EditText Name;
    private EditText Pass;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        Name = findViewById(R.id.user);
        Pass = findViewById(R.id.pass);
        Register = findViewById(R.id.sign_up_button);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(RegisterActivity.this, MenuPrincipal.class));
            finish();
        }

        //acao do botao REGISTER
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    CallDatabase(Name.getText().toString(), Pass.getText().toString());
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void CallDatabase(String username, String password) {

        //password restrictions
        if (password.length()>0 && username.length()>0){
            PD.show();
            String domain = "@serious.com";
            String email= username+domain;
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(
                                RegisterActivity.this,
                                "Authentication Failed",
                                Toast.LENGTH_LONG).show();
                        Log.v("error", task.getResult().toString());
                    } else {
                        Intent intent = new Intent(RegisterActivity.this, MenuPrincipal.class);
                        startActivity(intent);
                        finish();
                    }
                    PD.dismiss();
                }
            });
        }else{
            Toast.makeText(
                    RegisterActivity.this,"Fill All fields",Toast.LENGTH_LONG).show();
        }


    }


}
