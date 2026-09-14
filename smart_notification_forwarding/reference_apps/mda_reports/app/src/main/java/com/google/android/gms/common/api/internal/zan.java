package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zan implements Runnable {
    final /* synthetic */ zal a;
    private final zam zadj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(zal zalVar, zam zamVar) {
        this.a = zalVar;
        this.zadj = zamVar;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.a.b) {
            ConnectionResult a = this.zadj.a();
            if (a.hasResolution()) {
                zal zalVar = this.a;
                zalVar.a.startActivityForResult(GoogleApiActivity.zaa(zalVar.getActivity(), a.getResolution(), this.zadj.b(), false), 1);
            } else if (this.a.d.isUserResolvableError(a.getErrorCode())) {
                zal zalVar2 = this.a;
                zalVar2.d.zaa(zalVar2.getActivity(), this.a.a, a.getErrorCode(), 2, this.a);
            } else {
                if (a.getErrorCode() != 18) {
                    this.a.a(a, this.zadj.b());
                    return;
                }
                Dialog zaa = GoogleApiAvailability.zaa(this.a.getActivity(), this.a);
                zal zalVar3 = this.a;
                zalVar3.d.zaa(zalVar3.getActivity().getApplicationContext(), new zao(this, zaa));
            }
        }
    }
}
