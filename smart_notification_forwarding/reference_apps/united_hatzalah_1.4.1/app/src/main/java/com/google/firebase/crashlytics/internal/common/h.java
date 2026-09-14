package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.concurrent.Callable;
import org.apache.tika.pipes.async.AsyncProcessor;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4230a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4231b;

    public /* synthetic */ h(Object obj, int i) {
        this.f4230a = i;
        this.f4231b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Boolean lambda$checkForPreviousCrash$10;
        Void deleteFirebaseInstallationId;
        switch (this.f4230a) {
            case 0:
                lambda$checkForPreviousCrash$10 = ((CrashlyticsCore) this.f4231b).lambda$checkForPreviousCrash$10();
                return lambda$checkForPreviousCrash$10;
            case 1:
                deleteFirebaseInstallationId = ((FirebaseInstallations) this.f4231b).deleteFirebaseInstallationId();
                return deleteFirebaseInstallationId;
            case 2:
                return ((RemoteConfigComponent) this.f4231b).getDefault();
            case 3:
                return ((ConfigStorageClient) this.f4231b).read();
            default:
                return AsyncProcessor.b((AsyncProcessor) this.f4231b);
        }
    }
}
