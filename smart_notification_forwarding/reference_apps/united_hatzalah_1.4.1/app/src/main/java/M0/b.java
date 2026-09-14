package M0;

import F0.AbstractC0008a;
import W0.g;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import p3.h;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final g[] f1387a = {new g('C', 2), new g('D', 3), new g('E', 4), new g('F', 7), new g('G', 8), new g('H', 10), new g('I', 13), new g('J', 15), new g('K', 18), new g('L', 20), new g('M', 22), new g('N', 23), new g('O', 25)};

    /* renamed from: b, reason: collision with root package name */
    public static final a f1388b = new a(0);

    public static d a(W0.d dVar, c cVar) {
        long j2 = cVar.f1389a;
        long j3 = cVar.f1390b + j2;
        long j4 = cVar.f1392d;
        if (j3 == j4) {
            if (j2 >= 32) {
                ByteBuffer c4 = dVar.c(24, j2 - 24);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                c4.order(byteOrder);
                if (c4.getLong(8) == 2334950737559900225L && c4.getLong(16) == 3617552046287187010L) {
                    long j5 = c4.getLong(0);
                    if (j5 >= c4.capacity() && j5 <= 2147483639) {
                        long j6 = (int) (8 + j5);
                        long j7 = j2 - j6;
                        if (j7 >= 0) {
                            ByteBuffer c5 = dVar.c(8, j7);
                            c5.order(byteOrder);
                            long j8 = c5.getLong(0);
                            if (j8 == j5) {
                                return new d(j7, dVar.e(j7, j6));
                            }
                            StringBuilder x3 = AbstractC0008a.x("APK Signing Block sizes in header and footer do not match: ", " vs ", j8);
                            x3.append(j5);
                            throw new Exception(x3.toString());
                        }
                        throw new Exception(AbstractC0008a.l("APK Signing Block offset out of range: ", j7));
                    }
                    throw new Exception(AbstractC0008a.l("APK Signing Block size out of range: ", j5));
                }
                throw new Exception("No APK Signing Block before ZIP Central Directory");
            }
            throw new Exception(AbstractC0008a.l("APK too small for APK Signing Block. ZIP Central Directory offset: ", j2));
        }
        StringBuilder x4 = AbstractC0008a.x("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: ", ", EoCD start: ", j3);
        x4.append(j4);
        throw new Exception(x4.toString());
    }

    public static c b(W0.d dVar) {
        g q3;
        if (dVar.size() < 22) {
            q3 = null;
        } else {
            g q4 = h.q(dVar, 0);
            if (q4 != null) {
                q3 = q4;
            } else {
                q3 = h.q(dVar, 65535);
            }
        }
        if (q3 != null) {
            ByteBuffer byteBuffer = (ByteBuffer) q3.f2458a;
            long longValue = ((Long) q3.f2459b).longValue();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            h.d(byteBuffer);
            long j2 = byteBuffer.getInt(byteBuffer.position() + 16) & KeyboardMap.kValueMask;
            if (j2 <= longValue) {
                h.d(byteBuffer);
                long j3 = byteBuffer.getInt(byteBuffer.position() + 12) & KeyboardMap.kValueMask;
                long j4 = j2 + j3;
                if (j4 <= longValue) {
                    h.d(byteBuffer);
                    return new c(j2, j3, byteBuffer.getShort(byteBuffer.position() + 10) & 65535, longValue, byteBuffer);
                }
                StringBuilder x3 = AbstractC0008a.x("ZIP Central Directory overlaps with End of Central Directory. CD end: ", ", EoCD start: ", j4);
                x3.append(longValue);
                throw new Exception(x3.toString());
            }
            StringBuilder x4 = AbstractC0008a.x("ZIP Central Directory start offset out of range: ", ". ZIP End of Central Directory offset: ", j2);
            x4.append(longValue);
            throw new Exception(x4.toString());
        }
        throw new Exception("ZIP End of Central Directory record not found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.nio.ByteBuffer r9, java.lang.String r10, int r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.b.c(java.nio.ByteBuffer, java.lang.String, int):int");
    }

    public static int d(String str) {
        char charAt;
        if (str.isEmpty()) {
            charAt = ' ';
        } else {
            charAt = str.charAt(0);
        }
        if (charAt >= 'A' && charAt <= 'Z') {
            g gVar = new g(Character.valueOf(charAt), null);
            a aVar = f1388b;
            g[] gVarArr = f1387a;
            int binarySearch = Arrays.binarySearch(gVarArr, gVar, aVar);
            if (binarySearch >= 0) {
                return ((Integer) gVarArr[binarySearch].f2459b).intValue();
            }
            if ((-1) - binarySearch == 0) {
                return 1;
            }
            g gVar2 = gVarArr[(-2) - binarySearch];
            return (charAt - ((Character) gVar2.f2458a).charValue()) + ((Integer) gVar2.f2459b).intValue();
        }
        throw new Exception(e0.a.e("Unable to determine APK's minimum supported Android platform version : Unsupported codename in AndroidManifest.xml's minSdkVersion: \"", str, "\""));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
    
        r2 = java.lang.Math.max(r2, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(java.nio.ByteBuffer r9) {
        /*
            N0.d r0 = new N0.d     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            r0.<init>(r9)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            int r9 = r0.f1439e     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            r1 = 1
            r2 = r1
        L9:
            r3 = 2
            if (r9 == r3) goto L86
            r4 = 3
            if (r9 != r4) goto L81
            int r9 = r0.f1438d     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r9 != r3) goto L81
            java.lang.String r9 = "uses-sdk"
            int r5 = r0.f1439e     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            r6 = 0
            r7 = 4
            if (r5 == r4) goto L1f
            if (r5 == r7) goto L1f
            r5 = r6
            goto L21
        L1f:
            java.lang.String r5 = r0.f1440f     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L21:
            boolean r9 = r9.equals(r5)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r9 == 0) goto L81
            int r9 = r0.f1439e     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r9 == r4) goto L2e
            if (r9 == r7) goto L2e
            goto L30
        L2e:
            java.lang.String r6 = r0.f1441g     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L30:
            boolean r9 = r6.isEmpty()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r9 == 0) goto L81
            r9 = 0
            r5 = r9
        L38:
            int r6 = r0.f1439e     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r6 == r4) goto L3e
            r6 = -1
            goto L40
        L3e:
            int r6 = r0.f1442h     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L40:
            if (r5 >= r6) goto L7c
            int r6 = r0.c(r5)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            r8 = 16843276(0x101020c, float:2.3695027E-38)
            if (r6 != r8) goto L79
            N0.a r6 = r0.a(r5)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            int r6 = r6.f1423b     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            if (r6 == r1) goto L5f
            if (r6 == r4) goto L5e
            switch(r6) {
                case 16: goto L5c;
                case 17: goto L5c;
                case 18: goto L5a;
                default: goto L58;
            }     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L58:
            r4 = r9
            goto L5f
        L5a:
            r4 = r7
            goto L5f
        L5c:
            r4 = r3
            goto L5f
        L5e:
            r4 = r1
        L5f:
            if (r4 == r1) goto L70
            if (r4 != r3) goto L68
            int r9 = r0.b(r5)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            goto L7d
        L68:
            com.android.apksig.apk.MinSdkVersionException r9 = new com.android.apksig.apk.MinSdkVersionException     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            java.lang.String r0 = "Unable to determine APK's minimum supported Android: unsupported value type in AndroidManifest.xml's minSdkVersion. Only integer values supported."
            r9.<init>(r0)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            throw r9     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L70:
            java.lang.String r9 = r0.d(r5)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            int r9 = d(r9)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            goto L7d
        L79:
            int r5 = r5 + 1
            goto L38
        L7c:
            r9 = r1
        L7d:
            int r2 = java.lang.Math.max(r2, r9)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
        L81:
            int r9 = r0.e()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser$XmlParserException -> L87
            goto L9
        L86:
            return r2
        L87:
            r9 = move-exception
            com.android.apksig.apk.MinSdkVersionException r0 = new com.android.apksig.apk.MinSdkVersionException
            java.lang.String r1 = "Unable to determine APK's minimum supported Android platform version: malformed binary resource: AndroidManifest.xml"
            r0.<init>(r1, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.b.e(java.nio.ByteBuffer):int");
    }
}
