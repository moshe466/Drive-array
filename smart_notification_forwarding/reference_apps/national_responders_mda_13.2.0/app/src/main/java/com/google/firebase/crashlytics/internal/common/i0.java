package com.google.firebase.crashlytics.internal.common;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private String f7103a = null;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f7104b = new ConcurrentHashMap<>();

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f7104b);
    }

    public String b() {
        return this.f7103a;
    }

    public void d(String str) {
        this.f7103a = c(str);
    }
}
