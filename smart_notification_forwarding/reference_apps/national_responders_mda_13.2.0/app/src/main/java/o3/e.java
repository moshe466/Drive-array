package o3;

import android.content.Context;
import android.text.TextUtils;
import b2.o;
import b2.p;
import b2.s;
import g2.n;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f12484a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12485b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12486c;

    /* renamed from: d, reason: collision with root package name */
    private final String f12487d;

    /* renamed from: e, reason: collision with root package name */
    private final String f12488e;

    /* renamed from: f, reason: collision with root package name */
    private final String f12489f;

    /* renamed from: g, reason: collision with root package name */
    private final String f12490g;

    private e(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        p.o(!n.a(str), "ApplicationId must be set.");
        this.f12485b = str;
        this.f12484a = str2;
        this.f12486c = str3;
        this.f12487d = str4;
        this.f12488e = str5;
        this.f12489f = str6;
        this.f12490g = str7;
    }

    public static e a(Context context) {
        s sVar = new s(context);
        String a10 = sVar.a("google_app_id");
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return new e(a10, sVar.a("google_api_key"), sVar.a("firebase_database_url"), sVar.a("ga_trackingId"), sVar.a("gcm_defaultSenderId"), sVar.a("google_storage_bucket"), sVar.a("project_id"));
    }

    public String b() {
        return this.f12484a;
    }

    public String c() {
        return this.f12485b;
    }

    public String d() {
        return this.f12488e;
    }

    public String e() {
        return this.f12490g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return o.a(this.f12485b, eVar.f12485b) && o.a(this.f12484a, eVar.f12484a) && o.a(this.f12486c, eVar.f12486c) && o.a(this.f12487d, eVar.f12487d) && o.a(this.f12488e, eVar.f12488e) && o.a(this.f12489f, eVar.f12489f) && o.a(this.f12490g, eVar.f12490g);
    }

    public int hashCode() {
        return o.b(this.f12485b, this.f12484a, this.f12486c, this.f12487d, this.f12488e, this.f12489f, this.f12490g);
    }

    public String toString() {
        return o.c(this).a("applicationId", this.f12485b).a("apiKey", this.f12484a).a("databaseUrl", this.f12486c).a("gcmSenderId", this.f12488e).a("storageBucket", this.f12489f).a("projectId", this.f12490g).toString();
    }
}
