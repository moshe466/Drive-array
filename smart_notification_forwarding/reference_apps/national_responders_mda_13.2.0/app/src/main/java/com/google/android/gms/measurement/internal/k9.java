package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c2.b;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.f1;
import com.google.android.gms.internal.measurement.h1;
import com.google.android.gms.internal.measurement.l1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public final class k9 extends b9 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k9(e9 e9Var) {
        super(e9Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.f1 B(com.google.android.gms.internal.measurement.d1 d1Var, String str) {
        for (com.google.android.gms.internal.measurement.f1 f1Var : d1Var.B()) {
            if (f1Var.O().equals(str)) {
                return f1Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Builder extends com.google.android.gms.internal.measurement.x8> Builder C(Builder builder, byte[] bArr) {
        com.google.android.gms.internal.measurement.y6 c10 = com.google.android.gms.internal.measurement.y6.c();
        return c10 != null ? (Builder) builder.M(bArr, c10) : (Builder) builder.H(bArr);
    }

    private static String G(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> H(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 < bitSet.length()) {
                    if (bitSet.get(i12)) {
                        j10 |= 1 << i11;
                    }
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    private static List<com.google.android.gms.internal.measurement.f1> J(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                f1.a f02 = com.google.android.gms.internal.measurement.f1.f0();
                for (String str : bundle.keySet()) {
                    f1.a A = com.google.android.gms.internal.measurement.f1.f0().A(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        A.x(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        A.C((String) obj);
                    } else if (obj instanceof Double) {
                        A.w(((Double) obj).doubleValue());
                    }
                    f02.y(A);
                }
                if (f02.F() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.f1) ((com.google.android.gms.internal.measurement.l7) f02.g()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K(d1.a aVar, String str, Object obj) {
        List<com.google.android.gms.internal.measurement.f1> E = aVar.E();
        int i10 = 0;
        while (true) {
            if (i10 >= E.size()) {
                i10 = -1;
                break;
            } else if (str.equals(E.get(i10).O())) {
                break;
            } else {
                i10++;
            }
        }
        f1.a A = com.google.android.gms.internal.measurement.f1.f0().A(str);
        if (obj instanceof Long) {
            A.x(((Long) obj).longValue());
        } else if (obj instanceof String) {
            A.C((String) obj);
        } else if (obj instanceof Double) {
            A.w(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            A.z(J((Bundle[]) obj));
        }
        if (i10 >= 0) {
            aVar.u(i10, A);
        } else {
            aVar.y(A);
        }
    }

    private static void N(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    private final void O(StringBuilder sb2, int i10, com.google.android.gms.internal.measurement.n0 n0Var) {
        if (n0Var == null) {
            return;
        }
        N(sb2, i10);
        sb2.append("filter {\n");
        if (n0Var.G()) {
            R(sb2, i10, "complement", Boolean.valueOf(n0Var.I()));
        }
        if (n0Var.J()) {
            R(sb2, i10, "param_name", j().z(n0Var.K()));
        }
        if (n0Var.C()) {
            int i11 = i10 + 1;
            com.google.android.gms.internal.measurement.q0 D = n0Var.D();
            if (D != null) {
                N(sb2, i11);
                sb2.append("string_filter");
                sb2.append(" {\n");
                if (D.A()) {
                    R(sb2, i11, "match_type", D.B().name());
                }
                if (D.C()) {
                    R(sb2, i11, "expression", D.D());
                }
                if (D.E()) {
                    R(sb2, i11, "case_sensitive", Boolean.valueOf(D.F()));
                }
                if (D.I() > 0) {
                    N(sb2, i11 + 1);
                    sb2.append("expression_list {\n");
                    for (String str : D.G()) {
                        N(sb2, i11 + 2);
                        sb2.append(str);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                N(sb2, i11);
                sb2.append("}\n");
            }
        }
        if (n0Var.E()) {
            P(sb2, i10 + 1, "number_filter", n0Var.F());
        }
        N(sb2, i10);
        sb2.append("}\n");
    }

    private static void P(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.o0 o0Var) {
        if (o0Var == null) {
            return;
        }
        N(sb2, i10);
        sb2.append(str);
        sb2.append(" {\n");
        if (o0Var.A()) {
            R(sb2, i10, "comparison_type", o0Var.B().name());
        }
        if (o0Var.C()) {
            R(sb2, i10, "match_as_float", Boolean.valueOf(o0Var.D()));
        }
        if (o0Var.E()) {
            R(sb2, i10, "comparison_value", o0Var.F());
        }
        if (o0Var.G()) {
            R(sb2, i10, "min_comparison_value", o0Var.I());
        }
        if (o0Var.J()) {
            R(sb2, i10, "max_comparison_value", o0Var.K());
        }
        N(sb2, i10);
        sb2.append("}\n");
    }

    private static void Q(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.j1 j1Var, String str2) {
        if (j1Var == null) {
            return;
        }
        N(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (j1Var.S() != 0) {
            N(sb2, 4);
            sb2.append("results: ");
            int i11 = 0;
            for (Long l10 : j1Var.P()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i11 = i12;
            }
            sb2.append('\n');
        }
        if (j1Var.G() != 0) {
            N(sb2, 4);
            sb2.append("status: ");
            int i13 = 0;
            for (Long l11 : j1Var.B()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i13 = i14;
            }
            sb2.append('\n');
        }
        if (j1Var.Y() != 0) {
            N(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.c1 c1Var : j1Var.W()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb2.append(", ");
                }
                sb2.append(c1Var.E() ? Integer.valueOf(c1Var.F()) : null);
                sb2.append(":");
                sb2.append(c1Var.G() ? Long.valueOf(c1Var.I()) : null);
                i15 = i16;
            }
            sb2.append("}\n");
        }
        if (j1Var.a0() != 0) {
            N(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i17 = 0;
            for (com.google.android.gms.internal.measurement.k1 k1Var : j1Var.Z()) {
                int i18 = i17 + 1;
                if (i17 != 0) {
                    sb2.append(", ");
                }
                sb2.append(k1Var.E() ? Integer.valueOf(k1Var.F()) : null);
                sb2.append(": [");
                Iterator<Long> it = k1Var.I().iterator();
                int i19 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    int i20 = i19 + 1;
                    if (i19 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(longValue);
                    i19 = i20;
                }
                sb2.append("]");
                i17 = i18;
            }
            sb2.append("}\n");
        }
        N(sb2, 3);
        sb2.append("}\n");
    }

    private static void R(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        N(sb2, i10 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    private final void S(StringBuilder sb2, int i10, List<com.google.android.gms.internal.measurement.f1> list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        for (com.google.android.gms.internal.measurement.f1 f1Var : list) {
            if (f1Var != null) {
                N(sb2, i11);
                sb2.append("param {\n");
                R(sb2, i11, "name", f1Var.L() ? j().z(f1Var.O()) : null);
                R(sb2, i11, "string_value", f1Var.T() ? f1Var.U() : null);
                R(sb2, i11, "int_value", f1Var.X() ? Long.valueOf(f1Var.Y()) : null);
                R(sb2, i11, "double_value", f1Var.b0() ? Double.valueOf(f1Var.c0()) : null);
                if (f1Var.e0() > 0) {
                    S(sb2, i11, f1Var.d0());
                }
                N(sb2, i11);
                sb2.append("}\n");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean U(q qVar, v9 v9Var) {
        b2.p.k(qVar);
        b2.p.k(v9Var);
        return (TextUtils.isEmpty(v9Var.f6561g) && TextUtils.isEmpty(v9Var.f6577w)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean V(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean W(List<Long> list, int i10) {
        if (i10 < (list.size() << 6)) {
            return ((1 << (i10 % 64)) & list.get(i10 / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object X(com.google.android.gms.internal.measurement.d1 d1Var, String str) {
        com.google.android.gms.internal.measurement.f1 B = B(d1Var, str);
        if (B == null) {
            return null;
        }
        if (B.T()) {
            return B.U();
        }
        if (B.X()) {
            return Long.valueOf(B.Y());
        }
        if (B.b0()) {
            return Double.valueOf(B.c0());
        }
        if (B.e0() <= 0) {
            return null;
        }
        List<com.google.android.gms.internal.measurement.f1> d02 = B.d0();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.f1 f1Var : d02) {
            if (f1Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.f1 f1Var2 : f1Var.d0()) {
                    if (f1Var2.T()) {
                        bundle.putString(f1Var2.O(), f1Var2.U());
                    } else if (f1Var2.X()) {
                        bundle.putLong(f1Var2.O(), f1Var2.Y());
                    } else if (f1Var2.b0()) {
                        bundle.putDouble(f1Var2.O(), f1Var2.c0());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(h1.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < aVar.b0(); i10++) {
            if (str.equals(aVar.Z(i10).R())) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.d1 A(n nVar) {
        d1.a I = com.google.android.gms.internal.measurement.d1.c0().I(nVar.f6241e);
        Iterator<String> it = nVar.f6242f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            f1.a A = com.google.android.gms.internal.measurement.f1.f0().A(next);
            L(A, nVar.f6242f.l(next));
            I.y(A);
        }
        return (com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) I.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D(com.google.android.gms.internal.measurement.m0 m0Var) {
        if (m0Var == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (m0Var.F()) {
            R(sb2, 0, "filter_id", Integer.valueOf(m0Var.G()));
        }
        R(sb2, 0, "event_name", j().w(m0Var.I()));
        String G = G(m0Var.P(), m0Var.Q(), m0Var.S());
        if (!G.isEmpty()) {
            R(sb2, 0, "filter_type", G);
        }
        if (m0Var.L()) {
            P(sb2, 1, "event_count_filter", m0Var.O());
        }
        if (m0Var.K() > 0) {
            sb2.append("  filters {\n");
            Iterator<com.google.android.gms.internal.measurement.n0> it = m0Var.J().iterator();
            while (it.hasNext()) {
                O(sb2, 2, it.next());
            }
        }
        N(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E(com.google.android.gms.internal.measurement.p0 p0Var) {
        if (p0Var == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (p0Var.C()) {
            R(sb2, 0, "filter_id", Integer.valueOf(p0Var.D()));
        }
        R(sb2, 0, "property_name", j().A(p0Var.E()));
        String G = G(p0Var.G(), p0Var.I(), p0Var.K());
        if (!G.isEmpty()) {
            R(sb2, 0, "filter_type", G);
        }
        O(sb2, 1, p0Var.F());
        sb2.append("}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F(com.google.android.gms.internal.measurement.g1 g1Var) {
        if (g1Var == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.h1 h1Var : g1Var.B()) {
            if (h1Var != null) {
                N(sb2, 1);
                sb2.append("bundle {\n");
                if (h1Var.Y()) {
                    R(sb2, 1, "protocol_version", Integer.valueOf(h1Var.z0()));
                }
                R(sb2, 1, "platform", h1Var.O2());
                if (h1Var.Z2()) {
                    R(sb2, 1, "gmp_version", Long.valueOf(h1Var.Z()));
                }
                if (h1Var.a0()) {
                    R(sb2, 1, "uploading_gmp_version", Long.valueOf(h1Var.b0()));
                }
                if (h1Var.N0()) {
                    R(sb2, 1, "dynamite_version", Long.valueOf(h1Var.O0()));
                }
                if (h1Var.t0()) {
                    R(sb2, 1, "config_version", Long.valueOf(h1Var.u0()));
                }
                R(sb2, 1, "gmp_app_id", h1Var.l0());
                R(sb2, 1, "admob_app_id", h1Var.M0());
                R(sb2, 1, "app_id", h1Var.X2());
                R(sb2, 1, "app_version", h1Var.Y2());
                if (h1Var.q0()) {
                    R(sb2, 1, "app_version_major", Integer.valueOf(h1Var.r0()));
                }
                R(sb2, 1, "firebase_instance_id", h1Var.p0());
                if (h1Var.g0()) {
                    R(sb2, 1, "dev_cert_hash", Long.valueOf(h1Var.h0()));
                }
                R(sb2, 1, "app_store", h1Var.W2());
                if (h1Var.W1()) {
                    R(sb2, 1, "upload_timestamp_millis", Long.valueOf(h1Var.X1()));
                }
                if (h1Var.k2()) {
                    R(sb2, 1, "start_timestamp_millis", Long.valueOf(h1Var.l2()));
                }
                if (h1Var.w2()) {
                    R(sb2, 1, "end_timestamp_millis", Long.valueOf(h1Var.x2()));
                }
                if (h1Var.E2()) {
                    R(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(h1Var.F2()));
                }
                if (h1Var.K2()) {
                    R(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(h1Var.L2()));
                }
                R(sb2, 1, "app_instance_id", h1Var.f0());
                R(sb2, 1, "resettable_device_id", h1Var.c0());
                R(sb2, 1, "device_id", h1Var.s0());
                R(sb2, 1, "ds_id", h1Var.x0());
                if (h1Var.d0()) {
                    R(sb2, 1, "limited_ad_tracking", Boolean.valueOf(h1Var.e0()));
                }
                R(sb2, 1, "os_version", h1Var.R2());
                R(sb2, 1, "device_model", h1Var.S2());
                R(sb2, 1, "user_default_language", h1Var.T2());
                if (h1Var.U2()) {
                    R(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(h1Var.V2()));
                }
                if (h1Var.i0()) {
                    R(sb2, 1, "bundle_sequential_index", Integer.valueOf(h1Var.j0()));
                }
                if (h1Var.m0()) {
                    R(sb2, 1, "service_upload", Boolean.valueOf(h1Var.n0()));
                }
                R(sb2, 1, "health_monitor", h1Var.k0());
                if (!m().t(s.f6441y0) && h1Var.v0() && h1Var.w0() != 0) {
                    R(sb2, 1, "android_id", Long.valueOf(h1Var.w0()));
                }
                if (h1Var.y0()) {
                    R(sb2, 1, "retry_counter", Integer.valueOf(h1Var.L0()));
                }
                if (h1Var.Q0()) {
                    R(sb2, 1, "consent_signals", h1Var.R0());
                }
                List<com.google.android.gms.internal.measurement.l1> z12 = h1Var.z1();
                if (z12 != null) {
                    for (com.google.android.gms.internal.measurement.l1 l1Var : z12) {
                        if (l1Var != null) {
                            N(sb2, 2);
                            sb2.append("user_property {\n");
                            R(sb2, 2, "set_timestamp_millis", l1Var.I() ? Long.valueOf(l1Var.J()) : null);
                            R(sb2, 2, "name", j().A(l1Var.R()));
                            R(sb2, 2, "string_value", l1Var.U());
                            R(sb2, 2, "int_value", l1Var.V() ? Long.valueOf(l1Var.W()) : null);
                            R(sb2, 2, "double_value", l1Var.X() ? Double.valueOf(l1Var.Y()) : null);
                            N(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.b1> o02 = h1Var.o0();
                String X2 = h1Var.X2();
                if (o02 != null) {
                    for (com.google.android.gms.internal.measurement.b1 b1Var : o02) {
                        if (b1Var != null) {
                            N(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (b1Var.G()) {
                                R(sb2, 2, "audience_id", Integer.valueOf(b1Var.I()));
                            }
                            if (b1Var.Q()) {
                                R(sb2, 2, "new_audience", Boolean.valueOf(b1Var.R()));
                            }
                            Q(sb2, 2, "current_data", b1Var.L(), X2);
                            if (b1Var.O()) {
                                Q(sb2, 2, "previous_data", b1Var.P(), X2);
                            }
                            N(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.d1> Y0 = h1Var.Y0();
                if (Y0 != null) {
                    for (com.google.android.gms.internal.measurement.d1 d1Var : Y0) {
                        if (d1Var != null) {
                            N(sb2, 2);
                            sb2.append("event {\n");
                            R(sb2, 2, "name", j().w(d1Var.V()));
                            if (d1Var.W()) {
                                R(sb2, 2, "timestamp_millis", Long.valueOf(d1Var.X()));
                            }
                            if (d1Var.Y()) {
                                R(sb2, 2, "previous_timestamp_millis", Long.valueOf(d1Var.Z()));
                            }
                            if (d1Var.a0()) {
                                R(sb2, 2, "count", Integer.valueOf(d1Var.b0()));
                            }
                            if (d1Var.R() != 0) {
                                S(sb2, 2, d1Var.B());
                            }
                            N(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                N(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> I(List<Long> list, List<Integer> list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                h().I().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    h().I().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(f1.a aVar, Object obj) {
        b2.p.k(obj);
        aVar.u().B().E().G();
        if (obj instanceof String) {
            aVar.C((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.x(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.w(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            aVar.z(J((Bundle[]) obj));
        } else {
            h().F().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(l1.a aVar, Object obj) {
        b2.p.k(obj);
        aVar.u().z().C();
        if (obj instanceof String) {
            aVar.B((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.A(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.w(((Double) obj).doubleValue());
        } else {
            h().F().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean T(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(f().a() - j10) > j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] Y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e10) {
            h().F().b("Failed to ungzip content", e10);
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] Z(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            h().F().b("Failed to gzip content", e10);
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Integer> a0() {
        Map<String, String> c10 = s.c(this.f5912b.i());
        if (c10 == null || c10.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = s.P.a(null).intValue();
        for (Map.Entry<String, String> entry : c10.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            h().I().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e10) {
                    h().I().b("Experiment ID NumberFormatException", e10);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long y(byte[] bArr) {
        b2.p.k(bArr);
        k().c();
        MessageDigest J0 = o9.J0();
        if (J0 != null) {
            return o9.A(J0.digest(bArr));
        }
        h().F().a("Failed to get MD5");
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T z(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (b.a unused) {
            h().F().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }
}
