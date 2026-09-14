package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzar implements Parcelable.Creator<PlayGamesAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayGamesAuthCredential createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PlayGamesAuthCredential(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayGamesAuthCredential[] newArray(int i) {
        return new PlayGamesAuthCredential[i];
    }
}
