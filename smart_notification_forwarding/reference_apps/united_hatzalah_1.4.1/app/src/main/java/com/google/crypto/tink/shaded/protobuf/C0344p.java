package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0344p {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C0344p f4145a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0344p f4146b;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.p, java.lang.Object] */
    static {
        ?? obj = new Object();
        Map map = Collections.EMPTY_MAP;
        f4146b = obj;
    }

    public static C0344p a() {
        C0344p c0344p;
        C0344p c0344p2 = f4145a;
        if (c0344p2 == null) {
            synchronized (C0344p.class) {
                try {
                    c0344p = f4145a;
                    if (c0344p == null) {
                        Class cls = AbstractC0343o.f4143a;
                        C0344p c0344p3 = null;
                        if (cls != null) {
                            try {
                                c0344p3 = (C0344p) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                            } catch (Exception unused) {
                            }
                        }
                        if (c0344p3 != null) {
                            c0344p = c0344p3;
                        } else {
                            c0344p = f4146b;
                        }
                        f4145a = c0344p;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0344p;
        }
        return c0344p2;
    }
}
