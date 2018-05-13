package com.rubin.workmanagerdemo

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraints = Constraints.Builder().setRequiresCharging(true).build()

        val task = OneTimeWorkRequest.Builder(BackgroundWorkManager::class.java).setConstraints(constraints).build()
        val workManager = WorkManager.getInstance()
        workManager.enqueue(task)

        workManager.getStatusById(task.id).observe(this, Observer {
            if (it != null) {
                txtLog.text = "${txtLog.text} \n Status Changed to ${it.state.isFinished}"
            }
        })

    }
}
