package e.jpantas.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button btn_start, btn_friends, btn_ranking, btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_friends = (Button)findViewById(R.id.btn_friends);
        btn_ranking = (Button)findViewById(R.id.btn_ranking);
        btn_help = (Button)findViewById(R.id.btn_help);


    }

}
