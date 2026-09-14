package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* loaded from: classes.dex */
public final class zzjj extends zzjn implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzjj(int i) {
        if (i >= 0) {
            this.zzb = new ArrayDeque(i);
            this.zza = i;
            return;
        }
        throw new IllegalArgumentException(zzji.zza("maxSize (%s) must >= 0", Integer.valueOf(i)));
    }

    public static zzjj zza(int i) {
        return new zzjj(i);
    }

    @Override // com.google.android.recaptcha.internal.zzjl, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzjl, java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean z3;
        int size = collection.size();
        if (size >= this.zza) {
            clear();
            int i = size - this.zza;
            if (i >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzjf.zzb(z3, "number to skip cannot be negative");
            return zzjq.zza(this, new zzjp(collection, i).iterator());
        }
        return zzjq.zza(this, collection.iterator());
    }

    @Override // com.google.android.recaptcha.internal.zzjn, java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzjl, com.google.android.recaptcha.internal.zzjm
    public final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzjn, com.google.android.recaptcha.internal.zzjl
    public final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzjn
    public final Queue zzd() {
        return this.zzb;
    }
}
