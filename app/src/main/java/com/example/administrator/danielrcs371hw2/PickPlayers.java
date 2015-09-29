package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;


public class PickPlayers extends ActionBarActivity {

    public static TeamRoster TeamRoster1;
    public static TeamRoster TeamRoster2;
    public int counter1;
    public int counter2;
    public Button[] team1B;
    public Button[] team2B;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_players);

        TeamRoster1 = new TeamRoster(PickTeams.teamsToPlayGame[0].teamName, PickTeams.teamsToPlayGame[0].resource);
        TeamRoster2 = new TeamRoster(PickTeams.teamsToPlayGame[1].teamName, PickTeams.teamsToPlayGame[1].resource);

        team1B = new Button[15];
        team2B = new Button[15];
        team1B[0] = (Button)this.findViewById(R.id.t1p1);
        team1B[1] = (Button)this.findViewById(R.id.t1p2);
        team1B[2] = (Button)this.findViewById(R.id.t1p3);
        team1B[3] = (Button)this.findViewById(R.id.t1p4);
        team1B[4] = (Button)this.findViewById(R.id.t1p5);
        team1B[5] = (Button)this.findViewById(R.id.t1p6);
        team1B[6] = (Button)this.findViewById(R.id.t1p7);
        team1B[7] = (Button)this.findViewById(R.id.t1p8);
        team1B[8] = (Button)this.findViewById(R.id.t1p9);
        team1B[9] = (Button)this.findViewById(R.id.t1p10);
        team1B[10] = (Button)this.findViewById(R.id.t1p11);
        team1B[11] = (Button)this.findViewById(R.id.t1p12);
        team1B[12] = (Button)this.findViewById(R.id.t1p13);
        team1B[13] = (Button)this.findViewById(R.id.t1p14);
        team1B[14] = (Button)this.findViewById(R.id.t1p15);

        team2B[0] = (Button)this.findViewById(R.id.t2p1);
        team2B[1] = (Button)this.findViewById(R.id.t2p2);
        team2B[2] = (Button)this.findViewById(R.id.t2p3);
        team2B[3] = (Button)this.findViewById(R.id.t2p4);
        team2B[4] = (Button)this.findViewById(R.id.t2p5);
        team2B[5] = (Button)this.findViewById(R.id.t2p6);
        team2B[6] = (Button)this.findViewById(R.id.t2p7);
        team2B[7] = (Button)this.findViewById(R.id.t2p8);
        team2B[8] = (Button)this.findViewById(R.id.t2p9);
        team2B[9] = (Button)this.findViewById(R.id.t2p10);
        team2B[10] = (Button)this.findViewById(R.id.t2p11);
        team2B[11] = (Button)this.findViewById(R.id.t2p12);
        team2B[12] = (Button)this.findViewById(R.id.t2p13);
        team2B[13] = (Button)this.findViewById(R.id.t2p14);
        team2B[14] = (Button)this.findViewById(R.id.t2p15);

        counter1 = 0;
        counter2 = 0;

        PickTeams.teamsToPlayGame[0].showPlayers(team1B);
        PickTeams.teamsToPlayGame[1].showPlayers(team2B);


    }

    public void team1(View view)
    {
        PlayerStats player = new PlayerStats();
        Button playerButton = (Button)view;
        for(String key: PickTeams.teamsToPlayGame[0].teamPlayers.keySet())
        {
            if(key.equals(playerButton.getText().toString()))
            {
                TeamRoster1.teamPlayers.put(key, PickTeams.teamsToPlayGame[0].teamPlayers.get(key));
            }
        }

        /*
        for(String key: PickTeams.teamsToPlayGame[0].teamPlayers.keySet())
        {
            if (PickTeams.teamsToPlayGame[0].teamPlayers.get(key).playerImage.getId()==view.getId())
            {
                //check if the name is already in the array of players to play
                boolean isThere = false;
                for(int i = 0; i<5; i++)
                {
                    if(team1[i].fullName.equals(PickTeams.teamsToPlayGame[0].teamPlayers.get(key).fullName))
                    {
                        isThere = true;
                    }
                }

                if(!isThere) {
                    team1[counter1] = PickTeams.teamsToPlayGame[0].teamPlayers.get(key);
                    counter1++;
                }
            }
        }
        */



    }

    public void team2(View view)
    {
        PlayerStats player = new PlayerStats();
        Button playerButton = (Button)view;
        for(String key: PickTeams.teamsToPlayGame[1].teamPlayers.keySet())
        {
            if(key.equals(playerButton.getText().toString()))
            {
                TeamRoster2.teamPlayers.put(key, PickTeams.teamsToPlayGame[1].teamPlayers.get(key));
            }
        }
        /*
        ImageView newView = (ImageView)view;
        newView.setBackground(view.getBackground());
        for(String key: PickTeams.teamsToPlayGame[1].teamPlayers.keySet())
        {
            Log.i("Team player", key);
            if (PickTeams.teamsToPlayGame[1].teamPlayers.get(key).playerImage==newView)
            {
                //check if the name is already in the array of players to play
                Log.i("Picture is same", "Same");
                boolean isThere = false;
                for(int i = 0; i<5; i++)
                {
                    if(team1[i].fullName.equals(PickTeams.teamsToPlayGame[1].teamPlayers.get(key).fullName))
                    {
                        isThere = true;
                    }
                }

                if(!isThere) {
                    team1[counter2] = PickTeams.teamsToPlayGame[1].teamPlayers.get(key);

                    counter2++;
                }
            }
        }
        */

    }

    public void startGameWithPlayers(View view)
    {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
        finish();
    }

    public void pickNewTeams(View view)
    {
        Intent intent = new Intent(this, PickTeams.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_players, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
