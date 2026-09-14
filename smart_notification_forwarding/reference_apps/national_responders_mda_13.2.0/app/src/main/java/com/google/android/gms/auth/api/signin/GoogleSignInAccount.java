package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b2.p;
import c2.c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g2.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends c2.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final int f4726f;

    /* renamed from: g, reason: collision with root package name */
    private String f4727g;

    /* renamed from: h, reason: collision with root package name */
    private String f4728h;

    /* renamed from: i, reason: collision with root package name */
    private String f4729i;

    /* renamed from: j, reason: collision with root package name */
    private String f4730j;

    /* renamed from: k, reason: collision with root package name */
    private Uri f4731k;

    /* renamed from: l, reason: collision with root package name */
    private String f4732l;

    /* renamed from: m, reason: collision with root package name */
    private long f4733m;

    /* renamed from: n, reason: collision with root package name */
    private String f4734n;

    /* renamed from: o, reason: collision with root package name */
    List f4735o;

    /* renamed from: p, reason: collision with root package name */
    private String f4736p;

    /* renamed from: q, reason: collision with root package name */
    private String f4737q;

    /* renamed from: r, reason: collision with root package name */
    private Set f4738r = new HashSet();

    static {
        h.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i10, String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, List list, String str7, String str8) {
        this.f4726f = i10;
        this.f4727g = str;
        this.f4728h = str2;
        this.f4729i = str3;
        this.f4730j = str4;
        this.f4731k = uri;
        this.f4732l = str5;
        this.f4733m = j10;
        this.f4734n = str6;
        this.f4735o = list;
        this.f4736p = str7;
        this.f4737q = str8;
    }

    public static GoogleSignInAccount A(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        GoogleSignInAccount z10 = z(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        z10.f4732l = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return z10;
    }

    public static GoogleSignInAccount z(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l10, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l10.longValue(), p.g(str7), new ArrayList((Collection) p.k(set)), str5, str6);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f4734n.equals(this.f4734n) && googleSignInAccount.x().equals(x());
    }

    public Account g() {
        String str = this.f4729i;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public int hashCode() {
        return ((this.f4734n.hashCode() + 527) * 31) + x().hashCode();
    }

    public String j() {
        return this.f4730j;
    }

    public String l() {
        return this.f4729i;
    }

    public String s() {
        return this.f4737q;
    }

    public String t() {
        return this.f4736p;
    }

    public String u() {
        return this.f4727g;
    }

    public String v() {
        return this.f4728h;
    }

    public Uri w() {
        return this.f4731k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c.a(parcel);
        c.k(parcel, 1, this.f4726f);
        c.q(parcel, 2, u(), false);
        c.q(parcel, 3, v(), false);
        c.q(parcel, 4, l(), false);
        c.q(parcel, 5, j(), false);
        c.o(parcel, 6, w(), i10, false);
        c.q(parcel, 7, y(), false);
        c.m(parcel, 8, this.f4733m);
        c.q(parcel, 9, this.f4734n, false);
        c.t(parcel, 10, this.f4735o, false);
        c.q(parcel, 11, t(), false);
        c.q(parcel, 12, s(), false);
        c.b(parcel, a10);
    }

    public Set<Scope> x() {
        HashSet hashSet = new HashSet(this.f4735o);
        hashSet.addAll(this.f4738r);
        return hashSet;
    }

    public String y() {
        return this.f4732l;
    }
}
