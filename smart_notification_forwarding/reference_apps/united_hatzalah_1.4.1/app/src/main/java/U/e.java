package U;

import P2.C0161k0;
import P2.G;
import P2.O;
import R.C0179d;
import R.P;
import R.U;
import R.V;
import R.m0;
import T.k;
import T.l;
import androidx.datastore.preferences.protobuf.AbstractC0253u;
import androidx.datastore.preferences.protobuf.AbstractC0255w;
import androidx.datastore.preferences.protobuf.C0240g;
import androidx.datastore.preferences.protobuf.C0244k;
import androidx.datastore.preferences.protobuf.InterfaceC0254v;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import t2.AbstractC0707i;
import t2.C0716r;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2314a = new Object();

    public static d a(S.a aVar, F2.a aVar2) {
        W2.d dVar = O.f1623b;
        C0161k0 c0161k0 = new C0161k0();
        dVar.getClass();
        return new d(new d(new P(new V(new U(aVar2)), T.b.B(new C0179d(C0716r.f6476a, null)), aVar, G.b(T.b.F(dVar, c0161k0)))));
    }

    public b b(FileInputStream fileInputStream) {
        int i;
        byte[] bArr;
        try {
            T.g o2 = T.g.o(fileInputStream);
            b bVar = new b(false);
            g[] pairs = (g[]) Arrays.copyOf(new g[0], 0);
            kotlin.jvm.internal.j.e(pairs, "pairs");
            bVar.c();
            if (pairs.length <= 0) {
                Map m4 = o2.m();
                kotlin.jvm.internal.j.d(m4, "preferencesProto.preferencesMap");
                for (Map.Entry entry : m4.entrySet()) {
                    String name = (String) entry.getKey();
                    l value = (l) entry.getValue();
                    kotlin.jvm.internal.j.d(name, "name");
                    kotlin.jvm.internal.j.d(value, "value");
                    int C3 = value.C();
                    if (C3 == 0) {
                        i = -1;
                    } else {
                        i = i.f2316a[k.b(C3)];
                    }
                    switch (i) {
                        case -1:
                            throw new IOException("Value case is null.", null);
                        case 0:
                        default:
                            throw new NoWhenBranchMatchedException();
                        case 1:
                            bVar.e(T.b.c(name), Boolean.valueOf(value.t()));
                            break;
                        case 2:
                            bVar.e(new f(name), Float.valueOf(value.x()));
                            break;
                        case 3:
                            bVar.e(new f(name), Double.valueOf(value.w()));
                            break;
                        case 4:
                            bVar.e(new f(name), Integer.valueOf(value.y()));
                            break;
                        case 5:
                            bVar.e(new f(name), Long.valueOf(value.z()));
                            break;
                        case 6:
                            f K3 = T.b.K(name);
                            String A3 = value.A();
                            kotlin.jvm.internal.j.d(A3, "value.string");
                            bVar.e(K3, A3);
                            break;
                        case 7:
                            f fVar = new f(name);
                            InterfaceC0254v n4 = value.B().n();
                            kotlin.jvm.internal.j.d(n4, "value.stringSet.stringsList");
                            bVar.e(fVar, AbstractC0707i.u0(n4));
                            break;
                        case 8:
                            f fVar2 = new f(name);
                            C0240g u3 = value.u();
                            int size = u3.size();
                            if (size == 0) {
                                bArr = AbstractC0255w.f3237b;
                            } else {
                                byte[] bArr2 = new byte[size];
                                u3.j(bArr2, size);
                                bArr = bArr2;
                            }
                            kotlin.jvm.internal.j.d(bArr, "value.bytes.toByteArray()");
                            bVar.e(fVar2, bArr);
                            break;
                        case 9:
                            throw new IOException("Value not set.", null);
                    }
                }
                return new b(new LinkedHashMap(bVar.a()), true);
            }
            g gVar = pairs[0];
            throw null;
        } catch (InvalidProtocolBufferException e4) {
            throw new IOException("Unable to parse preferences proto.", e4);
        }
    }

    public void c(Object obj, m0 m0Var) {
        AbstractC0253u a2;
        Map a4 = ((h) obj).a();
        T.e n4 = T.g.n();
        for (Map.Entry entry : a4.entrySet()) {
            f fVar = (f) entry.getKey();
            Object value = entry.getValue();
            String str = fVar.f2315a;
            if (value instanceof Boolean) {
                T.j D3 = l.D();
                boolean booleanValue = ((Boolean) value).booleanValue();
                D3.c();
                l.q((l) D3.f3235b, booleanValue);
                a2 = D3.a();
            } else if (value instanceof Float) {
                T.j D4 = l.D();
                float floatValue = ((Number) value).floatValue();
                D4.c();
                l.r((l) D4.f3235b, floatValue);
                a2 = D4.a();
            } else if (value instanceof Double) {
                T.j D5 = l.D();
                double doubleValue = ((Number) value).doubleValue();
                D5.c();
                l.o((l) D5.f3235b, doubleValue);
                a2 = D5.a();
            } else if (value instanceof Integer) {
                T.j D6 = l.D();
                int intValue = ((Number) value).intValue();
                D6.c();
                l.s((l) D6.f3235b, intValue);
                a2 = D6.a();
            } else if (value instanceof Long) {
                T.j D7 = l.D();
                long longValue = ((Number) value).longValue();
                D7.c();
                l.l((l) D7.f3235b, longValue);
                a2 = D7.a();
            } else if (value instanceof String) {
                T.j D8 = l.D();
                D8.c();
                l.m((l) D8.f3235b, (String) value);
                a2 = D8.a();
            } else if (value instanceof Set) {
                T.j D9 = l.D();
                T.h o2 = T.i.o();
                kotlin.jvm.internal.j.c(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                o2.c();
                T.i.l((T.i) o2.f3235b, (Set) value);
                D9.c();
                l.n((l) D9.f3235b, (T.i) o2.a());
                a2 = D9.a();
            } else if (value instanceof byte[]) {
                T.j D10 = l.D();
                byte[] bArr = (byte[]) value;
                C0240g c0240g = C0240g.f3173c;
                C0240g i = C0240g.i(bArr, 0, bArr.length);
                D10.c();
                l.p((l) D10.f3235b, i);
                a2 = D10.a();
            } else {
                throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
            }
            n4.getClass();
            str.getClass();
            n4.c();
            T.g.l((T.g) n4.f3235b).put(str, (l) a2);
        }
        T.g gVar = (T.g) n4.a();
        int a5 = gVar.a(null);
        Logger logger = C0244k.f3196o;
        if (a5 > 4096) {
            a5 = 4096;
        }
        C0244k c0244k = new C0244k(m0Var, a5);
        gVar.b(c0244k);
        if (c0244k.f3200m > 0) {
            c0244k.P();
        }
    }
}
