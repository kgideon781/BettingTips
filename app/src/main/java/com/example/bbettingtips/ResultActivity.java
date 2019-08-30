package com.example.bbettingtips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.bbettingtips.Model.Bet;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {
    RecyclerView mRecycler;
    DatabaseReference db,databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionbar = getSupportActionBar();

        actionbar.setTitle("After Game Results");
        //actionbar.setDefaultDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);

        mRecycler = findViewById(R.id.MyRecyclers);
        // mRecycler = view.findViewById(R.id.myRecycler);
        mRecycler.setHasFixedSize(true);

        mRecycler.setLayoutManager(new LinearLayoutManager(ResultActivity.this));

        db = FirebaseDatabase.getInstance().getReference().child("Bets");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Results");
        databaseReference.keepSynced(true);
        db.keepSynced(true);


        fireBets();


    }

    @Override
    protected void onStart() {
        super.onStart();
        fireBets();
    }

    void fireBets(){
        FirebaseRecyclerAdapter<Bet, BetViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Bet, BetViewHolder>(
                Bet.class,
                R.layout.result_item,
                BetViewHolder.class,
                db) {
            @Override
            protected void populateViewHolder(final BetViewHolder betViewHolder, Bet bet, int i) {
                final String bet_id = getRef(i).getKey();


                betViewHolder.setHometeam(bet.getHometeam());
                betViewHolder.setAwayteam(bet.getAwayteam());
                betViewHolder.setOdds(bet.getOdds());
                betViewHolder.setPrediction(bet.getPrediction());
                betViewHolder.setStatus(bet.getStatus());
                betViewHolder.setTime(bet.getTime());
                betViewHolder.setPushed(bet_id);





                //Won

                final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Results");

                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(betViewHolder.txtPuskKey.getText().toString())){
                            betViewHolder.btnWon.setEnabled(false);
                            betViewHolder.btnLost.setEnabled(false);

                            betViewHolder.lnEdit.setVisibility(View.VISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                final DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Results");

                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(betViewHolder.txtPuskKey.getText().toString())){
                            betViewHolder.btnWon.setEnabled(false);
                            betViewHolder.btnLost.setEnabled(false);

                            betViewHolder.lnEdit.setVisibility(View.VISIBLE);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });





                betViewHolder.btnWon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Results");

                        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChild(betViewHolder.txtPuskKey.getText().toString())){
                                    betViewHolder.btnWon.setEnabled(false);
                                    betViewHolder.btnLost.setEnabled(false);

                                    betViewHolder.lnEdit.setVisibility(View.VISIBLE);
                                }
                                else {
                                   String node =  betViewHolder.txtPuskKey.getText().toString();
                                    dbRef.child(node).setValue("Won");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });




                    }
                });
                betViewHolder.btnLost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Results").child(betViewHolder.txtPuskKey.getText().toString());

                        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Results");

                        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChild(betViewHolder.txtPuskKey.getText().toString())){
                                    betViewHolder.btnWon.setEnabled(false);
                                    betViewHolder.btnLost.setEnabled(false);

                                    betViewHolder.lnEdit.setVisibility(View.VISIBLE);
                                }
                                else {
                                    String node =  betViewHolder.txtPuskKey.getText().toString();
                                    dbRef.child(node).setValue("Lost");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        //dbRef.setValue("Lost");
                    }
                });
               /* betViewHolder.lnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       final DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Results");
                        final String key = betViewHolder.txtPuskKey.getText().toString();
                        db.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChild(key)){
                                    db.child(key).removeValue();
                                    betViewHolder.btnWon.setEnabled(true);
                                    betViewHolder.btnLost.setEnabled(true);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
*/
              /*  betViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Results");
                        final String key = betViewHolder.txtPuskKey.getText().toString();
                        db.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChild(key)){
                                    db.child(key).removeValue();
                                    betViewHolder.btnWon.setEnabled(true);
                                    betViewHolder.btnLost.setEnabled(true);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });*/

            }

        };
        mRecycler.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BetViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView txtOdds, txtHome, txtAway, txtTime, txtPred, txtStat,txtPuskKey;
        LinearLayout lnEdit;
        public Button btnWon, btnLost;
        Button btnEdit;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Results");


        public BetViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;


            txtHome = mView.findViewById(R.id.textHteam);
            txtAway = mView.findViewById(R.id.textAteam);
            txtOdds = mView.findViewById(R.id.txtOdds);
            txtPred = mView.findViewById(R.id.txtPred);
            txtStat = mView.findViewById(R.id.txtStatus);
            txtTime = mView.findViewById(R.id.txtTime);
            btnWon = mView.findViewById(R.id.btnWon);
            btnLost = mView.findViewById(R.id.btnLost);
            lnEdit = mView.findViewById(R.id.lnEdit);
            btnEdit = mView.findViewById(R.id.btnEdit);
            txtPuskKey = itemView.findViewById(R.id.txtPushKey);

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChild(txtPuskKey.getText().toString())){
                        btnWon.setEnabled(false);
                        btnLost.setEnabled(false);

                        lnEdit.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


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
        void setStatus(String stat){
            txtStat.setText(stat);
        }
        void setTime(String time){
            txtTime.setText(time);
        }
        void setPushed(String push){

            txtPuskKey.setText(push);
        }

    }
}
