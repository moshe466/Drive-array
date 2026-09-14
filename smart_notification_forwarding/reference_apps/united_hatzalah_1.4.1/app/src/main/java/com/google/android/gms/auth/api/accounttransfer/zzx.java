package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import e0.a;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzx implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        byte[] bArr = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    int readInt = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(1);
                    i3 = readInt;
                    break;
                case 2:
                    String createString = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(2);
                    str = createString;
                    break;
                case 3:
                    int readInt2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(3);
                    i = readInt2;
                    break;
                case 4:
                    byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                    hashSet.add(4);
                    bArr = createByteArray;
                    break;
                case 5:
                    PendingIntent pendingIntent2 = (PendingIntent) SafeParcelReader.createParcelable(parcel, readHeader, PendingIntent.CREATOR);
                    hashSet.add(5);
                    pendingIntent = pendingIntent2;
                    break;
                case 6:
                    DeviceMetaData deviceMetaData2 = (DeviceMetaData) SafeParcelReader.createParcelable(parcel, readHeader, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    deviceMetaData = deviceMetaData2;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzw(hashSet, i3, str, i, bArr, pendingIntent, deviceMetaData);
        }
        throw new SafeParcelReader.ParseException(a.c(validateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzw[i];
    }
}
