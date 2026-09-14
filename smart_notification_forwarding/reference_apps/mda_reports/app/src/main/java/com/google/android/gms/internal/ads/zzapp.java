package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzapp implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzapn zzdil;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdim;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapp(zzapn zzapnVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdil = zzapnVar;
        this.zzdim = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzdil.a(thread, th);
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdim;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        } catch (Throwable unused) {
            zzayu.zzex("AdMob exception reporter failed reporting the exception.");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdim;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        }
    }
}
