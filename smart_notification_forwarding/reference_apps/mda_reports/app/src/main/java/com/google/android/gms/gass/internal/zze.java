package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbs;
import com.google.android.gms.internal.ads.zzdrg;
import com.google.android.gms.internal.ads.zzdse;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzh();

    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzbs.zza zzgtc = null;
    private byte[] zzgtd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzgtd = bArr;
        zzaqr();
    }

    private final void zzaqr() {
        if (this.zzgtc != null || this.zzgtd == null) {
            if (this.zzgtc == null || this.zzgtd != null) {
                if (this.zzgtc != null && this.zzgtd != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzgtc != null || this.zzgtd != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzgtd;
        if (bArr == null) {
            bArr = this.zzgtc.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzbs.zza zzaqq() {
        if (!(this.zzgtc != null)) {
            try {
                this.zzgtc = zzbs.zza.zza(this.zzgtd, zzdrg.zzazi());
                this.zzgtd = null;
            } catch (zzdse e) {
                throw new IllegalStateException(e);
            }
        }
        zzaqr();
        return this.zzgtc;
    }
}
