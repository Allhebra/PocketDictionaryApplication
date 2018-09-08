package com.bereg.pocketdictionaryapplication.presentation.views;

import com.arellomobile.mvp.MvpView;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;

import java.util.List;

/**
 * Created by 1 on 23.07.2018.
 */

public interface SavedMinicardsView extends MvpView {

    void showSavedMinicards(List<MinicardModel> minicardModels);
}
