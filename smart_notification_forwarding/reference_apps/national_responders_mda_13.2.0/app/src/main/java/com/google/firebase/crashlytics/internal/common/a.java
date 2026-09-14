package com.google.firebase.crashlytics.internal.common;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f7062e = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a, reason: collision with root package name */
    private final String f7063a;

    /* renamed from: b, reason: collision with root package name */
    private final y3.c f7064b;

    /* renamed from: c, reason: collision with root package name */
    private final y3.a f7065c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7066d;

    public a(String str, String str2, y3.c cVar, y3.a aVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.f7066d = str;
        this.f7063a = f(str2);
        this.f7064b = cVar;
        this.f7065c = aVar;
    }

    private String f(String str) {
        return !h.B(this.f7066d) ? f7062e.matcher(str).replaceFirst(this.f7066d) : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y3.b c() {
        return d(Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y3.b d(Map<String, String> map) {
        return this.f7064b.a(this.f7065c, e(), map).d("User-Agent", "Crashlytics Android SDK/" + m.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        return this.f7063a;
    }
}
