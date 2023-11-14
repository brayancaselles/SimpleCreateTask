package com.example.allcomposeapp.addtask.data.di

import android.content.Context
import androidx.room.Room
import com.example.allcomposeapp.addtask.data.AllComposeDataBase
import com.example.allcomposeapp.addtask.data.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AllComposeDataBase {
        return Room.databaseBuilder(context, AllComposeDataBase::class.java, "taskDatabase").build()
    }

    @Provides
    fun provideTaskDao(dataBase: AllComposeDataBase): TaskDao {
        return dataBase.taskDao()
    }
}
