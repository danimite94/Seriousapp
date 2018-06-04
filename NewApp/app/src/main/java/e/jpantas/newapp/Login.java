package e.jpantas.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText editUser, editPass;
    Button buttonLogin;
    TextView txtRegister;
    Button button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUser = (EditText)findViewById(R.id.editUser);
        editPass = (EditText)findViewById(R.id.editPass);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        txtRegister = (TextView)findViewById(R.id.txtRegister);
        button_menu = (Button)findViewById(R.id.button_menu);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openRegister = new Intent(Login.this, Register.class);
                startActivity(openRegister);

            }
        });

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMainMenu();

            }
        });
    }

    public void openMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}

