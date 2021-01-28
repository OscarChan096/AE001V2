package com.softchan.agendaescolar.dbroom;

import android.content.Context;

import androidx.room.Room;

import com.softchan.agendaescolar.dbroom.daos.HomeworkDAO;
import com.softchan.agendaescolar.dbroom.daos.LessonsDAO;
import com.softchan.agendaescolar.dbroom.daos.NoteDAO;
import com.softchan.agendaescolar.dbroom.daos.SubjectsDAO;

import java.util.List;

public class DBAcces {

    private static DBAcces dbAcces;
    private HomeworkDAO hwDAO;
    private LessonsDAO lessonsDAO;
    private SubjectsDAO subjectsDAO;
    private NoteDAO noteDAO;
    private AppDataBase appDataBase;
    public static final int optionHomeworkDAO = 0;
    public static final int optionLessonDAO = 1;
    public static final int optionSubjectDAO = 2;
    public static final int optionNoteDAO = 3;

    private DBAcces (Context context){
        Context appContext = context.getApplicationContext();
        appDataBase = Room.databaseBuilder(appContext, AppDataBase.class, "dbae").build();
    }

    private void selectEntity(int table){
        switch (table){
            case 0:
                hwDAO = appDataBase.getHwDAO();
                break;
            case 1:
                lessonsDAO = appDataBase.getLessonsDAO();
                break;
            case 2:
                subjectsDAO = appDataBase.getSubjectsDAO();
                break;
            case 3:
                noteDAO = appDataBase.getNoteDAO();
                break;
            default:
                break;
        }
    }

    public static DBAcces getInstance(Context context, int table){
        if (dbAcces == null){
            dbAcces = new DBAcces(context);
            dbAcces.selectEntity(table);
        }else{
            dbAcces.selectEntity(table);
        }
        return dbAcces;
    }

    /* -------------------------  hwDAO ---------------------*/
    public List<Homework> getAllHomework(){
        return hwDAO.getAll();
    }

    public List<Homework> getByIdHomework(int id){
        return hwDAO.getById(id);
    }

    public Homework findByTitleHomework(String titulo){
        return hwDAO.findByTitle(titulo);
    }

    public void addHomework(Homework homework){
        hwDAO.add(homework);
    }

    public void deleteHomework(Homework homework){
        hwDAO.delete(homework);
    }

    public void updateHomework(Homework homework){
        hwDAO.update(homework);
    }


    /*-----------------------LessonsDAO -----------------------*/
    public List<Lessons> getAllLessons(){
        return lessonsDAO.getAll();
    }

    public List<Lessons> getByDia(String dia){
        return lessonsDAO.getByDia(dia);
    }

    public void addLessons(Lessons lessons){
        lessonsDAO.add(lessons);
    }

    public void deleteLessons(Lessons lessons){
        lessonsDAO.delete(lessons);
    }

    public void updateLessons(Lessons lessons){
        lessonsDAO.update(lessons);
    }


    // --------------------------NoteDAO------------------------------
    public List<Note> getNotes(){
        return noteDAO.getNotes();
    }

    public void addNotes(Note note){
        noteDAO.add(note);
    }

    public void deleteNote(Note note){
        noteDAO.delete(note);
    }

    public void updateNote(Note note){
        noteDAO.update(note);
    }


    // --------------------- SubjectsDAO ------------------------------
    public List<Subjects> getAllSubjects(){
        return subjectsDAO.getAll();
    }

    public List<String> getAllSubjectsName(){
        return subjectsDAO.getAllSubjects();
    }

    public String findBySubjects(String name_subjects){
        return subjectsDAO.findBySubject(name_subjects);
    }

    public Subjects findByName(String firstname){
        return subjectsDAO.findByName(firstname);
    }

    public void addSubjects(Subjects subjects){
        subjectsDAO.add(subjects);
    }

    public void deleteSubjects(Subjects subjects){
        subjectsDAO.delete(subjects);
    }

    public void updateSubjects(Subjects subjects){
        subjectsDAO.update(subjects);
    }

    //https://ard-site.net/es/tutoriales/android/room-database-app-to-save-data-in-a-database-format-more-easily
    //https://javautodidacta.es/base-de-datos-room-en-android/

}
