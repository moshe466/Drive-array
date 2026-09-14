package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();
    static final Scope[] zza = new Scope[0];
    static final Feature[] zzb = new Feature[0];
    final int zzc;
    final int zzd;
    final int zze;
    String zzf;
    IBinder zzg;
    Scope[] zzh;
    Bundle zzi;
    Account zzj;
    Feature[] zzk;
    Feature[] zzl;
    final boolean zzm;
    final int zzn;
    boolean zzo;
    private final String zzp;

    public GetServiceRequest(int i, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z3, int i5, boolean z4, String str2) {
        Account account2;
        scopeArr = scopeArr == null ? zza : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? zzb : featureArr;
        featureArr2 = featureArr2 == null ? zzb : featureArr2;
        this.zzc = i;
        this.zzd = i3;
        this.zze = i4;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (i < 2) {
            if (iBinder != null) {
                account2 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
            } else {
                account2 = null;
            }
            this.zzj = account2;
        } else {
            this.zzg = iBinder;
            this.zzj = account;
        }
        this.zzh = scopeArr;
        this.zzi = bundle;
        this.zzk = featureArr;
        this.zzl = featureArr2;
        this.zzm = z3;
        this.zzn = i5;
        this.zzo = z4;
        this.zzp = str2;
    }

    public String getAttributionTag() {
        return this.zzp;
    }

    public String getCallingPackage() {
        return this.zzf;
    }

    public Feature[] getClientApiFeatures() {
        return this.zzl;
    }

    public int getClientLibraryVersion() {
        return this.zze;
    }

    public Bundle getExtraArgs() {
        return this.zzi;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
