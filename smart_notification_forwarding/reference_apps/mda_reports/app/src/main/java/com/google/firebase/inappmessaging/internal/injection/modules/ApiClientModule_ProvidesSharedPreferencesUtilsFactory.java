package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesSharedPreferencesUtilsFactory implements Factory<SharedPreferencesUtils> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesSharedPreferencesUtilsFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    public static ApiClientModule_ProvidesSharedPreferencesUtilsFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesSharedPreferencesUtilsFactory(apiClientModule);
    }

    public static SharedPreferencesUtils providesSharedPreferencesUtils(ApiClientModule apiClientModule) {
        return (SharedPreferencesUtils) Preconditions.checkNotNull(apiClientModule.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public SharedPreferencesUtils get() {
        return providesSharedPreferencesUtils(this.module);
    }
}
