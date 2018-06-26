package e.jpantas.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog PD;
    EditText editUsername, editPassword, editEmail;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, MainMenu.class));
            finish();
        }

        //acao do botao REGISTER
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    CallDatabase(editUsername.getText().toString(), editPassword.getText().toString(), editEmail.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void CallDatabase(String username, String password, String mail) {

        //password restrictions
        if (password.length() > 0 && username.length() > 0) {
            PD.show();
            //String domain = "@serious.com";
            //String email = username + domain;
            mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(
                                Register.this,
                                "Authentication Failed",
                                Toast.LENGTH_LONG).show();
                        Log.v("error", task.getResult().toString());
                    } else {
                        Intent intent = new Intent(Register.this, MainMenu.class);
                        startActivity(intent);
                        finish();
                    }
                    PD.dismiss();
                }
            });
        } else {
            Toast.makeText(
                    Register.this, "Fill All fields", Toast.LENGTH_LONG).show();
        }


    }

}

