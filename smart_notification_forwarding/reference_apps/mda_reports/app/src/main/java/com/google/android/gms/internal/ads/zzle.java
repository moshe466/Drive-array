package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class zzle implements Parcelable {
    public static final Parcelable.Creator<zzle> CREATOR = new zzlg();
    private final zza[] zzazn;

    /* loaded from: classes.dex */
    public interface zza extends Parcelable {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzle(Parcel parcel) {
        this.zzazn = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaVarArr = this.zzazn;
            if (i >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i++;
        }
    }

    public zzle(List<? extends zza> list) {
        this.zzazn = new zza[list.size()];
        list.toArray(this.zzazn);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzle.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzazn, ((zzle) obj).zzazn);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzazn);
    }

    public final int length() {
        return this.zzazn.length;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzazn.length);
        for (zza zzaVar : this.zzazn) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }

    public final zza zzas(int i) {
        return this.zzazn[i];
    }
}
