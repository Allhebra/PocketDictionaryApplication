package com.bereg.pocketdictionaryapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bereg.pocketdictionaryapplication.PocketDictionaryApp;
import com.bereg.pocketdictionaryapplication.R;
import com.bereg.pocketdictionaryapplication.data.api.AbbyyLingvoApi;
import com.bereg.pocketdictionaryapplication.interactors.LoginInteractor;
import com.bereg.pocketdictionaryapplication.presentation.presenters.LoginPresenter;
import com.bereg.pocketdictionaryapplication.presentation.views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Router;

/**
 * Created by 1 on 14.07.2018.
 */

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    private static final String TAG = LoginFragment.class.getSimpleName();

    @BindView(R.id.email)
    TextView mEmailView;
    @BindView(R.id.password)
    TextView mPasswordView;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    @ProvidePresenter
    LoginPresenter provideLoginPresenter() {
        Router router = PocketDictionaryApp.getInstance().getRouter();
        LoginInteractor mLoginInteractor = PocketDictionaryApp.getAppComponent().getLoginInteractor();//TODO
        return new LoginPresenter(router, mLoginInteractor);
    }

    public LoginFragment() {
    }

    public static LoginFragment getInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        //Log.e(TAG, "getInstance");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        //TODO: binding
        //TODO resume???
        /*mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.onLoginButtonPressed(mEmailView.getText(), mPasswordView.getText());
            }
        });*/
        return view;
    }

    @OnClick(R.id.email_sign_in_button)
    public void onSignInButtonClicked() {
        mLoginPresenter.onLoginButtonPressed(mEmailView.getText(), mPasswordView.getText());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Log.e(TAG, "onViewCreated");
    }
}
