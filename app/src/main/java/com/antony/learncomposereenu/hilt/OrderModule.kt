package com.antony.learncomposereenu.hilt

import android.content.Context
import androidx.room.Room
import com.antony.learncomposereenu.data.repository.SummaryRepository
import com.antony.learncomposereenu.data.repository.SummaryRepositoryImpl
import com.antony.learncomposereenu.data.source.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
abstract class OrderModule {


    @Binds
    abstract fun bindSummaryRepository(summaryRepositoryImpl: SummaryRepositoryImpl): SummaryRepository
}