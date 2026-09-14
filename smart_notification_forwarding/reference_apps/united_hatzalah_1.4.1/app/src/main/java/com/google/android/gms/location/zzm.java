package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        byte b4 = 0;
        long j2 = 0;
        float[] fArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 4:
                        f4 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 5:
                        f5 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 6:
                        j2 = SafeParcelReader.readLong(parcel, readHeader);
                        break;
                    case 7:
                        b4 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 8:
                        f6 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 9:
                        f7 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            } else {
                fArr = SafeParcelReader.createFloatArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DeviceOrientation(fArr, f4, f5, j2, b4, f6, f7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DeviceOrientation[i];
    }
}
