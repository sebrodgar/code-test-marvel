package com.srg.pruebamarvel

import android.os.Bundle
import com.srg.pruebamarvel.common.base.BaseActivity
import com.srg.pruebamarvel.presentation.features.main.MainFragment
import javax.inject.Inject

class MainActivity @Inject constructor() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }
}