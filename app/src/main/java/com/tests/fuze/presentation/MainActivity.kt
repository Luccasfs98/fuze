package com.tests.fuze.presentation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fuze.core.navigation.CrossModuleNavigationHelper.navigateToMatches

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        navigateToMatches(this@MainActivity)?.let {
            startActivity(it)
            finish()
        }

    }
}
