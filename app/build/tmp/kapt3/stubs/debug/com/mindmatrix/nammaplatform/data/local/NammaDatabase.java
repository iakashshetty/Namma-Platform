package com.mindmatrix.nammaplatform.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/local/NammaDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "userDao", "Lcom/mindmatrix/nammaplatform/data/local/UserDao;", "stationDao", "Lcom/mindmatrix/nammaplatform/data/local/StationDao;", "app_debug"})
@androidx.room.Database(entities = {com.mindmatrix.nammaplatform.data.local.UserEntity.class, com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity.class, com.mindmatrix.nammaplatform.data.local.RecentStationEntity.class}, version = 1, exportSchema = false)
public abstract class NammaDatabase extends androidx.room.RoomDatabase {
    
    public NammaDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.nammaplatform.data.local.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mindmatrix.nammaplatform.data.local.StationDao stationDao();
}