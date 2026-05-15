package com.mindmatrix.nammaplatform.data.local;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<UserEntity> __insertAdapterOfUserEntity;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfUserEntity = new EntityInsertAdapter<UserEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`name`,`email`,`phone`,`passwordHash`,`passwordSalt`,`photoUri`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getPhone());
        }
        if (entity.getPasswordHash() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getPasswordHash());
        }
        if (entity.getPasswordSalt() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getPasswordSalt());
        }
        if (entity.getPhotoUri() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getPhotoUri());
        }
      }
    };
  }

  @Override
  public Object insert(final UserEntity user, final Continuation<? super Long> $completion) {
    if (user == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      return __insertAdapterOfUserEntity.insertAndReturnId(_connection, user);
    }, $completion);
  }

  @Override
  public Object findByEmail(final String email,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (email == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, email);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfEmail = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "email");
        final int _columnIndexOfPhone = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "phone");
        final int _columnIndexOfPasswordHash = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "passwordHash");
        final int _columnIndexOfPasswordSalt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "passwordSalt");
        final int _columnIndexOfPhotoUri = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "photoUri");
        final UserEntity _result;
        if (_stmt.step()) {
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpEmail;
          if (_stmt.isNull(_columnIndexOfEmail)) {
            _tmpEmail = null;
          } else {
            _tmpEmail = _stmt.getText(_columnIndexOfEmail);
          }
          final String _tmpPhone;
          if (_stmt.isNull(_columnIndexOfPhone)) {
            _tmpPhone = null;
          } else {
            _tmpPhone = _stmt.getText(_columnIndexOfPhone);
          }
          final String _tmpPasswordHash;
          if (_stmt.isNull(_columnIndexOfPasswordHash)) {
            _tmpPasswordHash = null;
          } else {
            _tmpPasswordHash = _stmt.getText(_columnIndexOfPasswordHash);
          }
          final String _tmpPasswordSalt;
          if (_stmt.isNull(_columnIndexOfPasswordSalt)) {
            _tmpPasswordSalt = null;
          } else {
            _tmpPasswordSalt = _stmt.getText(_columnIndexOfPasswordSalt);
          }
          final String _tmpPhotoUri;
          if (_stmt.isNull(_columnIndexOfPhotoUri)) {
            _tmpPhotoUri = null;
          } else {
            _tmpPhotoUri = _stmt.getText(_columnIndexOfPhotoUri);
          }
          _result = new UserEntity(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpPasswordHash,_tmpPasswordSalt,_tmpPhotoUri);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Flow<UserEntity> observeById(final long id) {
    final String _sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
    return FlowUtil.createFlow(__db, false, new String[] {"users"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfEmail = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "email");
        final int _columnIndexOfPhone = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "phone");
        final int _columnIndexOfPasswordHash = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "passwordHash");
        final int _columnIndexOfPasswordSalt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "passwordSalt");
        final int _columnIndexOfPhotoUri = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "photoUri");
        final UserEntity _result;
        if (_stmt.step()) {
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpEmail;
          if (_stmt.isNull(_columnIndexOfEmail)) {
            _tmpEmail = null;
          } else {
            _tmpEmail = _stmt.getText(_columnIndexOfEmail);
          }
          final String _tmpPhone;
          if (_stmt.isNull(_columnIndexOfPhone)) {
            _tmpPhone = null;
          } else {
            _tmpPhone = _stmt.getText(_columnIndexOfPhone);
          }
          final String _tmpPasswordHash;
          if (_stmt.isNull(_columnIndexOfPasswordHash)) {
            _tmpPasswordHash = null;
          } else {
            _tmpPasswordHash = _stmt.getText(_columnIndexOfPasswordHash);
          }
          final String _tmpPasswordSalt;
          if (_stmt.isNull(_columnIndexOfPasswordSalt)) {
            _tmpPasswordSalt = null;
          } else {
            _tmpPasswordSalt = _stmt.getText(_columnIndexOfPasswordSalt);
          }
          final String _tmpPhotoUri;
          if (_stmt.isNull(_columnIndexOfPhotoUri)) {
            _tmpPhotoUri = null;
          } else {
            _tmpPhotoUri = _stmt.getText(_columnIndexOfPhotoUri);
          }
          _result = new UserEntity(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpPasswordHash,_tmpPasswordSalt,_tmpPhotoUri);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object updatePassword(final String email, final String hash, final String salt,
      final Continuation<? super Unit> $completion) {
    final String _sql = "UPDATE users SET passwordHash = ?, passwordSalt = ? WHERE email = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (hash == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, hash);
        }
        _argIndex = 2;
        if (salt == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, salt);
        }
        _argIndex = 3;
        if (email == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, email);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object updateProfile(final long id, final String name, final String phone,
      final String photoUri, final Continuation<? super Unit> $completion) {
    final String _sql = "UPDATE users SET name = ?, phone = ?, photoUri = ? WHERE id = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (name == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, name);
        }
        _argIndex = 2;
        if (phone == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, phone);
        }
        _argIndex = 3;
        if (photoUri == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, photoUri);
        }
        _argIndex = 4;
        _stmt.bindLong(_argIndex, id);
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
