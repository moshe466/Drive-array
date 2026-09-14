package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final s f4009a = this;

    /* renamed from: b, reason: collision with root package name */
    private final I1.i f4010b;

    /* renamed from: c, reason: collision with root package name */
    private final I1.i f4011c;

    /* renamed from: d, reason: collision with root package name */
    private final I1.i f4012d;

    /* renamed from: e, reason: collision with root package name */
    private final I1.i f4013e;

    /* renamed from: f, reason: collision with root package name */
    private final I1.i f4014f;

    public s(Context context, r rVar) {
        ad adVar;
        m mVar;
        m mVar2;
        if (context != null) {
            I1.h hVar = new I1.h(context);
            this.f4010b = hVar;
            adVar = ac.f3900a;
            I1.f b4 = I1.f.b(adVar);
            this.f4011c = b4;
            mVar = l.f4002a;
            au auVar = new au(hVar, mVar);
            this.f4012d = auVar;
            mVar2 = l.f4002a;
            I1.f b5 = I1.f.b(new al(hVar, b4, auVar, mVar2));
            this.f4013e = b5;
            this.f4014f = I1.f.b(new ab(b5));
            return;
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f4014f.a();
    }
}
