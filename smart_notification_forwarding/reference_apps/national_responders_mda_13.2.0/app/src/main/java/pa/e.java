package pa;

import bb.i0;
import java.util.Arrays;
import n9.d0;

/* loaded from: classes.dex */
public final class e extends o<Character> {
    public e(char c10) {
        super(Character.valueOf(c10));
    }

    private final String c(char c10) {
        return c10 == '\b' ? "\\b" : c10 == '\t' ? "\\t" : c10 == '\n' ? "\\n" : c10 == '\f' ? "\\f" : c10 == '\r' ? "\\r" : e(c10) ? String.valueOf(c10) : "?";
    }

    private final boolean e(char c10) {
        byte type = (byte) Character.getType(c10);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // pa.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 u10 = d0Var.w().u();
        y8.k.d(u10, "module.builtIns.charType");
        return u10;
    }

    @Override // pa.g
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        y8.k.d(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
