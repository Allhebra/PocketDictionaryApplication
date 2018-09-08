package com.bereg.pocketdictionaryapplication.data.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 1 on 22.07.2018.
 */

@Getter
@Setter
@Entity
public class UserEntity {

    @PrimaryKey
    private long id;

    String login;
    String passwordHash;
    String token;
}
