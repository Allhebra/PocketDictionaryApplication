package com.bereg.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 12.07.2018.
 */

class AnyObj3 {

    @SerializedName("Type")
    @Expose
    Integer type;
    @SerializedName("Items")
    @Expose
    List<AnyObj4> items;
}
