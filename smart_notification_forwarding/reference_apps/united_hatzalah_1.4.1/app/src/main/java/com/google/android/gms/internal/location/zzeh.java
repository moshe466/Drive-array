package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import com.google.firebase.remoteconfig.internal.Code;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzeh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j2 = Long.MAX_VALUE;
        LocationRequest locationRequest = null;
        ArrayList arrayList = null;
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 5) {
                    if (fieldId != 8) {
                        if (fieldId != 9) {
                            switch (fieldId) {
                                case 11:
                                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                                    break;
                                case Code.UNIMPLEMENTED /* 12 */:
                                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                                    break;
                                case 13:
                                    str = SafeParcelReader.createString(parcel, readHeader);
                                    break;
                                case 14:
                                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                                    break;
                                default:
                                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                                    break;
                            }
                        } else {
                            z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                        }
                    } else {
                        z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    }
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, ClientIdentity.CREATOR);
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readHeader, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzeg(locationRequest, arrayList, z3, z4, z5, z6, str, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzeg[i];
    }
}
