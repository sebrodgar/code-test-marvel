package com.srg.pruebamarvel.common.di

import com.srg.pruebamarvel.common.MarvelApplication
import com.srg.pruebamarvel.common.di.modules.AppModule
import com.srg.pruebamarvel.common.di.modules.DataProvidersModule
import com.srg.pruebamarvel.common.di.modules.RemoteModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * Created by sebrodgar on 26/02/2021.
 */
@Component(
    modules = [
        AppModule::class,
        DataProvidersModule::class,
        RemoteModule::class
    ]
)
interface AppComponent : AndroidInjector<MarvelApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MarvelApplication): Builder

        fun build(): AppComponent
    }
}
