package app.DTodd.gatorblocks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.DTodd.gatorblocks.R;

public class block3Settings extends WearableActivity{

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block3_settings);
        configureBackButton();
        configureColor();

        Button addTextButton = (Button) findViewById(R.id.Apply);
        TextView simpleEditText =  findViewById(R.id.simpleEditText);
        SharedPreferences prefs = getSharedPreferences("classes.txt", 0);
        simpleEditText.setText(prefs.getString("class3","1-3"));                  //set textbox to equal current class

        final EditText vEditText = (EditText) findViewById(R.id.simpleEditText);


        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        addTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = vEditText.getText().toString();        //sets the array value of block to the editText
                test(enteredText);
            }
        });
    }
    private void configureColor() {
        Button Block1 = (Button) findViewById(R.id.colorButton);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(block3Settings.this, colorBlock3.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }
    private void configureBackButton(){
        Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(block3Settings.this, classes.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void test(String enteredText){
        SharedPreferences pref = getSharedPreferences("classes.txt", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("class3", enteredText);
        editor.commit();
    }

}

