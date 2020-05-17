package app.DTodd.gatorblocks;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.DTodd.gatorblocks.R;

import java.lang.*;

import java.util.Calendar;

import static app.DTodd.gatorblocks.Begin.begin;


public class MainActivity extends WearableActivity {
    int swipe=0;
    Calendar calendar = Calendar.getInstance();
    int day_of_year_perm = calendar.get(Calendar.DAY_OF_YEAR);
    public void forward(int swipe) {
        TextView weekPrint = findViewById(R.id.weekPrint);
        TextView blockA = findViewById(R.id.blockA);
        TextView blockB = findViewById(R.id.blockB);
        TextView blockC = findViewById(R.id.blockC);         //These are how to print to the watch face
        TextView blockD = findViewById(R.id.blockD);
        TextView flex = findViewById(R.id.Flex);
        TextView lunch = findViewById(R.id.Lunch);
        TextView rotationPrint = findViewById(R.id.rotationPrint);
        refresh();

        Calendar calendar = Calendar.getInstance();
        int day_of_year = calendar.get(Calendar.DAY_OF_YEAR) + swipe;   //day of year

        int year=Calendar.getInstance().get(Calendar.YEAR);
        int BeginYear=app.DTodd.gatorblocks.BeginYear.BeginYear;
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 2;       //Gets current day of week
        calendar.add(Calendar.DAY_OF_YEAR, swipe);
        int MONTH = calendar.get(Calendar.MONTH);
        int DAY = calendar.get(Calendar.DAY_OF_MONTH);
        String[] monthArray={"January","February","March","April","May","June","July","August","September","October","November","December"};
        String Month = monthArray[MONTH];
        week += swipe;


        int[] dayOff = {263, 287, 298, 312, 315, 329, 357, 358, 359, 360, 361, 364, 365, 1, 2, 3, 45, 48, 55, 76, 77, 78, 79, 80, 83, 84, 85, 86, 87, 101, 104, 136, 139}; //Put all days off here in day of year format, DO NOT INCLUDE WEEKENDS
        int begin = Begin.begin;
        int Final = app.DTodd.gatorblocks.Final.Final;
        String FirstDay = app.DTodd.gatorblocks.FirstDay.FirstDay;
        int firstExam=167;
        firstExam+=(365-begin);
        ///-------------------------------------------------------------------------------------
        String[] classes = {"","","","","","","",""};
        SharedPreferences prefs = getSharedPreferences("classes.txt", 0);
        classes[0]=prefs.getString("class1","1-1");
        classes[1]=prefs.getString("class2","1-2");
        classes[2]=prefs.getString("class3","1-3");
        classes[3]=prefs.getString("class4","1-4");
        classes[4]=prefs.getString("class5","2-1");
        classes[5]=prefs.getString("class6","2-2");
        classes[6]=prefs.getString("class7","2-3");
        classes[7]=prefs.getString("class8","2-4");
        String[] colors = {"","","","","","","",""};
        SharedPreferences prefsColor = getSharedPreferences("colors.txt", 0);
        colors[0]=prefsColor.getString("color1","#00FFFFFF");
        colors[1]=prefsColor.getString("color2","#00FFFFFF");
        colors[2]=prefsColor.getString("color3","#00FFFFFF");
        colors[3]=prefsColor.getString("color4","#00FFFFFF");
        colors[4]=prefsColor.getString("color5","#00FFFFFF");
        colors[5]=prefsColor.getString("color6","#00FFFFFF");
        colors[6]=prefsColor.getString("color7","#00FFFFFF");
        colors[7]=prefsColor.getString("color8","#00FFFFFF");
        String[] associativeDaysOff= app.DTodd.gatorblocks.associativeDaysOff.associativeDaysOff;
        int[] day1 = {0, 1, 2, 3};
        int[] day2 = {4, 5, 6, 7};
        int[] day3 = {2, 3, 0, 1};
        int[] day4 = {6, 7, 4, 5};
        int[] day5 = {1, 0, 3, 2};           //These are my block rotations
        int[] day6 = {5, 4, 7, 6};
        int[] day7 = {3, 2, 1, 0};
        int[] day8 = {7, 6, 5, 4};
        int[][] masterlist = {day1, day2, day3, day4, day5, day6, day7, day8};   //This array is used to cycle through the block rotations
        String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};        //Pretty self explanatory :)
        int w = 0;        //counter for iterating through days off array
        int counter = 0;      //counter for number of days running through the main for loop
        if (day_of_year < Final - 1)     //Final is a dev inputted number indicating the last day of school
        {
            day_of_year += 365;
        }
        day_of_year -= begin;
        for (int i = 0; i < dayOff.length; i++)      //from list of days off in day of year format, converts to day of school year, based of the first day
        {
            if (dayOff[w] < Final - 1) {
                dayOff[w] += 365;     //This is similar to the code above, it just applies to an array
            }
            dayOff[w] -= begin;
            w++;
        }
        int rotation = index(weekday, FirstDay) - 1;//numeric value of the first day of school
        if((week%7)>=0){
            weekPrint.setText(weekday[week%7]);  //print the day of the week
        }
        if((week%7)<0){
            weekPrint.setText(weekday[(week+686)%7]);
        }
        int argCounter=-1;
        int success=0;
        if(day_of_year_perm<begin)
        {
            success=365;
        }
        if((((day_of_year_perm-begin)+success)+swipe)<0)
        {
            day_of_year=999;
        }
        for (int day = 0; day <=999; day++) //iterates through every day from the start of school until today, this is because we want to use modulo to tell which block rotation should be used
        //even if not a school day we still want to display day of week
        {
            rotation++;
            if (rotation == -1) {
                counter--;

            }
            if (rotation == 5)        //This code skips weekends
            {
                rotation = -2;
                counter--;
            }
            if (useLoop(dayOff, day)) {
                argCounter++;
                counter--;
            }
            int dayz = (counter % 8);     //When the code reaches to today's date, it will use modulo to tell which rotation is appropriate and then will cycle through the aforementioned lists to display today's classes
            counter++;
            int[] x = masterlist[dayz];
            if (day == day_of_year) {
                if (useLoop(dayOff, day)){
                    blockA.setText(associativeDaysOff[argCounter]);
                    blockB.setText("");
                    blockC.setText("");
                    blockD.setText("");
                    flex.setText("");
                    lunch.setText("");
                    rotationPrint.setText("");
                    blockA.setBackgroundColor(0);
                    blockB.setBackgroundColor(0);
                    blockC.setBackgroundColor(0);
                    blockD.setBackgroundColor(0);

                    if(swipe==1)
                    {
                        rotationPrint.setText("Tomorrow");
                    }
                    else if(swipe==-1)
                    {
                        rotationPrint.setText("Yesterday");
                    }
                    else if(swipe==0)
                    {
                        rotationPrint.setText("Today");
                    }
                    else
                    {
                        rotationPrint.setText(Month+" "+DAY);
                    }

                    continue;
                }
                if(rotation==-2) {
                        blockA.setText("Weekend");
                        blockB.setText("");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("");
                        lunch.setText("");
                        rotationPrint.setText("");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(0);
                        blockD.setBackgroundColor(0);
                    if(swipe==1)
                    {
                        rotationPrint.setText("Tomorrow");
                    }
                    else if(swipe==-1)
                    {
                        rotationPrint.setText("Yesterday");
                    }
                    else if(swipe==0)
                    {
                        rotationPrint.setText("Today");
                    }
                    else
                    {
                        rotationPrint.setText(Month+" "+DAY);
                    }

                        continue;
                    }
                if(rotation==-1) {
                    blockA.setText("Weekend");
                    blockB.setText("");
                    blockC.setText("");
                    blockD.setText("");
                    flex.setText("");
                    lunch.setText("");
                    rotationPrint.setText("");
                    blockA.setBackgroundColor(0);
                    blockB.setBackgroundColor(0);
                    blockC.setBackgroundColor(0);
                    blockD.setBackgroundColor(0);
                    if(swipe==1)
                    {
                        rotationPrint.setText("Tomorrow");
                    }
                    else if(swipe==-1)
                    {
                        rotationPrint.setText("Yesterday");
                    }
                    else if(swipe==0)
                    {
                        rotationPrint.setText("Today");
                    }
                    else
                    {
                        rotationPrint.setText(Month+" "+DAY);
                    }

                    continue;
                }
                flex.setText("Flex");
                lunch.setText("Lunch");
                if(swipe==1)
                {
                    rotationPrint.setText("Tomorrow");
                }
                else if(swipe==-1)
                {
                    rotationPrint.setText("Yesterday");
                }
                else if(swipe==0)
                {
                    rotationPrint.setText("Today");
                }
                else
                {
                    rotationPrint.setText(Month+" "+DAY);
                }

                for (int i = 0; i < 4; i++) {
                    int y = x[i];
                    String p = classes[y];
                    String q = colors[y];
                    if (i == 0) {
                        String block1 = p;
                        blockA.setText(block1);
                        blockA.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 1) {
                        String block2 = p;
                        blockB.setText(block2);
                        blockB.setBackgroundColor(Color.parseColor(q));
                    }                               //Printing the results to the screen
                    if (i == 2) {
                        String block3 = p;
                        blockC.setText(block3);
                        blockC.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 3) {
                        String block4 = p;
                        blockD.setText(block4);
                        blockD.setBackgroundColor(Color.parseColor(q));
                    }
                    if(day==firstExam)
                    {
                        blockA.setText("Assessment day 1");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 1-1");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 1-2");
                    }
                    if(day==(firstExam+1))
                    {
                        blockA.setText("Assessment day 2");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 2-1");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 2-2");
                    }
                    if(day==(firstExam+2))
                    {
                        blockA.setText("Assessment day 3");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 1-3");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 1-4");
                    }
                    if(day==(firstExam+3))
                    {
                        blockA.setText("Assessment day 4");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 2-3");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 2-4");
                    }
                    if(day==(firstExam+4))
                    {
                        blockA.setText("I Day");
                        blockB.setText("");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("");
                    }
                    if(day>(firstExam+4)) {
                        rotationPrint.setText("Summer Vacation");
                        blockA.setText("");
                        blockB.setText("");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("");
                        lunch.setText("");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(0);
                        blockD.setBackgroundColor(0);
                    }

                }
            }

        }

    }
    public static boolean useLoop(int[] arr, int targetValue) {         //check if an input is in a given array
        for (int s : arr) {
            if (s == targetValue)
                return true;
        }
        return false;
    }

    public static int index(String[] a, String b)    //Get the index of a given value in a given list
    {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == b)
                c = i;

        return c;
    }

    public TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureNextButton();

        TextView weekPrint = findViewById(R.id.weekPrint);
        TextView blockA = findViewById(R.id.blockA);
        TextView blockB = findViewById(R.id.blockB);
        TextView blockC = findViewById(R.id.blockC);         //These are how to print to the watch face
        TextView blockD = findViewById(R.id.blockD);
        TextView flex = findViewById(R.id.Flex);
        TextView lunch = findViewById(R.id.Lunch);
        TextView rotationPrint = (TextView) findViewById(R.id.rotationPrint);
        refresh();

        Calendar calendar = Calendar.getInstance();
        int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);   //day of year
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 2;//Gets current day of week
        //The following declarations are temporary until i store them on JSON files
        int[] dayOff = {263, 287, 298, 312, 315, 329, 357, 358, 359, 360, 361, 364, 365, 1, 2, 3, 45, 48, 55, 76, 77, 78, 79, 80, 83, 84, 85, 86, 87, 101, 104, 136, 139}; //Put all days off here in day of year format, DO NOT INCLUDE WEEKENDS
        int begin = Begin.begin;
        int Final = app.DTodd.gatorblocks.Final.Final;
        String FirstDay = app.DTodd.gatorblocks.FirstDay.FirstDay;
        ///-------------------------------------------------------------------------------------
        String[] classes = {"","","","","","","",""};
        SharedPreferences prefs = getSharedPreferences("classes.txt", 0);
        classes[0]=prefs.getString("class1","1-1");
        classes[1]=prefs.getString("class2","1-2");
        classes[2]=prefs.getString("class3","1-3");
        classes[3]=prefs.getString("class4","1-4");
        classes[4]=prefs.getString("class5","2-1");
        classes[5]=prefs.getString("class6","2-2");
        classes[6]=prefs.getString("class7","2-3");
        classes[7]=prefs.getString("class8","2-4");
        String[] colors = {"","","","","","","",""};
        SharedPreferences prefsColor = getSharedPreferences("colors.txt", 0);
        colors[0]=prefsColor.getString("color1","#00FFFFFF");
        colors[1]=prefsColor.getString("color2","#00FFFFFF");
        colors[2]=prefsColor.getString("color3","#00FFFFFF");
        colors[3]=prefsColor.getString("color4","#00FFFFFF");
        colors[4]=prefsColor.getString("color5","#00FFFFFF");
        colors[5]=prefsColor.getString("color6","#00FFFFFF");
        colors[6]=prefsColor.getString("color7","#00FFFFFF");
        colors[7]=prefsColor.getString("color8","#00FFFFFF");
        String[] associativeDaysOff= app.DTodd.gatorblocks.associativeDaysOff.associativeDaysOff;
        int[] day1 = {0, 1, 2, 3};
        int[] day2 = {4, 5, 6, 7};
        int[] day3 = {2, 3, 0, 1};
        int[] day4 = {6, 7, 4, 5};
        int[] day5 = {1, 0, 3, 2};           //These are my block rotations
        int[] day6 = {5, 4, 7, 6};
        int[] day7 = {3, 2, 1, 0};
        int[] day8 = {7, 6, 5, 4};
        int[][] masterlist = {day1, day2, day3, day4, day5, day6, day7, day8};   //This array is used to cycle through the block rotations
        String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};        //Pretty self explanatory :)
        int w = 0;        //counter for iterating through days off array
        int counter = 0;      //counter for number of days running through the main for loop
        if (day_of_year < Final - 1)     //Final is a dev inputted number indicating the last day of school
        {
            day_of_year += 365;
        }
        day_of_year -= begin;
        for (int i = 0; i < dayOff.length; i++)      //from list of days off in day of year format, converts to day of school year, based of the first day
        {
            if (dayOff[w] < Final - 1) {
                dayOff[w] += 365;     //This is similar to the code above, it just applies to an array
            }
            dayOff[w] -= begin;
            w++;
        }
        int firstExam=167;
        firstExam+=(365-begin);
        int rotation = index(weekday, FirstDay) - 1;     //numeric value of the first day of school
        if((week%7)>=0){
            weekPrint.setText(weekday[week%7]);  //print the day of the week
        }
        if((week%7)<0){
            weekPrint.setText(weekday[(week+686)%7]);
        }
        int argCounter=-1;
        for (int day = 0; day <= 999; day++) //iterates through every day from the start of school until today, this is because we want to use modulo to tell which block rotation should be used
        //even if not a school day we still want to display day of week
        {
            rotation++;
            if (rotation == -1) {
                counter--;

            }
            if (rotation == 5)        //This code skips weekends
            {
                rotation=-2;
                counter--;
            }
            if (useLoop(dayOff, day)) {
                counter--;
                argCounter++;
            }
            int dayz = (counter % 8);     //When the code reaches to today's date, it will use modulo to tell which rotation is appropriate and then will cycle through the aforementioned lists to display today's classes
            counter++;
            int[] x = masterlist[dayz];
            if (day == day_of_year) {
                if (useLoop(dayOff, day)){
                    blockA.setText("");
                    blockB.setText("");
                    blockC.setText("");
                    blockD.setText("");
                    flex.setText("");
                    lunch.setText("");
                    rotationPrint.setText(associativeDaysOff[argCounter]);
                    blockA.setBackgroundColor(0);
                    blockB.setBackgroundColor(0);
                    blockC.setBackgroundColor(0);
                    blockD.setBackgroundColor(0);

                    continue;
                }
                if(rotation==-2) {
                    blockA.setText("");
                    blockB.setText("");
                    blockC.setText("");
                    blockD.setText("");
                    flex.setText("");
                    lunch.setText("");
                    rotationPrint.setText("Weekend");
                    blockA.setBackgroundColor(0);
                    blockB.setBackgroundColor(0);
                    blockC.setBackgroundColor(0);
                    blockD.setBackgroundColor(0);

                    continue;
                }
                if(rotation==-1) {
                    blockA.setText("");
                    blockB.setText("");
                    blockC.setText("");
                    blockD.setText("");
                    flex.setText("");
                    lunch.setText("");
                    rotationPrint.setText("Weekend");
                    blockA.setBackgroundColor(0);
                    blockB.setBackgroundColor(0);
                    blockC.setBackgroundColor(0);
                    blockD.setBackgroundColor(0);

                    continue;
                }
                flex.setText("Flex");
                lunch.setText("Lunch");
                rotationPrint.setText("Today");
                for (int i = 0; i < 4; i++) {
                    int y = x[i];
                    String p = classes[y];
                    String q = colors[y];
                    if (i == 0) {
                        String block1 = p;
                        blockA.setText(block1);
                        blockA.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 1) {
                        String block2 = p;
                        blockB.setText(block2);
                        blockB.setBackgroundColor(Color.parseColor(q));
                    }                               //Printing the results to the screen
                    if (i == 2) {
                        String block3 = p;
                        blockC.setText(block3);
                        blockC.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 3) {
                        String block4 = p;
                        blockD.setText(block4);
                        blockD.setBackgroundColor(Color.parseColor(q));
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int y = x[i];
                    String p = classes[y];
                    String q = colors[y];
                    if (i == 0) {
                        String block1 = p;
                        blockA.setText(block1);
                        blockA.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 1) {
                        String block2 = p;
                        blockB.setText(block2);
                        blockB.setBackgroundColor(Color.parseColor(q));
                    }                               //Printing the results to the screen
                    if (i == 2) {
                        String block3 = p;
                        blockC.setText(block3);
                        blockC.setBackgroundColor(Color.parseColor(q));
                    }
                    if (i == 3) {
                        String block4 = p;
                        blockD.setText(block4);
                        blockD.setBackgroundColor(Color.parseColor(q));
                    }
                    if(day==firstExam)
                    {
                        blockA.setText("Assessment day 1");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 1-1");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 1-2");
                    }
                    if(day==(firstExam+1))
                    {
                        blockA.setText("Assessment day 2");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 2-1");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 2-2");
                    }
                    if(day==(firstExam+2))
                    {
                        blockA.setText("Assessment day 3");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 1-3");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 1-4");
                    }
                    if(day==(firstExam+3))
                    {
                        blockA.setText("Assessment day 4");
                        blockB.setText("Lunch");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("Block 2-3");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("Block 2-4");
                    }
                    if(day==(firstExam+4))
                    {
                        blockA.setText("I Day");
                        blockB.setText("");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(Color.parseColor(colors[1]));
                        blockD.setBackgroundColor(0);
                        flex.setBackgroundColor(Color.parseColor(colors[0]));
                        lunch.setText("");
                    }
                    if(day>(firstExam+4)){
                        rotationPrint.setText("Summer Vacation");
                        blockA.setText("");
                        blockB.setText("");
                        blockC.setText("");
                        blockD.setText("");
                        flex.setText("");
                        lunch.setText("");
                        blockA.setBackgroundColor(0);
                        blockB.setBackgroundColor(0);
                        blockC.setBackgroundColor(0);
                        blockD.setBackgroundColor(0);
                    }
                }
            }

        }
        Button forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipe+=1;
                forward(swipe);
            }
        });
        Button backward = findViewById(R.id.backward);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipe-=1;
                forward(swipe);
            }
        });



        // Enables Always-on
        setAmbientEnabled();
    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, classes.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();                               //when the button is pressed it will move to classes class
            }
        });
    }
    private void refresh() {
        Button refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipe =0;
                forward(swipe);
            }
        });
    }





}



