package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0246m {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C0246m f3203a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0246m f3204b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.m, java.lang.Object] */
    static {
        ?? obj = new Object();
        Map map = Collections.EMPTY_MAP;
        f3204b = obj;
    }

    public static C0246m a() {
        C0246m c0246m;
        O o2 = O.f3120c;
        C0246m c0246m2 = f3203a;
        if (c0246m2 == null) {
            synchronized (C0246m.class) {
                try {
                    c0246m = f3203a;
                    if (c0246m == null) {
                        Class cls = AbstractC0245l.f3202a;
                        C0246m c0246m3 = null;
                        if (cls != null) {
                            try {
                                c0246m3 = (C0246m) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                            } catch (Exception unused) {
                            }
                        }
                        if (c0246m3 != null) {
                            c0246m = c0246m3;
                        } else {
                            c0246m = f3204b;
                        }
                        f3203a = c0246m;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0246m;
        }
        return c0246m2;
    }
}
