package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final URL f6661f;

    /* renamed from: g, reason: collision with root package name */
    private final w6 f6662g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6663h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ x6 f6664i;

    public z6(x6 x6Var, String str, URL url, byte[] bArr, Map<String, String> map, w6 w6Var) {
        this.f6664i = x6Var;
        b2.p.g(str);
        b2.p.k(url);
        b2.p.k(w6Var);
        this.f6661f = url;
        this.f6662g = w6Var;
        this.f6663h = str;
    }

    private final void b(final int i10, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f6664i.e().z(new Runnable(this, i10, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.y6

            /* renamed from: f, reason: collision with root package name */
            private final z6 f6637f;

            /* renamed from: g, reason: collision with root package name */
            private final int f6638g;

            /* renamed from: h, reason: collision with root package name */
            private final Exception f6639h;

            /* renamed from: i, reason: collision with root package name */
            private final byte[] f6640i;

            /* renamed from: j, reason: collision with root package name */
            private final Map f6641j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f6637f = this;
                this.f6638g = i10;
                this.f6639h = exc;
                this.f6640i = bArr;
                this.f6641j = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f6637f.a(this.f6638g, this.f6639h, this.f6640i, this.f6641j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i10, Exception exc, byte[] bArr, Map map) {
        this.f6662g.a(this.f6663h, i10, exc, bArr, map);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        byte[] w10;
        this.f6664i.b();
        int i10 = 0;
        try {
            httpURLConnection = this.f6664i.u(this.f6661f);
            try {
                i10 = httpURLConnection.getResponseCode();
                map = httpURLConnection.getHeaderFields();
                try {
                    x6 x6Var = this.f6664i;
                    w10 = x6.w(httpURLConnection);
                    httpURLConnection.disconnect();
                    b(i10, null, w10, map);
                } catch (IOException e10) {
                    e = e10;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(i10, e, null, map);
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(i10, null, null, map);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                map = null;
            } catch (Throwable th2) {
                th = th2;
                map = null;
            }
        } catch (IOException e12) {
            e = e12;
            httpURLConnection = null;
            map = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            map = null;
        }
    }
}
