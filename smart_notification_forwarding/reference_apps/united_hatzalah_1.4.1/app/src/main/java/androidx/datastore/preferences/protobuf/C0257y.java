package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0257y {
    public static InterfaceC0254v a(long j2, Object obj) {
        int i;
        InterfaceC0254v interfaceC0254v = (InterfaceC0254v) f0.f3168c.h(j2, obj);
        if (!((AbstractC0235b) interfaceC0254v).f3154a) {
            P p = (P) interfaceC0254v;
            int i3 = p.f3125c;
            if (i3 == 0) {
                i = 10;
            } else {
                i = i3 * 2;
            }
            P h2 = p.h(i);
            f0.o(obj, j2, h2);
            return h2;
        }
        return interfaceC0254v;
    }
}
