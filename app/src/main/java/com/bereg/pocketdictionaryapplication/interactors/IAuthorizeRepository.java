package com.bereg.pocketdictionaryapplication.interactors;

import io.reactivex.Single;

/**
 * Created by 1 on 22.07.2018.
 */

public interface IAuthorizeRepository {

    Single<Object> sendAuthRequest();
}
