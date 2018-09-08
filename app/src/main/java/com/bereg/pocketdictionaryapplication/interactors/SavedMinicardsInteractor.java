package com.bereg.pocketdictionaryapplication.interactors;

import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.bereg.pocketdictionaryapplication.repository.RoomRepository;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by 1 on 23.07.2018.
 */

public class SavedMinicardsInteractor {

    private RoomRepository mRoomRepository;

    public SavedMinicardsInteractor(RoomRepository roomRepository) {
        mRoomRepository = roomRepository;
    }

    public Maybe<List<MinicardModel>> getAllMinicards() {
        return mRoomRepository.getAllMinicards();
    }
}
