package androidx.lifecycle;

import androidx.lifecycle.b0;

/* loaded from: classes.dex */
public final /* synthetic */ class c0 {
    public static a0 a(b0.b bVar, Class cls) {
        y8.k.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static a0 b(b0.b bVar, Class cls, k0.a aVar) {
        y8.k.e(cls, "modelClass");
        y8.k.e(aVar, "extras");
        return bVar.b(cls);
    }
}
