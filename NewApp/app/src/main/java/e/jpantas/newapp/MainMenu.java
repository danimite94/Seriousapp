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


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartGame();
            }
        });

        btn_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFriends();
            }
        });

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRanking();
            }
        });



    }

    public void openStartGame() {
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
        }

    public void openFriends() {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);

        // changes color if a friendship request has been sent

    }

    public void openRanking() {
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }
}
