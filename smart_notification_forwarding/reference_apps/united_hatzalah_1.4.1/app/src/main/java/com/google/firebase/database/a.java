package com.google.firebase.database;

import R2.p;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4262a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f4263b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f4264c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4265d;

    public /* synthetic */ a(p pVar, DataSnapshot dataSnapshot, String str, int i) {
        this.f4262a = i;
        this.f4263b = pVar;
        this.f4264c = dataSnapshot;
        this.f4265d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4262a) {
            case 0:
                DatabaseKt$childEvents$1$listener$1.d(this.f4263b, this.f4264c, this.f4265d);
                return;
            case 1:
                DatabaseKt$childEvents$1$listener$1.a(this.f4263b, this.f4264c, this.f4265d);
                return;
            case 2:
                DatabaseKt$childEvents$1$listener$1.c(this.f4263b, this.f4264c, this.f4265d);
                return;
            case 3:
                com.google.firebase.database.ktx.DatabaseKt$childEvents$1$listener$1.c(this.f4263b, this.f4264c, this.f4265d);
                return;
            case 4:
                com.google.firebase.database.ktx.DatabaseKt$childEvents$1$listener$1.b(this.f4263b, this.f4264c, this.f4265d);
                return;
            default:
                com.google.firebase.database.ktx.DatabaseKt$childEvents$1$listener$1.d(this.f4263b, this.f4264c, this.f4265d);
                return;
        }
    }
}
