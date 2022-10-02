package com.project.firstaid

import android.app.Application

class GlobalClass: Application() {

    var FirstTime = 0;

    fun addfirstTime(){
        FirstTime += 1;
    }

}