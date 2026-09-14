package androidx.datastore.preferences.protobuf;

import com.google.firebase.remoteconfig.internal.Code;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0249p {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3224c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final U f3225a = U.f();

    /* renamed from: b, reason: collision with root package name */
    public boolean f3226b;

    static {
        new C0249p(0);
    }

    public C0249p() {
    }

    public static void b(C0244k c0244k, n0 n0Var, int i, Object obj) {
        if (n0Var == n0.f3206d) {
            c0244k.f0(i, 3);
            ((AbstractC0234a) obj).b(c0244k);
            c0244k.f0(i, 4);
            return;
        }
        c0244k.f0(i, n0Var.f3210b);
        switch (n0Var.ordinal()) {
            case 0:
                c0244k.Z(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                c0244k.X(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                c0244k.j0(((Long) obj).longValue());
                return;
            case 3:
                c0244k.j0(((Long) obj).longValue());
                return;
            case 4:
                c0244k.b0(((Integer) obj).intValue());
                return;
            case 5:
                c0244k.Z(((Long) obj).longValue());
                return;
            case 6:
                c0244k.X(((Integer) obj).intValue());
                return;
            case 7:
                c0244k.R(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case 8:
                if (obj instanceof C0240g) {
                    c0244k.V((C0240g) obj);
                    return;
                } else {
                    c0244k.e0((String) obj);
                    return;
                }
            case 9:
                ((AbstractC0234a) obj).b(c0244k);
                return;
            case 10:
                AbstractC0234a abstractC0234a = (AbstractC0234a) obj;
                c0244k.getClass();
                c0244k.h0(((AbstractC0253u) abstractC0234a).a(null));
                abstractC0234a.b(c0244k);
                return;
            case 11:
                if (obj instanceof C0240g) {
                    c0244k.V((C0240g) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                c0244k.h0(length);
                c0244k.S(bArr, 0, length);
                return;
            case Code.UNIMPLEMENTED /* 12 */:
                c0244k.h0(((Integer) obj).intValue());
                return;
            case 13:
                c0244k.b0(((Integer) obj).intValue());
                return;
            case 14:
                c0244k.X(((Integer) obj).intValue());
                return;
            case 15:
                c0244k.Z(((Long) obj).longValue());
                return;
            case 16:
                int intValue = ((Integer) obj).intValue();
                c0244k.h0((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) obj).longValue();
                c0244k.j0((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
    }

    public final void a() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (this.f3226b) {
            return;
        }
        U u3 = this.f3225a;
        int size = u3.f3134a.size();
        for (int i = 0; i < size; i++) {
            Map.Entry c4 = u3.c(i);
            if (c4.getValue() instanceof AbstractC0253u) {
                AbstractC0253u abstractC0253u = (AbstractC0253u) c4.getValue();
                abstractC0253u.getClass();
                O o2 = O.f3120c;
                o2.getClass();
                o2.a(abstractC0253u.getClass()).b(abstractC0253u);
                abstractC0253u.h();
            }
        }
        if (!u3.f3136c) {
            if (u3.f3134a.size() <= 0) {
                Iterator it = u3.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    throw new ClassCastException();
                }
            } else {
                u3.c(0).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!u3.f3136c) {
            if (u3.f3135b.isEmpty()) {
                unmodifiableMap = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap = Collections.unmodifiableMap(u3.f3135b);
            }
            u3.f3135b = unmodifiableMap;
            if (u3.f3138e.isEmpty()) {
                unmodifiableMap2 = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(u3.f3138e);
            }
            u3.f3138e = unmodifiableMap2;
            u3.f3136c = true;
        }
        this.f3226b = true;
    }

    public final Object clone() {
        C0249p c0249p = new C0249p();
        U u3 = this.f3225a;
        if (u3.f3134a.size() <= 0) {
            Iterator it = u3.d().iterator();
            if (!it.hasNext()) {
                return c0249p;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getKey() == null) {
                entry.getValue();
                throw null;
            }
            throw new ClassCastException();
        }
        Map.Entry c4 = u3.c(0);
        if (c4.getKey() == null) {
            c4.getValue();
            throw null;
        }
        throw new ClassCastException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0249p)) {
            return false;
        }
        return this.f3225a.equals(((C0249p) obj).f3225a);
    }

    public final int hashCode() {
        return this.f3225a.hashCode();
    }

    public C0249p(int i) {
        a();
        a();
    }
}
