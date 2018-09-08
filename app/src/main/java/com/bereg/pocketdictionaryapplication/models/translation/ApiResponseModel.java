package com.bereg.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 08.07.2018.
 */

public class ApiResponseModel {

    @SerializedName("")
    @Expose
    List<ParticularDictionaryModel> particularDictionaryModels;
}
