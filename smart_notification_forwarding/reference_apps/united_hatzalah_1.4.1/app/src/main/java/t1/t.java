package t1;

import F0.C0047j2;
import F0.C0110z2;
import F0.Q2;
import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import q1.C0622c;
import r1.C0643a;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static volatile l f6453e;

    /* renamed from: a, reason: collision with root package name */
    public final A.n f6454a;

    /* renamed from: b, reason: collision with root package name */
    public final A.n f6455b;

    /* renamed from: c, reason: collision with root package name */
    public final y1.c f6456c;

    /* renamed from: d, reason: collision with root package name */
    public final z1.g f6457d;

    public t(A.n nVar, A.n nVar2, y1.c cVar, z1.g gVar, z1.i iVar) {
        this.f6454a = nVar;
        this.f6455b = nVar2;
        this.f6456c = cVar;
        this.f6457d = gVar;
        iVar.f6872a.execute(new Q2(iVar, 19));
    }

    public static t a() {
        l lVar = f6453e;
        if (lVar != null) {
            return (t) lVar.f6440j.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f6453e == null) {
            synchronized (t.class) {
                try {
                    if (f6453e == null) {
                        C0047j2 c0047j2 = new C0047j2(22);
                        context.getClass();
                        c0047j2.f546b = context;
                        f6453e = c0047j2.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final r c(m mVar) {
        Set singleton;
        byte[] bytes;
        if (mVar != null) {
            singleton = Collections.unmodifiableSet(C0643a.f6205d);
        } else {
            singleton = Collections.singleton(new C0622c("proto"));
        }
        C0110z2 a2 = k.a();
        mVar.getClass();
        a2.f729b = "cct";
        C0643a c0643a = (C0643a) mVar;
        String str = c0643a.f6208a;
        String str2 = c0643a.f6209b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = e0.a.f("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
        }
        a2.f730c = bytes;
        return new r(singleton, a2.g(), this);
    }
}
