package com.bereg.pocketdictionaryapplication.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.OnConflictStrategy;

import com.bereg.pocketdictionaryapplication.data.room.entity.MinicardEntity;

import io.reactivex.Single;
import io.reactivex.Maybe;

import java.util.List;

/**
 * Created by 1 on 14.07.2018.
 */

@Dao
public interface MinicardDao {

    @Query("SELECT * FROM minicardentity WHERE heading = :string")
    Maybe<MinicardEntity> getMinicardEntity(String string);

    @Query("SELECT * FROM minicardentity")
    Maybe<List<MinicardEntity>> getAllMinicards();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertMinicardEntity(MinicardEntity minicardEntity);
}
