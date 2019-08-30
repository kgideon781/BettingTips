package com.example.bbettingtips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bbettingtips.Fragments.FragToday;
import com.example.bbettingtips.Fragments.FragYest;
import com.example.bbettingtips.Model.Bet;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter vPager;


    @Override
    protected void onStart() {
        super.onStart();
        //load();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tab);
        vPager = new ViewPagerAdapter(getSupportFragmentManager());

        vPager.AddFragment(new FragToday(),"Today's");
        vPager.AddFragment(new FragYest(),"Yesterday's");



        viewPager.setAdapter(vPager);
        tabLayout.setupWithViewPager(viewPager);

      /*  tabLayout.getTabAt(0).setIcon(R.drawable.);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_class);
        tabLayout.getTabAt(2).setIcon(R.drawable.assignment);*/

      /*  mRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        btnAddGame = findViewById(R.id.addGame);
        btnAddGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AddGame.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        db = FirebaseDatabase.getInstance().getReference().child("Bets");
        db.keepSynced(true);



        fireBets();*/



    }
    /*void fireBets(){
        FirebaseRecyclerAdapter<Bet,BetViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Bet, BetViewHolder>(
                Bet.class,
                R.layout.bet_item,
                BetViewHolder.class,
                db) {
            @Override
            protected void populateViewHolder(final BetViewHolder betViewHolder, Bet bet, int i) {
                final String bet_id = getRef(i).getKey();


                            betViewHolder.setHometeam(bet.getHometeam());
                            betViewHolder.setAwayteam(bet.getAwayteam());
                            betViewHolder.setOdds(bet.getOdds());
                            betViewHolder.setPrediction(bet.getPrediction());
                          //  betViewHolder.setStatus(bet.getStatus());
                            betViewHolder.setTime(bet.getTime());
                            betViewHolder.setPushed(bet_id);
                            betViewHolder.setWonLost(bet_id);


                            dialog.dismiss();
                            *//*
                            * to remove this code before packaging*//*
      *//*--------------------------------------------------------------------------------------------------*//*
                            betViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                                    startActivity(i);
                                }
                            });
      *//*--------------------------------------------------------------------------------------------------*//*



            }

        };
        mRecycler.setAdapter(firebaseRecyclerAdapter);
    }
*/   /* public static class BetViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView txtOdds, txtHome, txtAway, txtTime, txtPred, txtStat, txtPuskKey;
        ImageView btnRes;

        RelativeLayout relativeLayout;
        public BetViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;


            txtHome = mView.findViewById(R.id.textHteam);
            txtAway = mView.findViewById(R.id.textAteam);
            txtOdds = mView.findViewById(R.id.txtOdds);
            txtPred = mView.findViewById(R.id.txtPred);
            txtStat = mView.findViewById(R.id.txtActive);
            txtTime = mView.findViewById(R.id.txtTime);
            btnRes = mView.findViewById(R.id.txtStatus);
            relativeLayout = mView.findViewById(R.id.rtfLayout);




        }
        void setHometeam(String hometeam){
            txtHome.setText(hometeam);

        }
        void setAwayteam(String awayteam){
            txtAway.setText(awayteam);

        }
        void setOdds(String odds){
            txtOdds.setText(odds);
        }
        void setPrediction(String prediction){
            txtPred.setText(prediction);
        }

        void setTime(String time){
            txtTime.setText(time);
        }
        void setPushed(String push){
            txtPuskKey = itemView.findViewById(R.id.txtPushKey);
            txtPuskKey.setText(push);
        }
        void setWonLost(final String assign){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Results");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String result = (String)dataSnapshot.child(assign).getValue();

                    if (result != null) {
                        if (result.equals("Won")) {
                            txtStat.setVisibility(View.INVISIBLE);
                            btnRes.setImageResource(R.drawable.ic_won);
                            relativeLayout.setBackgroundColor(Color.GREEN);

                        } else if (result.equals("Lost")) {
                            txtStat.setVisibility(View.INVISIBLE);
                            btnRes.setImageResource(R.drawable.ic_lost);
                            relativeLayout.setBackgroundColor(Color.RED);

                        }


                    }
                    else {

                        txtStat.setText("Active");
                        txtStat.setVisibility(View.VISIBLE);
                        txtPred.setTextColor(Color.BLACK);
                        txtOdds.setTextColor(Color.BLACK);
                        txtStat.setTextColor(Color.BLACK);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
    void load(){
        dialog.setMessage("Wait...");
        dialog.setCancelable(false);
        dialog.show();
    }*/
}
