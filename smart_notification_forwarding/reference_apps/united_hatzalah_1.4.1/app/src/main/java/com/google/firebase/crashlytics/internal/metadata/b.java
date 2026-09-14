package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4244a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4245b;

    public /* synthetic */ b(Object obj, int i) {
        this.f4244a = i;
        this.f4245b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4244a) {
            case 0:
                UserMetadata.SerializeableKeysMap.a((UserMetadata.SerializeableKeysMap) this.f4245b);
                return;
            default:
                UserMetadata.a((UserMetadata) this.f4245b);
                return;
        }
    }
}
