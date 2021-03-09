package com.softchan.agendaescolar.config;

import android.app.Activity;

import com.softchan.agendaescolar.dbroom.Agenda;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Homework;
import com.softchan.agendaescolar.dbroom.Lessons;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AgendaInfo {

    public static List<Agenda> getListAgendaH(Activity context){
        List<Agenda> listAgenda = new ArrayList<>();
        DBAcces dbAcces = DBAcces.getInstance(context,DBAcces.optionHLDAOS);
        Calendar calendar = Calendar.getInstance();

        for(Lessons lessons : dbAcces.getAllLessons()){
            if (lessons.getDia() == calendar.get(Calendar.DAY_OF_WEEK)) {
                Agenda agendaL = new Agenda(lessons.getDia(), lessons.getNameSubject(), lessons.getNameProfessor(), lessons.getHoraEmpiezo() + " - "
                        + lessons.getHoraFin(), lessons.getAula(), lessons.getCategoria());
                listAgenda.add(agendaL);
            }
        }

        return listAgenda;
    }

    public static List<Agenda> getListAgendaT(Activity context){
        List<Agenda> listAgenda = new ArrayList<>();
        DBAcces dbAcces = DBAcces.getInstance(context,DBAcces.optionHLDAOS);

        for(Homework hw : dbAcces.getAllHomework()){
            Agenda agendaHW = new Agenda(hw.getAsignatura(),hw.getTitulo(),hw.getFecha_entrega(),hw.getDescripcion(),hw.getCategoria());
            listAgenda.add(agendaHW);
        }

        return listAgenda;
    }

}
