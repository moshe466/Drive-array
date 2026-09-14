package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference zab;
    protected final GoogleApiAvailability zac;
    private final Handler zad;

    public zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zab = new AtomicReference(null);
        this.zad = new com.google.android.gms.internal.base.zar(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaa, reason: merged with bridge method [inline-methods] */
    public final void zag() {
        this.zab.set(null);
        zae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zab, reason: merged with bridge method [inline-methods] */
    public final void zah(ConnectionResult connectionResult, int i) {
        this.zab.set(null);
        zad(connectionResult, i);
    }

    private static final int zac(zam zamVar) {
        if (zamVar == null) {
            return -1;
        }
        return zamVar.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i3, Intent intent) {
        zam zamVar = (zam) this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    zag();
                    return;
                } else if (zamVar != null) {
                    if (zamVar.zab().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            if (i3 == -1) {
                zag();
                return;
            }
            if (i3 == 0) {
                if (zamVar != null) {
                    int i4 = 13;
                    if (intent != null) {
                        i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                    }
                    zah(new ConnectionResult(i4, null, zamVar.zab().toString()), zac(zamVar));
                    return;
                }
                return;
            }
        }
        if (zamVar != null) {
            zah(zamVar.zab(), zamVar.zaa());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        zah(new ConnectionResult(13, null), zac((zam) this.zab.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        zam zamVar;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.zab;
            if (bundle.getBoolean("resolving_error", false)) {
                zamVar = new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                zamVar = null;
            }
            atomicReference.set(zamVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zamVar = (zam) this.zab.get();
        if (zamVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", zamVar.zaa());
        bundle.putInt("failed_status", zamVar.zab().getErrorCode());
        bundle.putParcelable("failed_resolution", zamVar.zab().getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    public abstract void zad(ConnectionResult connectionResult, int i);

    public abstract void zae();

    public final void zaf(ConnectionResult connectionResult, int i) {
        zam zamVar = new zam(connectionResult, i);
        AtomicReference atomicReference = this.zab;
        while (!atomicReference.compareAndSet(null, zamVar)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.zad.post(new zao(this, zamVar));
    }
}
