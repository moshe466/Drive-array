package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class s implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final URL f7471f;

    /* renamed from: g, reason: collision with root package name */
    private z2.l<Bitmap> f7472g;

    /* renamed from: h, reason: collision with root package name */
    private volatile InputStream f7473h;

    private s(URL url) {
        this.f7471f = url;
    }

    private byte[] d() {
        URLConnection openConnection = this.f7471f.openConnection();
        if (openConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = openConnection.getInputStream();
        try {
            this.f7473h = inputStream;
            byte[] a10 = p2.g.a(p2.g.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                String valueOf = String.valueOf(this.f7471f);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                sb2.append("Downloaded ");
                sb2.append(a10.length);
                sb2.append(" bytes from ");
                sb2.append(valueOf);
            }
            if (a10.length <= 1048576) {
                return a10;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    p2.o.a(th, th2);
                }
            }
            throw th;
        }
    }

    public static s f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new s(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Not downloading image, bad URL: ".concat(valueOf);
            }
            return null;
        }
    }

    public Bitmap c() {
        String valueOf = String.valueOf(this.f7471f);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
        sb2.append("Starting download of: ");
        sb2.append(valueOf);
        byte[] d10 = d();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d10, 0, d10.length);
        if (decodeByteArray == null) {
            String valueOf2 = String.valueOf(this.f7471f);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 24);
            sb3.append("Failed to decode image: ");
            sb3.append(valueOf2);
            throw new IOException(sb3.toString());
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf3 = String.valueOf(this.f7471f);
            StringBuilder sb4 = new StringBuilder(valueOf3.length() + 31);
            sb4.append("Successfully downloaded image: ");
            sb4.append(valueOf3);
        }
        return decodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            p2.h.a(this.f7473h);
        } catch (NullPointerException unused) {
        }
    }

    public z2.l<Bitmap> g() {
        return (z2.l) b2.p.k(this.f7472g);
    }

    public void j(Executor executor) {
        this.f7472g = z2.o.c(executor, new Callable(this) { // from class: com.google.firebase.messaging.r

            /* renamed from: a, reason: collision with root package name */
            private final s f7470a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7470a = this;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return this.f7470a.c();
            }
        });
    }
}
