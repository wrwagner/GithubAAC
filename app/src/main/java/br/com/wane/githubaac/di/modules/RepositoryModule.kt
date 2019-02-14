package br.com.wane.githubaac.di.modules

import br.com.wane.githubaac.data.UserRepository
import br.com.wane.githubaac.data.local.dao.UserDAO
import br.com.wane.githubaac.data.remote.UserWebService
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module(includes = [
    NetModule::class,
    DataBaseModule::class,
    AppModule::class
])
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebService,
            userDao: UserDAO,
            executor: Executor
    ): UserRepository {
        return UserRepository(webservice, userDao, executor)
    }
}