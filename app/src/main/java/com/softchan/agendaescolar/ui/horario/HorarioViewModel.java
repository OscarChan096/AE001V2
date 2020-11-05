package com.softchan.agendaescolar.ui.horario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HorarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HorarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is horario fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}