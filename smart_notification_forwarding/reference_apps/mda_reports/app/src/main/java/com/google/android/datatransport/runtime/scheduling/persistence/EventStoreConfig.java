package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
/* loaded from: classes.dex */
public abstract class EventStoreConfig {
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760;
    private static final long DURATION_ONE_WEEK_MS = 604800000;
    static final EventStoreConfig a = e().b(MAX_DB_STORAGE_SIZE_IN_BYTES).b(200).a(10000).a(DURATION_ONE_WEEK_MS).a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        abstract Builder a(int i);

        abstract Builder a(long j);

        abstract EventStoreConfig a();

        abstract Builder b(int i);

        abstract Builder b(long j);
    }

    static Builder e() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long d();
}
