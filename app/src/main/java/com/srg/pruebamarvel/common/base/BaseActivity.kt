package com.srg.pruebamarvel.common.base

import android.os.Bundle
import com.srg.pruebamarvel.common.di.injections.FragmentInjectionFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by sebrodgar on 27/02/2021.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var fragmentFactory: FragmentInjectionFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
    }
}