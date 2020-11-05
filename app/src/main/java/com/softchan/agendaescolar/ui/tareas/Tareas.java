package com.softchan.agendaescolar.ui.tareas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Tareas extends ViewModel {

    private MutableLiveData<String> mText;

    public Tareas() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}