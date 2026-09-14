package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import e0.a;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzs zzsVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                        } else {
                            zzs zzsVar2 = (zzs) SafeParcelReader.createParcelable(parcel, readHeader, zzs.CREATOR);
                            hashSet.add(4);
                            zzsVar = zzsVar2;
                        }
                    } else {
                        int readInt = SafeParcelReader.readInt(parcel, readHeader);
                        hashSet.add(3);
                        i = readInt;
                    }
                } else {
                    ArrayList createTypedList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                    hashSet.add(2);
                    arrayList = createTypedList;
                }
            } else {
                int readInt2 = SafeParcelReader.readInt(parcel, readHeader);
                hashSet.add(1);
                i3 = readInt2;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzo(hashSet, i3, arrayList, i, zzsVar);
        }
        throw new SafeParcelReader.ParseException(a.c(validateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
