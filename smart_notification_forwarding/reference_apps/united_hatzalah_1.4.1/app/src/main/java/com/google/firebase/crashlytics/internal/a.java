package com.google.firebase.crashlytics.internal;

import A1.f;
import A1.l;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import t1.k;
import z1.g;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Deferred.DeferredHandler, OnSuccessListener, B1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4208a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4209b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4210c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4211d;

    public /* synthetic */ a(PersistentConnectionImpl persistentConnectionImpl, long j2, Task task, Task task2) {
        this.f4209b = persistentConnectionImpl;
        this.f4208a = j2;
        this.f4210c = task;
        this.f4211d = task2;
    }

    @Override // B1.a
    public Object a() {
        g gVar = (g) this.f4209b;
        Iterable iterable = (Iterable) this.f4210c;
        k kVar = (k) this.f4211d;
        l lVar = (l) gVar.f6859c;
        lVar.getClass();
        if (iterable.iterator().hasNext()) {
            lVar.c(new f(0, lVar, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + l.g(iterable)));
        }
        lVar.c(new A1.g(gVar.f6863g.d() + this.f4208a, kVar));
        return null;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy.lambda$prepareNativeSession$1((String) this.f4209b, (String) this.f4210c, this.f4208a, (StaticSessionData) this.f4211d, provider);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((PersistentConnectionImpl) this.f4209b).lambda$tryScheduleReconnect$1(this.f4208a, (Task) this.f4210c, (Task) this.f4211d, (Void) obj);
    }

    public /* synthetic */ a(String str, String str2, long j2, StaticSessionData staticSessionData) {
        this.f4209b = str;
        this.f4210c = str2;
        this.f4208a = j2;
        this.f4211d = staticSessionData;
    }

    public /* synthetic */ a(g gVar, Iterable iterable, k kVar, long j2) {
        this.f4209b = gVar;
        this.f4210c = iterable;
        this.f4211d = kVar;
        this.f4208a = j2;
    }
}
