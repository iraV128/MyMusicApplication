package com.example.myassssmentapplication

import android.app.Application
import com.example.myassssmentapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Custom Application class for initializing Koin Dependency Injection.
 */
class App : Application() {

    // This method is called when the application is first created.
    override fun onCreate() {
        super.onCreate()

        // ✅ Start Koin DI framework
        startKoin {
            // Provides context to Koin so it can inject Android-specific components
            androidContext(this@App)

            // Loads the app's DI module(s) defined in com.example.myassssmentapplication.di.appModule
            modules(appModule)
        }
    }
}
