package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class a2 {

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<String, String> f5161f;

    /* renamed from: k, reason: collision with root package name */
    private static Object f5166k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f5167l;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f5156a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    private static final Uri f5157b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f5158c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f5159d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f5160e = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Boolean> f5162g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Integer> f5163h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Long> f5164i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Float> f5165j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private static String[] f5168m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (a2.class) {
            if (f5161f == null) {
                f5160e.set(false);
                f5161f = new HashMap<>();
                f5166k = new Object();
                f5167l = false;
                contentResolver.registerContentObserver(f5156a, true, new z1(null));
            } else if (f5160e.getAndSet(false)) {
                f5161f.clear();
                f5162g.clear();
                f5163h.clear();
                f5164i.clear();
                f5165j.clear();
                f5166k = new Object();
                f5167l = false;
            }
            Object obj = f5166k;
            if (f5161f.containsKey(str)) {
                String str3 = f5161f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : f5168m) {
                if (str.startsWith(str4)) {
                    if (!f5167l || f5161f.isEmpty()) {
                        f5161f.putAll(b(contentResolver, f5168m));
                        f5167l = true;
                        if (f5161f.containsKey(str)) {
                            String str5 = f5161f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(f5156a, null, null, new String[]{str}, null);
            if (query == null) {
                if (query != null) {
                }
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    d(obj, str, null);
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                d(obj, str, string);
                return string != null ? string : null;
            } finally {
                query.close();
            }
        }
    }

    private static Map<String, String> b(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f5157b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void d(Object obj, String str, String str2) {
        synchronized (a2.class) {
            if (obj == f5166k) {
                f5161f.put(str, str2);
            }
        }
    }
}
