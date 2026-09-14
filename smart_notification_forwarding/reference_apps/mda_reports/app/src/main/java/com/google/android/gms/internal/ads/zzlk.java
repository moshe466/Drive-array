package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class zzlk extends zzll {
    public static final Parcelable.Creator<zzlk> CREATOR = new zzlj();
    public final String description;
    public final String text;
    private final String zzafv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(Parcel parcel) {
        super("COMM");
        this.zzafv = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public zzlk(String str, String str2, String str3) {
        super("COMM");
        this.zzafv = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlk.class == obj.getClass()) {
            zzlk zzlkVar = (zzlk) obj;
            if (zzoq.zza(this.description, zzlkVar.description) && zzoq.zza(this.zzafv, zzlkVar.zzafv) && zzoq.zza(this.text, zzlkVar.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzafv;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaez);
        parcel.writeString(this.zzafv);
        parcel.writeString(this.text);
    }
}
