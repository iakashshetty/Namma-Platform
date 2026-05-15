package com.mindmatrix.nammaplatform.data.repository;

import com.mindmatrix.nammaplatform.data.local.UserDao;
import com.mindmatrix.nammaplatform.data.session.SessionManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<SessionManager> sessionManagerProvider;

  public AuthRepository_Factory(Provider<UserDao> userDaoProvider,
      Provider<SessionManager> sessionManagerProvider) {
    this.userDaoProvider = userDaoProvider;
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(userDaoProvider.get(), sessionManagerProvider.get());
  }

  public static AuthRepository_Factory create(Provider<UserDao> userDaoProvider,
      Provider<SessionManager> sessionManagerProvider) {
    return new AuthRepository_Factory(userDaoProvider, sessionManagerProvider);
  }

  public static AuthRepository newInstance(UserDao userDao, SessionManager sessionManager) {
    return new AuthRepository(userDao, sessionManager);
  }
}
