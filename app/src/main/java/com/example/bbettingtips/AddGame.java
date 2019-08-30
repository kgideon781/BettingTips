package com.example.bbettingtips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bbettingtips.Model.Bet;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddGame extends AppCompatActivity {
    Button btnSave;
    EditText editHome, editAway, editOdds, editPred, editTime;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        btnSave = findViewById(R.id.btnSave);
        editHome = findViewById(R.id.editHome);
        editAway = findViewById(R.id.editAway);
        editOdds = findViewById(R.id.editOdds);
        editPred = findViewById(R.id.editPred);
        editTime = findViewById(R.id.editTime);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Bets");


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat ISO_8601_Format = new SimpleDateFormat("yyyy-MM-dd");
                String now = ISO_8601_Format.format(new Date());

                    String Home = editHome.getText().toString();
                    String Away = editAway.getText().toString();
                    String Odd = editOdds.getText().toString();
                    String pred = editPred.getText().toString();
                    String time = editTime.getText().toString();
                    if (!TextUtils.isEmpty(Home) && !TextUtils.isEmpty(Away) && !TextUtils.isEmpty(Odd) && !TextUtils.isEmpty(pred) && !TextUtils.isEmpty(time)) {

                        Bet bet = new Bet(Home, Away, Odd, pred, null, time, now);
                        String  pushkey = databaseReference.push().getKey();
                        databaseReference.child(pushkey).setValue(bet).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddGame.this, "Game Added Succesfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else {
                        Toast.makeText(AddGame.this, "One or more fields are empty", Toast.LENGTH_SHORT).show();
                    }

            }
        });





    }
}
