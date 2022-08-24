package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.bkm.game_me.R;

import data.GameMeImageAssets;

public class GameMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_me);
        if (savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setmImageResourceId(GameMeImageAssets.getHeads());
            //headFragment.setmIndex(1);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageResourceId(GameMeImageAssets.getBodies());
            fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setmImageResourceId(GameMeImageAssets.getLegs());
            fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
        }
    }
}