package com.bereg.pocketdictionaryapplication.interactors;

import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by 1 on 24.07.2018.
 */

public interface IGetAllMinicards {

    Maybe<List<MinicardModel>> getAllMinicards();
}
