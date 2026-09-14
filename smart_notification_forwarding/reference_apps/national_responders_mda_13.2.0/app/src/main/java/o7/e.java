package o7;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f12570a = Pattern.compile("(.+):([0-9]+)");

    /* renamed from: b, reason: collision with root package name */
    public static l f12571b;

    public static o a(String str, String str2, g gVar) {
        return c(str, str2, gVar, null, true);
    }

    public static o b(String str, String str2, g gVar) {
        return c(str, str2, gVar, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o7.o c(java.lang.String r6, java.lang.String r7, o7.g r8, o7.i r9, boolean r10) {
        /*
            java.lang.String r0 = "Client"
            java.util.regex.Pattern r1 = o7.e.f12570a
            java.util.regex.Matcher r6 = r1.matcher(r6)
            r6.find()
            r1 = 1
            java.lang.String r1 = r6.group(r1)
            r2 = 2
            java.lang.String r6 = r6.group(r2)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r6 = r6.intValue()
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L4b
            r3.<init>()     // Catch: java.io.IOException -> L4b
            java.lang.String r4 = "open socketChannel "
            r3.append(r4)     // Catch: java.io.IOException -> L4b
            r3.append(r1)     // Catch: java.io.IOException -> L4b
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch: java.io.IOException -> L4b
            r3.append(r6)     // Catch: java.io.IOException -> L4b
            java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> L4b
            v7.b.a(r0, r3)     // Catch: java.io.IOException -> L4b
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch: java.io.IOException -> L4b
            r3.<init>(r1, r6)     // Catch: java.io.IOException -> L4b
            java.nio.channels.SocketChannel r6 = java.nio.channels.SocketChannel.open(r3)     // Catch: java.io.IOException -> L4b
            java.lang.String r1 = "open socketChannel success"
            v7.b.a(r0, r1)     // Catch: java.io.IOException -> L49
            goto L6d
        L49:
            r1 = move-exception
            goto L4d
        L4b:
            r1 = move-exception
            r6 = r2
        L4d:
            java.lang.String r3 = r1.getMessage()
            v7.b.a(r0, r3)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[DIPIO][PTT] Cannot create TCP connection due to an exception "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.println(r3)
            r1.printStackTrace()
        L6d:
            if (r10 == 0) goto L80
            o7.o r10 = new o7.o
            java.lang.String r0 = "DCS Writer"
            r10.<init>(r6, r0)
            o7.p r1 = o7.p.d()
            r1.e(r6, r8, r10, r0)
            java.lang.String r8 = "DCS Reader"
            goto L90
        L80:
            o7.o r10 = new o7.o
            java.lang.String r0 = "DSS Writer"
            r10.<init>(r6, r0)
            o7.p r1 = o7.p.d()
            r1.e(r6, r8, r10, r0)
            java.lang.String r8 = "DSS Reader"
        L90:
            o7.n r0 = new o7.n
            r0.<init>(r7, r10, r9, r8)
            o7.p r7 = o7.p.d()
            r7.e(r6, r2, r0, r8)
            r0.w()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.e.c(java.lang.String, java.lang.String, o7.g, o7.i, boolean):o7.o");
    }
}
