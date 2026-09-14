package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.c;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
/* loaded from: classes.dex */
public abstract class e {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private t1.a f4724a;

        /* renamed from: b, reason: collision with root package name */
        private Map<i1.d, b> f4725b = new HashMap();

        public a a(i1.d dVar, b bVar) {
            this.f4725b.put(dVar, bVar);
            return this;
        }

        public e b() {
            Objects.requireNonNull(this.f4724a, "missing required property: clock");
            if (this.f4725b.keySet().size() < i1.d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<i1.d, b> map = this.f4725b;
            this.f4725b = new HashMap();
            return e.d(this.f4724a, map);
        }

        public a c(t1.a aVar) {
            this.f4724a = aVar;
            return this;
        }
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class b {

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set<c> set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new c.b().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<c> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    /* loaded from: classes.dex */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i10, long j10) {
        return (long) (Math.pow(3.0d, i10 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * r7)));
    }

    public static a b() {
        return new a();
    }

    static e d(t1.a aVar, Map<i1.d, b> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.b(aVar, map);
    }

    public static e f(t1.a aVar) {
        return b().a(i1.d.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(i1.d.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(i1.d.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.NETWORK_UNMETERED, c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void j(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, i1.d dVar, long j10, int i10) {
        builder.setMinimumLatency(g(dVar, j10, i10));
        j(builder, h().get(dVar).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract t1.a e();

    public long g(i1.d dVar, long j10, int i10) {
        long a10 = j10 - e().a();
        b bVar = h().get(dVar);
        return Math.min(Math.max(a(i10, bVar.b()), a10), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<i1.d, b> h();
}
