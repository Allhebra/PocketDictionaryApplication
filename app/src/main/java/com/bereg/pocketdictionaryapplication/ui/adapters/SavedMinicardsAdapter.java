package com.bereg.pocketdictionaryapplication.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.bereg.pocketdictionaryapplication.R;
import com.bereg.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by 1 on 23.07.2018.
 */

public class SavedMinicardsAdapter extends RecyclerView.Adapter<SavedMinicardsAdapter.ViewHolder> {

    private static final String TAG = SavedMinicardsAdapter.class.getSimpleName();
    private static PublishSubject<MinicardModel> mViewClickSubject = PublishSubject.create();
    private static PublishSubject<MinicardModel> mViewCheckedChangesSubject = PublishSubject.create();
    private List<MinicardModel> items;

    public SavedMinicardsAdapter(List<MinicardModel> list) {
        this.items = list;
    }

    public static Observable<MinicardModel> getViewClickedObservable() {
        return mViewClickSubject.hide();
    }

    public static Observable<MinicardModel> getViewCheckedChangesObservable() {
        return mViewCheckedChangesSubject.hide();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_minicards_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.e(TAG, "onCreateViewHolder:  " + viewHolder);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder:  " + holder + "to" + position + "with" + items.get(position));
        holder.bind(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "item count:   " + items.size());
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        MinicardModel mMinicardModel;
        private TextView heading;
        private TextView translation;

        ViewHolder(View v) {
            super(v);
            this.view = v;
            heading = v.findViewById(R.id.heading);
            translation = v.findViewById(R.id.translation);
        }

        public void bind(final MinicardModel minicardModel, final int position) {
            mMinicardModel = minicardModel;
            heading.setText(minicardModel.getHeading());
            translation.setText(minicardModel.getTranslation().getTranslation());
        }

        View getView() {
            return view;
        }
    }
}
