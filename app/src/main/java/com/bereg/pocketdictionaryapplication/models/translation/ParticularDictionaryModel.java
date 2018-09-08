package com.bereg.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 08.07.2018.
 */

class ParticularDictionaryModel {

    @SerializedName("Title")
    @Expose
    String title;
    @SerializedName("Dictionary")
    @Expose
    String dictionary;
    @SerializedName("Body")
    @Expose
    List<Body> bodies;
}
