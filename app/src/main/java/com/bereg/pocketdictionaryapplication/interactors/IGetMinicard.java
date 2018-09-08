package com.bereg.pocketdictionaryapplication.interactors;

import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;

import io.reactivex.Maybe;

/**
 * Created by 1 on 24.07.2018.
 */

public interface IGetMinicard {

    Maybe<MinicardModel> getMinicard(String string);
}
