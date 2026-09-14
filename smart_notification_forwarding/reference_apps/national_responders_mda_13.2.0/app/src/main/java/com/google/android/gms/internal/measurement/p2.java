package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes.dex */
public final class p2 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, String>> f5528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p2(Map<String, Map<String, String>> map) {
        this.f5528a = map;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        Map<String, String> map = this.f5528a.get(uri.toString());
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            str3 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return map.get(str3);
    }
}
