package e.jpantas.loginorg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterMain1 extends AppCompatActivity {

    EditText editUsername, editEmail, editPassword;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main1);

        editUsername = (EditText)findViewById(R.id.editUsername);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword = (EditText)findViewById(R.id.editPassword);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
    }
}
