package com.google.android.datatransport.cct;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import k1.f;

/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: c, reason: collision with root package name */
    static final String f4681c;

    /* renamed from: d, reason: collision with root package name */
    static final String f4682d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f4683e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<i1.b> f4684f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f4685g;

    /* renamed from: a, reason: collision with root package name */
    private final String f4686a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4687b;

    static {
        String a10 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f4681c = a10;
        String a11 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f4682d = a11;
        String a12 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f4683e = a12;
        f4684f = Collections.unmodifiableSet(new HashSet(Arrays.asList(i1.b.b("proto"), i1.b.b("json"))));
        new a(a10, null);
        f4685g = new a(a11, a12);
    }

    public a(String str, String str2) {
        this.f4686a = str;
        this.f4687b = str2;
    }

    public static a e(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // k1.f
    public Set<i1.b> a() {
        return f4684f;
    }

    @Override // k1.e
    public byte[] b() {
        return d();
    }

    @Override // k1.e
    public String c() {
        return "cct";
    }

    public byte[] d() {
        String str = this.f4687b;
        if (str == null && this.f4686a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f4686a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String f() {
        return this.f4687b;
    }

    public String g() {
        return this.f4686a;
    }
}
