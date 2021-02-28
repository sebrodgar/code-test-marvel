package com.srg.pruebamarvel

import androidx.appcompat.app.AppCompatActivity
import com.srg.pruebamarvel.presentation.features.main.MainFragmentBuilder
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by sebrodgar on 28/02/2021.
 */
@Module
abstract class MainActivityBuilder {
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainFragmentBuilder::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun provideActivity(mainActivity: MainActivity): AppCompatActivity

}