package N2;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f1524a;

    public e(String pattern) {
        kotlin.jvm.internal.j.e(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        kotlin.jvm.internal.j.d(compile, "compile(...)");
        this.f1524a = compile;
    }

    public final String toString() {
        String pattern = this.f1524a.toString();
        kotlin.jvm.internal.j.d(pattern, "toString(...)");
        return pattern;
    }
}
