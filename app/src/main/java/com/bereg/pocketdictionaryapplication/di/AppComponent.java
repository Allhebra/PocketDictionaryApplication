package com.bereg.pocketdictionaryapplication.di;

import com.bereg.pocketdictionaryapplication.data.api.AbbyyLingvoApi;
import com.bereg.pocketdictionaryapplication.interactors.LoginInteractor;
import com.bereg.pocketdictionaryapplication.interactors.MainInteractor;
import com.bereg.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.bereg.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 1 on 15.07.2018.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainInteractor getMainInteractor();
    LoginInteractor getLoginInteractor();
    MinicardInteractor getMinicardInteractor();
    SavedMinicardsInteractor getSavedMinicardsInteractor();
}
