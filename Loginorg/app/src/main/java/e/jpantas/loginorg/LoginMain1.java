package e.jpantas.loginorg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginMain1 extends AppCompatActivity {

    EditText editUser, editPass;
    Button buttonLogin;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main1);

        editUser = (EditText)findViewById(R.id.editUser);
        editPass = (EditText)findViewById(R.id.editPass);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        txtRegister = (TextView)findViewById(R.id.txtRegister);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openRegister = new Intent(LoginMain1.this, RegisterMain1.class);
                startActivity(openRegister);
            }
        });
    }
}
