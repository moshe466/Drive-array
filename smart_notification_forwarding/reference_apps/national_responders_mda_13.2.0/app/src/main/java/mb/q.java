package mb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static Byte e(String str, int i10) {
        Integer g10;
        int intValue;
        y8.k.e(str, "<this>");
        g10 = g(str, i10);
        if (g10 == null || (intValue = g10.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    public static Integer f(String str) {
        Integer g10;
        y8.k.e(str, "<this>");
        g10 = g(str, 10);
        return g10;
    }

    public static Integer g(String str, int i10) {
        boolean z10;
        int i11;
        y8.k.e(str, "<this>");
        a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        int i13 = -2147483647;
        int i14 = 1;
        if (y8.k.f(charAt, 48) >= 0) {
            z10 = false;
            i14 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i13 = Integer.MIN_VALUE;
                z10 = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z10 = false;
            }
        }
        int i15 = -59652323;
        while (i14 < length) {
            int b10 = a.b(str.charAt(i14), i10);
            if (b10 < 0) {
                return null;
            }
            if ((i12 < i15 && (i15 != -59652323 || i12 < (i15 = i13 / i10))) || (i11 = i12 * i10) < i13 + b10) {
                return null;
            }
            i12 = i11 - b10;
            i14++;
        }
        return z10 ? Integer.valueOf(i12) : Integer.valueOf(-i12);
    }

    public static Long h(String str) {
        Long i10;
        y8.k.e(str, "<this>");
        i10 = i(str, 10);
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Long i(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            y8.k.e(r0, r2)
            mb.a.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = y8.k.f(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r6 >= 0) goto L39
            if (r2 != r9) goto L2a
            return r3
        L2a:
            r6 = 45
            if (r5 != r6) goto L32
            r7 = -9223372036854775808
            r4 = 1
            goto L3a
        L32:
            r6 = 43
            if (r5 != r6) goto L38
            r4 = 1
            goto L39
        L38:
            return r3
        L39:
            r9 = 0
        L3a:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L42:
            if (r4 >= r2) goto L73
            char r14 = r0.charAt(r4)
            int r14 = mb.a.b(r14, r1)
            if (r14 >= 0) goto L4f
            return r3
        L4f:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L5e
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
        L5e:
            return r3
        L5f:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L6a
            return r3
        L6a:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L73:
            if (r9 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L7f
        L7a:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.q.i(java.lang.String, int):java.lang.Long");
    }

    public static Short j(String str, int i10) {
        Integer g10;
        int intValue;
        y8.k.e(str, "<this>");
        g10 = g(str, i10);
        if (g10 == null || (intValue = g10.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
