package com.bereg.pocketdictionaryapplication.repository;

import java.util.concurrent.Callable;

import io.reactivex.Completable;

/**
 * Created by 1 on 14.07.2018.
 */

public class LoginRepository {

    private static final String TAG = LoginRepository.class.getSimpleName();

    public Completable login(String email, String password) {
        return Completable.complete();//TODO
    }
}
