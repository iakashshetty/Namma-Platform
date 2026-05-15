package com.mindmatrix.nammaplatform.di;

import com.mindmatrix.nammaplatform.data.local.NammaDatabase;
import com.mindmatrix.nammaplatform.data.local.StationDao;
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
public final class AppModule_ProvideStationDaoFactory implements Factory<StationDao> {
  private final Provider<NammaDatabase> databaseProvider;

  public AppModule_ProvideStationDaoFactory(Provider<NammaDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public StationDao get() {
    return provideStationDao(databaseProvider.get());
  }

  public static AppModule_ProvideStationDaoFactory create(
      Provider<NammaDatabase> databaseProvider) {
    return new AppModule_ProvideStationDaoFactory(databaseProvider);
  }

  public static StationDao provideStationDao(NammaDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStationDao(database));
  }
}
