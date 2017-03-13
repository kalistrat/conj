package com.jetbrains;

/**
 * Created by SemenovNA on 01.08.2016.
 */
public class TimerMinSec {
    public int min;
    public int sec;

    public TimerMinSec(int Mins, int Secs){
        this.min=Mins;
        this.sec=Secs;
    }

    public void AddOneSecond(){
    if (this.sec == 59) {
        this.min=this.min+1;
        this.sec=0;
    } else {
        this.sec=this.sec+1;
    }
    }

    public String getStrTime(){
        String StrSec;
        String StrMin;

        if (String.valueOf(this.sec).length() == 1){
            StrSec = "0" + String.valueOf(this.sec);
        } else {
            StrSec = String.valueOf(this.sec);
        }

        if (String.valueOf(this.min).length() == 1){
            StrMin = "0" + String.valueOf(this.min);
        } else {
            StrMin = String.valueOf(this.min);
        }
        return  StrMin+":"+StrSec;

    }

    public void ToZeros(){
        this.min = 0;
        this.sec = 0;
    }
}
