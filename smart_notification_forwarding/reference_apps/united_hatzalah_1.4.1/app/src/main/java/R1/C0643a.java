package r1;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p3.h;
import q1.C0622c;
import t1.m;

/* renamed from: r1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0643a implements m {

    /* renamed from: c, reason: collision with root package name */
    public static final String f6204c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f6205d;

    /* renamed from: e, reason: collision with root package name */
    public static final C0643a f6206e;

    /* renamed from: f, reason: collision with root package name */
    public static final C0643a f6207f;

    /* renamed from: a, reason: collision with root package name */
    public final String f6208a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6209b;

    static {
        String w3 = h.w("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f6204c = w3;
        String w4 = h.w("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String w5 = h.w("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f6205d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C0622c("proto"), new C0622c("json"))));
        f6206e = new C0643a(w3, null);
        f6207f = new C0643a(w4, w5);
    }

    public C0643a(String str, String str2) {
        this.f6208a = str;
        this.f6209b = str2;
    }

    public static C0643a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new C0643a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }
}
