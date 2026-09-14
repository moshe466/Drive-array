package z6;

import com.opentok.otc.opentokJNI;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f16234c = new a("OTC_SUCCESS", opentokJNI.OTC_SUCCESS_get());

    /* renamed from: a, reason: collision with root package name */
    private final int f16235a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16236b;

    static {
        new a("OTC_FALSE", opentokJNI.OTC_FALSE_get());
        new a("OTC_TRUE", opentokJNI.OTC_TRUE_get());
    }

    private a(String str, int i10) {
        this.f16236b = str;
        this.f16235a = i10;
    }

    public final int a() {
        return this.f16235a;
    }

    public String toString() {
        return this.f16236b;
    }
}
