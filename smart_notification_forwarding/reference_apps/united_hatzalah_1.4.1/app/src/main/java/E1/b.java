package E1;

import A.n;
import F0.C0035g2;
import J.G;
import N0.q;
import N0.s;
import P2.C0163m;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import android.webkit.WebView;
import com.android.apksig.apk.ApkFormatException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.internal.Code;
import com.uh.sf.R;
import io.flutter.embedding.android.KeyboardMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlSerializer;
import u0.AbstractC0733k;
import w0.C0752h;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static f f125a;

    public b() {
        new ConcurrentHashMap();
    }

    public static N0.c A(W0.d dVar, M0.c cVar, byte[] bArr, HashMap hashMap, int i) {
        boolean z3;
        N0.c cVar2 = new N0.c(0);
        ByteBuffer byteBuffer = q.a(dVar, cVar, 1845461005).f1500a;
        N0.e eVar = new N0.e();
        ((ArrayList) cVar2.f1432c).add(eVar);
        try {
            p3.h.J(q.c(byteBuffer), CertificateFactory.getInstance("X.509"), eVar, q(hashMap), bArr, i);
            if (!cVar2.a() && !cVar2.b()) {
                z3 = true;
            } else {
                z3 = false;
            }
            cVar2.f1431b = z3;
            return cVar2;
        } catch (ApkFormatException | BufferUnderflowException unused) {
            eVar.a(20, new Object[0]);
            return cVar2;
        } catch (CertificateException e4) {
            throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    public static R2.c a(int i, R2.a aVar, int i3) {
        if ((i3 & 2) != 0) {
            aVar = R2.a.f2018a;
        }
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != Integer.MAX_VALUE) {
                        if (aVar == R2.a.f2018a) {
                            return new R2.c(i);
                        }
                        return new R2.m(i, aVar);
                    }
                    return new R2.c(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                if (aVar == R2.a.f2018a) {
                    return new R2.c(0);
                }
                return new R2.m(1, aVar);
            }
            if (aVar == R2.a.f2018a) {
                return new R2.m(1, R2.a.f2019b);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (aVar == R2.a.f2018a) {
            R2.g.f2055g.getClass();
            return new R2.c(R2.f.f2054b);
        }
        return new R2.m(1, aVar);
    }

    public static void b(Throwable th, Throwable exception) {
        kotlin.jvm.internal.j.e(th, "<this>");
        kotlin.jvm.internal.j.e(exception, "exception");
        if (th != exception) {
            Integer num = B2.a.f82a;
            if (num != null && num.intValue() < 19) {
                Method method = A2.a.f67a;
                if (method != null) {
                    method.invoke(th, exception);
                    return;
                }
                return;
            }
            th.addSuppressed(exception);
        }
    }

    public static final Object c(Task task, InterfaceC0763d interfaceC0763d) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception == null) {
                if (!task.isCanceled()) {
                    return task.getResult();
                }
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
            throw exception;
        }
        C0163m c0163m = new C0163m(1, m3.b.z(interfaceC0763d));
        c0163m.r();
        task.addOnCompleteListener(Z2.a.f2731a, new C0035g2(c0163m, 9));
        Object q3 = c0163m.q();
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return q3;
    }

    public static final void d(int i, int i3) {
        if (i <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i3 + ").");
    }

    public static byte[] j(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                byte b4 = (byte) ((bArr[i] << 1) & 254);
                bArr2[i] = b4;
                if (i < 15) {
                    bArr2[i] = (byte) (((byte) ((bArr[i + 1] >> 7) & 1)) | b4);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }

    public static final void l(Throwable th) {
        Log.e("FingerprintJS", "Unexpected error occurred. Feel free to create an issue on Github repository of the fingerprintjs-android library.", th);
    }

    public static InvocationHandler n() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = AbstractC0733k.b();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static String p(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i != 1) {
            if (i != 7) {
                switch (i) {
                    case 9:
                        break;
                    case 10:
                        return context.getString(R.string.fingerprint_error_user_canceled);
                    case 11:
                        return context.getString(R.string.fingerprint_error_no_fingerprints);
                    case Code.UNIMPLEMENTED /* 12 */:
                        return context.getString(R.string.fingerprint_error_hw_not_present);
                    default:
                        Log.e("BiometricUtils", "Unknown error code: " + i);
                        return context.getString(R.string.default_error_msg);
                }
            }
            return context.getString(R.string.fingerprint_error_lockout);
        }
        return context.getString(R.string.fingerprint_error_hw_not_available);
    }

    public static HashMap q(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            Map map = (Map) entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry2 : map.entrySet()) {
                arrayList.add(new W0.g(Integer.valueOf(((s) entry2.getKey()).f1490a), (byte[]) entry2.getValue()));
            }
            Collections.sort(arrayList, new M0.a(1));
            Integer num = (Integer) entry.getKey();
            char[] cArr = q.f1482a;
            int size = arrayList.size();
            int i = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                i3 += ((byte[]) ((W0.g) obj).f2459b).length + 12;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i3);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                W0.g gVar = (W0.g) obj2;
                byte[] bArr = (byte[]) gVar.f2459b;
                allocate.putInt(bArr.length + 8);
                allocate.putInt(((Integer) gVar.f2458a).intValue());
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            hashMap2.put(num, allocate.array());
        }
        return hashMap2;
    }

    public static final M2.d s(BufferedReader bufferedReader) {
        return new M2.a(new D2.c(bufferedReader, 0));
    }

    public static C0752h t(String str) {
        String group;
        String description;
        if (str != null && !N2.f.U(str)) {
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (matcher.matches() && (group = matcher.group(1)) != null) {
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                if (group2 != null) {
                    int parseInt2 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    if (group3 != null) {
                        int parseInt3 = Integer.parseInt(group3);
                        if (matcher.group(4) != null) {
                            description = matcher.group(4);
                        } else {
                            description = "";
                        }
                        kotlin.jvm.internal.j.d(description, "description");
                        return new C0752h(parseInt, parseInt2, parseInt3, description);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static void v(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag(null, "locales");
                newSerializer.attribute(null, "application_locales", str);
                newSerializer.endTag(null, "locales");
                newSerializer.endDocument();
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
            } catch (Exception unused) {
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
            } catch (Throwable th) {
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException | IOException unused3) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [J.G, W.b] */
    public static W.b w(MappedByteBuffer mappedByteBuffer) {
        long j2;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i = duplicate.getShort() & 65535;
        if (i <= 100) {
            duplicate.position(duplicate.position() + 6);
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    int i4 = duplicate.getInt();
                    duplicate.position(duplicate.position() + 4);
                    j2 = duplicate.getInt() & KeyboardMap.kValueMask;
                    duplicate.position(duplicate.position() + 4);
                    if (1835365473 == i4) {
                        break;
                    }
                    i3++;
                } else {
                    j2 = -1;
                    break;
                }
            }
            if (j2 != -1) {
                duplicate.position(duplicate.position() + ((int) (j2 - duplicate.position())));
                duplicate.position(duplicate.position() + 12);
                long j3 = duplicate.getInt() & KeyboardMap.kValueMask;
                for (int i5 = 0; i5 < j3; i5++) {
                    int i6 = duplicate.getInt();
                    long j4 = duplicate.getInt() & KeyboardMap.kValueMask;
                    duplicate.getInt();
                    if (1164798569 == i6 || 1701669481 == i6) {
                        duplicate.position((int) (j4 + j2));
                        ?? g3 = new G();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        g3.f946d = duplicate;
                        g3.f943a = position;
                        int i7 = position - duplicate.getInt(position);
                        g3.f944b = i7;
                        g3.f945c = ((ByteBuffer) g3.f946d).getShort(i7);
                        return g3;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r2 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        if (r1.isEmpty() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002b, code lost:
    
        if (r5 != 4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0038, code lost:
    
        if (r3.getName().equals("locales") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003a, code lost:
    
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        if (r2 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String x(android.content.Context r8) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = ""
            java.io.FileInputStream r2 = r8.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L5a
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
        L15:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            r6 = 1
            if (r5 == r6) goto L41
            r6 = 3
            if (r5 != r6) goto L28
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            if (r7 <= r4) goto L41
            goto L28
        L26:
            r8 = move-exception
            goto L47
        L28:
            if (r5 == r6) goto L15
            r6 = 4
            if (r5 != r6) goto L2e
            goto L15
        L2e:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
            if (r5 == 0) goto L15
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L26 java.lang.Throwable -> L4d
        L41:
            if (r2 == 0) goto L50
        L43:
            r2.close()     // Catch: java.io.IOException -> L50
            goto L50
        L47:
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.io.IOException -> L4c
        L4c:
            throw r8
        L4d:
            if (r2 == 0) goto L50
            goto L43
        L50:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L57
            goto L5a
        L57:
            r8.deleteFile(r0)
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.b.x(android.content.Context):java.lang.String");
    }

    public static final String y(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.j.d(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0126, code lost:
    
        if (r8 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0221, code lost:
    
        if (r9 == null) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static G0.l z(java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 1777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.b.z(java.lang.String):G0.l");
    }

    public abstract Typeface e(Context context, z.e eVar, Resources resources, int i);

    public abstract Typeface f(Context context, G.i[] iVarArr, int i);

    public Typeface g(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface h(Context context, InputStream inputStream) {
        File x3 = T.b.x(context);
        if (x3 == null) {
            return null;
        }
        try {
            if (!T.b.g(inputStream, x3)) {
                return null;
            }
            return Typeface.createFromFile(x3.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            x3.delete();
        }
    }

    public Typeface i(Context context, Resources resources, int i, String str, int i3) {
        File x3 = T.b.x(context);
        if (x3 == null) {
            return null;
        }
        try {
            if (!T.b.f(x3, resources, i)) {
                return null;
            }
            return Typeface.createFromFile(x3.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            x3.delete();
        }
    }

    public abstract String k(byte[] bArr, int i, int i3);

    public abstract int m(String str, byte[] bArr, int i, int i3);

    public G.i o(G.i[] iVarArr, int i) {
        int i3;
        boolean z3;
        int i4;
        new n(0);
        if ((i & 1) == 0) {
            i3 = 400;
        } else {
            i3 = 700;
        }
        if ((i & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        G.i iVar = null;
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (G.i iVar2 : iVarArr) {
            int abs = Math.abs(iVar2.f793c - i3) * 2;
            if (iVar2.f794d == z3) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            int i6 = abs + i4;
            if (iVar == null || i5 > i6) {
                iVar = iVar2;
                i5 = i6;
            }
        }
        return iVar;
    }

    public boolean r(byte[] bArr, int i, int i3) {
        if (u(bArr, i, i3) == 0) {
            return true;
        }
        return false;
    }

    public abstract int u(byte[] bArr, int i, int i3);
}
