package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ba {
    private final com.google.android.play.core.splitcompat.c a;
    private final ag b;
    private final Context c;

    public ba(Context context, com.google.android.play.core.splitcompat.c cVar, ag agVar) {
        this.a = cVar;
        this.b = agVar;
        this.c = context;
    }

    public static <T> ax<T> a(Object obj, String str, Class<T> cls) {
        return new ax<>(obj, a(obj, str), cls);
    }

    public static <R, P0> R a(Class<?> cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(a(cls, str, (Class<?>[]) new Class[]{cls3}).invoke(null, p0));
        } catch (Exception e) {
            throw new az(String.format("Failed to invoke static method %s on type %s", str, cls), e);
        }
    }

    public static <R, P0, P1> R a(Class<?> cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(a(cls, str, (Class<?>[]) new Class[]{cls3, cls4}).invoke(null, p0, p1));
        } catch (Exception e) {
            throw new az(String.format("Failed to invoke static method %s on type %s", str, cls), e);
        }
    }

    public static <R, P0> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2}).invoke(obj, p0));
        } catch (Exception e) {
            throw new az(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static <R, P0, P1, P2> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2, cls3, cls4}).invoke(obj, p0, p1, p2));
        } catch (Exception e) {
            throw new az(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    private static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new az(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new az(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) {
        return a(obj.getClass(), str, clsArr);
    }

    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    private boolean a(String str, List<X509Certificate> list) {
        try {
            X509Certificate[][] a = ag.a(str);
            if (a != null && a.length != 0 && a[0].length != 0) {
                return a(a, list);
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32);
            sb.append("Downloaded split ");
            sb.append(str);
            sb.append(" is not signed.");
            Log.e("SplitCompat", sb.toString());
            return false;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32);
            sb2.append("Downloaded split ");
            sb2.append(str);
            sb2.append(" is not signed.");
            Log.e("SplitCompat", sb2.toString(), e);
            return false;
        }
    }

    private static boolean a(X509Certificate[][] x509CertificateArr, List<X509Certificate> list) {
        boolean z;
        if (list.isEmpty()) {
            Log.e("SplitCompat", "No certificates found for app.");
            return false;
        }
        Iterator<X509Certificate> it = list.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return true;
            }
            X509Certificate next = it.next();
            int length = x509CertificateArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (x509CertificateArr[i][0].equals(next)) {
                    break;
                }
                i++;
            }
        } while (z);
        Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
        return false;
    }

    public static <T> ax b(Object obj, String str, Class<T> cls) {
        return new ax(obj, a(obj, str), cls, (byte) 0);
    }

    private List<X509Certificate> b() {
        Signature[] c = c();
        if (c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Signature signature : c) {
            X509Certificate a = a(signature);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    private Signature[] c() {
        try {
            return this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public boolean a() {
        try {
            File c = this.a.c();
            List<X509Certificate> b = b();
            if (b == null || b.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            File[] listFiles = c.listFiles();
            Arrays.sort(listFiles);
            for (int length = listFiles.length - 1; length >= 0; length--) {
                File file = listFiles[length];
                try {
                    if (!a(file.getAbsolutePath(), b)) {
                        Log.e("SplitCompat", "Split verification failure.");
                        return false;
                    }
                    try {
                        file.renameTo(this.a.a(file));
                    } catch (IOException e) {
                        Log.e("SplitCompat", "Cannot write verified split.", e);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.e("SplitCompat", "Split verification error.", e2);
                    return false;
                }
            }
            return true;
        } catch (IOException e3) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e3);
            return false;
        }
    }

    public boolean a(List<Intent> list) {
        Iterator<Intent> it = list.iterator();
        while (it.hasNext()) {
            if (!this.a.b(it.next().getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
