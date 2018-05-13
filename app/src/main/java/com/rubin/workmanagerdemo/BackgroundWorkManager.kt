package com.rubin.workmanagerdemo

import android.util.Log.d
import androidx.work.Worker

class BackgroundWorkManager : Worker() {

    override fun doWork(): WorkerResult {
        // This is where you do your background Tasks

        d("WorkManager", "Running the Background Process")

        return WorkerResult.SUCCESS
    }
}