package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import p4.f;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final o3.c f7311a;

    /* renamed from: b, reason: collision with root package name */
    private final s f7312b;

    /* renamed from: c, reason: collision with root package name */
    private final y1.d f7313c;

    /* renamed from: d, reason: collision with root package name */
    private final r4.b<x4.i> f7314d;

    /* renamed from: e, reason: collision with root package name */
    private final r4.b<p4.f> f7315e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.g f7316f;

    public p(o3.c cVar, s sVar, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar) {
        this(cVar, sVar, new y1.d(cVar.g()), bVar, bVar2, gVar);
    }

    p(o3.c cVar, s sVar, y1.d dVar, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar) {
        this.f7311a = cVar;
        this.f7312b = sVar;
        this.f7313c = dVar;
        this.f7314d = bVar;
        this.f7315e = bVar2;
        this.f7316f = gVar;
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private z2.l<String> b(z2.l<Bundle> lVar) {
        return lVar.h(h.a(), new z2.c(this) { // from class: com.google.firebase.iid.o

            /* renamed from: a, reason: collision with root package name */
            private final p f7310a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7310a = this;
            }

            @Override // z2.c
            public Object a(z2.l lVar2) {
                return this.f7310a.g(lVar2);
            }
        });
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(this.f7311a.i().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String e(Bundle bundle) {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        String valueOf = String.valueOf(bundle);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
        sb2.append("Unexpected response: ");
        sb2.append(valueOf);
        new Throwable();
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    private Bundle h(String str, String str2, String str3, Bundle bundle) {
        f.a a10;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f7311a.j().c());
        bundle.putString("gmsv", Integer.toString(this.f7312b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f7312b.a());
        bundle.putString("app_ver_name", this.f7312b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String b10 = ((com.google.firebase.installations.l) z2.o.a(this.f7316f.a(false))).b();
            if (!TextUtils.isEmpty(b10)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b10);
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        bundle.putString("cliv", "fiid-21.0.1");
        p4.f fVar = this.f7315e.get();
        x4.i iVar = this.f7314d.get();
        if (fVar != null && iVar != null && (a10 = fVar.a("fire-iid")) != f.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a10.getCode()));
            bundle.putString("Firebase-Client", iVar.a());
        }
        return bundle;
    }

    private z2.l<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f7313c.a(bundle);
    }

    public z2.l<String> d(String str, String str2, String str3) {
        return b(i(str, str2, str3, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String g(z2.l lVar) {
        return e((Bundle) lVar.m(IOException.class));
    }

    public z2.l<?> j(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return b(i(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }

    public z2.l<?> k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return b(i(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }
}
