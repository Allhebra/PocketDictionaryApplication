package com.bereg.pocketdictionaryapplication.presentation.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bereg.pocketdictionaryapplication.Screens;
import com.bereg.pocketdictionaryapplication.interactors.LoginInteractor;
import com.bereg.pocketdictionaryapplication.presentation.views.LoginView;

import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import ru.terrakok.cicerone.Router;

/**
 * Created by Aleksander Beregovoy on 07.07.2018.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    private LoginInteractor mLoginInteractor;
    private Router mRouter;

    public LoginPresenter(Router router, LoginInteractor loginInteractor) {
        mRouter = router;
        mLoginInteractor = loginInteractor;
    }

    public void onLoginButtonPressed(CharSequence email, CharSequence password) {
        mLoginInteractor.login(email.toString(), password.toString())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.e(TAG, "Login onComplete");
                        getAuthToken();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }
                });
    }

    //TODO ApiKey
    private void getAuthToken() {
        mLoginInteractor.authorize()
                .subscribe(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(Boolean a) {
                        Log.e(TAG, "authorized:   " + a);
                        if (a) {
                            mRouter.showSystemMessage("You authorized successfully!");
                        }
                        else {
                            mRouter.showSystemMessage("You are not authorized!");

                        }
                        mRouter.navigateTo(Screens.MINICARD_SCREEN);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }
                });
    }
}
