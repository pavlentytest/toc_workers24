package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {

    public int x;

    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        x = workerParams.getInputData().getInt("key",0);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("RRR","x = " + x);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Data data = new Data.Builder().putString("fromworker","Hello!").build();
        return Result.success(data);

    }
}