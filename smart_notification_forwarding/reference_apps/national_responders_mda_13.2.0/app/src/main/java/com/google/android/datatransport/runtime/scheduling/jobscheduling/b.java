package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    private final t1.a f4714a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<i1.d, e.b> f4715b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(t1.a aVar, Map<i1.d, e.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.f4714a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f4715b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e
    t1.a e() {
        return this.f4714a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4714a.equals(eVar.e()) && this.f4715b.equals(eVar.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e
    Map<i1.d, e.b> h() {
        return this.f4715b;
    }

    public int hashCode() {
        return ((this.f4714a.hashCode() ^ 1000003) * 1000003) ^ this.f4715b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f4714a + ", values=" + this.f4715b + "}";
    }
}
