package com.softchan.agendaescolar.config;

import java.util.Calendar;

public class Date {

    public static int getDia(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDiaSemana(){
        String dia = "";
        Calendar calendar = Calendar.getInstance();
        //calendar.set();
        int diax = calendar.get(Calendar.DAY_OF_WEEK);
        switch (diax){
            case Calendar.MONDAY: // 2
                dia = "lunes";
                break;
            case Calendar.TUESDAY: // 3
                dia = "martes";
                break;
            case Calendar.WEDNESDAY: // 4
                dia = "miercoles";
                break;
            case Calendar.THURSDAY: // 5
                dia = "jueves";
                break;
            case Calendar.FRIDAY: // 6
                dia = "viernes";
                break;
                //Calendar.SATURDAY 7 - Calendar.SUNDAY 1
        }
        return dia;
    }

}
