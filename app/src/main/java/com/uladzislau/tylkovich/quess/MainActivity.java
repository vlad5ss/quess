package com.uladzislau.tylkovich.quess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText txtGuess;
    private Button btnGuess;
    private TextView lblOutput;
    private int theNumber;
private int triesLeft =7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGuess = (EditText) findViewById(R.id.txtGuess);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        lblOutput = (TextView) findViewById(R.id.lblOutput);

        newGame();
        //set up the listener
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
txtGuess.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        checkGuess();
        return true;
    }
});

    }

    public void checkGuess() {

        //get the number

        String theirNumber = txtGuess.getText().toString();
        String message = "";


        try {
            int guess = Integer.parseInt(theirNumber);
            triesLeft--;

            if (guess > theNumber) {
                //too high
                message = guess + " was to high. YOu have " + triesLeft + " tries left.";
                lblOutput.setText(message);
            } else if (guess < theNumber) {
                //too low
                message = guess + " was to low.  YOu have " + triesLeft + " tries left.";
                lblOutput.setText(message);
            } else {
                //correctly
                message = guess + " was the right number. You win!";
                lblOutput.setText(message);
                newGame();
            }
        } catch (Exception ex) {
            message = "Plese enter the whole number";
            lblOutput.setText(message);
        } finally {
            //highlith the texy
txtGuess.requestFocus();
txtGuess.selectAll();
        }


    }


    private void newGame() {

        theNumber = (int) (Math.random() * 100 + 1);
        triesLeft=7;

    }

}




