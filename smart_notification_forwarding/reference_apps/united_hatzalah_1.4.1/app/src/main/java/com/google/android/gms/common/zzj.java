package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzj extends com.google.android.gms.common.internal.zzw {
    private final int zza;

    public zzj(byte[] bArr) {
        boolean z3;
        if (bArr.length == 25) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.zza = Arrays.hashCode(bArr);
    }

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (!(obj instanceof com.google.android.gms.common.internal.zzx)) {
            return false;
        }
        try {
            com.google.android.gms.common.internal.zzx zzxVar = (com.google.android.gms.common.internal.zzx) obj;
            if (zzxVar.zze() != this.zza || (zzd = zzxVar.zzd()) == null) {
                return false;
            }
            return Arrays.equals(zzc(), (byte[]) ObjectWrapper.unwrap(zzd));
        } catch (RemoteException e4) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
            return false;
        }
    }

    public final int hashCode() {
        return this.zza;
    }

    public abstract byte[] zzc();

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzc());
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() {
        return this.zza;
    }
}
