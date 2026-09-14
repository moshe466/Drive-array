package K1;

import F0.AbstractC0083t;
import F0.C0110z2;
import R1.s;
import W1.W;
import W1.X;
import W1.Y;
import W1.b0;
import W1.d0;
import W1.e0;
import W1.f0;
import W1.g0;
import W1.r0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0341m;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f1085c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f1086d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f1087e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1088a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1089b;

    static {
        int i = 0;
        f1085c = new f("ENABLED", i);
        f1086d = new f("DISABLED", i);
        f1087e = new f("DESTROYED", i);
    }

    public /* synthetic */ f(Object obj, int i) {
        this.f1088a = i;
        this.f1089b = obj;
    }

    public synchronized void a(b0 b0Var) {
        f0 b4;
        synchronized (this) {
            b4 = b(o.e(b0Var), b0Var.A());
        }
        d0 d0Var = (d0) this.f1089b;
        d0Var.e();
        g0.x((g0) d0Var.f4158b, b4);
    }

    public synchronized f0 b(Y y, r0 r0Var) {
        int a2;
        synchronized (this) {
            a2 = s.a();
            while (d(a2)) {
                a2 = s.a();
            }
        }
        return (f0) r1.b();
        if (r0Var != r0.UNKNOWN_PREFIX) {
            e0 F3 = f0.F();
            F3.e();
            f0.w((f0) F3.f4158b, y);
            F3.e();
            f0.z((f0) F3.f4158b, a2);
            F3.e();
            f0.y((f0) F3.f4158b);
            F3.e();
            f0.x((f0) F3.f4158b, r0Var);
            return (f0) F3.b();
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }

    public synchronized C0110z2 c() {
        return C0110z2.l((g0) ((d0) this.f1089b).b());
    }

    public synchronized boolean d(int i) {
        Iterator it = Collections.unmodifiableList(((g0) ((d0) this.f1089b).f4158b).A()).iterator();
        while (it.hasNext()) {
            if (((f0) it.next()).B() == i) {
                return true;
            }
        }
        return false;
    }

    public Y e(AbstractC0337i abstractC0337i) {
        R1.d dVar = (R1.d) this.f1089b;
        try {
            AbstractC0083t d2 = dVar.d();
            AbstractC0329a n4 = d2.n(abstractC0337i);
            d2.o(n4);
            AbstractC0329a c4 = d2.c(n4);
            W D3 = Y.D();
            String b4 = dVar.b();
            D3.e();
            Y.w((Y) D3.f4158b, b4);
            try {
                int b5 = ((AbstractC0351x) c4).b(null);
                byte[] bArr = new byte[b5];
                C0341m c0341m = new C0341m(bArr, b5);
                c4.f(c0341m);
                if (c0341m.f4133l - c0341m.f4134m == 0) {
                    C0336h c0336h = new C0336h(bArr);
                    D3.e();
                    Y.x((Y) D3.f4158b, c0336h);
                    X e4 = dVar.e();
                    D3.e();
                    Y.y((Y) D3.f4158b, e4);
                    return (Y) D3.b();
                }
                throw new IllegalStateException("Did not write as much data as expected.");
            } catch (IOException e5) {
                throw new RuntimeException(c4.c("ByteString"), e5);
            }
        } catch (InvalidProtocolBufferException e6) {
            throw new GeneralSecurityException("Unexpected proto", e6);
        }
    }

    public String toString() {
        switch (this.f1088a) {
            case 0:
                return (String) this.f1089b;
            default:
                return super.toString();
        }
    }

    public f(R1.d dVar, Class cls) {
        this.f1088a = 2;
        if (!dVar.f1985b.keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(e0.a.f("Given internalKeyMananger ", dVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.f1089b = dVar;
    }
}
