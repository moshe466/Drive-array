package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzli extends zzll {
    public static final Parcelable.Creator<zzli> CREATOR = new zzlh();
    private final String description;
    private final String mimeType;
    private final int zzazq;
    private final byte[] zzazr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzli(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzazq = parcel.readInt();
        this.zzazr = parcel.createByteArray();
    }

    public zzli(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzazq = 3;
        this.zzazr = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzli.class == obj.getClass()) {
            zzli zzliVar = (zzli) obj;
            if (this.zzazq == zzliVar.zzazq && zzoq.zza(this.mimeType, zzliVar.mimeType) && zzoq.zza(this.description, zzliVar.description) && Arrays.equals(this.zzazr, zzliVar.zzazr)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.zzazq + 527) * 31;
        String str = this.mimeType;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzazr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzazq);
        parcel.writeByteArray(this.zzazr);
    }
}
