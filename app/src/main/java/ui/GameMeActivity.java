package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bkm.game_me.R;

import data.GameMeImageAssets;

public class GameMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_me);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("index");

                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setmImageResourceId(GameMeImageAssets.getHeads());
                headFragment.setmIndex(bundle.getInt("head"));

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setmImageResourceId(GameMeImageAssets.getBodies());
                bodyFragment.setmIndex(bundle.getInt("body"));
                fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setmImageResourceId(GameMeImageAssets.getLegs());
                legFragment.setmIndex(bundle.getInt("leg"));
                fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
            }
        }
    }
}