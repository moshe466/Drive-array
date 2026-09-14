package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.remoteconfig.internal.Code;

/* loaded from: classes.dex */
public final class zzais implements Parcelable.Creator<zzait> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    str10 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    str11 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 15:
                    str12 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 16:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 17:
                    str13 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzait(str, str2, str3, str4, str5, str6, str7, str8, z3, z4, str9, str10, str11, str12, z5, str13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait[] newArray(int i) {
        return new zzait[i];
    }
}
