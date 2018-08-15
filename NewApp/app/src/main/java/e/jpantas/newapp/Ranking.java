package e.jpantas.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ranking extends AppCompatActivity {
    Button btn_back;
<<<<<<< HEAD

    String username;
    long score;

=======
>>>>>>> e949f1827bba581e3150b4f35f20272c96e6745a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        btn_back = (Button)findViewById(R.id.btn_help);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
