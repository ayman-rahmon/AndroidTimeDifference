package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String[] providedTimes = {"04:59","05:30","12:07","15:29","17:59","19:29","19:01","18:30","01:53"};
    TextView display ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (EditText)findViewById(R.id.input);
        ((Button)findViewById(R.id.calc)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = ((EditText)findViewById(R.id.input)).getText().toString() ;

                for(int i = 0 ; i < providedTimes.length ; i++) {
                  display.append(getTimeRemaining(providedTimes[i],input) + " , ");
                }
            }
        });
    }



    private static String getTimeRemaining(String prov, String input) {
        String[] values = input.split(":");
        int inputhour = Integer.parseInt(values[0]);
        int inputminutes = Integer.parseInt(values[1]);
//        StringBuilder builder = new StringBuilder() ;

        String[] timesValues = prov.split(":");
        int timesHours = Integer.parseInt(timesValues[0]);
        int timesMinutes = Integer.parseInt(timesValues[1]);
        int hoursRemaining  ;
        int minRemaining ;
//        System.out.println(inputhour + ":" + inputminutes );
//        System.out.println(timesHours + ":" + timesMinutes );
        // if minutes more than 60 add one to hours...
        if(inputhour > timesHours ) {
            // getting difference between hours first...
            // x = 10 ,  y = 5 , y is input...
            // x = 23 ,  y = 20 , y is input...
            // x - y + 24
            hoursRemaining = Math.abs(timesHours - inputhour) + 24 ;
            // getting the difference between minutes ...
            // x = 59 , y = 10
            if(timesMinutes + inputminutes > 60 ) {
                minRemaining = (60 - timesMinutes )+ inputminutes ;
            }else {
                minRemaining = Math.abs(timesMinutes - inputminutes);
            }
            if(timesMinutes + inputminutes > 60){
                System.out.println(timesMinutes+inputminutes);
                hoursRemaining += (int) ((timesMinutes+inputminutes )/ 60) ;
//                 System.out.println(hoursRemaining);

            }
            // 60  - x  + y
        }else {
            // hour still is coming so just get the difference...
            hoursRemaining = Math.abs(timesHours - inputhour) ;
            if(timesMinutes + inputminutes > 60) {
                minRemaining = (60 - timesMinutes )+ inputminutes ;
            }else {
                minRemaining = Math.abs(timesMinutes - inputminutes);
            }
            if(timesMinutes + inputminutes > 60){
//                System.out.println(timesMinutes+inputminutes);

                hoursRemaining += (int) ((timesMinutes+inputminutes )/ 60) ;
//                System.out.println(hoursRemaining);

            }

        }
        return hoursRemaining + ":" + minRemaining;
    }

}