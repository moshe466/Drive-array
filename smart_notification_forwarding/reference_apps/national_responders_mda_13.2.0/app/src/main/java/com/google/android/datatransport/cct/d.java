package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import j1.j;
import j1.k;
import j1.l;
import j1.m;
import j1.n;
import j1.o;
import j1.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import k1.h;
import l1.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private final l4.a f4690a;

    /* renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f4691b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f4692c;

    /* renamed from: d, reason: collision with root package name */
    final URL f4693d;

    /* renamed from: e, reason: collision with root package name */
    private final t1.a f4694e;

    /* renamed from: f, reason: collision with root package name */
    private final t1.a f4695f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4696g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final URL f4697a;

        /* renamed from: b, reason: collision with root package name */
        final j f4698b;

        /* renamed from: c, reason: collision with root package name */
        final String f4699c;

        a(URL url, j jVar, String str) {
            this.f4697a = url;
            this.f4698b = jVar;
            this.f4699c = str;
        }

        a a(URL url) {
            return new a(url, this.f4698b, this.f4699c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f4700a;

        /* renamed from: b, reason: collision with root package name */
        final URL f4701b;

        /* renamed from: c, reason: collision with root package name */
        final long f4702c;

        b(int i10, URL url, long j10) {
            this.f4700a = i10;
            this.f4701b = url;
            this.f4702c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, t1.a aVar, t1.a aVar2) {
        this(context, aVar, aVar2, 40000);
    }

    d(Context context, t1.a aVar, t1.a aVar2, int i10) {
        this.f4690a = j.b();
        this.f4692c = context;
        this.f4691b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f4693d = m(com.google.android.datatransport.cct.a.f4681c);
        this.f4694e = aVar2;
        this.f4695f = aVar;
        this.f4696g = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b d(a aVar) {
        n1.a.a("CctTransportBackend", "Making request to: %s", aVar.f4697a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f4697a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f4696g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.3"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f4699c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f4690a.b(aVar.f4698b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    n1.a.e("CctTransportBackend", "Status Code: " + responseCode);
                    n1.a.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    n1.a.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream l10 = l(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(l10))).c());
                            if (l10 != null) {
                                l10.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (l10 != null) {
                                try {
                                    l10.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (ConnectException e10) {
            e = e10;
            n1.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            n1.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            n1.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (l4.b e13) {
            e = e13;
            n1.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int e(NetworkInfo networkInfo) {
        o.b bVar;
        if (networkInfo == null) {
            bVar = o.b.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            int subtype = networkInfo.getSubtype();
            if (subtype != -1) {
                if (o.b.forNumber(subtype) != null) {
                    return subtype;
                }
                return 0;
            }
            bVar = o.b.COMBINED;
        }
        return bVar.getValue();
    }

    private static int f(NetworkInfo networkInfo) {
        return networkInfo == null ? o.c.NONE.getValue() : networkInfo.getType();
    }

    private static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            n1.a.c("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    private j h(com.google.android.datatransport.runtime.backends.d dVar) {
        l.a j10;
        HashMap hashMap = new HashMap();
        for (h hVar : dVar.b()) {
            String j11 = hVar.j();
            if (hashMap.containsKey(j11)) {
                ((List) hashMap.get(j11)).add(hVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hVar);
                hashMap.put(j11, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            h hVar2 = (h) ((List) entry.getValue()).get(0);
            m.a b10 = m.a().f(p.DEFAULT).g(this.f4695f.a()).h(this.f4694e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(j1.a.a().m(Integer.valueOf(hVar2.g("sdk-version"))).j(hVar2.b("model")).f(hVar2.b("hardware")).d(hVar2.b("device")).l(hVar2.b("product")).k(hVar2.b("os-uild")).h(hVar2.b("manufacturer")).e(hVar2.b("fingerprint")).c(hVar2.b("country")).g(hVar2.b("locale")).i(hVar2.b("mcc_mnc")).b(hVar2.b("application_build")).a()).a());
            try {
                b10.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b10.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (h hVar3 : (List) entry.getValue()) {
                k1.g e10 = hVar3.e();
                i1.b b11 = e10.b();
                if (b11.equals(i1.b.b("proto"))) {
                    j10 = l.j(e10.a());
                } else if (b11.equals(i1.b.b("json"))) {
                    j10 = l.i(new String(e10.a(), Charset.forName("UTF-8")));
                } else {
                    n1.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b11);
                }
                j10.c(hVar3.f()).d(hVar3.k()).h(hVar3.h("tz-offset")).e(o.a().c(o.c.forNumber(hVar3.g("net-type"))).b(o.b.forNumber(hVar3.g("mobile-subtype"))).a());
                if (hVar3.d() != null) {
                    j10.b(hVar3.d());
                }
                arrayList3.add(j10.a());
            }
            b10.c(arrayList3);
            arrayList2.add(b10.a());
        }
        return j.a(arrayList2);
    }

    private static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long j() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.f4701b;
        if (url == null) {
            return null;
        }
        n1.a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f4701b);
    }

    private static InputStream l(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    @Override // l1.g
    public h a(h hVar) {
        NetworkInfo activeNetworkInfo = this.f4691b.getActiveNetworkInfo();
        return hVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", j()).a("net-type", f(activeNetworkInfo)).a("mobile-subtype", e(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", i(this.f4692c).getSimOperator()).c("application_build", Integer.toString(g(this.f4692c))).d();
    }

    @Override // l1.g
    public com.google.android.datatransport.runtime.backends.e b(com.google.android.datatransport.runtime.backends.d dVar) {
        j h10 = h(dVar);
        URL url = this.f4693d;
        if (dVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a e10 = com.google.android.datatransport.cct.a.e(dVar.c());
                r3 = e10.f() != null ? e10.f() : null;
                if (e10.g() != null) {
                    url = m(e10.g());
                }
            } catch (IllegalArgumentException unused) {
                return com.google.android.datatransport.runtime.backends.e.a();
            }
        }
        try {
            b bVar = (b) o1.b.a(5, new a(url, h10, r3), com.google.android.datatransport.cct.b.a(this), c.b());
            int i10 = bVar.f4700a;
            if (i10 == 200) {
                return com.google.android.datatransport.runtime.backends.e.d(bVar.f4702c);
            }
            if (i10 < 500 && i10 != 404) {
                return com.google.android.datatransport.runtime.backends.e.a();
            }
            return com.google.android.datatransport.runtime.backends.e.e();
        } catch (IOException e11) {
            n1.a.c("CctTransportBackend", "Could not make request to the backend", e11);
            return com.google.android.datatransport.runtime.backends.e.e();
        }
    }
}
