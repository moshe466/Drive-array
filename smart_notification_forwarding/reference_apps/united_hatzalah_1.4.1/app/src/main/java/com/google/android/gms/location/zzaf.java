package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.remoteconfig.internal.Code;

/* loaded from: classes.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.gms.internal.location.zze zzeVar = null;
        boolean z3 = false;
        int i = 0;
        int i3 = 0;
        boolean z4 = false;
        long j2 = -1;
        float f4 = 0.0f;
        int i4 = Integer.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        long j6 = 600000;
        long j7 = 3600000;
        int i5 = 102;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                case 14:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 5:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 11:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, readHeader, WorkSource.CREATOR);
                    break;
                case 17:
                    zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.internal.location.zze.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationRequest(i5, j7, j6, j5, j3, j4, i4, f4, z3, j2, i, i3, z4, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
