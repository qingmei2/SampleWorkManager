package com.example.sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.work.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_add_task).setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(workRequest)
    }

    class UploadWorker(appContext: Context, params: WorkerParameters) : Worker(appContext, params) {
        override fun doWork(): Result {
            Log.i("mq", "worker.doWork--  start")
            Thread.sleep(3000)
            Log.i("mq", "worker.doWork--  end")
            return Result.success()
        }
    }
}