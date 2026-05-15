package com.mindmatrix.nammaplatform.data.repository;

import android.content.Context;
import com.google.gson.Gson;
import com.mindmatrix.nammaplatform.data.local.StationDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AssetRailwayRepository_Factory implements Factory<AssetRailwayRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<StationDao> stationDaoProvider;

  private final Provider<Gson> gsonProvider;

  public AssetRailwayRepository_Factory(Provider<Context> contextProvider,
      Provider<StationDao> stationDaoProvider, Provider<Gson> gsonProvider) {
    this.contextProvider = contextProvider;
    this.stationDaoProvider = stationDaoProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public AssetRailwayRepository get() {
    return newInstance(contextProvider.get(), stationDaoProvider.get(), gsonProvider.get());
  }

  public static AssetRailwayRepository_Factory create(Provider<Context> contextProvider,
      Provider<StationDao> stationDaoProvider, Provider<Gson> gsonProvider) {
    return new AssetRailwayRepository_Factory(contextProvider, stationDaoProvider, gsonProvider);
  }

  public static AssetRailwayRepository newInstance(Context context, StationDao stationDao,
      Gson gson) {
    return new AssetRailwayRepository(context, stationDao, gson);
  }
}
