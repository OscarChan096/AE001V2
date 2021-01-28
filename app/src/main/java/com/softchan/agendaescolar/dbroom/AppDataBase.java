package com.softchan.agendaescolar.dbroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.softchan.agendaescolar.dbroom.daos.HomeworkDAO;
import com.softchan.agendaescolar.dbroom.daos.LessonsDAO;
import com.softchan.agendaescolar.dbroom.daos.NoteDAO;
import com.softchan.agendaescolar.dbroom.daos.SubjectsDAO;

@Database(entities = {Homework.class, Lessons.class, Subjects.class, Note.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract HomeworkDAO getHwDAO();
    public abstract LessonsDAO getLessonsDAO();
    public abstract SubjectsDAO getSubjectsDAO();
    public abstract NoteDAO getNoteDAO();
}
