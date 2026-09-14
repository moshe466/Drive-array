package m3;

import F0.AbstractC0008a;
import J.Y;
import L0.e;
import M.i;
import M0.c;
import N0.k;
import N0.l;
import N0.m;
import N0.n;
import N0.o;
import N0.p;
import N0.q;
import N0.r;
import N0.t;
import W0.d;
import W0.g;
import W0.j;
import a.AbstractC0228a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.datastore.preferences.protobuf.C0240g;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigningBlockUtils$NoSupportedSignaturesException;
import com.android.apksig.internal.apk.NoApkSupportedSignaturesException;
import com.android.apksig.internal.apk.SignatureNotFoundException;
import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.internal.Code;
import e.C0359a;
import f.C0368d;
import f.C0369e;
import f.C0370f;
import f.InterfaceC0371g;
import h.AbstractActivityC0441k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import m.C0537c0;
import s2.C0679d;
import s2.C0680e;
import s2.C0681f;
import t2.AbstractC0705g;
import t2.u;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.C0780b;
import x2.C0781c;
import x2.EnumC0779a;
import y2.AbstractC0785a;
import y2.AbstractC0787c;
import y2.AbstractC0791g;

/* loaded from: classes.dex */
public abstract class b implements Y {

    /* renamed from: a, reason: collision with root package name */
    public static Field f5871a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5872b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f5873c = true;

    public static boolean A(int i) {
        if ((i & 32768) != 0) {
            return true;
        }
        return false;
    }

    public static boolean C(int i) {
        if (i != 15 && i != 255) {
            if (i != 32768) {
                if (i != 32783) {
                    if (i == 33023 || i == 0) {
                        return true;
                    }
                    return false;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 28 || i3 > 29) {
                    return true;
                }
                return false;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static Set D(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(u.F(objArr.length));
        AbstractC0705g.P(objArr, linkedHashSet);
        return linkedHashSet;
    }

    public static void E(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
    }

    public static void F(ByteBuffer byteBuffer, CertificateFactory certificateFactory, m mVar, HashSet hashSet, Map map, HashSet hashSet2, int i) {
        byte[] encoded;
        ByteBuffer c4 = q.c(byteBuffer);
        c4.get(new byte[c4.remaining()]);
        c4.flip();
        ArrayList arrayList = mVar.f1470g;
        ArrayList arrayList2 = mVar.f1446b;
        ArrayList arrayList3 = mVar.i;
        ByteBuffer c5 = q.c(byteBuffer);
        byte[] e4 = q.e(byteBuffer);
        int i3 = 1;
        ArrayList arrayList4 = new ArrayList(1);
        int i4 = 0;
        int i5 = 0;
        while (c5.hasRemaining()) {
            i5++;
            try {
                ByteBuffer c6 = q.c(c5);
                int i6 = c6.getInt();
                byte[] e5 = q.e(c6);
                arrayList3.add(new l(i6));
                t a2 = t.a(i6);
                if (a2 == null) {
                    mVar.g(e.V2_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i6));
                } else {
                    arrayList4.add(new r(a2, e5));
                }
            } catch (ApkFormatException | BufferUnderflowException unused) {
                mVar.f(e.V2_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i5));
                return;
            }
        }
        if (arrayList3.isEmpty()) {
            mVar.f(e.V2_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        try {
            ArrayList d2 = q.d(arrayList4, i, Api.BaseClientBuilder.API_PRIORITY_OTHER, false);
            int size = d2.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = d2.get(i7);
                i7++;
                o oVar = (o) obj;
                t tVar = oVar.f1483a;
                g gVar = tVar.f1497d;
                String str = (String) gVar.f2458a;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) gVar.f2459b;
                try {
                    int i8 = i3;
                    PublicKey generatePublic = KeyFactory.getInstance(tVar.f1495b).generatePublic(new X509EncodedKeySpec(e4));
                    try {
                        Signature signature = Signature.getInstance(str);
                        signature.initVerify(generatePublic);
                        if (algorithmParameterSpec != null) {
                            signature.setParameter(algorithmParameterSpec);
                        }
                        c4.position(0);
                        signature.update(c4);
                        byte[] bArr = oVar.f1484b;
                        if (!signature.verify(bArr)) {
                            mVar.f(e.V2_SIG_DID_NOT_VERIFY, tVar);
                            return;
                        } else {
                            mVar.f1472j.put(tVar, bArr);
                            hashSet.add(tVar.f1496c);
                            i3 = i8;
                        }
                    } catch (InvalidAlgorithmParameterException e6) {
                        e = e6;
                        mVar.f(e.V2_SIG_VERIFY_EXCEPTION, tVar, e);
                        return;
                    } catch (InvalidKeyException e7) {
                        e = e7;
                        mVar.f(e.V2_SIG_VERIFY_EXCEPTION, tVar, e);
                        return;
                    } catch (SignatureException e8) {
                        e = e8;
                        mVar.f(e.V2_SIG_VERIFY_EXCEPTION, tVar, e);
                        return;
                    }
                } catch (Exception e9) {
                    mVar.f(e.V2_SIG_MALFORMED_PUBLIC_KEY, e9);
                    return;
                }
            }
            int i9 = i3;
            c4.position(0);
            ByteBuffer c7 = q.c(c4);
            ByteBuffer c8 = q.c(c4);
            ByteBuffer c9 = q.c(c4);
            int i10 = -1;
            while (c8.hasRemaining()) {
                int i11 = i10 + 1;
                byte[] e10 = q.e(c8);
                try {
                    arrayList2.add(new W0.e(j.b(e10, certificateFactory), e10));
                    i10 = i11;
                } catch (CertificateException e11) {
                    mVar.f(e.V2_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i11), Integer.valueOf(i10 + 2), e11);
                    return;
                }
            }
            if (arrayList2.isEmpty()) {
                mVar.f(e.V2_SIG_NO_CERTIFICATES, new Object[0]);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) arrayList2.get(0);
            try {
                encoded = p.c(x509Certificate.getPublicKey());
            } catch (InvalidKeyException e12) {
                System.out.println("Caught an exception encoding the public key: " + e12);
                e12.printStackTrace();
                encoded = x509Certificate.getPublicKey().getEncoded();
            }
            if (!Arrays.equals(e4, encoded)) {
                mVar.f(e.V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, q.f(encoded), q.f(e4));
                return;
            }
            int i12 = 0;
            while (c7.hasRemaining()) {
                i12++;
                try {
                    ByteBuffer c10 = q.c(c7);
                    arrayList.add(new k(q.e(c10), c10.getInt()));
                } catch (ApkFormatException | BufferUnderflowException unused2) {
                    mVar.f(e.V2_SIG_MALFORMED_DIGEST, Integer.valueOf(i12));
                    return;
                }
            }
            ArrayList arrayList5 = new ArrayList(arrayList3.size());
            int size2 = arrayList3.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList3.get(i13);
                i13++;
                arrayList5.add(Integer.valueOf(((l) obj2).f1469a));
            }
            ArrayList arrayList6 = new ArrayList(arrayList.size());
            int size3 = arrayList.size();
            int i14 = 0;
            while (i14 < size3) {
                Object obj3 = arrayList.get(i14);
                i14++;
                arrayList6.add(Integer.valueOf(((k) obj3).f1467a));
            }
            if (!arrayList5.equals(arrayList6)) {
                mVar.f(e.V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList5, arrayList6);
                return;
            }
            Set keySet = map.keySet();
            HashSet hashSet3 = new HashSet(i9);
            while (c9.hasRemaining()) {
                i4 += i9;
                try {
                    ByteBuffer c11 = q.c(c9);
                    int i15 = c11.getInt();
                    byte[] bArr2 = new byte[c11.remaining()];
                    c11.get(bArr2);
                    mVar.f1473k.add(new N0.j(bArr2, i15));
                    if (i15 != -1091571699) {
                        mVar.g(e.V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i15));
                    } else {
                        int i16 = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
                        if (keySet.contains(Integer.valueOf(i16))) {
                            hashSet3.add(Integer.valueOf(i16));
                        } else {
                            mVar.g(e.V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID, Integer.valueOf(mVar.f1445a), Integer.valueOf(i16));
                        }
                    }
                } catch (ApkFormatException | BufferUnderflowException unused3) {
                    mVar.f(e.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i4));
                    return;
                }
            }
            Iterator it = hashSet3.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                num.getClass();
                if (!hashSet2.contains(num)) {
                    mVar.f(e.V2_SIG_MISSING_APK_SIG_REFERENCED, Integer.valueOf(mVar.f1445a), (String) map.get(num));
                }
            }
        } catch (NoApkSupportedSignaturesException e13) {
            try {
                throw new Exception(e13.getMessage());
            } catch (ApkSigningBlockUtils$NoSupportedSignaturesException e14) {
                mVar.f(e.V2_SIG_NO_SUPPORTED_SIGNATURES, e14);
            }
        }
    }

    public static final File G(Context context, String name) {
        kotlin.jvm.internal.j.e(context, "<this>");
        kotlin.jvm.internal.j.e(name, "name");
        String fileName = name.concat(".preferences_pb");
        kotlin.jvm.internal.j.e(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(fileName));
    }

    public static ArrayList H(ByteBuffer byteBuffer) {
        W0.e eVar;
        ArrayList arrayList = new ArrayList();
        W0.e eVar2 = null;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return null;
        }
        char[] cArr = q.f1482a;
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                int i = 0;
                try {
                    try {
                        if (byteBuffer.getInt() == 1) {
                            HashSet hashSet = new HashSet();
                            int i3 = 0;
                            while (byteBuffer.hasRemaining()) {
                                i++;
                                ByteBuffer c4 = q.c(byteBuffer);
                                ByteBuffer c5 = q.c(c4);
                                int i4 = c4.getInt();
                                int i5 = c4.getInt();
                                t a2 = t.a(i3);
                                byte[] e4 = q.e(c4);
                                if (eVar2 != null) {
                                    g gVar = a2.f1497d;
                                    String str = (String) gVar.f2458a;
                                    AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) gVar.f2459b;
                                    try {
                                        PublicKey publicKey = eVar2.f2453a.getPublicKey();
                                        eVar = eVar2;
                                        Signature signature = Signature.getInstance(str);
                                        signature.initVerify(publicKey);
                                        if (algorithmParameterSpec != null) {
                                            signature.setParameter(algorithmParameterSpec);
                                        }
                                        signature.update(c5);
                                        if (!signature.verify(e4)) {
                                            throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + str + " when verifying SourceStampCertificateLineage object");
                                        }
                                    } catch (BufferUnderflowException e5) {
                                        e = e5;
                                        throw new IOException("Failed to parse SourceStampCertificateLineage object", e);
                                    }
                                } else {
                                    eVar = eVar2;
                                }
                                c5.rewind();
                                byte[] e6 = q.e(c5);
                                int i6 = c5.getInt();
                                if (eVar != null && i3 != i6) {
                                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + c4 + " when verifying SourceStampCertificateLineage object");
                                }
                                W0.e eVar3 = new W0.e((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(e6)), e6);
                                if (!hashSet.contains(eVar3)) {
                                    hashSet.add(eVar3);
                                    arrayList.add(new O0.a(eVar3, t.a(i6), t.a(i5), e4, i4));
                                    eVar2 = eVar3;
                                    i3 = i5;
                                } else {
                                    throw new SecurityException("Encountered duplicate entries in SigningCertificateLineage at certificate #" + i + ".  All signing certificates should be unique");
                                }
                            }
                            return arrayList;
                        }
                        throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                    } catch (ApkFormatException | BufferUnderflowException e7) {
                        e = e7;
                    }
                } catch (InvalidAlgorithmParameterException e8) {
                    e = e8;
                    throw new SecurityException(AbstractC0008a.j(0, "Failed to verify signature over signed data for certificate #", " when parsing SourceStampCertificateLineage object"), e);
                } catch (InvalidKeyException e9) {
                    e = e9;
                    throw new SecurityException(AbstractC0008a.j(0, "Failed to verify signature over signed data for certificate #", " when parsing SourceStampCertificateLineage object"), e);
                } catch (NoSuchAlgorithmException e10) {
                    e = e10;
                    throw new SecurityException(AbstractC0008a.j(0, "Failed to verify signature over signed data for certificate #", " when parsing SourceStampCertificateLineage object"), e);
                } catch (SignatureException e11) {
                    e = e11;
                    throw new SecurityException(AbstractC0008a.j(0, "Failed to verify signature over signed data for certificate #", " when parsing SourceStampCertificateLineage object"), e);
                } catch (CertificateException e12) {
                    throw new SecurityException(AbstractC0008a.j(0, "Failed to decode certificate #", " when parsing SourceStampCertificateLineage object"), e12);
                }
            } catch (CertificateException e13) {
                throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e13);
            }
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static void K(TextView textView, int i) {
        int i3;
        if (i >= 0) {
            if (Build.VERSION.SDK_INT >= 28) {
                B.b.n(textView, i);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.top;
            } else {
                i3 = fontMetricsInt.ascent;
            }
            if (i > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), i + i3, textView.getPaddingRight(), textView.getPaddingBottom());
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void L(TextView textView, int i) {
        int i3;
        if (i >= 0) {
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.bottom;
            } else {
                i3 = fontMetricsInt.descent;
            }
            if (i > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static Set M(Object obj) {
        Set singleton = Collections.singleton(obj);
        kotlin.jvm.internal.j.d(singleton, "singleton(...)");
        return singleton;
    }

    public static Set N(Object... objArr) {
        return AbstractC0705g.T(objArr);
    }

    public static boolean Q(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i = 0; i < bArr2.length; i++) {
                if (bArr[i] == bArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public static final C0679d R(Object obj, Object obj2) {
        return new C0679d(obj, obj2);
    }

    public static ActionMode.Callback S(ActionMode.Callback callback) {
        if ((callback instanceof i) && Build.VERSION.SDK_INT >= 26) {
            return ((i) callback).f1380a;
        }
        return callback;
    }

    public static n T(d dVar, c cVar, Map map, HashSet hashSet, int i) {
        int i3 = Y0.c.f2705h;
        n nVar = new n(2);
        try {
            N0.u a2 = q.a(dVar, cVar, 1896449818);
            Y0.b e4 = dVar.e(0L, a2.f1501b);
            long j2 = a2.f1502c;
            Y0.b e5 = dVar.e(j2, a2.f1503d - j2);
            ByteBuffer byteBuffer = a2.f1504e;
            ByteBuffer byteBuffer2 = a2.f1500a;
            HashSet hashSet2 = new HashSet(1);
            try {
                ByteBuffer c4 = q.c(byteBuffer2);
                if (!c4.hasRemaining()) {
                    nVar.d(e.V2_SIG_NO_SIGNERS, new Object[0]);
                } else {
                    try {
                        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                        int i4 = 0;
                        while (c4.hasRemaining()) {
                            int i5 = i4 + 1;
                            m mVar = new m();
                            mVar.f1445a = i4;
                            nVar.f1479g.add(mVar);
                            try {
                                F(q.c(c4), certificateFactory, mVar, hashSet2, map, hashSet, i);
                                i4 = i5;
                            } catch (ApkFormatException | BufferUnderflowException unused) {
                                mVar.f(e.V2_SIG_MALFORMED_SIGNER, new Object[0]);
                            }
                        }
                        if (i4 > 10) {
                            nVar.d(e.V2_SIG_MAX_SIGNATURES_EXCEEDED, 10, Integer.valueOf(i4));
                        }
                    } catch (CertificateException e6) {
                        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
                    }
                }
            } catch (ApkFormatException unused2) {
                nVar.d(e.V2_SIG_MALFORMED_SIGNERS, new Object[0]);
            }
            if (!nVar.a()) {
                p.d(e4, e5, byteBuffer, hashSet2, nVar);
                if (!nVar.a()) {
                    nVar.f1431b = true;
                }
            }
            return nVar;
        } catch (SignatureNotFoundException e7) {
            throw new Exception(e7.getMessage());
        }
    }

    public static ActionMode.Callback U(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 27 && !(callback instanceof i) && callback != null) {
            return new i(callback, textView);
        }
        return callback;
    }

    public static Object W(F2.p pVar, Object obj, InterfaceC0763d interfaceC0763d) {
        Object abstractC0787c;
        kotlin.jvm.internal.j.e(pVar, "<this>");
        InterfaceC0768i context = interfaceC0763d.getContext();
        if (context == C0769j.f6733a) {
            abstractC0787c = new AbstractC0791g(interfaceC0763d);
        } else {
            abstractC0787c = new AbstractC0787c(interfaceC0763d, context);
        }
        kotlin.jvm.internal.u.a(2, pVar);
        return pVar.invoke(obj, abstractC0787c);
    }

    public static void X(Parcel parcel, Parcelable parcelable) {
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public static Object d(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] f(Serializable serializable) {
        if (serializable instanceof int[]) {
            int[] iArr = (int[]) serializable;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        }
        if (serializable instanceof long[]) {
            return (long[]) serializable;
        }
        return null;
    }

    public static void g(Y.b bVar, Y.c cVar, int i) {
        byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        while (i > 0) {
            int min = Math.min(i, UserMetadata.MAX_INTERNAL_KEY_SIZE);
            int read = bVar.read(bArr, 0, min);
            if (read == min) {
                i -= read;
                cVar.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static void h(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void i(InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
        byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        int read = inputStream.read(bArr);
        while (read >= 0) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static V.s j(android.content.Context r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Le
            V.c r0 = new V.c
            r1 = 10
            r0.<init>(r1)
            goto L15
        Le:
            A.n r0 = new A.n
            r1 = 10
            r0.<init>(r1)
        L15:
            android.content.pm.PackageManager r1 = r13.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            I.d.c(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2e
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2e
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2e
            goto L4b
        L4a:
            r4 = r5
        L4b:
            if (r4 != 0) goto L4f
        L4d:
            r6 = r5
            goto L80
        L4f:
            java.lang.String r7 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            java.lang.String r8 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            android.content.pm.Signature[] r0 = r0.c(r1, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            int r2 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
        L5d:
            if (r3 >= r2) goto L6b
            r4 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            byte[] r4 = r4.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            r1.add(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            int r3 = r3 + 1
            goto L5d
        L6b:
            java.util.List r10 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            G.d r6 = new G.d     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            java.lang.String r9 = "emojicompat-emoji-font"
            r11 = 0
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L79
            goto L80
        L79:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4d
        L80:
            if (r6 != 0) goto L83
            goto L8d
        L83:
            V.s r5 = new V.s
            V.r r0 = new V.r
            r0.<init>(r13, r6)
            r5.<init>(r0)
        L8d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.b.j(android.content.Context):V.s");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC0763d k(F2.p pVar, InterfaceC0763d interfaceC0763d, InterfaceC0763d interfaceC0763d2) {
        kotlin.jvm.internal.j.e(pVar, "<this>");
        if (pVar instanceof AbstractC0785a) {
            return ((AbstractC0785a) pVar).create(interfaceC0763d, interfaceC0763d2);
        }
        InterfaceC0768i context = interfaceC0763d2.getContext();
        if (context == C0769j.f6733a) {
            return new C0780b(pVar, interfaceC0763d2, interfaceC0763d);
        }
        return new C0781c(interfaceC0763d2, context, pVar, interfaceC0763d);
    }

    public static String l(C0240g c0240g) {
        StringBuilder sb = new StringBuilder(c0240g.size());
        for (int i = 0; i < c0240g.size(); i++) {
            byte g3 = c0240g.g(i);
            if (g3 != 34) {
                if (g3 != 39) {
                    if (g3 != 92) {
                        switch (g3) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case Code.UNIMPLEMENTED /* 12 */:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (g3 >= 32 && g3 <= 126) {
                                    sb.append((char) g3);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((g3 >>> 6) & 3) + 48));
                                    sb.append((char) (((g3 >>> 3) & 7) + 48));
                                    sb.append((char) ((g3 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    public static String m(AbstractC0337i abstractC0337i) {
        StringBuilder sb = new StringBuilder(abstractC0337i.size());
        for (int i = 0; i < abstractC0337i.size(); i++) {
            byte g3 = abstractC0337i.g(i);
            if (g3 != 34) {
                if (g3 != 39) {
                    if (g3 != 92) {
                        switch (g3) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case Code.UNIMPLEMENTED /* 12 */:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (g3 >= 32 && g3 <= 126) {
                                    sb.append((char) g3);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((g3 >>> 6) & 3) + 48));
                                    sb.append((char) (((g3 >>> 3) & 7) + 48));
                                    sb.append((char) ((g3 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    public static final Object n(Object obj) {
        boolean z3 = obj instanceof C0680e;
        if (!z3) {
            AbstractC0228a.C(obj);
            return ((C0681f) obj).f6335a;
        }
        if (z3) {
            Throwable a2 = C0681f.a(obj);
            kotlin.jvm.internal.j.b(a2);
            return AbstractC0228a.g(a2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static void o() {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
    }

    public static Object q(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 34) {
            return F.b.b(bundle, str);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (C0359a.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static Intent r(AbstractActivityC0441k abstractActivityC0441k) {
        Intent parentActivityIntent = abstractActivityC0441k.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String t3 = t(abstractActivityC0441k, abstractActivityC0441k.getComponentName());
            if (t3 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(abstractActivityC0441k, t3);
            try {
                if (t(abstractActivityC0441k, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + t3 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Intent s(AbstractActivityC0441k abstractActivityC0441k, ComponentName componentName) {
        String t3 = t(abstractActivityC0441k, componentName);
        if (t3 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), t3);
        if (t(abstractActivityC0441k, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String t(Context context, ComponentName componentName) {
        int i;
        String string;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 29) {
            i = 269222528;
        } else {
            i = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static ResolveInfo u(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
    }

    public static H.a v(C0537c0 c0537c0) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new H.a(B.b.k(c0537c0));
        }
        TextPaint textPaint = new TextPaint(c0537c0.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = c0537c0.getBreakStrategy();
        int hyphenationFrequency = c0537c0.getHyphenationFrequency();
        if (c0537c0.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z3 = true;
            if (i >= 28 && (c0537c0.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(B.b.b(DecimalFormatSymbols.getInstance(c0537c0.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                if (c0537c0.getLayoutDirection() != 1) {
                    z3 = false;
                }
                switch (c0537c0.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z3) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                        break;
                }
            }
        }
        return new H.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static String x(InterfaceC0371g input) {
        kotlin.jvm.internal.j.e(input, "input");
        if (input instanceof C0369e) {
            return "image/*";
        }
        if (input instanceof C0370f) {
            return "video/*";
        }
        if (input instanceof C0368d) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static HashSet y(Object... objArr) {
        HashSet hashSet = new HashSet(u.F(objArr.length));
        AbstractC0705g.P(objArr, hashSet);
        return hashSet;
    }

    public static InterfaceC0763d z(InterfaceC0763d interfaceC0763d) {
        AbstractC0787c abstractC0787c;
        InterfaceC0763d intercepted;
        kotlin.jvm.internal.j.e(interfaceC0763d, "<this>");
        if (interfaceC0763d instanceof AbstractC0787c) {
            abstractC0787c = (AbstractC0787c) interfaceC0763d;
        } else {
            abstractC0787c = null;
        }
        if (abstractC0787c != null && (intercepted = abstractC0787c.intercepted()) != null) {
            return intercepted;
        }
        return interfaceC0763d;
    }

    public abstract boolean B();

    public abstract void I(boolean z3);

    public abstract void J(boolean z3);

    public void O(View view, float f4) {
        if (f5873c) {
            try {
                view.setTransitionAlpha(f4);
                return;
            } catch (NoSuchMethodError unused) {
                f5873c = false;
            }
        }
        view.setAlpha(f4);
    }

    public void P(View view, int i) {
        if (!f5872b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f5871a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f5872b = true;
        }
        Field field = f5871a;
        if (field != null) {
            try {
                f5871a.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract TransformationMethod V(TransformationMethod transformationMethod);

    public abstract InputFilter[] p(InputFilter[] inputFilterArr);

    public float w(View view) {
        float transitionAlpha;
        if (f5873c) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f5873c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // J.Y
    public void a() {
    }

    @Override // J.Y
    public void b() {
    }
}
