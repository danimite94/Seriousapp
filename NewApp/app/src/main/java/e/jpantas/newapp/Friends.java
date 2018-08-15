package e.jpantas.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Friends extends AppCompatActivity {

    EditText editUser1;
    Button btn_back;
    TextView txtAdd, txtInvites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        editUser1 = (EditText)findViewById(R.id.editUser1);
        txtAdd = (TextView)findViewById(R.id.txtAdd);
        txtInvites = (TextView)findViewById(R.id.txtInvites);
        btn_back = (Button)findViewById(R.id.btn_back);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }

    public void sendinvite() {
        // look for specific username and check if it exists while the name is being written


        // if DB contains users with searched term, add element in list of invites (below "invites:")
        // ex. "serna" might show "Sernardo" and "caserna". If more names than the ones that fit in the phone screen show up,
        // a scrolling bar shows up to go up and down


        // name(s) that show up is a textfield that once clicked sends a friendship invitation
        // v2) opens profile view with some stats of the person and photo and "add" button


        // if DB doesnt contain users that were searched for, a "user not found" message shows up under the
        // "Invites:" section
    }


    public void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }



    //image of the emoji shows up a notification warning with number of invitations holding for response)
    // , like in facebook messages. Once clicked, it opens a view with the profile
    // of the inviter and in the end you accept/reject. the view has the size of the screen.
}
