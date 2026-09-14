package t;

import java.util.ConcurrentModificationException;
import u.AbstractC0717a;

/* renamed from: t.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0692h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f6362a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6363b = new Object();

    public static final void a(C0690f c0690f, int i) {
        c0690f.f6355a = new int[i];
        c0690f.f6356b = new Object[i];
    }

    public static final int b(C0690f c0690f, Object obj, int i) {
        int i3 = c0690f.f6357c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a2 = AbstractC0717a.a(i3, i, c0690f.f6355a);
            if (a2 < 0 || kotlin.jvm.internal.j.a(obj, c0690f.f6356b[a2])) {
                return a2;
            }
            int i4 = a2 + 1;
            while (i4 < i3 && c0690f.f6355a[i4] == i) {
                if (kotlin.jvm.internal.j.a(obj, c0690f.f6356b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && c0690f.f6355a[i5] == i; i5--) {
                if (kotlin.jvm.internal.j.a(obj, c0690f.f6356b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
