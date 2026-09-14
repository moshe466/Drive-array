package la;

import mb.r;
import y8.k;

/* loaded from: classes.dex */
public final class d {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11856a;

        static {
            int[] iArr = new int[h.valuesCustom().length];
            iArr[h.BEGINNING.ordinal()] = 1;
            iArr[h.AFTER_DOT.ordinal()] = 2;
            iArr[h.MIDDLE.ordinal()] = 3;
            f11856a = iArr;
        }
    }

    private static final boolean a(String str, String str2) {
        boolean w10;
        w10 = r.w(str, str2, false, 2, null);
        return w10 && str.charAt(str2.length()) == '.';
    }

    public static final boolean b(b bVar, b bVar2) {
        k.e(bVar, "<this>");
        k.e(bVar2, "packageName");
        if (k.a(bVar, bVar2) || bVar2.d()) {
            return true;
        }
        String b10 = bVar.b();
        k.d(b10, "this.asString()");
        String b11 = bVar2.b();
        k.d(b11, "packageName.asString()");
        return a(b10, b11);
    }

    public static final boolean c(String str) {
        if (str == null) {
            return false;
        }
        h hVar = h.BEGINNING;
        int i10 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            i10++;
            int i11 = a.f11856a[hVar.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                hVar = h.MIDDLE;
            } else if (i11 != 3) {
                continue;
            } else if (charAt == '.') {
                hVar = h.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return hVar != h.AFTER_DOT;
    }

    public static final b d(b bVar, b bVar2) {
        k.e(bVar, "<this>");
        k.e(bVar2, "prefix");
        if (!b(bVar, bVar2) || bVar2.d()) {
            return bVar;
        }
        if (k.a(bVar, bVar2)) {
            b bVar3 = b.f11846c;
            k.d(bVar3, "ROOT");
            return bVar3;
        }
        String b10 = bVar.b();
        k.d(b10, "asString()");
        String substring = b10.substring(bVar2.b().length() + 1);
        k.d(substring, "(this as java.lang.String).substring(startIndex)");
        return new b(substring);
    }
}
