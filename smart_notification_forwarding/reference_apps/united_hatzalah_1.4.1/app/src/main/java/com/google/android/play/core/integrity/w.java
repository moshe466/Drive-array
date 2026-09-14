package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes.dex */
final class w implements aw {

    /* renamed from: a, reason: collision with root package name */
    private final w f4016a = this;

    /* renamed from: b, reason: collision with root package name */
    private final I1.i f4017b;

    /* renamed from: c, reason: collision with root package name */
    private final I1.i f4018c;

    /* renamed from: d, reason: collision with root package name */
    private final I1.i f4019d;

    /* renamed from: e, reason: collision with root package name */
    private final I1.i f4020e;

    /* renamed from: f, reason: collision with root package name */
    private final I1.i f4021f;

    /* renamed from: g, reason: collision with root package name */
    private final I1.i f4022g;

    public w(Context context, v vVar) {
        bc bcVar;
        o oVar;
        o oVar2;
        if (context != null) {
            I1.h hVar = new I1.h(context);
            this.f4017b = hVar;
            bcVar = bb.f3953a;
            I1.f b4 = I1.f.b(bcVar);
            this.f4018c = b4;
            oVar = n.f4007a;
            au auVar = new au(hVar, oVar);
            this.f4019d = auVar;
            oVar2 = n.f4007a;
            I1.f b5 = I1.f.b(new bp(hVar, b4, auVar, oVar2));
            this.f4020e = b5;
            I1.f b6 = I1.f.b(new bu(b5));
            this.f4021f = b6;
            this.f4022g = I1.f.b(new ba(b5, b6));
            return;
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // com.google.android.play.core.integrity.aw
    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f4022g.a();
    }
}
