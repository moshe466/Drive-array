package r9;

import mb.r;

/* loaded from: classes.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(la.a aVar) {
        String t10;
        String b10 = aVar.i().b();
        y8.k.d(b10, "relativeClassName.asString()");
        t10 = r.t(b10, '.', '$', false, 4, null);
        if (aVar.h().d()) {
            return t10;
        }
        return aVar.h() + '.' + t10;
    }
}
