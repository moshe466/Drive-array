package P0;

import F0.AbstractC0008a;
import com.android.apksig.zip.ZipFormatException;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1574a = {"SHA-512", "SHA-384", "SHA-256", "SHA-1"};

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f1575b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f1576c;

    static {
        HashMap hashMap = new HashMap(8);
        f1575b = hashMap;
        hashMap.put("MD5", "MD5");
        hashMap.put("SHA", "SHA-1");
        hashMap.put("SHA1", "SHA-1");
        hashMap.put("SHA-1", "SHA-1");
        hashMap.put("SHA-256", "SHA-256");
        hashMap.put("SHA-384", "SHA-384");
        hashMap.put("SHA-512", "SHA-512");
        HashMap hashMap2 = new HashMap(5);
        f1576c = hashMap2;
        hashMap2.put("MD5", 0);
        hashMap2.put("SHA-1", 0);
        hashMap2.put("SHA-256", 0);
        hashMap2.put("SHA-384", 9);
        hashMap2.put("SHA-512", 9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (r1.isEmpty() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList a(U0.b r7, java.lang.String r8, int r9) {
        /*
            java.util.Base64$Decoder r0 = F0.m3.r()
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 1
            r1.<init>(r2)
            r2 = 18
            if (r9 >= r2) goto L79
            java.lang.String r2 = "Digest-Algorithms"
            java.lang.String r2 = r7.a(r2)
            if (r2 != 0) goto L18
            java.lang.String r2 = "SHA SHA1"
        L18:
            java.util.StringTokenizer r3 = new java.util.StringTokenizer
            r3.<init>(r2)
        L1d:
            boolean r2 = r3.hasMoreTokens()
            if (r2 == 0) goto L72
            java.lang.String r2 = r3.nextToken()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r7.a(r4)
            if (r4 != 0) goto L3d
            goto L1d
        L3d:
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r5)
            java.util.HashMap r6 = P0.e.f1575b
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L1d
            java.util.HashMap r6 = P0.e.f1576c
            java.lang.String r5 = r2.toUpperCase(r5)
            java.lang.Object r5 = r6.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L60
            int r5 = r5.intValue()
            goto L63
        L60:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L63:
            if (r5 <= r9) goto L66
            goto L1d
        L66:
            P0.b r9 = new P0.b
            byte[] r3 = F0.m3.A(r0, r4)
            r9.<init>(r2, r3)
            r1.add(r9)
        L72:
            boolean r9 = r1.isEmpty()
            if (r9 == 0) goto L79
            goto Lcc
        L79:
            r9 = 0
            r2 = r9
        L7b:
            r3 = 4
            if (r2 >= r3) goto Lcc
            java.lang.String[] r3 = P0.e.f1574a
            r3 = r3[r2]
            java.lang.String r4 = "SHA-1"
            boolean r4 = r4.equalsIgnoreCase(r3)
            if (r4 == 0) goto L91
            java.lang.String r4 = "SHA1"
            java.lang.String r4 = r4.concat(r8)
            goto L95
        L91:
            java.lang.String r4 = F0.AbstractC0008a.n(r3, r8)
        L95:
            java.lang.String r4 = r7.a(r4)
            if (r4 != 0) goto L9e
            int r2 = r2 + 1
            goto L7b
        L9e:
            byte[] r7 = F0.m3.A(r0, r4)
            int r8 = r1.size()
        La6:
            if (r9 >= r8) goto Lbb
            java.lang.Object r0 = r1.get(r9)
            int r9 = r9 + 1
            P0.b r0 = (P0.b) r0
            java.lang.String r2 = r0.f1561a
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto La6
            byte[] r8 = r0.f1562b
            goto Lbc
        Lbb:
            r8 = 0
        Lbc:
            if (r8 == 0) goto Lc4
            boolean r8 = java.util.Arrays.equals(r8, r7)
            if (r8 != 0) goto Lcc
        Lc4:
            P0.b r8 = new P0.b
            r8.<init>(r3, r7)
            r1.add(r8)
        Lcc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.e.a(U0.b, java.lang.String, int):java.util.ArrayList");
    }

    public static List b(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(((d) obj).f1567a);
        }
        return arrayList2;
    }

    public static ArrayList c(W0.d dVar, M0.c cVar) {
        long j2 = cVar.f1390b;
        if (j2 <= 2147483647L) {
            long j3 = cVar.f1389a;
            ByteBuffer c4 = dVar.c((int) j2, j3);
            c4.order(ByteOrder.LITTLE_ENDIAN);
            int i = cVar.f1391c;
            ArrayList arrayList = new ArrayList(i);
            for (int i3 = 0; i3 < i; i3++) {
                int position = c4.position();
                try {
                    X0.a b4 = X0.a.b(c4);
                    if (!b4.f2581g.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        arrayList.add(b4);
                    }
                } catch (ZipFormatException e4) {
                    throw new Exception("Malformed ZIP Central Directory record #" + (i3 + 1) + " at file offset " + (j3 + position), e4);
                }
            }
            return arrayList;
        }
        throw new Exception(AbstractC0008a.l("ZIP Central Directory too large: ", j2));
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0501  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static F0.C0093v1 d(W0.d r45, M0.c r46, java.util.Map r47, java.util.HashSet r48, int r49) {
        /*
            Method dump skipped, instructions count: 2644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.e.d(W0.d, M0.c, java.util.Map, java.util.HashSet, int):F0.v1");
    }
}
