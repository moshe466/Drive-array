package X1;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class l implements V1.a {

    /* renamed from: a, reason: collision with root package name */
    public final k f2616a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2617b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f2618c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2619d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        if (r4.equals("HMACSHA256") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(java.lang.String r4, javax.crypto.spec.SecretKeySpec r5) {
        /*
            r3 = this;
            r3.<init>()
            X1.k r0 = new X1.k
            r0.<init>(r3)
            r3.f2616a = r0
            r1 = 2
            boolean r2 = F0.AbstractC0008a.c(r1)
            if (r2 == 0) goto L8f
            r3.f2617b = r4
            r3.f2618c = r5
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            r2 = 16
            if (r5 < r2) goto L87
            int r5 = r4.hashCode()
            r2 = -1
            switch(r5) {
                case -1823053428: goto L52;
                case 392315023: goto L47;
                case 392315118: goto L3e;
                case 392316170: goto L33;
                case 392317873: goto L28;
                default: goto L26;
            }
        L26:
            r1 = r2
            goto L5c
        L28:
            java.lang.String r5 = "HMACSHA512"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L31
            goto L26
        L31:
            r1 = 4
            goto L5c
        L33:
            java.lang.String r5 = "HMACSHA384"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L3c
            goto L26
        L3c:
            r1 = 3
            goto L5c
        L3e:
            java.lang.String r5 = "HMACSHA256"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5c
            goto L26
        L47:
            java.lang.String r5 = "HMACSHA224"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L50
            goto L26
        L50:
            r1 = 1
            goto L5c
        L52:
            java.lang.String r5 = "HMACSHA1"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5b
            goto L26
        L5b:
            r1 = 0
        L5c:
            switch(r1) {
                case 0: goto L7f;
                case 1: goto L7a;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L6b;
                default: goto L5f;
            }
        L5f:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            java.lang.String r4 = r0.concat(r4)
            r5.<init>(r4)
            throw r5
        L6b:
            r4 = 64
            r3.f2619d = r4
            goto L83
        L70:
            r4 = 48
            r3.f2619d = r4
            goto L83
        L75:
            r4 = 32
            r3.f2619d = r4
            goto L83
        L7a:
            r4 = 28
            r3.f2619d = r4
            goto L83
        L7f:
            r4 = 20
            r3.f2619d = r4
        L83:
            r0.get()
            return
        L87:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "key size too small, need at least 16 bytes"
            r4.<init>(r5)
            throw r4
        L8f:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            java.lang.String r5 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: X1.l.<init>(java.lang.String, javax.crypto.spec.SecretKeySpec):void");
    }

    @Override // V1.a
    public final byte[] d(byte[] bArr, int i) {
        if (i <= this.f2619d) {
            k kVar = this.f2616a;
            ((Mac) kVar.get()).update(bArr);
            return Arrays.copyOf(((Mac) kVar.get()).doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
