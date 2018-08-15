package e.jpantas.newapp;

import android.app.LoaderManager;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import android.support.annotation.NonNull;
import android.app.ProgressDialog;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity implements ValueEventListener{

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private ProgressDialog PD;

    EditText editMail, editPass;
    Button buttonLogin;
    TextView txtRegister;
    Button button_menu;

    private static final String nome_do_user = "nome_do_user_register";
    private static final String nome_do_user2 = "nome_do_user_signin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        editMail = (EditText) findViewById(R.id.editUser);
        editPass = (EditText) findViewById(R.id.editPass);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        txtRegister = (TextView) findViewById(R.id.txtRegister);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openRegister = new Intent(Login.this, Register.class);
                startActivity(openRegister);

            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                String password = editPass.getText().toString();
                String mail = editMail.getText().toString();

                //look for corresponding email

                try {
                    Log.d(nome_do_user2, editMail.getText().toString());

                    if (password.length() > 0 && mail.length() > 0) {
                        PD.show();
                        //String domain = "@serious.com";
                        //String email = username + domain;
                        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    try {
                                        throw task.getException();
                                    } catch (FirebaseAuthInvalidUserException e) {
                                        Toast.makeText(Login.this, "Invalid Emaild Id", Toast.LENGTH_LONG).show();

                                    } catch (FirebaseAuthInvalidCredentialsException e) {
                                        Toast.makeText(Login.this, "Invalid Password", Toast.LENGTH_LONG).show();

                                    } catch (FirebaseNetworkException e) {
                                        Toast.makeText(Login.this, "error_message_failed_sign_in_no_network", Toast.LENGTH_LONG).show();

                                    } catch (Exception e) {
                                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                    }

                                } else {
                                    Intent intent = new Intent(Login.this, MainMenu.class);
                                    startActivity(intent);
                                    finish();
                                }
                                PD.dismiss();
                            }
                        });
                    } else {
                        Toast.makeText(
                                Login.this, "Fill All fields", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {


    }

}

