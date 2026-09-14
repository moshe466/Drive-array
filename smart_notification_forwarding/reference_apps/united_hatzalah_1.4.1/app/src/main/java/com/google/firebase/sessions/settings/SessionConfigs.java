package com.google.firebase.sessions.settings;

import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionConfigs {
    private final Integer cacheDuration;
    private final Long cacheUpdatedTime;
    private final Boolean sessionEnabled;
    private final Integer sessionRestartTimeout;
    private final Double sessionSamplingRate;

    public SessionConfigs(Boolean bool, Double d2, Integer num, Integer num2, Long l3) {
        this.sessionEnabled = bool;
        this.sessionSamplingRate = d2;
        this.sessionRestartTimeout = num;
        this.cacheDuration = num2;
        this.cacheUpdatedTime = l3;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d2, Integer num, Integer num2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sessionConfigs.sessionEnabled;
        }
        if ((i & 2) != 0) {
            d2 = sessionConfigs.sessionSamplingRate;
        }
        if ((i & 4) != 0) {
            num = sessionConfigs.sessionRestartTimeout;
        }
        if ((i & 8) != 0) {
            num2 = sessionConfigs.cacheDuration;
        }
        if ((i & 16) != 0) {
            l3 = sessionConfigs.cacheUpdatedTime;
        }
        Long l4 = l3;
        Integer num3 = num;
        return sessionConfigs.copy(bool, d2, num3, num2, l4);
    }

    public final Boolean component1() {
        return this.sessionEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionRestartTimeout;
    }

    public final Integer component4() {
        return this.cacheDuration;
    }

    public final Long component5() {
        return this.cacheUpdatedTime;
    }

    public final SessionConfigs copy(Boolean bool, Double d2, Integer num, Integer num2, Long l3) {
        return new SessionConfigs(bool, d2, num, num2, l3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return j.a(this.sessionEnabled, sessionConfigs.sessionEnabled) && j.a(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && j.a(this.sessionRestartTimeout, sessionConfigs.sessionRestartTimeout) && j.a(this.cacheDuration, sessionConfigs.cacheDuration) && j.a(this.cacheUpdatedTime, sessionConfigs.cacheUpdatedTime);
    }

    public final Integer getCacheDuration() {
        return this.cacheDuration;
    }

    public final Long getCacheUpdatedTime() {
        return this.cacheUpdatedTime;
    }

    public final Boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    public final Integer getSessionRestartTimeout() {
        return this.sessionRestartTimeout;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public int hashCode() {
        Boolean bool = this.sessionEnabled;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d2 = this.sessionSamplingRate;
        int hashCode2 = (hashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.sessionRestartTimeout;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDuration;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l3 = this.cacheUpdatedTime;
        return hashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.sessionEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionRestartTimeout=" + this.sessionRestartTimeout + ", cacheDuration=" + this.cacheDuration + ", cacheUpdatedTime=" + this.cacheUpdatedTime + ')';
    }
}
