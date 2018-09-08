package com.bereg.pocketdictionaryapplication.data.room.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.bereg.pocketdictionaryapplication.models.minicard.Translation;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 1 on 14.07.2018.
 */

@Getter
@Setter
@Entity
public class MinicardEntity {

    @PrimaryKey(autoGenerate  = true)
    private long id;

    Integer sourceLanguage;
    Integer targetLanguage;
    String heading;

    @Embedded(prefix = "translation")
    Translation translation;

    String seeAlso;
}
