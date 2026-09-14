package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    private final byte[][] zza;

    public zzai(byte[][] bArr) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (bArr != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (1 != ((bArr.length & 1) ^ 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        Preconditions.checkArgument(z4);
        for (int i = 0; i < bArr.length; i += 2) {
            if (i == 0 || bArr[i] != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            int i3 = i + 1;
            if (bArr[i3] != null) {
                z6 = true;
            } else {
                z6 = false;
            }
            Preconditions.checkArgument(z6);
            int length = bArr[i3].length;
            if (length == 32 || length == 64) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkArgument(z7);
        }
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
    }

    public final int hashCode() {
        int i = 0;
        for (byte[] bArr : this.zza) {
            i ^= Objects.hashCode(bArr);
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
