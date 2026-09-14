package com.google.firebase;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatInfoStorage;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4159a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f4160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4161c;

    public /* synthetic */ a(Context context, String str) {
        this.f4160b = context;
        this.f4161c = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        HeartBeatInfoStorage lambda$new$2;
        switch (this.f4159a) {
            case 0:
                return FirebaseApp.b((FirebaseApp) this.f4161c, this.f4160b);
            default:
                lambda$new$2 = DefaultHeartBeatController.lambda$new$2(this.f4160b, (String) this.f4161c);
                return lambda$new$2;
        }
    }

    public /* synthetic */ a(FirebaseApp firebaseApp, Context context) {
        this.f4161c = firebaseApp;
        this.f4160b = context;
    }
}
