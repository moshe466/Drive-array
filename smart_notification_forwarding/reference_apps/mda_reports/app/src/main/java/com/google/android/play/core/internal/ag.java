package com.google.android.play.core.internal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ag {
    public static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public static Bundle a(List<String> list, List<String> list2) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!list.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(list));
        }
        if (!list2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(list2));
        }
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        return bundle;
    }

    public static ad a() {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            throw new AssertionError("Unsupported Android Version");
        }
        switch (i) {
            case 21:
                return new af();
            case 22:
                return new am();
            case 23:
                return new al();
            case 24:
                return new ap();
            case 25:
                return new as();
            case 26:
                return new ar();
            case 27:
                if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                    return new aw();
                }
                break;
        }
        return new av();
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CommonUtils.SHA256_INSTANCE);
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static X509Certificate[][] a(String str) {
        return h.a(str);
    }
}
