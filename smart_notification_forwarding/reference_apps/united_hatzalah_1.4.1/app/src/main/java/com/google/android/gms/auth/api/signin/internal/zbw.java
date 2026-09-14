package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.content.e;
import com.google.android.gms.common.api.GoogleApiClient;
import f0.InterfaceC0372a;

/* loaded from: classes.dex */
final class zbw implements InterfaceC0372a {
    final /* synthetic */ SignInHubActivity zba;

    public /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.zba = signInHubActivity;
    }

    @Override // f0.InterfaceC0372a
    public final e onCreateLoader(int i, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    @Override // f0.InterfaceC0372a
    public final /* bridge */ /* synthetic */ void onLoadFinished(e eVar, Object obj) {
        SignInHubActivity signInHubActivity = this.zba;
        signInHubActivity.setResult(SignInHubActivity.zba(signInHubActivity), SignInHubActivity.zbb(signInHubActivity));
        this.zba.finish();
    }

    @Override // f0.InterfaceC0372a
    public final void onLoaderReset(e eVar) {
    }
}
