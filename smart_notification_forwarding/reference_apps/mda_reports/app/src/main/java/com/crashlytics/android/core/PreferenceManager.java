package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
public class PreferenceManager {
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final PreferenceStore preferenceStore;

    public PreferenceManager(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = preferenceStore;
        this.kit = crashlyticsCore;
    }

    public static PreferenceManager create(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(preferenceStore, crashlyticsCore);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        PreferenceStore preferenceStore = this.preferenceStore;
        preferenceStore.save(preferenceStore.edit().putBoolean("always_send_reports_opt_in", z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (!this.preferenceStore.get().contains(PREF_MIGRATION_COMPLETE)) {
            PreferenceStoreImpl preferenceStoreImpl = new PreferenceStoreImpl(this.kit);
            if (!this.preferenceStore.get().contains("always_send_reports_opt_in") && preferenceStoreImpl.get().contains("always_send_reports_opt_in")) {
                boolean z = preferenceStoreImpl.get().getBoolean("always_send_reports_opt_in", false);
                PreferenceStore preferenceStore = this.preferenceStore;
                preferenceStore.save(preferenceStore.edit().putBoolean("always_send_reports_opt_in", z));
            }
            PreferenceStore preferenceStore2 = this.preferenceStore;
            preferenceStore2.save(preferenceStore2.edit().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return this.preferenceStore.get().getBoolean("always_send_reports_opt_in", false);
    }
}
