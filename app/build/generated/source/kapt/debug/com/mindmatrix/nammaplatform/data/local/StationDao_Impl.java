package com.mindmatrix.nammaplatform.data.local;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class StationDao_Impl implements StationDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<FavoriteStationEntity> __insertAdapterOfFavoriteStationEntity;

  private final EntityInsertAdapter<RecentStationEntity> __insertAdapterOfRecentStationEntity;

  public StationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFavoriteStationEntity = new EntityInsertAdapter<FavoriteStationEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorite_stations` (`stationCode`,`addedAt`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final FavoriteStationEntity entity) {
        if (entity.getStationCode() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getStationCode());
        }
        statement.bindLong(2, entity.getAddedAt());
      }
    };
    this.__insertAdapterOfRecentStationEntity = new EntityInsertAdapter<RecentStationEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `recent_stations` (`stationCode`,`viewedAt`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final RecentStationEntity entity) {
        if (entity.getStationCode() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getStationCode());
        }
        statement.bindLong(2, entity.getViewedAt());
      }
    };
  }

  @Override
  public Object addFavorite(final FavoriteStationEntity favorite,
      final Continuation<? super Unit> $completion) {
    if (favorite == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfFavoriteStationEntity.insert(_connection, favorite);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object addRecent(final RecentStationEntity recent,
      final Continuation<? super Unit> $completion) {
    if (recent == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfRecentStationEntity.insert(_connection, recent);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<FavoriteStationEntity>> observeFavorites() {
    final String _sql = "SELECT * FROM favorite_stations ORDER BY addedAt DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"favorite_stations"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfStationCode = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "stationCode");
        final int _columnIndexOfAddedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "addedAt");
        final List<FavoriteStationEntity> _result = new ArrayList<FavoriteStationEntity>();
        while (_stmt.step()) {
          final FavoriteStationEntity _item;
          final String _tmpStationCode;
          if (_stmt.isNull(_columnIndexOfStationCode)) {
            _tmpStationCode = null;
          } else {
            _tmpStationCode = _stmt.getText(_columnIndexOfStationCode);
          }
          final long _tmpAddedAt;
          _tmpAddedAt = _stmt.getLong(_columnIndexOfAddedAt);
          _item = new FavoriteStationEntity(_tmpStationCode,_tmpAddedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<RecentStationEntity>> observeRecent() {
    final String _sql = "SELECT * FROM recent_stations ORDER BY viewedAt DESC LIMIT 8";
    return FlowUtil.createFlow(__db, false, new String[] {"recent_stations"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfStationCode = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "stationCode");
        final int _columnIndexOfViewedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "viewedAt");
        final List<RecentStationEntity> _result = new ArrayList<RecentStationEntity>();
        while (_stmt.step()) {
          final RecentStationEntity _item;
          final String _tmpStationCode;
          if (_stmt.isNull(_columnIndexOfStationCode)) {
            _tmpStationCode = null;
          } else {
            _tmpStationCode = _stmt.getText(_columnIndexOfStationCode);
          }
          final long _tmpViewedAt;
          _tmpViewedAt = _stmt.getLong(_columnIndexOfViewedAt);
          _item = new RecentStationEntity(_tmpStationCode,_tmpViewedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object removeFavorite(final String stationCode,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM favorite_stations WHERE stationCode = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (stationCode == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, stationCode);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
