package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.md;
import com.google.android.gms.internal.measurement.ob;
import com.google.android.gms.internal.measurement.rf;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class o9 extends q5 {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f6296g = {"firebase_", "google_", "ga_"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f6297h = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    private SecureRandom f6298c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicLong f6299d;

    /* renamed from: e, reason: collision with root package name */
    private int f6300e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f6301f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o9(t4 t4Var) {
        super(t4Var);
        this.f6301f = null;
        this.f6299d = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A(byte[] bArr) {
        b2.p.k(bArr);
        int i10 = 0;
        b2.p.n(bArr.length > 0);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (bArr[length] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static Bundle E(List<n9> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (n9 n9Var : list) {
            String str = n9Var.f6262j;
            if (str != null) {
                bundle.putString(n9Var.f6259g, str);
            } else {
                Long l10 = n9Var.f6261i;
                if (l10 != null) {
                    bundle.putLong(n9Var.f6259g, l10.longValue());
                } else {
                    Double d10 = n9Var.f6264l;
                    if (d10 != null) {
                        bundle.putDouble(n9Var.f6259g, d10.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static boolean F0(String str) {
        for (String str2 : f6297h) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private final Object G(int i10, Object obj, boolean z10, boolean z11) {
        Bundle C;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return I(String.valueOf(obj), i10, z10);
        }
        if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (C = C((Bundle) parcelable)) != null && !C.isEmpty()) {
                arrayList.add(C);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final int G0(String str) {
        if (!h0("event param", str)) {
            return 3;
        }
        if (m0("event param", null, str)) {
            return !g0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public static String I(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return null;
    }

    private final int I0(String str) {
        if (!w0("event param", str)) {
            return 3;
        }
        if (m0("event param", null, str)) {
            return !g0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest J0() {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    private static void K(Bundle bundle, int i10, String str, String str2, Object obj) {
        if (v0(bundle, i10)) {
            bundle.putString("_ev", I(str, 40, true));
            if (obj != null) {
                b2.p.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    private static boolean L0(String str) {
        b2.p.k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int M0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (m().t(s.f6407h0) && "_lgclid".equals(str)) ? 100 : 36;
    }

    private final void Y(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z10) {
        int G0;
        String str4;
        int v10;
        if (bundle == null) {
            return;
        }
        int i10 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                G0 = z10 ? G0(str5) : 0;
                if (G0 == 0) {
                    G0 = I0(str5);
                }
            } else {
                G0 = 0;
            }
            if (G0 != 0) {
                K(bundle, G0, str5, str5, G0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (d0(bundle.get(str5))) {
                    h().K().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    v10 = 22;
                    str4 = str5;
                } else {
                    str4 = str5;
                    v10 = v(str, str2, str5, bundle.get(str5), bundle, list, z10, false);
                }
                if (v10 != 0 && !"_ev".equals(str4)) {
                    K(bundle, v10, str4, str4, bundle.get(str4));
                } else if (e0(str4) && !l0(str4, v2.h.f14626d) && (i10 = i10 + 1) > 0) {
                    h().H().c("Item cannot contain custom parameters", j().w(str2), j().u(bundle));
                    v0(bundle, 23);
                }
                bundle.remove(str4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Z(Context context, boolean z10) {
        b2.p.k(context);
        return u0(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b0(Bundle bundle, int i10) {
        int i11 = 0;
        if (bundle.size() <= i10) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i11++;
            if (i11 > i10) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c0(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e0(String str) {
        b2.p.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static boolean l0(String str, String[] strArr) {
        b2.p.k(strArr);
        for (String str2 : strArr) {
            if (B0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o0(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] p0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle s0(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        if (parcelableArr[i10] instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static ArrayList<Bundle> t0(List<ha> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (ha haVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", haVar.f6091f);
            bundle.putString("origin", haVar.f6092g);
            bundle.putLong("creation_timestamp", haVar.f6094i);
            bundle.putString("name", haVar.f6093h.f6259g);
            v2.g.b(bundle, haVar.f6093h.g());
            bundle.putBoolean("active", haVar.f6095j);
            String str = haVar.f6096k;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            q qVar = haVar.f6097l;
            if (qVar != null) {
                bundle.putString("timed_out_event_name", qVar.f6333f);
                p pVar = haVar.f6097l.f6334g;
                if (pVar != null) {
                    bundle.putBundle("timed_out_event_params", pVar.s());
                }
            }
            bundle.putLong("trigger_timeout", haVar.f6098m);
            q qVar2 = haVar.f6099n;
            if (qVar2 != null) {
                bundle.putString("triggered_event_name", qVar2.f6333f);
                p pVar2 = haVar.f6099n.f6334g;
                if (pVar2 != null) {
                    bundle.putBundle("triggered_event_params", pVar2.s());
                }
            }
            bundle.putLong("triggered_timestamp", haVar.f6093h.f6260h);
            bundle.putLong("time_to_live", haVar.f6100o);
            q qVar3 = haVar.f6101p;
            if (qVar3 != null) {
                bundle.putString("expired_event_name", qVar3.f6333f);
                p pVar3 = haVar.f6101p.f6334g;
                if (pVar3 != null) {
                    bundle.putBundle("expired_event_params", pVar3.s());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static boolean u0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int v(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Object r20, android.os.Bundle r21, java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.o9.v(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    private static boolean v0(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    public static long x(long j10, long j11) {
        return (j10 + (j11 * 60000)) / 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] x0(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    public static long z(p pVar) {
        long j10 = 0;
        if (pVar == null) {
            return 0L;
        }
        Iterator<String> it = pVar.iterator();
        while (it.hasNext()) {
            if (pVar.l(it.next()) instanceof Parcelable[]) {
                j10 += ((Parcelable[]) r3).length;
            }
        }
        return j10;
    }

    private final boolean z0(Context context, String str) {
        t3 F;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e10 = i2.c.a(context).e(str, 64);
            if (e10 == null || (signatureArr = e10.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e11) {
            e = e11;
            F = h().F();
            str2 = "Package name not found";
            F.b(str2, e);
            return true;
        } catch (CertificateException e12) {
            e = e12;
            F = h().F();
            str2 = "Error obtaining certificate";
            F.b(str2, e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A0(String str) {
        c();
        if (i2.c.a(i()).a(str) == 0) {
            return true;
        }
        h().M().b("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle B(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            h().I().b("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle C(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object H = H(str, bundle.get(str));
                if (H == null) {
                    h().K().b("Param value can't be null", j().z(str));
                } else {
                    N(bundle2, str, H);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle D(String str, String str2, Bundle bundle, List<String> list, boolean z10, boolean z11) {
        int G0;
        int i10;
        o9 o9Var = this;
        boolean l02 = l0(str2, v2.i.f14630d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int y10 = m().y();
        int i11 = 0;
        for (String str3 : m().D(str, s.Z) ? new TreeSet<>(bundle.keySet()) : bundle.keySet()) {
            if (list == null || !list.contains(str3)) {
                G0 = z10 ? o9Var.G0(str3) : 0;
                if (G0 == 0) {
                    G0 = o9Var.I0(str3);
                }
            } else {
                G0 = 0;
            }
            if (G0 != 0) {
                K(bundle2, G0, str3, str3, G0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i10 = y10;
            } else {
                i10 = y10;
                int v10 = v(str, str2, str3, bundle.get(str3), bundle2, list, z10, l02);
                if (v10 == 17) {
                    K(bundle2, v10, str3, str3, Boolean.FALSE);
                } else if (v10 != 0 && !"_ev".equals(str3)) {
                    K(bundle2, v10, v10 == 21 ? str2 : str3, str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (e0(str3)) {
                    int i12 = i11 + 1;
                    if (i12 > i10) {
                        StringBuilder sb2 = new StringBuilder(48);
                        sb2.append("Event can't contain more than ");
                        sb2.append(i10);
                        sb2.append(" params");
                        h().H().c(sb2.toString(), j().w(str2), j().u(bundle));
                        v0(bundle2, 5);
                        bundle2.remove(str3);
                        i11 = i12;
                        y10 = i10;
                        o9Var = this;
                    } else {
                        i11 = i12;
                    }
                }
            }
            y10 = i10;
            o9Var = this;
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m().R().equals(str);
    }

    public final long E0() {
        long j10 = this.f6299d.get();
        synchronized (this.f6299d) {
            if (j10 != 0) {
                this.f6299d.compareAndSet(-1L, 1L);
                return this.f6299d.getAndIncrement();
            }
            long nextLong = new Random(System.nanoTime() ^ f().a()).nextLong();
            int i10 = this.f6300e + 1;
            this.f6300e = i10;
            return nextLong + i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q F(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (w(str2, z12) != 0) {
            h().F().b("Invalid conditional property event name", j().A(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle D = D(str, str2, bundle2, g2.f.b("_o"), false, false);
        if (z10) {
            D = C(D);
        }
        return new q(str2, new p(D), str3, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object H(String str, Object obj) {
        if ("_ev".equals(str)) {
            return G(256, obj, true, true);
        }
        return G(C0(str) ? 256 : 100, obj, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom H0() {
        c();
        if (this.f6298c == null) {
            this.f6298c = new SecureRandom();
        }
        return this.f6298c;
    }

    public final URL J(long j10, String str, String str2, long j11) {
        try {
            b2.p.g(str2);
            b2.p.g(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j10), Integer.valueOf(K0())), str2, str, Long.valueOf(j11));
            if (str.equals(m().S())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            h().F().b("Failed to create BOW URL for Deferred Deep Link. exception", e10.getMessage());
            return null;
        }
    }

    public final int K0() {
        if (this.f6301f == null) {
            this.f6301f = Integer.valueOf(com.google.android.gms.common.c.h().b(i()) / 1000);
        }
        return this.f6301f.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            h().I().b("Params already contained engagement", Long.valueOf(j11));
        }
        bundle.putLong("_et", j10 + j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                k().N(bundle, str, bundle2.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            h().K().c("Not putting event parameter. Invalid value type. name, type", j().z(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final boolean N0() {
        try {
            i().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void O(rf rfVar, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning int value to wrapper", e10);
        }
    }

    public final void P(rf rfVar, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning long value to wrapper", e10);
        }
    }

    public final void Q(rf rfVar, Bundle bundle) {
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning bundle value to wrapper", e10);
        }
    }

    public final void R(rf rfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning string value to wrapper", e10);
        }
    }

    public final void S(rf rfVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning bundle list to wrapper", e10);
        }
    }

    public final void T(rf rfVar, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning boolean value to wrapper", e10);
        }
    }

    public final void U(rf rfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f6381a.h().I().b("Error returning byte array to wrapper", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void V(v3 v3Var, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(v3Var.f6547d.keySet())) {
            if (e0(str) && (i11 = i11 + 1) > i10) {
                StringBuilder sb2 = new StringBuilder(48);
                sb2.append("Event can't contain more than ");
                sb2.append(i10);
                sb2.append(" params");
                h().H().c(sb2.toString(), j().w(v3Var.f6544a), j().u(v3Var.f6547d));
                v0(v3Var.f6547d, 5);
                v3Var.f6547d.remove(str);
            }
        }
    }

    public final void W(r9 r9Var, int i10, String str, String str2, int i11) {
        X(r9Var, null, i10, str, str2, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(r9 r9Var, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        v0(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        if (ob.a() && m().t(s.O0)) {
            r9Var.a(str, bundle);
        } else {
            this.f6381a.F().R("auto", "_err", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    public final boolean f0(String str, double d10) {
        try {
            SharedPreferences.Editor edit = i().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return edit.commit();
        } catch (Exception e10) {
            h().F().b("Failed to persist Deferred Deep Link. exception", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g0(String str, int i10, String str2) {
        if (str2 == null) {
            h().H().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        h().H().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h0(String str, String str2) {
        if (str2 == null) {
            h().H().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            h().H().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            h().H().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                h().H().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i0(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i10) {
                h().K().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (L0(str)) {
                return true;
            }
            if (this.f6381a.J()) {
                h().H().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", r3.x(str));
            }
            return false;
        }
        if (md.a() && m().t(s.f6411j0) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f6381a.J()) {
                h().H().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (L0(str2)) {
            return true;
        }
        h().H().b("Invalid admob_app_id. Analytics disabled.", r3.x(str2));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m0(String str, String[] strArr, String str2) {
        return n0(str, strArr, null, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z10;
        if (str2 == null) {
            h().H().b("Name is required and can't be null. Type", str);
            return false;
        }
        b2.p.k(str2);
        String[] strArr3 = f6296g;
        int length = strArr3.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (str2.startsWith(strArr3[i10])) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            h().H().c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !l0(str2, strArr) || (strArr2 != null && l0(str2, strArr2))) {
            return true;
        }
        h().H().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final void o() {
        c();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                h().I().a("Utils falling back to Random for random id");
            }
        }
        this.f6299d.set(nextLong);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int q0(String str) {
        if (!w0("user property", str)) {
            return 6;
        }
        if (m0("user property", v2.k.f14631a, str)) {
            return !g0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int r0(String str, Object obj) {
        int M0;
        String str2;
        if ("_ldl".equals(str)) {
            M0 = M0(str);
            str2 = "user property referrer";
        } else {
            M0 = M0(str);
            str2 = "user property";
        }
        return i0(str2, str, M0, obj) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        return true;
    }

    public final int u(int i10) {
        return com.google.android.gms.common.c.h().j(i(), com.google.android.gms.common.e.f5095a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int w(String str, boolean z10) {
        if (!w0("event", str)) {
            return 2;
        }
        if (z10) {
            if (!n0("event", v2.i.f14627a, v2.i.f14628b, str)) {
                return 13;
            }
        } else if (!m0("event", v2.i.f14627a, str)) {
            return 13;
        }
        return !g0("event", 40, str) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean w0(String str, String str2) {
        if (str2 == null) {
            h().H().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            h().H().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            h().H().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                h().H().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0065 -> B:7:0x0072). Please report as a decompilation issue!!! */
    public final long y(Context context, String str) {
        c();
        b2.p.k(context);
        b2.p.g(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest J0 = J0();
        long j10 = -1;
        if (J0 == null) {
            h().F().a("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e10) {
                    h().F().b("Package name not found", e10);
                }
                if (!z0(context, str)) {
                    Signature[] signatureArr = i2.c.a(context).e(i().getPackageName(), 64).signatures;
                    if (signatureArr == null || signatureArr.length <= 0) {
                        h().I().a("Could not get signatures");
                    } else {
                        j10 = A(J0.digest(signatureArr[0].toByteArray()));
                    }
                }
            }
            j10 = 0;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object y0(String str, Object obj) {
        boolean equals = "_ldl".equals(str);
        int M0 = M0(str);
        return equals ? G(M0, obj, true, false) : G(M0, obj, false, false);
    }
}
