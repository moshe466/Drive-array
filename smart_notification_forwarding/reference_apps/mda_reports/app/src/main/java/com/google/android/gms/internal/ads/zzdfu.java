package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzdfu<I, O, F, T> extends zzdgm<O> implements Runnable {

    @NullableDecl
    private zzdhe<? extends I> zzgvg;

    @NullableDecl
    private F zzgvx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfu(zzdhe<? extends I> zzdheVar, F f) {
        this.zzgvg = (zzdhe) zzdei.checkNotNull(zzdheVar);
        this.zzgvx = (F) zzdei.checkNotNull(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzdhe<O> a(zzdhe<I> zzdheVar, zzded<? super I, ? extends O> zzdedVar, Executor executor) {
        zzdei.checkNotNull(zzdedVar);
        zzdfw zzdfwVar = new zzdfw(zzdheVar, zzdedVar);
        zzdheVar.addListener(zzdfwVar, zzdhg.a(executor, zzdfwVar));
        return zzdfwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzdhe<O> a(zzdhe<I> zzdheVar, zzdgf<? super I, ? extends O> zzdgfVar, Executor executor) {
        zzdei.checkNotNull(executor);
        zzdfx zzdfxVar = new zzdfx(zzdheVar, zzdgfVar);
        zzdheVar.addListener(zzdfxVar, zzdhg.a(executor, zzdfxVar));
        return zzdfxVar;
    }

    @NullableDecl
    abstract T a(F f, @NullableDecl I i);

    abstract void a(@NullableDecl T t);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final void b() {
        a((Future<?>) this.zzgvg);
        this.zzgvg = null;
        this.zzgvx = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String d() {
        String str;
        zzdhe<? extends I> zzdheVar = this.zzgvg;
        F f = this.zzgvx;
        String d = super.d();
        if (zzdheVar != null) {
            String valueOf = String.valueOf(zzdheVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f == null) {
            if (d == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(d);
            return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
        }
        String valueOf4 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf4).length());
        sb2.append(str);
        sb2.append("function=[");
        sb2.append(valueOf4);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdhe<? extends I> zzdheVar = this.zzgvg;
        F f = this.zzgvx;
        if ((isCancelled() | (zzdheVar == null)) || (f == null)) {
            return;
        }
        this.zzgvg = null;
        if (zzdheVar.isCancelled()) {
            a((zzdhe) zzdheVar);
            return;
        }
        try {
            try {
                Object a = a((zzdfu<I, O, F, T>) f, (F) zzdgs.zzb(zzdheVar));
                this.zzgvx = null;
                a((zzdfu<I, O, F, T>) a);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.zzgvx = null;
                }
            }
        } catch (Error e) {
            setException(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            setException(e2);
        } catch (ExecutionException e3) {
            setException(e3.getCause());
        }
    }
}
