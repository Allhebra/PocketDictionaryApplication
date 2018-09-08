package com.bereg.pocketdictionaryapplication.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.inputmethod.InputMethodManager;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bereg.pocketdictionaryapplication.PocketDictionaryApp;
import com.bereg.pocketdictionaryapplication.R;
import com.bereg.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.bereg.pocketdictionaryapplication.presentation.presenters.MinicardPresenter;
import com.bereg.pocketdictionaryapplication.presentation.views.MinicardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Router;

/**
 * Created by 1 on 14.07.2018.
 */

public class MinicardFragment extends MvpAppCompatFragment implements MinicardView {

    private static final String TAG = MinicardFragment.class.getSimpleName();

    @BindView(R.id.word)
    EditText word;
    @BindView(R.id.translate)
    Button translate;
    @BindView(R.id.heading)
    TextView heading;
    @BindView(R.id.translation)
    TextView translation;
    @BindView(R.id.newTranslation)
    Button newTranslation;
    @BindView(R.id.minicard)
    View minicardView;

    @InjectPresenter
    MinicardPresenter mMinicardPresenter;

    @ProvidePresenter
    MinicardPresenter provideMinicardPresenter() {
        Router router = PocketDictionaryApp.getInstance().getRouter();
        MinicardInteractor minicardInteractor = PocketDictionaryApp.getAppComponent().getMinicardInteractor();
        return new MinicardPresenter(router, minicardInteractor);
    }

    public MinicardFragment() {
    }

    public static MinicardFragment getInstance() {
        Bundle args = new Bundle();
        MinicardFragment fragment = new MinicardFragment();
        fragment.setArguments(args);
        //Log.e(TAG, "getInstance");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_minicard, container, false);
        ButterKnife.bind(this, view);//TODO unbind
        Log.e(TAG, "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Log.e(TAG, "onViewCreated");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.menu_save:
                hideKeyboard(getContext(), word);
                mMinicardPresenter.onSaveMinicardMenuClicked();
            case R.id.menu_saved:
                mMinicardPresenter.onSavedMinicardMenuClicked();
        }
        return true;
    }

    @OnClick(R.id.translate)
    public void onTranslateButtonClicked() {
        mMinicardPresenter.onTranslateClicked(word.getText().toString());
    }

    @OnClick(R.id.newTranslation)
    public void onNewTranslationButtonClicked() {
        mMinicardPresenter.onNewTranslationClicked();
    }

    @Override
    public void showMinicard(MinicardModel minicardModel) {
        Log.e(TAG, "showMinicard:   " + minicardModel.getHeading() + minicardModel.getTranslation().getTranslation());
        word.setVisibility(View.GONE);
        translate.setVisibility(View.GONE);
        minicardView.setVisibility(View.VISIBLE);
        heading.setText(minicardModel.getHeading());
        translation.setText(minicardModel.getTranslation().getTranslation());
    }

    @Override
    public void showNewTranslation() {
        word.setVisibility(View.VISIBLE);
        translate.setVisibility(View.VISIBLE);
        minicardView.setVisibility(View.GONE);
        word.setText("");
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
