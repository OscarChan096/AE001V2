package com.softchan.agendaescolar.dbroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.softchan.agendaescolar.dbroom.Interfaces.HomeworkDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.LessonsWithSubjectsDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.NoteDAO;
import com.softchan.agendaescolar.dbroom.Interfaces.SubjectsDAO;

@Database(entities = {Homework.class, Lessons.class, Subjects.class, Note.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract HomeworkDAO getHwDAO();
    public abstract LessonsWithSubjectsDAO getLessonsWithSubjectsDAO();
    public abstract SubjectsDAO getSubjectsDAO();
    public abstract NoteDAO getNoteDAO();
}
