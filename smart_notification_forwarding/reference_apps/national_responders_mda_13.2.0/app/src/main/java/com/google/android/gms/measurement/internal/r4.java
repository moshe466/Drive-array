package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.pb;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r4<V> extends FutureTask<V> implements Comparable<r4<V>> {

    /* renamed from: f, reason: collision with root package name */
    private final long f6377f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f6378g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6379h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ q4 f6380i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r4(q4 q4Var, Runnable runnable, boolean z10, String str) {
        super(pb.a().b(runnable), null);
        AtomicLong atomicLong;
        this.f6380i = q4Var;
        b2.p.k(str);
        atomicLong = q4.f6341l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f6377f = andIncrement;
        this.f6379h = str;
        this.f6378g = z10;
        if (andIncrement == Long.MAX_VALUE) {
            q4Var.h().F().a("Tasks index overflow");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r4(q4 q4Var, Callable<V> callable, boolean z10, String str) {
        super(pb.a().a(callable));
        AtomicLong atomicLong;
        this.f6380i = q4Var;
        b2.p.k(str);
        atomicLong = q4.f6341l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f6377f = andIncrement;
        this.f6379h = str;
        this.f6378g = z10;
        if (andIncrement == Long.MAX_VALUE) {
            q4Var.h().F().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        r4 r4Var = (r4) obj;
        boolean z10 = this.f6378g;
        if (z10 != r4Var.f6378g) {
            return z10 ? -1 : 1;
        }
        long j10 = this.f6377f;
        long j11 = r4Var.f6377f;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f6380i.h().G().b("Two tasks share the same index. index", Long.valueOf(this.f6377f));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f6380i.h().F().b(this.f6379h, th);
        super.setException(th);
    }
}
