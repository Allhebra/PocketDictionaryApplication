package com.bereg.pocketdictionaryapplication.presentation.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;

/**
 * Created by 1 on 14.07.2018.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MinicardView extends MvpView {

    void showMinicard(MinicardModel minicardModel);
    void showNewTranslation();
}
