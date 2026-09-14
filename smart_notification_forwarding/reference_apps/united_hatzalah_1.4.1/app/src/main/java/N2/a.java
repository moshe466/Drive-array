package N2;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f1508a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f1509b;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.j.d(forName, "forName(...)");
        f1508a = forName;
        kotlin.jvm.internal.j.d(Charset.forName("UTF-16"), "forName(...)");
        kotlin.jvm.internal.j.d(Charset.forName("UTF-16BE"), "forName(...)");
        kotlin.jvm.internal.j.d(Charset.forName("UTF-16LE"), "forName(...)");
        Charset forName2 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.j.d(forName2, "forName(...)");
        f1509b = forName2;
        kotlin.jvm.internal.j.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
