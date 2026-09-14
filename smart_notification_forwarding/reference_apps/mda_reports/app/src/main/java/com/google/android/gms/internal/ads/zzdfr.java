package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzdfr<V, X extends Throwable, F, T> extends zzdgm<V> implements Runnable {

    @NullableDecl
    private zzdhe<? extends V> zzgvg;

    @NullableDecl
    private Class<X> zzgvh;

    @NullableDecl
    private F zzgvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfr(zzdhe<? extends V> zzdheVar, Class<X> cls, F f) {
        this.zzgvg = (zzdhe) zzdei.checkNotNull(zzdheVar);
        this.zzgvh = (Class) zzdei.checkNotNull(cls);
        this.zzgvi = (F) zzdei.checkNotNull(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends Throwable, V> zzdhe<V> a(zzdhe<? extends V> zzdheVar, Class<X> cls, zzdgf<? super X, ? extends V> zzdgfVar, Executor executor) {
        zzdfq zzdfqVar = new zzdfq(zzdheVar, cls, zzdgfVar);
        zzdheVar.addListener(zzdfqVar, zzdhg.a(executor, zzdfqVar));
        return zzdfqVar;
    }

    @NullableDecl
    abstract T a(F f, X x);

    abstract void a(@NullableDecl T t);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final void b() {
        a((Future<?>) this.zzgvg);
        this.zzgvg = null;
        this.zzgvh = null;
        this.zzgvi = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String d() {
        String str;
        zzdhe<? extends V> zzdheVar = this.zzgvg;
        Class<X> cls = this.zzgvh;
        F f = this.zzgvi;
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
        if (cls == null || f == null) {
            if (d == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(d);
            return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
        }
        String valueOf4 = String.valueOf(cls);
        String valueOf5 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb2.append(str);
        sb2.append("exceptionType=[");
        sb2.append(valueOf4);
        sb2.append("], fallback=[");
        sb2.append(valueOf5);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzdhe<? extends V> r0 = r7.zzgvg
            java.lang.Class<X extends java.lang.Throwable> r1 = r7.zzgvh
            F r2 = r7.zzgvi
            r3 = 1
            r4 = 0
            if (r0 != 0) goto Lc
            r5 = 1
            goto Ld
        Lc:
            r5 = 0
        Ld:
            if (r1 != 0) goto L11
            r6 = 1
            goto L12
        L11:
            r6 = 0
        L12:
            r5 = r5 | r6
            if (r2 != 0) goto L16
            goto L17
        L16:
            r3 = 0
        L17:
            r3 = r3 | r5
            boolean r4 = r7.isCancelled()
            r3 = r3 | r4
            if (r3 == 0) goto L20
            return
        L20:
            r3 = 0
            r7.zzgvg = r3
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzdgs.zzb(r0)     // Catch: java.lang.Throwable -> L2a java.util.concurrent.ExecutionException -> L2c
            r5 = r4
            r4 = r3
            goto L38
        L2a:
            r4 = move-exception
            goto L37
        L2c:
            r4 = move-exception
            java.lang.Throwable r4 = r4.getCause()
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzdei.checkNotNull(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L37:
            r5 = r3
        L38:
            if (r4 != 0) goto L3e
            r7.set(r5)
            return
        L3e:
            boolean r1 = r1.isInstance(r4)
            if (r1 != 0) goto L48
            r7.a(r0)
            return
        L48:
            java.lang.Object r0 = r7.a(r2, r4)     // Catch: java.lang.Throwable -> L54
            r7.zzgvh = r3
            r7.zzgvi = r3
            r7.a(r0)
            return
        L54:
            r0 = move-exception
            r7.setException(r0)     // Catch: java.lang.Throwable -> L5d
            r7.zzgvh = r3
            r7.zzgvi = r3
            return
        L5d:
            r0 = move-exception
            r7.zzgvh = r3
            r7.zzgvi = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfr.run():void");
    }
}
