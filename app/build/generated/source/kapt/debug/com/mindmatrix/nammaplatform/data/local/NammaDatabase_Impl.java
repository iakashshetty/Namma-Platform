package com.mindmatrix.nammaplatform.data.local;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class NammaDatabase_Impl extends NammaDatabase {
  private volatile UserDao _userDao;

  private volatile StationDao _stationDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "890f8e429c1698b8fe6de34f49d130c6", "888984c1f6121d5bcd253e2557873128") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `passwordHash` TEXT NOT NULL, `passwordSalt` TEXT NOT NULL, `photoUri` TEXT)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_users_email` ON `users` (`email`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `favorite_stations` (`stationCode` TEXT NOT NULL, `addedAt` INTEGER NOT NULL, PRIMARY KEY(`stationCode`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `recent_stations` (`stationCode` TEXT NOT NULL, `viewedAt` INTEGER NOT NULL, PRIMARY KEY(`stationCode`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '890f8e429c1698b8fe6de34f49d130c6')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `users`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `favorite_stations`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `recent_stations`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(7);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("passwordHash", new TableInfo.Column("passwordHash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("passwordSalt", new TableInfo.Column("passwordSalt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(1);
        _indicesUsers.add(new TableInfo.Index("index_users_email", true, Arrays.asList("email"), Arrays.asList("ASC")));
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(connection, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenDelegate.ValidationResult(false, "users(com.mindmatrix.nammaplatform.data.local.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final Map<String, TableInfo.Column> _columnsFavoriteStations = new HashMap<String, TableInfo.Column>(2);
        _columnsFavoriteStations.put("stationCode", new TableInfo.Column("stationCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavoriteStations.put("addedAt", new TableInfo.Column("addedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysFavoriteStations = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesFavoriteStations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavoriteStations = new TableInfo("favorite_stations", _columnsFavoriteStations, _foreignKeysFavoriteStations, _indicesFavoriteStations);
        final TableInfo _existingFavoriteStations = TableInfo.read(connection, "favorite_stations");
        if (!_infoFavoriteStations.equals(_existingFavoriteStations)) {
          return new RoomOpenDelegate.ValidationResult(false, "favorite_stations(com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity).\n"
                  + " Expected:\n" + _infoFavoriteStations + "\n"
                  + " Found:\n" + _existingFavoriteStations);
        }
        final Map<String, TableInfo.Column> _columnsRecentStations = new HashMap<String, TableInfo.Column>(2);
        _columnsRecentStations.put("stationCode", new TableInfo.Column("stationCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecentStations.put("viewedAt", new TableInfo.Column("viewedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysRecentStations = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesRecentStations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecentStations = new TableInfo("recent_stations", _columnsRecentStations, _foreignKeysRecentStations, _indicesRecentStations);
        final TableInfo _existingRecentStations = TableInfo.read(connection, "recent_stations");
        if (!_infoRecentStations.equals(_existingRecentStations)) {
          return new RoomOpenDelegate.ValidationResult(false, "recent_stations(com.mindmatrix.nammaplatform.data.local.RecentStationEntity).\n"
                  + " Expected:\n" + _infoRecentStations + "\n"
                  + " Found:\n" + _existingRecentStations);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users", "favorite_stations", "recent_stations");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "users", "favorite_stations", "recent_stations");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StationDao.class, StationDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public StationDao stationDao() {
    if (_stationDao != null) {
      return _stationDao;
    } else {
      synchronized(this) {
        if(_stationDao == null) {
          _stationDao = new StationDao_Impl(this);
        }
        return _stationDao;
      }
    }
  }
}
