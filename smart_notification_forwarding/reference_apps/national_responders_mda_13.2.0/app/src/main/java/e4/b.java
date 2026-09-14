package e4;

import i1.e;
import java.nio.charset.Charset;
import w3.v;

/* loaded from: classes.dex */
final /* synthetic */ class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final b f9142a = new b();

    private b() {
    }

    public static e a() {
        return f9142a;
    }

    @Override // i1.e
    public Object apply(Object obj) {
        byte[] bytes;
        bytes = c.f9143b.E((v) obj).getBytes(Charset.forName("UTF-8"));
        return bytes;
    }
}
