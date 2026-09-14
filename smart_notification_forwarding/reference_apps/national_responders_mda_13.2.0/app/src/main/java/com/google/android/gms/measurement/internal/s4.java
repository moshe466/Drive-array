package com.google.android.gms.measurement.internal;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final String f6447a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ q4 f6448b;

    public s4(q4 q4Var, String str) {
        this.f6448b = q4Var;
        b2.p.k(str);
        this.f6447a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f6448b.h().F().b(this.f6447a, th);
    }
}
