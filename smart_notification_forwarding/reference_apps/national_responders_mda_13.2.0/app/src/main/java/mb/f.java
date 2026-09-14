package mb;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final Pattern f12130f;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            y8.k.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            y8.k.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.f.<init>(java.lang.String):void");
    }

    public f(Pattern pattern) {
        y8.k.e(pattern, "nativePattern");
        this.f12130f = pattern;
    }

    public final d a(CharSequence charSequence) {
        d c10;
        y8.k.e(charSequence, "input");
        Matcher matcher = this.f12130f.matcher(charSequence);
        y8.k.d(matcher, "nativePattern.matcher(input)");
        c10 = g.c(matcher, charSequence);
        return c10;
    }

    public final boolean b(CharSequence charSequence) {
        y8.k.e(charSequence, "input");
        return this.f12130f.matcher(charSequence).matches();
    }

    public final String c(CharSequence charSequence, String str) {
        y8.k.e(charSequence, "input");
        y8.k.e(str, "replacement");
        String replaceAll = this.f12130f.matcher(charSequence).replaceAll(str);
        y8.k.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f12130f.toString();
        y8.k.d(pattern, "nativePattern.toString()");
        return pattern;
    }
}
