package com.bereg.pocketdictionaryapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bereg.pocketdictionaryapplication.PocketDictionaryApp;
import com.bereg.pocketdictionaryapplication.R;
import com.bereg.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.bereg.pocketdictionaryapplication.presentation.presenters.SavedMinicardsPresenter;
import com.bereg.pocketdictionaryapplication.presentation.views.SavedMinicardsView;
import com.bereg.pocketdictionaryapplication.ui.adapters.SavedMinicardsAdapter;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 23.07.2018.
 */

public class SavedMinicardsFragment extends MvpAppCompatFragment implements SavedMinicardsView {

    private static final String TAG = SavedMinicardsFragment.class.getSimpleName();

    private List<MinicardModel> mMinicardModels = new ArrayList<>();
    private SavedMinicardsAdapter mSavedMinicardsAdapter;

    @InjectPresenter
    SavedMinicardsPresenter mSavedMinicardsPresenter;

    @ProvidePresenter
    SavedMinicardsPresenter provideSavedMinicardsPresenter() {
        Router router = PocketDictionaryApp.getInstance().getRouter();
        SavedMinicardsInteractor savedMinicardsInteractor = PocketDictionaryApp.getAppComponent().getSavedMinicardsInteractor();
        return new SavedMinicardsPresenter(router, savedMinicardsInteractor);
    }

    public SavedMinicardsFragment() {
    }

    public static SavedMinicardsFragment getInstance() {
        Bundle args = new Bundle();
        SavedMinicardsFragment fragment = new SavedMinicardsFragment();
        fragment.setArguments(args);
        //Log.e(TAG, "getInstance");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_saved_minicards, container, false);
        ButterKnife.bind(this, view);//TODO unbind
        Log.e(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.frag_saved_minicards_list);
        mSavedMinicardsAdapter = new SavedMinicardsAdapter(mMinicardModels);
        recyclerView.setAdapter(mSavedMinicardsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Log.e(TAG, "onViewCreated");
    }

    @Override
    public void showSavedMinicards(List<MinicardModel> minicardModels) {
        //mMinicardModels.clear();
        Log.e(TAG, minicardModels.toString());
        mMinicardModels.addAll(minicardModels);
        mSavedMinicardsAdapter.notifyDataSetChanged();
    }
}
