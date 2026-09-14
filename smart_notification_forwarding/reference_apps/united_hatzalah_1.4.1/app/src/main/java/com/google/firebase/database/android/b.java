package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.TokenProvider;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements OnSuccessListener, OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4269a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f4270b;

    public /* synthetic */ b(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, int i) {
        this.f4269a = i;
        this.f4270b = getTokenCompletionListener;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.f4269a) {
            case 1:
                AndroidAppCheckTokenProvider.a(this.f4270b, exc);
                return;
            default:
                AndroidAuthTokenProvider.f(this.f4270b, exc);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f4269a) {
            case 0:
                AndroidAppCheckTokenProvider.c(this.f4270b, (AppCheckTokenResult) obj);
                return;
            default:
                AndroidAuthTokenProvider.a(this.f4270b, (GetTokenResult) obj);
                return;
        }
    }
}
