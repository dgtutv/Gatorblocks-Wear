package app.DTodd.gatorblocks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.DTodd.gatorblocks.R;

public class classes extends WearableActivity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        configureBackButton();
        configureBlock1();
        configureBlock2();
        configureBlock3();
        configureBlock4();
        configureBlock5();
        configureBlock6();
        configureBlock7();
        configureBlock8();
        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
        String[] classes = {"","","","","","","",""};
        Button class1 = (Button) findViewById(R.id.class1);
        Button class2 = (Button) findViewById(R.id.class2);
        Button class3 = (Button) findViewById(R.id.class3);
        Button class4 = (Button) findViewById(R.id.class4);
        Button class5 = (Button) findViewById(R.id.class5);
        Button class6 = (Button) findViewById(R.id.class6);
        Button class7 = (Button) findViewById(R.id.class7);
        Button class8 = (Button) findViewById(R.id.class8);
        SharedPreferences prefs = getSharedPreferences("classes.txt", 0);
        classes[0]=prefs.getString("class1","1-1");
        classes[1]=prefs.getString("class2","1-2");
        classes[2]=prefs.getString("class3","1-3");
        classes[3]=prefs.getString("class4","1-4");
        classes[4]=prefs.getString("class5","2-1");
        classes[5]=prefs.getString("class6","2-2");
        classes[6]=prefs.getString("class7","2-3");
        classes[7]=prefs.getString("class8","2-4");
        class1.setText(classes[0]);
        class2.setText(classes[1]);
        class3.setText(classes[2]);
        class4.setText(classes[3]);
        class5.setText(classes[4]);
        class6.setText(classes[5]);
        class7.setText(classes[6]);
        class8.setText(classes[7]);
    }
    private void configureBackButton(){
        Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }
    private void configureBlock1() {
        Button Block1 = (Button) findViewById(R.id.class1);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block1Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock2() {
        Button Block1 = (Button) findViewById(R.id.class2);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block2Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock3() {
        Button Block1 = (Button) findViewById(R.id.class3);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block3Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock4() {
        Button Block1 = (Button) findViewById(R.id.class4);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block4Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock5() {
        Button Block1 = (Button) findViewById(R.id.class5);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block5Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock6() {
        Button Block1 = (Button) findViewById(R.id.class6);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block6Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock7() {
        Button Block1 = (Button) findViewById(R.id.class7);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block7Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void configureBlock8() {
        Button Block1 = (Button) findViewById(R.id.class8);
        Block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, block8Settings.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

}
