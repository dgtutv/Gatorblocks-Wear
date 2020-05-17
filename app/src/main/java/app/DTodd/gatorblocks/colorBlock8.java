package app.DTodd.gatorblocks;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.DTodd.gatorblocks.R;

public class colorBlock8 extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_block8);
        configureBlock1();
        configureBlock2();
        configureBlock3();
        configureBlock4();
        configureBlock5();
        configureBlock6();
        configureBlock7();
        configureBlock8();
        configureBlock9();
        configureBlock10();
        configureBlock11();
        configureBlock12();
        configureBlock13();
        configureBlock14();
        configureBlock15();
        configureBlock16();
        configureBlock17();
        configureBlock18();

    }
    private void configureBlock1() {
        Button red = (Button) findViewById(R.id.red);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7EFF0000";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

    }
    private void configureBlock2() {
        Button orange = (Button) findViewById(R.id.orange);
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#ABFF8000";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

    }
    private void configureBlock3() {
        Button yellow = (Button) findViewById(R.id.yellow);
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#8EFFFF00";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock4() {
        Button blue = (Button) findViewById(R.id.blue);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7E0026E6";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock5() {
        Button purple = (Button) findViewById(R.id.purple);
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7EBF00E6";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock6() {
        Button pink = (Button) findViewById(R.id.pink);
        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7EFF19B3";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock7() {
        Button green = (Button) findViewById(R.id.green);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7E00FF00";test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock8() {
        Button lightBlue = (Button) findViewById(R.id.lightBlue);
        lightBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color="#7E00FFFF";test(color);

                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock9() {
        Button darkGreen = (Button) findViewById(R.id.darkGreen);
        darkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7E00C853";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock10() {
        Button alabamaCrimson = (Button) findViewById(R.id.alabamaCrimson);
        alabamaCrimson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EAF002A";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

    }
    private void configureBlock11() {
        Button mahogany = (Button) findViewById(R.id.Mahogany);
        mahogany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EB33B00";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

    }
    private void configureBlock12() {
        Button airForceBlue = (Button) findViewById(R.id.airForceBlue);
        airForceBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7E00308F";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock13() {
        Button deepCarmine = (Button) findViewById(R.id.deepCarmine);
        deepCarmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EAB274F";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock14() {
        Button alienArmpit = (Button) findViewById(R.id.alienArmpit);
        alienArmpit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7E84DE02";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock15() {
        Button gold = (Button) findViewById(R.id.gold);
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EFFD700";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock16() {
        Button grey = (Button) findViewById(R.id.grey);
        grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EB2BEB5";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock17() {
        Button pastelMagenta = (Button) findViewById(R.id.pastelMagenta);
        pastelMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#7EF19CBB";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void configureBlock18() {
        Button none = (Button) findViewById(R.id.none);
        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color="#00FFFFFF";
                test(color);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    public void test(String color){
        SharedPreferences pref = getSharedPreferences("colors.txt", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("color8", color);
        editor.commit();
    }
}
