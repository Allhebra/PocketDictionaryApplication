package com.bereg.pocketdictionaryapplication.interactors;

import android.text.TextUtils;
import android.util.Log;

import com.bereg.pocketdictionaryapplication.data.SharedPreferencesManager;
import com.bereg.pocketdictionaryapplication.repository.AbbyyLingvoApiRepository;
import com.bereg.pocketdictionaryapplication.repository.LoginRepository;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Single;

/**
 * Created by Aleksander Beregovoy on 13.07.2018.
 */

public class LoginInteractor {

    private static final String TAG = LoginInteractor.class.getSimpleName();
    private LoginRepository mLoginRepository;
    private IAuthorizeRepository mAbbyyLingvoApiRepository;
    private SharedPreferencesManager mSharedPreferencesManager;

    public LoginInteractor(LoginRepository loginRepository, IAuthorizeRepository abbyyLingvoApiRepository, SharedPreferencesManager sharedPreferencesManager) {
        mLoginRepository = loginRepository;
        mAbbyyLingvoApiRepository = abbyyLingvoApiRepository;
        mSharedPreferencesManager = sharedPreferencesManager;
    }

    public Completable login(String email, String password) {
        if (isValidEmail(email) && isValidPassword(password)) {
            return mLoginRepository.login(email, password);
        }
        return Completable.error(new IllegalArgumentException("Wrong email or password!"));
    }

    public Single<Boolean> authorize() {
        return mAbbyyLingvoApiRepository.sendAuthRequest()
                .doOnSuccess(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mSharedPreferencesManager.saveToken(o.toString());
                        Log.e(TAG, o.toString());
                    }
                })
                .map(new Function<Object, Boolean>() {
                    @Override
                    public Boolean apply(Object o) throws Exception {
                        return true;//TODO
                    }
                });
    }

    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email);
    }

    private boolean isValidPassword(CharSequence password) {
        return !TextUtils.isEmpty(password);

    }
}
