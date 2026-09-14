package com.google.android.gms.common.api.internal;

import F0.AbstractC0008a;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public final class zak extends zap {
    private final SparseArray zad;

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.zad = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zakVar != null) {
            return zakVar;
        }
        return new zak(fragment);
    }

    private final zaj zai(int i) {
        SparseArray sparseArray = this.zad;
        if (sparseArray.size() <= i) {
            return null;
        }
        return (zaj) sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        SparseArray sparseArray = this.zad;
        boolean z3 = this.zaa;
        String valueOf = String.valueOf(sparseArray);
        new StringBuilder(String.valueOf(z3).length() + 9 + valueOf.length());
        if (this.zab.get() == null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                zaj zai = zai(i);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }

    public final void zab(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z3;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        SparseArray sparseArray = this.zad;
        int indexOfKey = sparseArray.indexOfKey(i);
        String t3 = AbstractC0008a.t(new StringBuilder(String.valueOf(i).length() + 43), "Already managing a GoogleApiClient with id ", i);
        if (indexOfKey < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, t3);
        zam zamVar = (zam) this.zab.get();
        boolean z4 = this.zaa;
        String valueOf = String.valueOf(zamVar);
        new StringBuilder(String.valueOf(i).length() + 32 + String.valueOf(z4).length() + 1 + valueOf.length());
        zaj zajVar = new zaj(this, i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zajVar);
        sparseArray.put(i, zajVar);
        if (this.zaa && zamVar == null) {
            "connecting ".concat(googleApiClient.toString());
            googleApiClient.connect();
        }
    }

    public final void zac(int i) {
        SparseArray sparseArray = this.zad;
        zaj zajVar = (zaj) sparseArray.get(i);
        sparseArray.remove(i);
        if (zajVar != null) {
            GoogleApiClient googleApiClient = zajVar.zab;
            googleApiClient.unregisterConnectionFailedListener(zajVar);
            googleApiClient.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zad(ConnectionResult connectionResult, int i) {
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zajVar = (zaj) this.zad.get(i);
        if (zajVar != null) {
            zac(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zajVar.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zae() {
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }
}
