package com.mindmatrix.nammaplatform.di;

import com.mindmatrix.nammaplatform.data.local.NammaDatabase;
import com.mindmatrix.nammaplatform.data.local.UserDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AppModule_ProvideUserDaoFactory implements Factory<UserDao> {
  private final Provider<NammaDatabase> databaseProvider;

  public AppModule_ProvideUserDaoFactory(Provider<NammaDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserDao get() {
    return provideUserDao(databaseProvider.get());
  }

  public static AppModule_ProvideUserDaoFactory create(Provider<NammaDatabase> databaseProvider) {
    return new AppModule_ProvideUserDaoFactory(databaseProvider);
  }

  public static UserDao provideUserDao(NammaDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserDao(database));
  }
}
