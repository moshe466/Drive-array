package com.google.firebase.database;

import R2.p;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4273a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f4274b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f4275c;

    public /* synthetic */ b(p pVar, DataSnapshot dataSnapshot, int i) {
        this.f4273a = i;
        this.f4274b = pVar;
        this.f4275c = dataSnapshot;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4273a) {
            case 0:
                DatabaseKt$childEvents$1$listener$1.b(this.f4274b, this.f4275c);
                return;
            case 1:
                DatabaseKt$snapshots$1$listener$1.a(this.f4274b, this.f4275c);
                return;
            case 2:
                com.google.firebase.database.ktx.DatabaseKt$childEvents$1$listener$1.a(this.f4274b, this.f4275c);
                return;
            default:
                com.google.firebase.database.ktx.DatabaseKt$snapshots$1$listener$1.a(this.f4274b, this.f4275c);
                return;
        }
    }
}
