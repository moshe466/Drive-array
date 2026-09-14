package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    /* loaded from: classes.dex */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z3, boolean z4, boolean z5) {
            this.collectReports = z3;
            this.collectAnrs = z4;
            this.collectBuildIds = z5;
        }
    }

    /* loaded from: classes.dex */
    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i, int i3) {
            this.maxCustomExceptionEvents = i;
            this.maxCompleteSessionsCount = i3;
        }
    }

    public Settings(long j2, SessionData sessionData, FeatureFlagData featureFlagData, int i, int i3, double d2, double d4, int i4) {
        this.expiresAtMillis = j2;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i;
        this.cacheDuration = i3;
        this.onDemandUploadRatePerMinute = d2;
        this.onDemandBackoffBase = d4;
        this.onDemandBackoffStepDurationSeconds = i4;
    }

    public boolean isExpired(long j2) {
        if (this.expiresAtMillis < j2) {
            return true;
        }
        return false;
    }
}
