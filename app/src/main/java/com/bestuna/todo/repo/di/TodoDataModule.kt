package com.bestuna.todo.repo.di

import com.bestuna.todo.repo.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object TodoRepositoryModule {
    @Remote
    @Provides
    fun provideTodoDataSourceRemote(): TodoDataSource {
        return TodoDataSourceRemote()
    }


    @Local
    @Provides
    fun provideTodoDataSourceLocale(): TodoDataSource {
        return TodoDataSourceLocale()
    }

    @Provides
    fun provideTodoRepository(
        @Remote remote: TodoDataSource,
        @Local local: TodoDataSource,
    ): TodoRepository {
        return TodoRepositoryImpl(
            remote,
            local
        )
    }



    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Remote

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Local

}
