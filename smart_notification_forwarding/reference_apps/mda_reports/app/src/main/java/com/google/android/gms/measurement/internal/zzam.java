package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new zzao();

    @SafeParcelable.Field(getter = "z", id = 2)
    private final Bundle zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzam(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long a(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double b(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c(String str) {
        return this.zza.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzal(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zza(String str) {
        return this.zza.get(str);
    }

    public final Bundle zzb() {
        return new Bundle(this.zza);
    }
}
