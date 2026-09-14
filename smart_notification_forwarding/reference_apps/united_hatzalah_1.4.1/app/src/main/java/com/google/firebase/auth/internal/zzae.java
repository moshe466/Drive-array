package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.remoteconfig.internal.Code;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzae implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzahn zzahnVar = null;
        zzab zzabVar = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Boolean bool = null;
        zzah zzahVar = null;
        com.google.firebase.auth.zzc zzcVar = null;
        zzbj zzbjVar = null;
        ArrayList arrayList3 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzahnVar = (zzahn) SafeParcelReader.createParcelable(parcel, readHeader, zzahn.CREATOR);
                    break;
                case 2:
                    zzabVar = (zzab) SafeParcelReader.createParcelable(parcel, readHeader, zzab.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzab.CREATOR);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    bool = SafeParcelReader.readBooleanObject(parcel, readHeader);
                    break;
                case 9:
                    zzahVar = (zzah) SafeParcelReader.createParcelable(parcel, readHeader, zzah.CREATOR);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    zzcVar = (com.google.firebase.auth.zzc) SafeParcelReader.createParcelable(parcel, readHeader, com.google.firebase.auth.zzc.CREATOR);
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    zzbjVar = (zzbj) SafeParcelReader.createParcelable(parcel, readHeader, zzbj.CREATOR);
                    break;
                case 13:
                    arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, com.google.firebase.auth.zzal.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaf(zzahnVar, zzabVar, str, str2, arrayList, arrayList2, str3, bool, zzahVar, z3, zzcVar, zzbjVar, arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}
