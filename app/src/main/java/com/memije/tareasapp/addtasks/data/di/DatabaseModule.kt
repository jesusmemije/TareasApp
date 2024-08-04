package com.memije.tareasapp.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.memije.tareasapp.addtasks.data.TareasDatabase
import com.memije.tareasapp.addtasks.data.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideTaskDao(tareasDatabase: TareasDatabase) : TaskDao {
        return tareasDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTareasDatabase(@ApplicationContext appContext: Context): TareasDatabase {
        return Room.databaseBuilder(appContext, TareasDatabase::class.java, "TareasDatabase").build()
    }
}