package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import e0.a;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i;
        int readHeader;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        zzw zzwVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        loop0: while (true) {
            i = i3;
            while (parcel.dataPosition() < validateObjectHeader) {
                readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId != 1) {
                    if (fieldId != 2) {
                        if (fieldId != 3) {
                            if (fieldId != 4) {
                                if (fieldId != 5) {
                                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                                } else {
                                    String createString = SafeParcelReader.createString(parcel, readHeader);
                                    hashSet.add(5);
                                    str3 = createString;
                                }
                            } else {
                                String createString2 = SafeParcelReader.createString(parcel, readHeader);
                                hashSet.add(4);
                                str2 = createString2;
                            }
                        } else {
                            String createString3 = SafeParcelReader.createString(parcel, readHeader);
                            hashSet.add(3);
                            str = createString3;
                        }
                    } else {
                        zzw zzwVar2 = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                        hashSet.add(2);
                        zzwVar = zzwVar2;
                    }
                }
            }
            i3 = SafeParcelReader.readInt(parcel, readHeader);
            hashSet.add(1);
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzu(hashSet, i, zzwVar, str, str2, str3);
        }
        throw new SafeParcelReader.ParseException(a.c(validateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
