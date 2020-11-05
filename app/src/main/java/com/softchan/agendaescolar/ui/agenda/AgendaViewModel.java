package com.softchan.agendaescolar.ui.agenda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgendaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AgendaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}