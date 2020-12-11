package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas")
public class Note {

    @NonNull
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "nota")
    public String nota;

}
