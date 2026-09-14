package com.google.firebase.database.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.core.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4284a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4285b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4286c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f4284a = i;
        this.f4285b = obj;
        this.f4286c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4284a) {
            case 0:
                Context.AnonymousClass1.b((ConnectionTokenProvider.GetTokenCallback) this.f4285b, (String) this.f4286c);
                return;
            case 1:
                Context.AnonymousClass1.a((ConnectionTokenProvider.GetTokenCallback) this.f4285b, (String) this.f4286c);
                return;
            default:
                ((TaskCompletionSource) this.f4285b).trySetResult((DataSnapshot) this.f4286c);
                return;
        }
    }
}
