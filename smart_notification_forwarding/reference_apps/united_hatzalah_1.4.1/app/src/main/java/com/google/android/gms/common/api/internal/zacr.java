package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zacr<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final WeakReference zag;
    private final zacq zah;
    private ResultTransform zaa = null;
    private zacr zab = null;
    private volatile ResultCallbacks zac = null;
    private PendingResult zad = null;
    private final Object zae = new Object();
    private Status zaf = null;
    private boolean zai = false;

    public zacr(WeakReference weakReference) {
        Looper mainLooper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        if (googleApiClient != null) {
            mainLooper = googleApiClient.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.zah = new zacq(this, mainLooper);
    }

    private final void zaj() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
            if (!this.zai && this.zaa != null && googleApiClient != null) {
                googleApiClient.zao(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zal(status);
                return;
            }
            PendingResult pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zak, reason: merged with bridge method [inline-methods] */
    public final void zac(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    private final void zal(Status status) {
        synchronized (this.zae) {
            try {
                ResultTransform resultTransform = this.zaa;
                if (resultTransform != null) {
                    ((zacr) Preconditions.checkNotNull(this.zab)).zac((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
                } else if (zam()) {
                    ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean zam() {
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
        if (this.zac != null && googleApiClient != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(result));
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        boolean z3;
        synchronized (this.zae) {
            boolean z4 = false;
            if (this.zac == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannot call andFinally() twice.");
            if (this.zaa == null) {
                z4 = true;
            }
            Preconditions.checkState(z4, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zaj();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        synchronized (this.zae) {
            try {
                if (result.getStatus().isSuccess()) {
                    if (this.zaa != null) {
                        zacg.zaa().submit(new zacp(this, result));
                    } else if (zam()) {
                        ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(result);
                    }
                } else {
                    zac(result.getStatus());
                    zan(result);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z3;
        zacr zacrVar;
        synchronized (this.zae) {
            boolean z4 = false;
            if (this.zaa == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannot call then() twice.");
            if (this.zac == null) {
                z4 = true;
            }
            Preconditions.checkState(z4, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zacrVar = new zacr(this.zag);
            this.zab = zacrVar;
            zaj();
        }
        return zacrVar;
    }

    public final void zaa(PendingResult pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zaj();
        }
    }

    public final void zab() {
        this.zac = null;
    }

    public final /* synthetic */ ResultTransform zad() {
        return this.zaa;
    }

    public final /* synthetic */ zacr zae() {
        return this.zab;
    }

    public final /* synthetic */ Object zaf() {
        return this.zae;
    }

    public final /* synthetic */ WeakReference zag() {
        return this.zag;
    }

    public final /* synthetic */ zacq zah() {
        return this.zah;
    }
}
