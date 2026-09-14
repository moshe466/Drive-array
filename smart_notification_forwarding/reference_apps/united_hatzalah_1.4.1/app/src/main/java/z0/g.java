package z0;

import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.s;
import s2.C0682g;
import w0.C0752h;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f6826a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final C0682g f6827b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f6828c;

    /* JADX WARN: Type inference failed for: r0v0, types: [z0.g, java.lang.Object] */
    static {
        s.a(h.class).c();
        f6827b = T.b.A(f.f6825a);
        f6828c = a.f6808a;
    }

    public static b a(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        A0.a aVar = (A0.a) f6827b.a();
        if (aVar == null) {
            C0.m mVar = C0.m.f103c;
            if (C0.m.f103c == null) {
                ReentrantLock reentrantLock = C0.m.f104d;
                reentrantLock.lock();
                try {
                    if (C0.m.f103c == null) {
                        C0.k kVar = null;
                        try {
                            C0752h b4 = C0.i.b();
                            if (b4 != null) {
                                C0752h other = C0752h.f6698f;
                                kotlin.jvm.internal.j.e(other, "other");
                                Object a2 = b4.f6703e.a();
                                kotlin.jvm.internal.j.d(a2, "<get-bigInteger>(...)");
                                Object a4 = other.f6703e.a();
                                kotlin.jvm.internal.j.d(a4, "<get-bigInteger>(...)");
                                if (((BigInteger) a2).compareTo((BigInteger) a4) >= 0) {
                                    C0.k kVar2 = new C0.k(context);
                                    if (kVar2.e()) {
                                        kVar = kVar2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        C0.m.f103c = new C0.m(kVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            aVar = C0.m.f103c;
            kotlin.jvm.internal.j.b(aVar);
        }
        int i = m.f6838b;
        b bVar = new b(aVar);
        f6828c.getClass();
        return bVar;
    }
}
