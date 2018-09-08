package com.bereg.pocketdictionaryapplication.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.bereg.pocketdictionaryapplication.data.room.dao.MinicardDao;
import com.bereg.pocketdictionaryapplication.data.room.dao.TranslationDao;
import com.bereg.pocketdictionaryapplication.data.room.entity.MinicardEntity;
import com.bereg.pocketdictionaryapplication.models.minicard.Translation;

/**
 * Created by 1 on 14.07.2018.
 */

@Database(entities = {MinicardEntity.class/*, Translation.class*/}, version = 2, exportSchema = false)
public abstract class PocketDictionaryAppDatabase extends RoomDatabase {

    public abstract MinicardDao minicardDao();
    //public abstract TranslationDao translationDao();
}
