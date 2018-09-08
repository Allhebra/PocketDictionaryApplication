package com.bereg.pocketdictionaryapplication.interactors;

import io.reactivex.Single;

/**
 * Created by 1 on 14.07.2018.
 */

public class MainInteractor {

    private static final String TAG = MainInteractor.class.getSimpleName();

    public Single<Boolean> checkLoggedIn() {
        return Single.just(false);
    }
}
