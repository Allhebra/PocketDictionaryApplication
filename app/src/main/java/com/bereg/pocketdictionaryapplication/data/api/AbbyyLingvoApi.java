package com.bereg.pocketdictionaryapplication.data.api;

import com.bereg.pocketdictionaryapplication.models.translation.ApiResponseModel;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;

import io.reactivex.Single;
import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 1 on 08.07.2018.
 */

public interface AbbyyLingvoApi {

    @POST("authenticate")
    Single<Object> getAuthData(@Header("Authorization") String apiKey);

    @GET("Minicard/")
    Maybe<MinicardModel> getMinicardData(@Header("authorization") String token,
                                         @Query("text") String text,
                                         @Query("srcLang") Integer srcLang,
                                         @Query("dstLang") Integer dstLang);

    @GET()
    Single<ApiResponseModel> getObservableData();
}
