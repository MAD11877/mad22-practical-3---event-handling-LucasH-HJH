package sg.edu.np.mad.week2activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private final String TAG = "List Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Log.v(TAG, "On Create!"); //Log messages

        ImageView listImgView = (ImageView) findViewById(R.id.listImageView);
        listImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAlertDialog(); //Show Alert Dialog
            }
        });
    }

    //Random Number Generator
    private int randomInt()
    {
        Random rand = new Random();
        int val = rand.nextInt(1000000000);
        return val;
    }

    //Show Alert Dialog
    private void imgAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness");
        builder.setCancelable(true);
        //View Button
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Generate Random Number
                int randVal = randomInt();

                //Bundle
                Bundle rngBundle = new Bundle();
                rngBundle.putString("Random Value", String.valueOf(randVal));

                //Intent
                Intent rngIntent = new Intent(ListActivity.this, MainActivity.class);
                rngIntent.putExtras(rngBundle);
                startActivity(rngIntent);

                //Kill Activity
                finish();
            }
        });
        //Cancel Button
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Kill Activity
                finish();
            }
        });

        //Actual Alert Dialog Object
        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}