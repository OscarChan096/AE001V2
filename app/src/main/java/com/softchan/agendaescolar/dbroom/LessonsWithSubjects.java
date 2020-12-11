package com.softchan.agendaescolar.dbroom;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class LessonsWithSubjects {

    @Embedded public Lessons lessons;
    @Relation(
            parentColumn = "subject_lesson_id", // ENTIDAD PRINCIPAL
            entityColumn = "subject_id" // ENTIDAD SECUNDARIA
    )

    public List<Subjects> subjects;

}
