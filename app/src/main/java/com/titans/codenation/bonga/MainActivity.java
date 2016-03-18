package com.titans.codenation.bonga;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String FIREBASE_URL = "https://bongachat.firebaseio.com/";

    private Firebase firebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);


        //COnecting to server
        firebaseRef = new Firebase(FIREBASE_URL);

        //adding eventlistener for when one presses enter button after typing message

        EditText inputText = (EditText) findViewById(R.id.textView);
        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //check whether there is a send ID
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    sendMessage();
                }

                return true;
            }
        });
            //get a reference to the send button
        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    public void sendMessage(){
        //get a reference to thr text field itself so as to get the message
        EditText textInput = (EditText) findViewById(R.id.textView);

        String message = textInput.getText().toString();

        //check whether message has content
        if(!message.equals("")){
            Random rand = new Random();
            String author = "Joseph" + rand.nextInt(100);
            ChatMessage cMessage = new ChatMessage(author, message);

            firebaseRef.push().setValue(cMessage);
            textInput.setText("");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
