package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzvb<T> {

    @Nullable
    private static final zzwd zzcdp = zzor();

    private static zzwd zzor() {
        try {
            Object newInstance = zzup.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzayu.zzez("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return queryLocalInterface instanceof zzwd ? (zzwd) queryLocalInterface : new zzwf(iBinder);
        } catch (Exception unused) {
            zzayu.zzez("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzos() {
        zzwd zzwdVar = zzcdp;
        if (zzwdVar == null) {
            zzayu.zzez("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzwdVar);
        } catch (RemoteException e) {
            zzayu.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzot() {
        try {
            return zzoq();
        } catch (RemoteException e) {
            zzayu.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    @Nullable
    protected abstract T zza(zzwd zzwdVar);

    public final T zzd(Context context, boolean z) {
        T zzos;
        boolean z2 = z;
        if (!z2) {
            zzve.zzou();
            if (!zzayk.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzayu.zzea("Google Play Services is not available.");
                z2 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z2 = true;
        }
        zzzn.initialize(context);
        if (zzaay.zzctf.get().booleanValue()) {
            z2 = false;
        }
        if (z2) {
            zzos = zzos();
            if (zzos == null) {
                zzos = zzot();
            }
        } else {
            T zzot = zzot();
            int i = zzot == null ? 1 : 0;
            if (i != 0) {
                if (zzve.zzpb().nextInt(zzabi.zzcuj.get().intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzve.zzou().zza(context, zzve.zzpa().zzbma, "gmob-apps", bundle, true);
                }
            }
            zzos = zzot == null ? zzos() : zzot;
        }
        return zzos == null ? zzop() : zzos;
    }

    @NonNull
    protected abstract T zzop();

    @Nullable
    protected abstract T zzoq();
}
