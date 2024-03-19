package ir.mirdar.pexelmovieapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.kotlin.Realm
import ir.mirdar.pexelmovieapp.data.local.LocalRepositoryImpl
import ir.mirdar.pexelmovieapp.data.remote.ApiService
import ir.mirdar.pexelmovieapp.data.remote.RemoteRepositoryImpl
import ir.mirdar.pexelmovieapp.domain.repositories.LocalRepository
import ir.mirdar.pexelmovieapp.domain.repositories.RemoteRepository

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideRemoteRepository(apiService: ApiService): RemoteRepository =
        RemoteRepositoryImpl(apiService)

    @Provides
    @ViewModelScoped
    fun provideLocalRepository(realm: Realm) : LocalRepository = LocalRepositoryImpl(realm)
}