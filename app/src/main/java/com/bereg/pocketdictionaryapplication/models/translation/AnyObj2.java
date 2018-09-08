package com.bereg.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 11.07.2018.
 */

class AnyObj2 {

    @SerializedName("Markup")
    @Expose
    List<AnyObj3> markups;
}
