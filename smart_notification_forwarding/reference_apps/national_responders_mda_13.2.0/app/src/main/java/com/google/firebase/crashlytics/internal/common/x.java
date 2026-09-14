package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class x implements y {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f7248f = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: g, reason: collision with root package name */
    private static final String f7249g = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    private final z f7250a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7251b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7252c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.installations.g f7253d;

    /* renamed from: e, reason: collision with root package name */
    private String f7254e;

    public x(Context context, String str, com.google.firebase.installations.g gVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f7251b = context;
        this.f7252c = str;
        this.f7253d = gVar;
        this.f7250a = new z();
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String c10;
        c10 = c(UUID.randomUUID().toString());
        s3.b.f().b("Created new Crashlytics IID: " + c10);
        sharedPreferences.edit().putString("crashlytics.installation.id", c10).putString("firebase.installation.id", str).apply();
        return c10;
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        return f7248f.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    private synchronized void i(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        s3.b.f().b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    private String j(String str) {
        return str.replaceAll(f7249g, "");
    }

    @Override // com.google.firebase.crashlytics.internal.common.y
    public synchronized String a() {
        String str;
        String b10;
        String str2 = this.f7254e;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences t10 = h.t(this.f7251b);
        z2.l<String> e10 = this.f7253d.e();
        String string = t10.getString("firebase.installation.id", null);
        try {
            str = (String) k0.a(e10);
        } catch (Exception e11) {
            s3.b.f().c("Failed to retrieve installation id", e11);
            str = string != null ? string : null;
        }
        if (string == null) {
            SharedPreferences o10 = h.o(this.f7251b);
            String string2 = o10.getString("crashlytics.installation.id", null);
            s3.b.f().b("No cached FID; legacy id is " + string2);
            if (string2 == null) {
                this.f7254e = b(str, t10);
            } else {
                this.f7254e = string2;
                i(string2, str, t10, o10);
            }
            return this.f7254e;
        }
        if (string.equals(str)) {
            this.f7254e = t10.getString("crashlytics.installation.id", null);
            s3.b.f().b("Found matching FID, using Crashlytics IID: " + this.f7254e);
            if (this.f7254e == null) {
                b10 = b(str, t10);
            }
            return this.f7254e;
        }
        b10 = b(str, t10);
        this.f7254e = b10;
        return this.f7254e;
    }

    public String d() {
        return this.f7252c;
    }

    public String e() {
        return this.f7250a.a(this.f7251b);
    }

    public String f() {
        return String.format(Locale.US, "%s/%s", j(Build.MANUFACTURER), j(Build.MODEL));
    }

    public String g() {
        return j(Build.VERSION.INCREMENTAL);
    }

    public String h() {
        return j(Build.VERSION.RELEASE);
    }
}
