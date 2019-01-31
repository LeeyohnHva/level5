package com.example.leey_.level5;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

public class BucketViewModel extends ViewModel {
    private BucketRepository mRepository;
    private LiveData<List<Bucket>> mBuckets;

    public BucketViewModel(Context context) {

        mRepository = new BucketRepository(context);
        mBuckets = mRepository.getAllBuckets();
    }

    public LiveData<List<Bucket>> getBuckets() {
        return mBuckets;
    }

    public void insert(Bucket bucket) {
        mRepository.insert(bucket);
    }

    public void update(Bucket bucket) {
        mRepository.update(bucket);
    }

    public void delete(Bucket bucket) {
        mRepository.delete(bucket);
    }
}
