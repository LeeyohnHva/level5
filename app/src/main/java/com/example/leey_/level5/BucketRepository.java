package com.example.leey_.level5;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BucketRepository {
    private AppDatabase mAppDatabase;
    private BucketDao mBucketDao;

    private LiveData<List<Bucket>> mBuckets;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public BucketRepository(Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
        mBucketDao = mAppDatabase.bucketDao();
        mBuckets = mBucketDao.getAllBuckets();
    }

    public LiveData<List<Bucket>> getAllBuckets() {
        return mBuckets;
    }

    public void insert(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.insertBuckets(bucket);
            }
        });
    }

    public void update(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.updateBuckets(bucket);
            }
        });
    }

    public void delete(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.deleteBuckets(bucket);
            }
        });
    }
}
