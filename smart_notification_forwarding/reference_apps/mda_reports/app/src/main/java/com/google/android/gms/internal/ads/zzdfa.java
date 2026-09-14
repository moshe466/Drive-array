package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class zzdfa<E> extends zzdes<E> {
    private int zzafx;

    @NullableDecl
    private Object[] zzgup;

    public zzdfa() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfa(int i) {
        super(i);
        this.zzgup = new Object[zzdfb.a(i)];
    }

    @Override // com.google.android.gms.internal.ads.zzdev
    public final /* synthetic */ zzdev zza(Iterator it) {
        zzdei.checkNotNull(it);
        while (it.hasNext()) {
            zzae(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdes
    /* renamed from: zzad */
    public final /* synthetic */ zzdes zzae(Object obj) {
        return (zzdfa) zzae(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdes, com.google.android.gms.internal.ads.zzdev
    public final /* synthetic */ zzdev zzae(Object obj) {
        zzdei.checkNotNull(obj);
        if (this.zzgup != null) {
            int a = zzdfb.a(this.b);
            Object[] objArr = this.zzgup;
            if (a <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int a2 = zzdeq.a(hashCode);
                while (true) {
                    int i = a2 & length;
                    Object[] objArr2 = this.zzgup;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        a2 = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzafx += hashCode;
                        super.zzae(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzgup = null;
        super.zzae(obj);
        return this;
    }

    public final zzdfb<E> zzarh() {
        zzdfb<E> zza;
        boolean zzv;
        int i = this.b;
        if (i == 0) {
            return zzdfk.a;
        }
        if (i == 1) {
            return zzdfb.zzag(this.a[0]);
        }
        if (this.zzgup == null || zzdfb.a(i) != this.zzgup.length) {
            zza = zzdfb.zza(this.b, this.a);
            this.b = zza.size();
        } else {
            zzv = zzdfb.zzv(this.b, this.a.length);
            Object[] copyOf = zzv ? Arrays.copyOf(this.a, this.b) : this.a;
            zza = new zzdfk<>(copyOf, this.zzafx, this.zzgup, r5.length - 1, this.b);
        }
        this.c = true;
        this.zzgup = null;
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdes, com.google.android.gms.internal.ads.zzdev
    public final /* synthetic */ zzdev zze(Iterable iterable) {
        zzdei.checkNotNull(iterable);
        if (this.zzgup != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzae(it.next());
            }
        } else {
            super.zze(iterable);
        }
        return this;
    }
}
