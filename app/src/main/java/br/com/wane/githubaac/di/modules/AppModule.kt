package br.com.wane.githubaac.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import br.com.wane.githubaac.data.UserRepository
import br.com.wane.githubaac.data.local.MeuBancoDeDados
import br.com.wane.githubaac.data.local.dao.UserDAO
import br.com.wane.githubaac.data.remote.UserWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {



    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }






}

