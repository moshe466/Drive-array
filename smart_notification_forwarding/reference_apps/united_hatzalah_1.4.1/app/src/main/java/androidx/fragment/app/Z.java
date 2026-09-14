package androidx.fragment.app;

import t.C0694j;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: b, reason: collision with root package name */
    public static final C0694j f3333b = new C0694j(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0272g0 f3334a;

    public Z(AbstractC0272g0 abstractC0272g0) {
        this.f3334a = abstractC0272g0;
    }

    public static Class a(String str, ClassLoader classLoader) {
        C0694j c0694j = f3333b;
        C0694j c0694j2 = (C0694j) c0694j.get(classLoader);
        if (c0694j2 == null) {
            c0694j2 = new C0694j(0);
            c0694j.put(classLoader, c0694j2);
        }
        Class cls = (Class) c0694j2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            c0694j2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class b(String str, ClassLoader classLoader) {
        try {
            return a(str, classLoader);
        } catch (ClassCastException e4) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": make sure class name exists"), e5);
        }
    }
}
