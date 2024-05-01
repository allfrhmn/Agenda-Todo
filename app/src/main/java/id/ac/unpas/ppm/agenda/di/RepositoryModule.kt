package id.ac.unpas.ppm.agenda.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.ppm.agenda.networks.TodoApi
import id.ac.unpas.ppm.agenda.persistences.TodoDao
import id.ac.unpas.ppm.agenda.repositories.TodoRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTodoRepository(todoDao: TodoDao, todoApi: TodoApi): TodoRepository {
        return TodoRepository(todoApi, todoDao)
    }
}