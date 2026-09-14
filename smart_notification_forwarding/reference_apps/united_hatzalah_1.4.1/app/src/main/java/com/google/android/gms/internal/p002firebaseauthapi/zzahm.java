package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzahm implements Parcelable.Creator<zzahn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahn createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Long l3 = null;
        String str3 = null;
        Long l4 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 2) {
                if (fieldId != 3) {
                    if (fieldId != 4) {
                        if (fieldId != 5) {
                            if (fieldId != 6) {
                                SafeParcelReader.skipUnknownField(parcel, readHeader);
                            } else {
                                l4 = SafeParcelReader.readLongObject(parcel, readHeader);
                            }
                        } else {
                            str3 = SafeParcelReader.createString(parcel, readHeader);
                        }
                    } else {
                        l3 = SafeParcelReader.readLongObject(parcel, readHeader);
                    }
                } else {
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzahn(str, str2, l3, str3, l4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahn[] newArray(int i) {
        return new zzahn[i];
    }
}
