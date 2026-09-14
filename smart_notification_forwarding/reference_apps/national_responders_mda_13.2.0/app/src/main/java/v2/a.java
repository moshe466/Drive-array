package v2;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f14619c = new a(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f14620a;

    /* renamed from: b, reason: collision with root package name */
    private final Boolean f14621b;

    public a(Boolean bool, Boolean bool2) {
        this.f14620a = bool;
        this.f14621b = bool2;
    }

    private static int a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean b(char c10) {
        if (c10 == '0') {
            return Boolean.FALSE;
        }
        if (c10 != '1') {
            return null;
        }
        return Boolean.TRUE;
    }

    private static Boolean c(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static String e(Bundle bundle) {
        String string = bundle.getString("ad_storage");
        if (string != null && k(string) == null) {
            return string;
        }
        String string2 = bundle.getString("analytics_storage");
        if (string2 == null || k(string2) != null) {
            return null;
        }
        return string2;
    }

    public static a f(String str) {
        Boolean bool;
        if (str != null) {
            Boolean b10 = str.length() >= 3 ? b(str.charAt(2)) : null;
            bool = str.length() >= 4 ? b(str.charAt(3)) : null;
            r0 = b10;
        } else {
            bool = null;
        }
        return new a(r0, bool);
    }

    public static boolean g(int i10, int i11) {
        return i10 <= i11;
    }

    private static char i(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    private static Boolean k(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static a l(Bundle bundle) {
        return bundle == null ? f14619c : new a(k(bundle.getString("ad_storage")), k(bundle.getString("analytics_storage")));
    }

    public final String d() {
        return "G1" + i(this.f14620a) + i(this.f14621b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a(this.f14620a) == a(aVar.f14620a) && a(this.f14621b) == a(aVar.f14621b);
    }

    public final boolean h(a aVar) {
        Boolean bool = this.f14620a;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || aVar.f14620a == bool2) {
            return this.f14621b == bool2 && aVar.f14621b != bool2;
        }
        return true;
    }

    public final int hashCode() {
        return ((a(this.f14620a) + 527) * 31) + a(this.f14621b);
    }

    public final Boolean j() {
        return this.f14620a;
    }

    public final a m(a aVar) {
        return new a(c(this.f14620a, aVar.f14620a), c(this.f14621b, aVar.f14621b));
    }

    public final a n(a aVar) {
        Boolean bool = this.f14620a;
        if (bool == null) {
            bool = aVar.f14620a;
        }
        Boolean bool2 = this.f14621b;
        if (bool2 == null) {
            bool2 = aVar.f14621b;
        }
        return new a(bool, bool2);
    }

    public final boolean o() {
        Boolean bool = this.f14620a;
        return bool == null || bool.booleanValue();
    }

    public final Boolean p() {
        return this.f14621b;
    }

    public final boolean q() {
        Boolean bool = this.f14621b;
        return bool == null || bool.booleanValue();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ConsentSettings: ");
        sb2.append("adStorage=");
        Boolean bool = this.f14620a;
        if (bool == null) {
            sb2.append("uninitialized");
        } else {
            sb2.append(bool.booleanValue() ? "granted" : "denied");
        }
        sb2.append(", analyticsStorage=");
        Boolean bool2 = this.f14621b;
        if (bool2 == null) {
            sb2.append("uninitialized");
        } else {
            sb2.append(bool2.booleanValue() ? "granted" : "denied");
        }
        return sb2.toString();
    }
}
