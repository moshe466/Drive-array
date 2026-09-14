package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai extends I1.u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f3913a;

    /* renamed from: b, reason: collision with root package name */
    private final I1.y f3914b;

    /* renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f3915c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        super("com.google.android.play.core.integrity.protocol.IIntegrityServiceCallback");
        this.f3913a = ajVar;
        this.f3914b = new I1.y("OnRequestIntegrityTokenCallback");
        this.f3915c = taskCompletionSource;
    }

    @Override // I1.v
    public final void b(Bundle bundle) {
        k kVar;
        String str;
        this.f3913a.f3916a.d(this.f3915c);
        this.f3914b.b("onRequestIntegrityToken", new Object[0]);
        kVar = this.f3913a.f3920e;
        ApiException a2 = kVar.a(bundle);
        if (a2 != null) {
            this.f3915c.trySetException(a2);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f3915c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        long j2 = bundle.getLong("request.token.sid");
        str = this.f3913a.f3918c;
        ah ahVar = new ah(this, str, j2);
        TaskCompletionSource taskCompletionSource = this.f3915c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
