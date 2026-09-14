package t1;

import java.util.HashMap;
import q1.C0620a;
import q1.C0621b;
import q1.C0622c;
import y1.C0784a;

/* loaded from: classes.dex */
public final class s implements q1.f {

    /* renamed from: a, reason: collision with root package name */
    public final k f6448a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6449b;

    /* renamed from: c, reason: collision with root package name */
    public final C0622c f6450c;

    /* renamed from: d, reason: collision with root package name */
    public final q1.e f6451d;

    /* renamed from: e, reason: collision with root package name */
    public final t f6452e;

    public s(k kVar, String str, C0622c c0622c, q1.e eVar, t tVar) {
        this.f6448a = kVar;
        this.f6449b = str;
        this.f6450c = c0622c;
        this.f6451d = eVar;
        this.f6452e = tVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, t1.i] */
    public final void a(C0620a c0620a, q1.h hVar) {
        q1.e eVar = this.f6451d;
        if (eVar != null) {
            t tVar = this.f6452e;
            y1.c cVar = tVar.f6456c;
            k b4 = this.f6448a.b(c0620a.f6146b);
            ?? obj = new Object();
            obj.f6418f = new HashMap();
            obj.f6416d = Long.valueOf(tVar.f6454a.d());
            obj.f6417e = Long.valueOf(tVar.f6455b.d());
            obj.f6413a = this.f6449b;
            obj.f6415c = new n(this.f6450c, (byte[]) eVar.apply(c0620a.f6145a));
            obj.f6414b = null;
            C0621b c0621b = c0620a.f6147c;
            if (c0621b != null) {
                obj.f6419g = c0621b.f6148a;
            }
            C0784a c0784a = (C0784a) cVar;
            c0784a.f6752b.execute(new com.google.firebase.crashlytics.internal.metadata.a(c0784a, b4, hVar, obj.b(), 7));
            return;
        }
        throw new NullPointerException("Null transformer");
    }
}
