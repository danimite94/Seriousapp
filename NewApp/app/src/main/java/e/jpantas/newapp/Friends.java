package e.jpantas.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Friends extends AppCompatActivity {

    EditText editUser1;
    Button btn_add;
    TextView txtAdd, txtInvites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        editUser1 = (EditText)findViewById(R.id.editUser1);
        btn_add = (Button)findViewById(R.id.btn_add);
        txtAdd = (TextView)findViewById(R.id.txtAdd);
        txtInvites = (TextView)findViewById(R.id.txtInvites);

    }
}
