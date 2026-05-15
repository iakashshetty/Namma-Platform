package com.mindmatrix.nammaplatform.presentation.home;

import com.mindmatrix.nammaplatform.data.repository.RailwayRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class RailwayViewModel_Factory implements Factory<RailwayViewModel> {
  private final Provider<RailwayRepository> railwayRepositoryProvider;

  public RailwayViewModel_Factory(Provider<RailwayRepository> railwayRepositoryProvider) {
    this.railwayRepositoryProvider = railwayRepositoryProvider;
  }

  @Override
  public RailwayViewModel get() {
    return newInstance(railwayRepositoryProvider.get());
  }

  public static RailwayViewModel_Factory create(
      Provider<RailwayRepository> railwayRepositoryProvider) {
    return new RailwayViewModel_Factory(railwayRepositoryProvider);
  }

  public static RailwayViewModel newInstance(RailwayRepository railwayRepository) {
    return new RailwayViewModel(railwayRepository);
  }
}
