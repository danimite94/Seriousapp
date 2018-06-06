package e.jpantas.newapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/*When on the shared cloud, you share the Quickblox instance with other users -
        this is fine for most developers. When traffic is high, it might
        affect the speed of the API and slow down your app. The Medium and
        Pro tiers are on higher priority than the Starter tier.

        Dedicated instance means you are able to host the Quickblox API on
        your own servers, and therefore you pay only for what you need and
        never experience interference from other users.*/

public class VideoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);


    }
}