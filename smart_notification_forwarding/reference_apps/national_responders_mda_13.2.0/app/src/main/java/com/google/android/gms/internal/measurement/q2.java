package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: classes.dex */
public final class q2 {

    /* renamed from: a, reason: collision with root package name */
    private static final l.a<String, Uri> f5544a = new l.a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (q2.class) {
            l.a<String, Uri> aVar = f5544a;
            uri = aVar.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                aVar.put(str, uri);
            }
        }
        return uri;
    }
}
