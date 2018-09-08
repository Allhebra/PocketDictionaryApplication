package com.bereg.pocketdictionaryapplication.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.bereg.pocketdictionaryapplication.models.minicard.Translation;

import io.reactivex.Single;

/**
 * Created by 1 on 15.07.2018.
 */

@Dao
public interface TranslationDao {

    @Query("SELECT * FROM translation")
    Single<Translation> getTranslation();
}
