package com.google.firebase.messaging;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f7411d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    private final String f7412a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7413b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7414c;

    private b0(String str, String str2) {
        this.f7412a = d(str2, str);
        this.f7413b = str;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("!");
        sb2.append(str2);
        this.f7414c = sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new b0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2);
            str = str.substring(8);
        }
        if (str == null || !f7411d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public String b() {
        return this.f7413b;
    }

    public String c() {
        return this.f7412a;
    }

    public String e() {
        return this.f7414c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f7412a.equals(b0Var.f7412a) && this.f7413b.equals(b0Var.f7413b);
    }

    public int hashCode() {
        return b2.o.b(this.f7413b, this.f7412a);
    }
}
