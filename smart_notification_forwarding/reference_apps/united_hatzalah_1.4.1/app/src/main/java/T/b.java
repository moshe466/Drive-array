package T;

import F0.H2;
import F2.p;
import P2.AbstractC0140a;
import P2.G;
import R2.r;
import a.AbstractC0228a;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.V;
import com.fingerprintjs.android.fingerprint.tools.threading.safe.ExecutionTimeoutException;
import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.A;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0352y;
import com.google.crypto.tink.shaded.protobuf.B;
import com.google.crypto.tink.shaded.protobuf.C0332d;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.b0;
import com.google.crypto.tink.shaded.protobuf.e0;
import com.google.crypto.tink.shaded.protobuf.q0;
import com.uh.sf.R;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import l0.InterfaceC0516f;
import m1.AbstractC0587a;
import org.apache.tika.fork.ForkServer;
import s2.C0681f;
import s2.C0682g;
import s2.C0684i;
import t2.AbstractC0702d;
import t2.AbstractC0705g;
import w.AbstractC0744b;
import w2.C0761b;
import w2.C0769j;
import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Field f2248a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f2249b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f2250c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f2251d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f2252e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f2253f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f2254g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f2255h;

    public static C0682g A(F2.a initializer) {
        kotlin.jvm.internal.j.e(initializer, "initializer");
        return new C0682g(initializer);
    }

    public static List B(Object obj) {
        List singletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.j.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static int C(Object obj, b0 b0Var, byte[] bArr, int i, int i3, C0332d c0332d) {
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            i4 = p(i5, bArr, i4, c0332d);
            i5 = c0332d.f4092a;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            int i7 = i6 + i5;
            b0Var.g(obj, bArr, i6, i7, c0332d);
            c0332d.f4094c = obj;
            return i7;
        }
        throw InvalidProtocolBufferException.h();
    }

    public static InterfaceC0768i D(InterfaceC0766g interfaceC0766g, InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        if (kotlin.jvm.internal.j.a(interfaceC0766g.getKey(), key)) {
            return C0769j.f6733a;
        }
        return interfaceC0766g;
    }

    public static MappedByteBuffer E(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static InterfaceC0768i F(InterfaceC0766g interfaceC0766g, InterfaceC0768i context) {
        kotlin.jvm.internal.j.e(context, "context");
        if (context == C0769j.f6733a) {
            return interfaceC0766g;
        }
        return (InterfaceC0768i) context.fold(interfaceC0766g, new C0761b(1));
    }

    public static final Object G(long j2, F2.a block) {
        boolean booleanValue;
        Object g3;
        Object g4;
        StackTraceElement[] stackTrace;
        kotlin.jvm.internal.j.e(block, "block");
        ArrayList arrayList = null;
        AtomicReference atomicReference = new AtomicReference(null);
        Boolean bool = (Boolean) n1.b.f5885a.get();
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        if (booleanValue) {
            E1.b.l(new IllegalStateException());
        }
        try {
            g3 = AbstractC0587a.f5865a.submit(new com.google.firebase.remoteconfig.b(3, atomicReference, block));
            kotlin.jvm.internal.j.b(g3);
        } catch (Throwable th) {
            g3 = AbstractC0228a.g(th);
        }
        Throwable a2 = C0681f.a(g3);
        if (a2 == null) {
            Future future = (Future) g3;
            try {
                g4 = future.get(j2, TimeUnit.MILLISECONDS);
            } catch (Throwable th2) {
                g4 = AbstractC0228a.g(th2);
            }
            Throwable a4 = C0681f.a(g4);
            if (a4 != null) {
                try {
                    if (a4 instanceof TimeoutException) {
                        TimeoutException timeoutException = (TimeoutException) a4;
                        Thread thread = (Thread) atomicReference.get();
                        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
                            arrayList = AbstractC0705g.J(stackTrace);
                        }
                        throw new ExecutionTimeoutException(timeoutException, arrayList);
                    }
                    throw a4;
                } catch (Throwable th3) {
                    g4 = AbstractC0228a.g(th3);
                }
            }
            if (C0681f.a(g4) != null) {
                try {
                    future.cancel(true);
                } catch (Throwable th4) {
                    AbstractC0228a.g(th4);
                }
            }
            return g4;
        }
        return AbstractC0228a.g(a2);
    }

    public static final void H(View view, InterfaceC0516f interfaceC0516f) {
        kotlin.jvm.internal.j.e(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, interfaceC0516f);
    }

    public static void I(p pVar, AbstractC0140a abstractC0140a, AbstractC0140a abstractC0140a2) {
        try {
            U2.a.g(C0684i.f6340a, m3.b.z(m3.b.k(pVar, abstractC0140a, abstractC0140a2)));
        } catch (Throwable th) {
            abstractC0140a2.resumeWith(AbstractC0228a.g(th));
            throw th;
        }
    }

    public static Integer J(HashSet hashSet) {
        if (hashSet.contains(4)) {
            return 4;
        }
        if (hashSet.contains(2)) {
            return 2;
        }
        if (hashSet.contains(0)) {
            return 0;
        }
        if (hashSet.contains(3)) {
            return 3;
        }
        return 1;
    }

    public static final U.f K(String name) {
        kotlin.jvm.internal.j.e(name, "name");
        return new U.f(name);
    }

    public static int L(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static final long M(int i, O2.c unit) {
        kotlin.jvm.internal.j.e(unit, "unit");
        if (unit.compareTo(O2.c.f1542d) <= 0) {
            long f4 = AbstractC0228a.f(i, unit, O2.c.f1540b) << 1;
            int i3 = O2.a.f1537d;
            int i4 = O2.b.f1539a;
            return f4;
        }
        return N(i, unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r5 > 4611686018427387903L) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long N(long r5, O2.c r7) {
        /*
            java.lang.String r0 = "unit"
            kotlin.jvm.internal.j.e(r7, r0)
            O2.c r0 = O2.c.f1540b
            r1 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            long r1 = a.AbstractC0228a.f(r1, r0, r7)
            long r3 = -r1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = 1
            if (r3 > 0) goto L24
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 > 0) goto L24
            long r5 = a.AbstractC0228a.f(r5, r7, r0)
            long r5 = r5 << r4
            int r7 = O2.a.f1537d
            int r7 = O2.b.f1539a
            return r5
        L24:
            O2.c r0 = O2.c.f1541c
            java.lang.String r1 = "targetUnit"
            kotlin.jvm.internal.j.e(r0, r1)
            java.util.concurrent.TimeUnit r0 = r0.f1547a
            java.util.concurrent.TimeUnit r7 = r7.f1547a
            long r5 = r0.convert(r5, r7)
            r0 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 >= 0) goto L3e
        L3c:
            r5 = r0
            goto L48
        L3e:
            r0 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L48
            goto L3c
        L48:
            long r5 = r5 << r4
            r0 = 1
            long r5 = r5 + r0
            int r7 = O2.a.f1537d
            int r7 = O2.b.f1539a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: T.b.N(long, O2.c):long");
    }

    public static int O(Activity activity, String str, int i) {
        if (i == -1) {
            return u(str, activity);
        }
        return 1;
    }

    public static final void P(r rVar, Object obj) {
        Object b4 = rVar.b(obj);
        if (!(b4 instanceof R2.i)) {
        } else {
            Object obj2 = ((R2.j) G.v(new R2.l(rVar, obj, null))).f2058a;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [K2.f, K2.d] */
    public static K2.f Q(int i, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            K2.f fVar = K2.f.f1125d;
            return K2.f.f1125d;
        }
        return new K2.d(i, i3 - 1, 1);
    }

    public static final boolean R(String str, F2.a aVar) {
        try {
            boolean booleanValue = ((Boolean) aVar.invoke()).booleanValue();
            if (!booleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static final void S(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i >= 0 && byteBuffer2.remaining() >= i && byteBuffer3.remaining() >= i && byteBuffer.remaining() >= i) {
            for (int i3 = 0; i3 < i; i3++) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
            }
            return;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final byte[] T(byte[] bArr, int i, byte[] bArr2, int i3, int i4) {
        if (i4 >= 0 && bArr.length - i4 >= i && bArr2.length - i4 >= i3) {
            byte[] bArr3 = new byte[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                bArr3[i5] = (byte) (bArr[i5 + i] ^ bArr2[i5 + i3]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final byte[] U(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return T(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            I1.l lVar = (I1.l) obj;
            Bundle bundle = new Bundle();
            bundle.putInt("event_type", lVar.f925a);
            bundle.putLong("event_timestamp", lVar.f926b);
            arrayList2.add(bundle);
        }
        return arrayList2;
    }

    public static final String b(Object[] objArr, int i, int i3, AbstractC0702d abstractC0702d) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i4];
            if (obj == abstractC0702d) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }

    public static final U.f c(String name) {
        kotlin.jvm.internal.j.e(name, "name");
        return new U.f(name);
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] e(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (i <= Api.BaseClientBuilder.API_PRIORITY_OTHER - bArr2.length) {
                i += bArr2.length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[i];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
            i3 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean f(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean g3 = g(inputStream, file);
                d(inputStream);
                return g3;
            } catch (Throwable th) {
                th = th;
                d(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static boolean g(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    d(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static V h(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            kotlin.jvm.internal.j.d(newInstance, "{\n            modelClass…).newInstance()\n        }");
            return (V) newInstance;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        }
    }

    public static int i(byte[] bArr, int i, C0332d c0332d) {
        int q3 = q(bArr, i, c0332d);
        int i3 = c0332d.f4092a;
        if (i3 >= 0) {
            if (i3 <= bArr.length - q3) {
                if (i3 == 0) {
                    c0332d.f4094c = AbstractC0337i.f4107b;
                    return q3;
                }
                c0332d.f4094c = AbstractC0337i.i(bArr, q3, i3);
                return q3 + i3;
            }
            throw InvalidProtocolBufferException.h();
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int j(byte[] bArr, int i) {
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
    }

    public static long k(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int l(b0 b0Var, int i, byte[] bArr, int i3, int i4, A a2, C0332d c0332d) {
        Object newInstance = b0Var.newInstance();
        b0 b0Var2 = b0Var;
        byte[] bArr2 = bArr;
        int i5 = i4;
        C0332d c0332d2 = c0332d;
        int C3 = C(newInstance, b0Var2, bArr2, i3, i5, c0332d2);
        b0Var2.b(newInstance);
        c0332d2.f4094c = newInstance;
        a2.add(newInstance);
        while (C3 < i5) {
            C0332d c0332d3 = c0332d2;
            int i6 = i5;
            int q3 = q(bArr2, C3, c0332d3);
            if (i != c0332d3.f4092a) {
                break;
            }
            byte[] bArr3 = bArr2;
            b0 b0Var3 = b0Var2;
            Object newInstance2 = b0Var3.newInstance();
            C3 = C(newInstance2, b0Var3, bArr3, q3, i6, c0332d3);
            b0Var2 = b0Var3;
            bArr2 = bArr3;
            i5 = i6;
            c0332d2 = c0332d3;
            b0Var2.b(newInstance2);
            c0332d2.f4094c = newInstance2;
            a2.add(newInstance2);
        }
        return C3;
    }

    public static int m(byte[] bArr, int i, C0332d c0332d) {
        int q3 = q(bArr, i, c0332d);
        int i3 = c0332d.f4092a;
        if (i3 >= 0) {
            if (i3 == 0) {
                c0332d.f4094c = "";
                return q3;
            }
            c0332d.f4094c = new String(bArr, q3, i3, B.f4029a);
            return q3 + i3;
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int n(byte[] bArr, int i, C0332d c0332d) {
        int q3 = q(bArr, i, c0332d);
        int i3 = c0332d.f4092a;
        if (i3 >= 0) {
            if (i3 == 0) {
                c0332d.f4094c = "";
                return q3;
            }
            c0332d.f4094c = q0.f4147a.k(bArr, q3, i3);
            return q3 + i3;
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int o(int i, byte[] bArr, int i3, int i4, e0 e0Var, C0332d c0332d) {
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                e0Var.d(i, Integer.valueOf(j(bArr, i3)));
                                return i3 + 4;
                            }
                            throw InvalidProtocolBufferException.a();
                        }
                        e0 c4 = e0.c();
                        int i6 = (i & (-8)) | 4;
                        int i7 = 0;
                        while (true) {
                            if (i3 >= i4) {
                                break;
                            }
                            int q3 = q(bArr, i3, c0332d);
                            i7 = c0332d.f4092a;
                            if (i7 == i6) {
                                i3 = q3;
                                break;
                            }
                            i3 = o(i7, bArr, q3, i4, c4, c0332d);
                        }
                        if (i3 <= i4 && i7 == i6) {
                            e0Var.d(i, c4);
                            return i3;
                        }
                        throw InvalidProtocolBufferException.g();
                    }
                    int q4 = q(bArr, i3, c0332d);
                    int i8 = c0332d.f4092a;
                    if (i8 >= 0) {
                        if (i8 <= bArr.length - q4) {
                            if (i8 == 0) {
                                e0Var.d(i, AbstractC0337i.f4107b);
                            } else {
                                e0Var.d(i, AbstractC0337i.i(bArr, q4, i8));
                            }
                            return q4 + i8;
                        }
                        throw InvalidProtocolBufferException.h();
                    }
                    throw InvalidProtocolBufferException.f();
                }
                e0Var.d(i, Long.valueOf(k(bArr, i3)));
                return i3 + 8;
            }
            int s3 = s(bArr, i3, c0332d);
            e0Var.d(i, Long.valueOf(c0332d.f4093b));
            return s3;
        }
        throw InvalidProtocolBufferException.a();
    }

    public static int p(int i, byte[] bArr, int i3, C0332d c0332d) {
        int i4 = i & 127;
        int i5 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 >= 0) {
            c0332d.f4092a = i4 | (b4 << 7);
            return i5;
        }
        int i6 = i4 | ((b4 & Byte.MAX_VALUE) << 7);
        int i7 = i3 + 2;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            c0332d.f4092a = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & Byte.MAX_VALUE) << 14);
        int i9 = i3 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            c0332d.f4092a = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & Byte.MAX_VALUE) << 21);
        int i11 = i3 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            c0332d.f4092a = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                c0332d.f4092a = i12;
                return i13;
            }
        }
    }

    public static int q(byte[] bArr, int i, C0332d c0332d) {
        int i3 = i + 1;
        byte b4 = bArr[i];
        if (b4 >= 0) {
            c0332d.f4092a = b4;
            return i3;
        }
        return p(b4, bArr, i3, c0332d);
    }

    public static int r(int i, byte[] bArr, int i3, int i4, A a2, C0332d c0332d) {
        AbstractC0352y abstractC0352y = (AbstractC0352y) a2;
        int q3 = q(bArr, i3, c0332d);
        abstractC0352y.g(c0332d.f4092a);
        while (q3 < i4) {
            int q4 = q(bArr, q3, c0332d);
            if (i != c0332d.f4092a) {
                break;
            }
            q3 = q(bArr, q4, c0332d);
            abstractC0352y.g(c0332d.f4092a);
        }
        return q3;
    }

    public static int s(byte[] bArr, int i, C0332d c0332d) {
        int i3 = i + 1;
        long j2 = bArr[i];
        if (j2 >= 0) {
            c0332d.f4093b = j2;
            return i3;
        }
        int i4 = i + 2;
        byte b4 = bArr[i3];
        long j3 = (j2 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b4 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & Byte.MAX_VALUE) << i5;
            b4 = bArr[i4];
            i4 = i6;
        }
        c0332d.f4093b = j3;
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String t(android.content.Context r3, java.lang.String r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 0
            if (r0 < r1) goto Le
            boolean r1 = y(r3, r2, r4)
            if (r1 == 0) goto Le
            return r4
        Le:
            r4 = 29
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            if (r0 >= r4) goto L24
            boolean r4 = y(r3, r2, r1)
            if (r4 == 0) goto L1b
            goto L2a
        L1b:
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r3 = y(r3, r2, r4)
            if (r3 == 0) goto L2b
            return r4
        L24:
            boolean r3 = y(r3, r2, r1)
            if (r3 == 0) goto L2b
        L2a:
            return r1
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: T.b.t(android.content.Context, java.lang.String):java.lang.String");
    }

    public static int u(String str, Activity activity) {
        if (activity != null) {
            boolean z3 = activity.getSharedPreferences(str, 0).getBoolean("sp_permission_handler_permission_was_denied_before", false);
            boolean e4 = AbstractC0744b.e(str, activity);
            if (z3) {
                if (!e4) {
                    e4 = true;
                } else {
                    e4 = false;
                }
            }
            if (!z3 && e4) {
                activity.getSharedPreferences(str, 0).edit().putBoolean("sp_permission_handler_permission_was_denied_before", true).apply();
            }
            if (z3 && e4) {
                return 4;
            }
        }
        return 0;
    }

    public static InterfaceC0766g v(InterfaceC0766g interfaceC0766g, InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        if (kotlin.jvm.internal.j.a(interfaceC0766g.getKey(), key)) {
            return interfaceC0766g;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x012f, code lost:
    
        if (r6 != false) goto L109;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList w(android.content.Context r5, int r6) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T.b.w(android.content.Context, int):java.util.ArrayList");
    }

    public static File x(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static boolean y(Context context, ArrayList arrayList, String str) {
        PackageInfo packageInfo;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((String) obj).equals(str)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = H2.c(packageManager, context.getPackageName(), H2.e());
            } else {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 4096);
            }
            if (packageInfo != null) {
                ArrayList arrayList2 = new ArrayList(Arrays.asList(packageInfo.requestedPermissions));
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    if (((String) obj2).equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean z(char c4) {
        if (!Character.isWhitespace(c4) && !Character.isSpaceChar(c4)) {
            return false;
        }
        return true;
    }
}
