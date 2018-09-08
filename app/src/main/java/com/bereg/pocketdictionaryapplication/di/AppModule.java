package com.bereg.pocketdictionaryapplication.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.bereg.pocketdictionaryapplication.PocketDictionaryApp;
import com.bereg.pocketdictionaryapplication.data.SharedPreferencesManager;
import com.bereg.pocketdictionaryapplication.data.api.AbbyyLingvoApi;
import com.bereg.pocketdictionaryapplication.data.api.ApiManager;
import com.bereg.pocketdictionaryapplication.data.room.PocketDictionaryAppDatabase;
import com.bereg.pocketdictionaryapplication.interactors.LoginInteractor;
import com.bereg.pocketdictionaryapplication.interactors.MainInteractor;
import com.bereg.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.bereg.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;
import com.bereg.pocketdictionaryapplication.repository.AbbyyLingvoApiRepository;
import com.bereg.pocketdictionaryapplication.repository.LoginRepository;
import com.bereg.pocketdictionaryapplication.repository.RoomRepository;

import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 1 on 15.07.2018.
 */

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    PocketDictionaryAppDatabase providePocketDictionaryAppDatabase() {
        return Room.databaseBuilder(mContext,
                PocketDictionaryAppDatabase.class, "PocketDictionaryAppDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    AbbyyLingvoApi provideAbbyyLingvoApi() {
        return ApiManager.getAbbyyLingvoApi();
    }

    @Provides
    MainInteractor provideMainInteractor() {
        return new MainInteractor();
    }

    @Provides
    LoginInteractor provideLoginInteractor(LoginRepository loginRepository, AbbyyLingvoApiRepository abbyyLingvoApiRepository, SharedPreferencesManager sharedPreferencesManager) {
        return new LoginInteractor(loginRepository, abbyyLingvoApiRepository, sharedPreferencesManager);
    }

    @Provides
    MinicardInteractor provideMinicardInteractor(RoomRepository roomRepository, AbbyyLingvoApiRepository abbyyLingvoApiRepository) {
        return new MinicardInteractor(roomRepository, abbyyLingvoApiRepository);
    }

    @Provides
    SavedMinicardsInteractor provideSavedMinicardsInteractor(RoomRepository roomRepository) {
        return new SavedMinicardsInteractor(roomRepository);
    }

    @Provides
    LoginRepository provideLoginRepository() {
        return new LoginRepository();
    }

    @Provides
    RoomRepository provideRoomRepository() {
        return new RoomRepository();
    }

    @Provides
    AbbyyLingvoApiRepository provideAbbyyLingvoApiRepository(AbbyyLingvoApi abbyyLingvoApi, SharedPreferencesManager sharedPreferencesManager) {
        return new AbbyyLingvoApiRepository(abbyyLingvoApi, sharedPreferencesManager);
    }

    @Provides
    SharedPreferencesManager provideSharedPreferencesManager(SharedPreferences sharedPreferences) {
        return new SharedPreferencesManager(sharedPreferences);
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager
                .getDefaultSharedPreferences(mContext);
    }
}
