package com.softchan.agendaescolar.dbroom;

import android.content.Context;

import androidx.room.Room;

import com.softchan.agendaescolar.dbroom.Interfaces.HomeworkDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.LessonsWithSubjectsDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.NoteDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.SubjectsDAO;

import java.util.List;

public class DBAcces {

    private AppDataBase appDataBase;
    private static DBAcces dbAcces;

    private DBAcces (Context context){
        Context appContext = context.getApplicationContext();
        appDataBase = Room.databaseBuilder(appContext, AppDataBase.class, "dbae").build();
    }

    public static DBAcces get(Context context){
        if (dbAcces == null){
            dbAcces = new DBAcces(context);
        }
        return dbAcces;
    }

    // posiblemente funcione :D
    public HomeworkDAO getHWDAO(){
        HomeworkDAO hwDAO = appDataBase.getHwDAO();
        return hwDAO;
    }

    // :D
    public LessonsWithSubjectsDAO getLWSDAO(){
        LessonsWithSubjectsDAO lwsdao = appDataBase.getLessonsWithSubjectsDAO();
        return lwsdao;
    }

    // :D
    public SubjectsDAO getSubjectsDAO(){
        SubjectsDAO subjectsDAO = appDataBase.getSubjectsDAO();
        return subjectsDAO;
    }

    // :D
    public NoteDAO getNoteDAO(){
        NoteDAO noteDAO = appDataBase.getNoteDAO();
        return noteDAO;
    }

    public List<Homework> getAllHomework(){
        HomeworkDAO hwDAO = appDataBase.getHwDAO();
        return hwDAO.getAll();
    }

    public List<Homework> getByIdHomework(int id){
        HomeworkDAO hwDAO = appDataBase.getHwDAO();
        return hwDAO.getById(id);
    }

    public Homework findByTitleHomework(String titulo){
        HomeworkDAO hwDAO = appDataBase.getHwDAO();
        return hwDAO.findByTitle(titulo);
    }

    //https://ard-site.net/es/tutoriales/android/room-database-app-to-save-data-in-a-database-format-more-easily
    //https://javautodidacta.es/base-de-datos-room-en-android/

}
