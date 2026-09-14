package io.flutter.embedding.android;

import R2.o;
import R2.p;
import z0.j;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements I.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5007a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5008b;

    public /* synthetic */ a(Object obj, int i) {
        this.f5007a = i;
        this.f5008b = obj;
    }

    @Override // I.a, androidx.window.extensions.core.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5007a) {
            case 0:
                ((FlutterView) this.f5008b).setWindowInfoListenerDisplayFeatures((j) obj);
                return;
            default:
                ((o) ((p) this.f5008b)).b((j) obj);
                return;
        }
    }
}
