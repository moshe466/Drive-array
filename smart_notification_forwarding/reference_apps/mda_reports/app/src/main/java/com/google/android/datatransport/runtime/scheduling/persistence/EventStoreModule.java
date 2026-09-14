package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
/* loaded from: classes.dex */
public abstract class EventStoreModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SCHEMA_VERSION")
    public static int a() {
        return SchemaManager.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static EventStoreConfig b() {
        return EventStoreConfig.a;
    }
}
