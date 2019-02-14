package br.com.wane.githubaac.di.modules

import br.com.wane.githubaac.BuildConfig
import br.com.wane.githubaac.data.remote.UserWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
import com.facebook.stetho.okhttp3.StethoInterceptor



@Module
class NetModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson,
                        @Named("githubURL")githubURL: String, okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.GITHUB_URL)
                .client(okHttp)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkhtppClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build();
    }

    @Provides
    @Singleton
    @Named("githubURL")
    fun providesGithubURL(): String {
        return  BuildConfig.GITHUB_URL
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebService {
        return restAdapter.create(UserWebService::class.java)
    }

}