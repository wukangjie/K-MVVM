package com.example.appsimple.tasks

import com.example.appsimple.di.appModule
import com.fmt.launch.starter.task.Task
import org.koin.core.context.startKoin

class InitKoInTask : Task(){

    override fun run() {
        startKoin {
            modules(appModule)
        }
    }
}