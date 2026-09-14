package p3;

import F0.AbstractC0008a;
import F0.AbstractC0014b1;
import F0.AbstractC0044j;
import F0.AbstractC0083t;
import F0.AbstractC0099x;
import F0.B0;
import F0.D;
import F0.D1;
import F0.S;
import F0.j3;
import F2.l;
import K1.m;
import N0.q;
import N0.r;
import N0.t;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.view.View;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.NoApkSupportedSignaturesException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import io.flutter.embedding.android.KeyboardMap;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import k0.C0472C;
import k0.u;
import kotlin.jvm.internal.j;
import m.t1;
import m.v1;
import org.apache.tika.fork.ForkServer;
import org.apache.tika.utils.StringUtils;
import q.E;
import q.F;

/* loaded from: classes.dex */
public abstract class h implements M.g {

    /* renamed from: a, reason: collision with root package name */
    public static g f5988a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5989b = false;

    public static void D(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            t1.a(view, charSequence);
            return;
        }
        v1 v1Var = v1.f5800n;
        if (v1Var != null && v1Var.f5802a == view) {
            v1.b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            v1 v1Var2 = v1.f5801o;
            if (v1Var2 != null && v1Var2.f5802a == view) {
                v1Var2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new v1(view, charSequence);
    }

    public static void E(ByteBuffer byteBuffer, long j2) {
        d(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j2 >= 0 && j2 <= KeyboardMap.kValueMask) {
            byteBuffer.putInt(position, (int) j2);
            return;
        }
        throw new IllegalArgumentException(AbstractC0008a.l("uint32 value of out range: ", j2));
    }

    public static String F(int i, int i3) {
        String str;
        String G3 = G(i);
        if (i3 != 16) {
            if (i3 != 17) {
                if (i3 != 23) {
                    if (i3 != 24) {
                        switch (i3) {
                            case 1:
                                str = "BOOLEAN";
                                break;
                            case 2:
                                str = "INTEGER";
                                break;
                            case 3:
                                str = "BIT STRING";
                                break;
                            case 4:
                                str = "OCTET STRING";
                                break;
                            case 5:
                                str = "NULL";
                                break;
                            case 6:
                                str = "OBJECT IDENTIFIER";
                                break;
                            default:
                                str = "0x" + Integer.toHexString(i3);
                                break;
                        }
                    } else {
                        str = "GENERALIZED TIME";
                    }
                } else {
                    str = "UTC TIME";
                }
            } else {
                str = "SET";
            }
        } else {
            str = "SEQUENCE";
        }
        if (G3.isEmpty()) {
            return str;
        }
        return AbstractC0008a.o(G3, StringUtils.SPACE, str);
    }

    public static String G(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "PRIVATE";
                    }
                    throw new IllegalArgumentException(e0.a.c(i, "Unsupported type class: "));
                }
                return "";
            }
            return "APPLICATION";
        }
        return "UNIVERSAL";
    }

    public static void H(byte[] bArr, long j2, int i) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }

    public static void I(byte[] bArr, int i, W0.e eVar, ByteBuffer byteBuffer, N0.e eVar2) {
        ArrayList arrayList = new ArrayList(1);
        int i3 = 0;
        int i4 = 0;
        while (byteBuffer.hasRemaining()) {
            i4++;
            try {
                ByteBuffer c4 = q.c(byteBuffer);
                int i5 = c4.getInt();
                byte[] e4 = q.e(c4);
                t a2 = t.a(i5);
                if (a2 == null) {
                    eVar2.f1448d.add(new L0.a(19, Integer.valueOf(i5)));
                } else {
                    arrayList.add(new r(a2, e4));
                }
            } catch (ApkFormatException | BufferUnderflowException unused) {
                eVar2.a(20, Integer.valueOf(i4));
                return;
            }
        }
        if (arrayList.isEmpty()) {
            eVar2.a(17, new Object[0]);
            return;
        }
        try {
            ArrayList d2 = q.d(arrayList, i, Api.BaseClientBuilder.API_PRIORITY_OTHER, true);
            int size = d2.size();
            while (i3 < size) {
                Object obj = d2.get(i3);
                i3++;
                r rVar = (r) obj;
                t tVar = rVar.f1483a;
                W0.g gVar = tVar.f1497d;
                String str = (String) gVar.f2458a;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) gVar.f2459b;
                PublicKey publicKey = eVar.f2453a.getPublicKey();
                try {
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(publicKey);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(bArr);
                    if (!signature.verify(rVar.f1484b)) {
                        eVar2.a(21, tVar);
                        return;
                    }
                } catch (InvalidAlgorithmParameterException e5) {
                    e = e5;
                    eVar2.a(22, tVar, e);
                    return;
                } catch (InvalidKeyException e6) {
                    e = e6;
                    eVar2.a(22, tVar, e);
                    return;
                } catch (NoSuchAlgorithmException e7) {
                    e = e7;
                    eVar2.a(22, tVar, e);
                    return;
                } catch (SignatureException e8) {
                    e = e8;
                    eVar2.a(22, tVar, e);
                    return;
                }
            }
        } catch (NoApkSupportedSignaturesException e9) {
            StringBuilder sb = new StringBuilder();
            int size2 = arrayList.size();
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                r rVar2 = (r) obj2;
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(rVar2.f1483a);
            }
            eVar2.a(26, sb.toString(), e9);
        }
    }

    public static void J(ByteBuffer byteBuffer, CertificateFactory certificateFactory, N0.e eVar, HashMap hashMap, byte[] bArr, int i) {
        ArrayList arrayList = eVar.f1448d;
        byte[] e4 = q.e(byteBuffer);
        W0.e eVar2 = null;
        try {
            W0.e eVar3 = new W0.e((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(e4)), e4);
            eVar.f1446b.add(eVar3);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(e4);
            byte[] digest = messageDigest.digest();
            if (!Arrays.equals(bArr, digest)) {
                eVar.a(27, q.f(digest), q.f(bArr));
            } else {
                eVar2 = eVar3;
            }
        } catch (CertificateException e5) {
            eVar.a(18, e5);
        }
        if (!eVar.c() && !eVar.b()) {
            ByteBuffer c4 = q.c(byteBuffer);
            HashMap hashMap2 = new HashMap();
            while (c4.hasRemaining()) {
                ByteBuffer c5 = q.c(c4);
                int i3 = c5.getInt();
                hashMap2.put(Integer.valueOf(i3), q.c(c5));
            }
            Iterator it = hashMap.entrySet().iterator();
            while (true) {
                int i4 = 0;
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() == 31) {
                        arrayList.add(new L0.a(39, 31));
                    } else {
                        if (!hashMap2.containsKey(entry.getKey())) {
                            eVar.a(17, new Object[0]);
                            return;
                        }
                        I((byte[]) entry.getValue(), i, eVar2, (ByteBuffer) hashMap2.get(entry.getKey()), eVar);
                        if (eVar.c() || eVar.b()) {
                            return;
                        }
                    }
                } else {
                    if (byteBuffer.hasRemaining()) {
                        ByteBuffer c6 = q.c(byteBuffer);
                        ByteBuffer c7 = q.c(byteBuffer);
                        byte[] bArr2 = new byte[c6.remaining()];
                        c6.get(bArr2);
                        c6.flip();
                        I(bArr2, i, eVar2, c7, eVar);
                        if (!eVar.b() && !eVar.c()) {
                            ByteBuffer c8 = q.c(c6);
                            while (c8.hasRemaining()) {
                                i4++;
                                try {
                                    ByteBuffer c9 = q.c(c8);
                                    int i5 = c9.getInt();
                                    byte[] bArr3 = new byte[c9.remaining()];
                                    c9.get(bArr3);
                                    if (i5 == -1654455305) {
                                        z(bArr3, eVar2, eVar);
                                    } else if (i5 == -465807034) {
                                        long j2 = ByteBuffer.wrap(bArr3).order(ByteOrder.LITTLE_ENDIAN).getLong();
                                        if (j2 <= 0) {
                                            eVar.a(38, Long.valueOf(j2));
                                        }
                                    } else {
                                        arrayList.add(new L0.a(32, Integer.valueOf(i5)));
                                    }
                                } catch (ApkFormatException | BufferUnderflowException unused) {
                                    eVar.a(31, Integer.valueOf(i4));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static BiometricPrompt.CryptoObject K(m mVar) {
        IdentityCredential identityCredential;
        if (mVar == null) {
            return null;
        }
        Cipher cipher = (Cipher) mVar.f1103b;
        if (cipher != null) {
            return E.b(cipher);
        }
        Signature signature = (Signature) mVar.f1102a;
        if (signature != null) {
            return E.a(signature);
        }
        Mac mac = (Mac) mVar.f1104c;
        if (mac != null) {
            return E.c(mac);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredential = (IdentityCredential) mVar.f1105d) == null) {
            return null;
        }
        return F.a(identityCredential);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
        short[] sArr = null;
        char c4 = 50438;
        int i = 0;
        int i3 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        int i4 = 0;
        while (true) {
            switch (c4) {
                case 60804:
                    if (i < i3) {
                        c4 = 3065;
                    } else {
                        c4 = 11261;
                    }
                case 22124:
                    int i5 = ((short) ((s4 << 4) + sArr[2])) ^ (s4 + s3);
                    short s6 = sArr[3];
                    int i6 = -(s4 >>> 5);
                    int i7 = i6 | s6;
                    int i8 = (i7 - (i6 * 2)) + ((i6 ^ s6) ^ i7);
                    int i9 = -B0.a(i8 | (~i5), i8 - i5);
                    s5 = (short) D.a(s5, 3, -(D1.a(s5, i9) | (i9 & 2)), 1);
                    s4 = (short) (s4 - ((((short) ((s5 << 4) + sArr[0])) ^ (((s3 | s5) - (((~s5) & 51) & s3)) + ((s5 | 51) & s3))) ^ ((s5 >>> 5) + sArr[1])));
                    s3 = (short) (s3 - 40503);
                    i4++;
                    c4 = 17109;
                case 3065:
                    byte b4 = bArr[i];
                    s4 = (short) (((bArr[((i & 1) * 2) + (i ^ 1)] & ForkServer.ERROR) << 8) | ((255 - (b4 | ForkServer.ERROR)) + b4));
                    int i10 = -i;
                    int i11 = i10 | 2;
                    s5 = (short) ((bArr[(i11 - (i10 * 2)) + ((i10 ^ 2) ^ i11)] & ForkServer.ERROR) | ((bArr[i + 3] & ForkServer.ERROR) << 8));
                    s3 = -14624;
                    i4 = 0;
                    c4 = 17109;
                case 50438:
                    sArr = new short[4];
                    i = 0;
                    c4 = 5848;
                case 49265:
                    sArr[i] = (short) ((bArr2[(((~i) & 2) * (i & (-3))) + ((i & 2) * (i | 2))] & ForkServer.ERROR) ^ ((bArr2[(i * 2) + 1] & ForkServer.ERROR) << 8));
                    i++;
                    c4 = 5848;
                case 5255:
                    int i12 = -i;
                    int i13 = -bArr.length;
                    int i14 = i13 | i12;
                    bArr[(i14 - (i13 * 2)) + ((i13 ^ i12) ^ i14)] = (byte) (bArr[bArr.length - i] ^ bArr2[i % 8]);
                    i--;
                    c4 = 33742;
                case 5848:
                    if (i < 4) {
                        c4 = 49265;
                    } else {
                        c4 = 18639;
                    }
                case 11261:
                    i = bArr.length % 4;
                    c4 = 33742;
                case 18639:
                    i3 = bArr.length - (bArr.length % 4);
                    i = 0;
                    c4 = 60804;
                case 15026:
                    break;
                case 33742:
                    if (i > 0) {
                        c4 = 5255;
                    } else {
                        c4 = 15026;
                    }
                case 42144:
                    bArr[i] = (byte) (s4 & 255);
                    bArr[i + 1] = (byte) ((s4 >> 8) & 255);
                    bArr[i + 2] = (byte) (s5 & 255);
                    bArr[i + 3] = (byte) ((s5 >> 8) & 255);
                    i += 4;
                    c4 = 60804;
                case 17109:
                    if (i4 < 32) {
                        c4 = 22124;
                    } else {
                        c4 = 42144;
                    }
                default:
                    c4 = 17109;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0085 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.List r6, R.C0186k r7, y2.AbstractC0787c r8) {
        /*
            boolean r0 = r8 instanceof R.C0180e
            if (r0 == 0) goto L13
            r0 = r8
            R.e r0 = (R.C0180e) r0
            int r1 = r0.f1865d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1865d = r1
            goto L18
        L13:
            R.e r0 = new R.e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f1864c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1865d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.util.Iterator r6 = r0.f1863b
            java.io.Serializable r7 = r0.f1862a
            kotlin.jvm.internal.r r7 = (kotlin.jvm.internal.r) r7
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Throwable -> L30
            goto L65
        L30:
            r8 = move-exception
            goto L7e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.f1862a
            java.util.List r6 = (java.util.List) r6
            a.AbstractC0228a.C(r8)
            goto L5c
        L42:
            a.AbstractC0228a.C(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            R.g r2 = new R.g
            r5 = 0
            r2.<init>(r6, r8, r5)
            r0.f1862a = r8
            r0.f1865d = r4
            java.lang.Object r6 = r7.a(r2, r0)
            if (r6 != r1) goto L5b
            goto L93
        L5b:
            r6 = r8
        L5c:
            kotlin.jvm.internal.r r7 = new kotlin.jvm.internal.r
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()
            F2.l r8 = (F2.l) r8
            r0.f1862a = r7     // Catch: java.lang.Throwable -> L30
            r0.f1863b = r6     // Catch: java.lang.Throwable -> L30
            r0.f1865d = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L65
            goto L93
        L7e:
            java.lang.Object r2 = r7.f5312a
            if (r2 != 0) goto L85
            r7.f5312a = r8
            goto L65
        L85:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            E1.b.b(r2, r8)
            goto L65
        L8b:
            java.lang.Object r6 = r7.f5312a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L94
            s2.i r1 = s2.C0684i.f6340a
        L93:
            return r1
        L94:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.h.b(java.util.List, R.k, y2.c):java.lang.Object");
    }

    public static W0.d c(FileChannel fileChannel) {
        fileChannel.getClass();
        return new W0.d(fileChannel);
    }

    public static void d(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        byte[] bArr3 = null;
        int i4 = 1516727821;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int a2 = j3.a(650911840 & (~i8) & i9, i9, i8, (i8 | 650911840) & i9);
            int i10 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
            int i11 = -365117735;
            boolean z3 = true;
            switch (((~i10) + ((i10 | 1) * 2)) ^ 962785775) {
                case -1896910703:
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = (length ^ i12) + ((length & i12) * 2);
                    byte b4 = bArr3[i13];
                    int length2 = bArr4.length;
                    int i14 = 0 - i12;
                    int i15 = i14 | length2;
                    byte b5 = bArr3[D.a(i14, 2, i15, (length2 ^ i14) ^ i15)];
                    bArr3[i13] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i4 = -746753280;
                case -1725904394:
                    i7 = bArr4.length % 4;
                    if ((((i7 > 1 ? 1 : (i7 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case -1399959314:
                    int a4 = j3.a((-1205100636) & i6, i6, 3, (-1205100633) & i6);
                    byte b6 = bArr3[a4];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i6 - 1;
                    int i18 = i17 - (i6 | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a5 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 - (i6 | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a5) | i23);
                    int i25 = bArr3[i6] & ForkServer.ERROR;
                    int a6 = S.a(i24, i25, 1, ((-1) - i24) | ((-1) - i25));
                    byte b7 = bArr4[a4];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i18] & ForkServer.ERROR;
                    int i28 = ((i27 * ((~i27) & 65536)) & (~i26)) + i26;
                    int i29 = bArr4[i21] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((((~i30) | 911399251) | i28) - ((i30 & 911399251) | i28));
                    int i32 = bArr4[i6] & ForkServer.ERROR;
                    int i33 = ~((((~i31) | 1433568692) | i32) - ((i31 & 1433568692) | i32));
                    int i34 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (-1254002618) - ((i34 & 2) | ((-1672003491) - i34));
                    int i36 = (i35 + i33) - ((i35 & i33) * 2);
                    bArr4[i6] = (byte) i36;
                    bArr4[i21] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[a4] = (byte) (i36 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i6 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i = -1605440657;
                    } else {
                        i = -365117735;
                    }
                    if (i37 != 0) {
                        i4 = i;
                    } else {
                        i4 = -169475207;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    int length5 = bArr.length;
                    int length6 = 0 - (bArr.length % 4);
                    if ((length5 ^ (~length6)) + ((length5 | length6) * 2) + 1 <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -169475207;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case 511524454:
                    int length7 = bArr4.length;
                    int i38 = 0 - i5;
                    int i39 = 0 - i38;
                    int i40 = ((~length7) & i39) * 2;
                    int length8 = bArr4.length;
                    byte b8 = bArr4[((length8 | i38) * 2) - (length8 ^ i38)];
                    int length9 = bArr4.length;
                    byte b9 = bArr3[(i38 ^ length9) + ((length9 & i38) * 2)];
                    bArr4[(length7 ^ i39) - i40] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i7 = AbstractC0099x.a(i5, 3, (~i5) * 2);
                    if ((((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i41 = 0 - i7;
                    if ((bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] > Double.NaN ? 1 : (bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i11 = 1093626513;
                    }
                    if (z3) {
                        i4 = -746753280;
                    } else {
                        i4 = i11;
                    }
                    i5 = i7;
                default:
                    i4 = -365117735;
            }
            return;
        }
    }

    public static void f(int i, int i3, int i4) {
        if (i >= 0 && i3 <= i4) {
            if (i <= i3) {
                return;
            } else {
                throw new IllegalArgumentException(AbstractC0008a.k("fromIndex: ", i, i3, " > toIndex: "));
            }
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i3 + ", size: " + i4);
    }

    public static final void g(int i, int i3) {
        String j2;
        if (i > 0 && i3 > 0) {
            return;
        }
        if (i != i3) {
            j2 = "Both size " + i + " and step " + i3 + " must be greater than zero.";
        } else {
            j2 = AbstractC0008a.j(i, "size ", " must be greater than zero.");
        }
        throw new IllegalArgumentException(j2.toString());
    }

    public static final void h(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                E1.b.b(th, th2);
            }
        }
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long v2 = v(bArr, 0) & 67108863;
            int i = 3;
            long v3 = (v(bArr, 3) >> 2) & 67108611;
            long v4 = (v(bArr, 6) >> 4) & 67092735;
            long v5 = (v(bArr, 9) >> 6) & 66076671;
            long v6 = (v(bArr, 12) >> 8) & 1048575;
            long j2 = v3 * 5;
            long j3 = v4 * 5;
            long j4 = v5 * 5;
            long j5 = v6 * 5;
            byte[] bArr3 = new byte[17];
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            int i3 = 0;
            while (i3 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, 17, (byte) 0);
                }
                long v7 = j10 + (v(bArr3, 0) & 67108863);
                long v8 = j6 + ((v(bArr3, i) >> 2) & 67108863);
                long v9 = j7 + ((v(bArr3, 6) >> 4) & 67108863);
                long v10 = j8 + ((v(bArr3, 9) >> 6) & 67108863);
                long j11 = v3;
                long v11 = j9 + (((v(bArr3, 12) >> 8) & 67108863) | (bArr3[16] << 24));
                long j12 = (v11 * j2) + (v10 * j3) + (v9 * j4) + (v8 * j5) + (v7 * v2);
                long j13 = (v11 * j3) + (v10 * j4) + (v9 * j5) + (v8 * v2) + (v7 * j11);
                long j14 = (v11 * j4) + (v10 * j5) + (v9 * v2) + (v8 * j11) + (v7 * v4);
                long j15 = (v11 * j5) + (v10 * v2) + (v9 * j11) + (v8 * v4) + (v7 * v5);
                long j16 = v10 * j11;
                long j17 = v11 * v2;
                long j18 = j13 + (j12 >> 26);
                long j19 = j14 + (j18 >> 26);
                long j20 = j15 + (j19 >> 26);
                long j21 = j17 + j16 + (v9 * v4) + (v8 * v5) + (v7 * v6) + (j20 >> 26);
                long j22 = j21 >> 26;
                j9 = j21 & 67108863;
                long j23 = (j22 * 5) + (j12 & 67108863);
                i3 += 16;
                j7 = j19 & 67108863;
                j8 = j20 & 67108863;
                j10 = j23 & 67108863;
                j6 = (j18 & 67108863) + (j23 >> 26);
                v3 = j11;
                i = 3;
            }
            long j24 = j7 + (j6 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j8 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = j9 + (j26 >> 26);
            long j29 = j28 & 67108863;
            long j30 = ((j28 >> 26) * 5) + j10;
            long j31 = j30 >> 26;
            long j32 = j30 & 67108863;
            long j33 = (j6 & 67108863) + j31;
            long j34 = j32 + 5;
            long j35 = j34 & 67108863;
            long j36 = j33 + (j34 >> 26);
            long j37 = j25 + (j36 >> 26);
            long j38 = j27 + (j37 >> 26);
            long j39 = j38 & 67108863;
            long j40 = (j29 + (j38 >> 26)) - 67108864;
            long j41 = j40 >> 63;
            long j42 = j32 & j41;
            long j43 = j33 & j41;
            long j44 = j25 & j41;
            long j45 = j27 & j41;
            long j46 = j29 & j41;
            long j47 = ~j41;
            long j48 = j43 | (j36 & 67108863 & j47);
            long j49 = j44 | (j37 & 67108863 & j47);
            long j50 = j45 | (j39 & j47);
            long j51 = (j42 | (j35 & j47) | (j48 << 26)) & KeyboardMap.kValueMask;
            long j52 = ((j48 >> 6) | (j49 << 20)) & KeyboardMap.kValueMask;
            long j53 = ((j49 >> 12) | (j50 << 14)) & KeyboardMap.kValueMask;
            long j54 = ((j50 >> 18) | ((j46 | (j40 & j47)) << 8)) & KeyboardMap.kValueMask;
            long v12 = v(bArr, 16) + j51;
            long j55 = v12 & KeyboardMap.kValueMask;
            long v13 = v(bArr, 20) + j52 + (v12 >> 32);
            long j56 = v13 & KeyboardMap.kValueMask;
            long v14 = v(bArr, 24) + j53 + (v13 >> 32);
            long j57 = v14 & KeyboardMap.kValueMask;
            long v15 = (v(bArr, 28) + j54 + (v14 >> 32)) & KeyboardMap.kValueMask;
            byte[] bArr4 = new byte[16];
            H(bArr4, j55, 0);
            H(bArr4, j56, 4);
            H(bArr4, j57, 8);
            H(bArr4, v15, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    public static int k(C0472C c0472c, AbstractC0083t abstractC0083t, View view, View view2, k0.t tVar, boolean z3) {
        if (tVar.p() != 0 && c0472c.a() != 0 && view != null && view2 != null) {
            if (z3) {
                return Math.min(abstractC0083t.l(), abstractC0083t.h(view2) - abstractC0083t.i(view));
            }
            ((u) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static int l(C0472C c0472c, AbstractC0083t abstractC0083t, View view, View view2, k0.t tVar, boolean z3) {
        if (tVar.p() != 0 && c0472c.a() != 0 && view != null && view2 != null) {
            if (!z3) {
                return c0472c.a();
            }
            abstractC0083t.h(view2);
            abstractC0083t.i(view);
            ((u) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static m m() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyGenParameterSpec.Builder b4 = q.D.b("androidxBiometric", 3);
            q.D.d(b4);
            q.D.e(b4);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            q.D.c(keyGenerator, q.D.a(b4));
            keyGenerator.generateKey();
            SecretKey secretKey = (SecretKey) keyStore.getKey("androidxBiometric", null);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKey);
            return new m(cipher);
        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public static String n(Object value, String str) {
        j.e(value, "value");
        return str + " value: " + value;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void o(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        int i4 = 0;
        byte[] bArr3 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1180709023;
        byte[] bArr4 = null;
        while (true) {
            int i9 = ((i8 & 16777216) * (i8 | 16777216)) + ((i8 & (-16777217)) * ((~i8) & 16777216));
            int i10 = i8 >>> 8;
            int a2 = S.a(i10, i9, 1, ((-1) - i10) | ((-1) - i9));
            int i11 = (a2 ^ (-201803027)) + ((a2 & (-201803027)) * 2);
            int i12 = 1565752577;
            int i13 = 1621215041;
            switch ((i11 - 814310662) - ((i11 & (-814310662)) * 2)) {
                case -2000520841:
                    i = i4;
                    int length = bArr4.length;
                    int i14 = 0 - (0 - i5);
                    if ((bArr3[((length & (~i14)) * 2) - (length ^ i14)] > Double.NaN ? 1 : (bArr3[((length & (~i14)) * 2) - (length ^ i14)] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = i;
                    } else {
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        i12 = 1621215041;
                    }
                    if (i3 != 0) {
                        i8 = i12;
                    } else {
                        i8 = -1164716566;
                    }
                    i7 = i5;
                    i4 = i;
                case -870579640:
                    int i15 = (i6 - 1) - (i6 | (-4));
                    byte b4 = bArr3[i15];
                    int i16 = ((b4 & ForkServer.DONE) * (b4 | ForkServer.DONE)) + ((b4 & ForkServer.ERROR) * ((~b4) & 16777216));
                    int i17 = i6 + 3 + (((-1) - i6) | (-3));
                    int i18 = bArr3[i17] & ForkServer.ERROR;
                    i = i4;
                    int i19 = i18 * ((~i18) & 65536);
                    int i20 = ~((((-1268032266) | (~i19)) | i16) - ((i19 & (-1268032266)) | i16));
                    int a4 = j3.a((-132004404) & i6, i6, 1, (-132004403) & i6);
                    int i21 = bArr3[a4] & ForkServer.ERROR;
                    int i22 = i21 * ((~i21) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i23 = (i22 + i20) - (i22 & i20);
                    int i24 = bArr3[i6] & ForkServer.ERROR;
                    int i25 = ((~i24) & i23) + i24;
                    byte b5 = bArr4[i15];
                    int i26 = ((b5 & ForkServer.DONE) * (b5 | ForkServer.DONE)) + (((-16777217) & b5) * ((~b5) & 16777216));
                    int i27 = bArr4[i17] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = ~((i26 | ((~i28) | (-1355861741))) - ((i28 & (-1355861741)) | i26));
                    int i30 = bArr4[a4] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int a5 = S.a(i31, i29, 1, ((-1) - i31) | ((-1) - i29));
                    int i32 = (a5 - 1) - ((~(bArr4[i6] & ForkServer.ERROR)) | a5);
                    int i33 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i34 = (i33 ^ (-418000873)) + ((i33 & (-418000873)) * 2);
                    int i35 = (i34 + i32) - ((i34 & i32) * 2);
                    bArr4[i6] = (byte) i35;
                    bArr4[a4] = (byte) (i35 >>> 8);
                    bArr4[i17] = (byte) (i35 >>> 16);
                    bArr4[i15] = (byte) (i35 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length2 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    if ((((i6 > (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 1 : (i6 == (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 0 : -1)) >>> 31) & 1) != 0) {
                        i8 = 1910359311;
                    } else {
                        i8 = 1621215041;
                    }
                    i4 = i;
                case -97532338:
                    i5 = bArr4.length % 4;
                    int i36 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i36 != 0) {
                        i13 = 986083301;
                    }
                    if (i36 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 298177592:
                    int length3 = bArr4.length;
                    int i37 = 0 - i7;
                    int a7 = AbstractC0014b1.a((length3 & 2) | D1.a(i37, length3), i37 * 3);
                    byte b6 = bArr3[a7];
                    int length4 = bArr4.length;
                    int i38 = 0 - i37;
                    int i39 = i38 | length4;
                    byte b7 = bArr3[D.a(i38, 2, i39, (length4 ^ i38) ^ i39)];
                    bArr3[a7] = (byte) (((byte) (b7 ^ b6)) + ((byte) (((byte) 2) * ((byte) (b7 & b6)))));
                    i8 = 1565752577;
                case 373627814:
                    break;
                case 975213712:
                    int length5 = bArr4.length;
                    int i40 = 0 - i7;
                    int length6 = bArr4.length;
                    int i41 = ~i40;
                    byte b8 = bArr4[((length6 | i40) - (((-656070458) & i41) & length6)) + ((i40 | (-656070458)) & length6)];
                    int length7 = bArr4.length;
                    byte b9 = bArr3[(length7 ^ i41) + ((length7 | i40) * 2) + 1];
                    bArr4[((length5 | i40) * 2) - (length5 ^ i40)] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i5 = (~i7) + (i7 * 2);
                    int i42 = ((i7 > 2 ? 1 : (i7 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i42 != 0) {
                        i13 = 986083301;
                    }
                    if (i42 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 1548321255:
                    int length8 = bArr.length;
                    int length9 = 0 - (0 - (bArr.length % 4));
                    if ((length8 & (~length9)) - ((~length8) & length9) <= 0) {
                        i8 = 1621215041;
                    } else {
                        i8 = 1910359311;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = i4;
                default:
                    i8 = i13;
            }
            return;
        }
    }

    public static final z2.b p(Enum[] entries) {
        j.e(entries, "entries");
        return new z2.b(entries);
    }

    public static W0.g q(W0.d dVar, int i) {
        int i3;
        if (i >= 0 && i <= 65535) {
            long size = dVar.size();
            if (size >= 22) {
                int min = ((int) Math.min(i, size - 22)) + 22;
                long j2 = size - min;
                ByteBuffer c4 = dVar.c(min, j2);
                c4.order(ByteOrder.LITTLE_ENDIAN);
                d(c4);
                int capacity = c4.capacity();
                if (capacity >= 22) {
                    int i4 = capacity - 22;
                    int min2 = Math.min(i4, 65535);
                    for (int i5 = 0; i5 <= min2; i5++) {
                        i3 = i4 - i5;
                        if (c4.getInt(i3) == 101010256 && (c4.getShort(i3 + 20) & 65535) == i5) {
                            break;
                        }
                    }
                }
                i3 = -1;
                if (i3 == -1) {
                    return null;
                }
                c4.position(i3);
                ByteBuffer slice = c4.slice();
                slice.order(ByteOrder.LITTLE_ENDIAN);
                return new W0.g(slice, Long.valueOf(j2 + i3));
            }
            return null;
        }
        throw new IllegalArgumentException(e0.a.c(i, "maxCommentSize: "));
    }

    public static int r(S0.h hVar) {
        int ordinal = hVar.ordinal();
        if (ordinal != 0) {
            int i = 1;
            if (ordinal != 1) {
                i = 2;
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return 3;
                    }
                    throw new IllegalArgumentException("Unsupported tag class: " + hVar);
                }
            }
            return i;
        }
        return 0;
    }

    public static int s(S0.j jVar) {
        switch (jVar.ordinal()) {
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 4;
            case 5:
            case 6:
                return 16;
            case 7:
                return 17;
            case 8:
                return 3;
            case 9:
                return 23;
            case 10:
                return 24;
            case 11:
                return 1;
            default:
                throw new IllegalArgumentException("Unsupported data type: " + jVar);
        }
    }

    public static boolean t(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }

    public static boolean u(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }

    public static long v(byte[] bArr, int i) {
        return (((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16)) & KeyboardMap.kValueMask;
    }

    public static String w(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                if (str2.length() > i) {
                    sb.append(str2.charAt(i));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public static void z(byte[] bArr, W0.e eVar, N0.e eVar2) {
        try {
            ArrayList H3 = m3.b.H(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
            for (int i = 0; i < H3.size(); i++) {
                eVar2.f1447c.add(((O0.a) H3.get(i)).f1528a);
            }
            if (!eVar.equals(eVar2.f1447c.get(r5.size() - 1))) {
                eVar2.a(34, new Object[0]);
            }
        } catch (IllegalArgumentException unused) {
            eVar2.a(34, new Object[0]);
        } catch (SecurityException unused2) {
            eVar2.a(35, new Object[0]);
        } catch (Exception unused3) {
            eVar2.a(33, new Object[0]);
        }
    }

    public abstract h A(String str, l lVar);

    public abstract void C(boolean z3);

    public abstract Object i();

    public abstract void x(Throwable th);

    public abstract void y(m mVar);

    public void B(boolean z3) {
    }
}
