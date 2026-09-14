package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference<zam> c;
    protected final GoogleApiAvailability d;
    private final Handler zadg;

    /* JADX INFO: Access modifiers changed from: protected */
    public zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.c = new AtomicReference<>(null);
        this.zadg = new com.google.android.gms.internal.base.zap(Looper.getMainLooper());
        this.d = googleApiAvailability;
    }

    private static int zaa(@Nullable zam zamVar) {
        if (zamVar == null) {
            return -1;
        }
        return zamVar.b();
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.c.set(null);
        a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onActivityResult(int i, int i2, Intent intent) {
        zam zamVar = this.c.get();
        if (i != 1) {
            if (i == 2) {
                int isGooglePlayServicesAvailable = this.d.isGooglePlayServicesAvailable(getActivity());
                r1 = isGooglePlayServicesAvailable == 0;
                if (zamVar == null) {
                    return;
                }
                if (zamVar.a().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i2 != -1) {
            if (i2 == 0) {
                zam zamVar2 = new zam(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), zaa(zamVar));
                this.c.set(zamVar2);
                zamVar = zamVar2;
            }
            r1 = false;
        }
        if (r1) {
            b();
        } else if (zamVar != null) {
            a(zamVar.a(), zamVar.b());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), zaa(this.c.get()));
        b();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zamVar = this.c.get();
        if (zamVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zamVar.b());
            bundle.putInt("failed_status", zamVar.a().getErrorCode());
            bundle.putParcelable("failed_resolution", zamVar.a().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.b = false;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        zam zamVar = new zam(connectionResult, i);
        if (this.c.compareAndSet(null, zamVar)) {
            this.zadg.post(new zan(this, zamVar));
        }
    }
}
