package com.mindmatrix.nammaplatform.di;

import android.content.Context;
import androidx.room.Room;
import com.google.gson.Gson;
import com.mindmatrix.nammaplatform.data.local.NammaDatabase;
import com.mindmatrix.nammaplatform.data.local.StationDao;
import com.mindmatrix.nammaplatform.data.local.UserDao;
import com.mindmatrix.nammaplatform.data.repository.AssetRailwayRepository;
import com.mindmatrix.nammaplatform.data.repository.RailwayRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/mindmatrix/nammaplatform/di/AppModule;", "", "<init>", "()V", "provideGson", "Lcom/google/gson/Gson;", "provideDatabase", "Lcom/mindmatrix/nammaplatform/data/local/NammaDatabase;", "context", "Landroid/content/Context;", "provideUserDao", "Lcom/mindmatrix/nammaplatform/data/local/UserDao;", "database", "provideStationDao", "Lcom/mindmatrix/nammaplatform/data/local/StationDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.mindmatrix.nammaplatform.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.nammaplatform.data.local.NammaDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.nammaplatform.data.local.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.NammaDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.nammaplatform.data.local.StationDao provideStationDao(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.NammaDatabase database) {
        return null;
    }
}