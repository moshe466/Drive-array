package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class o2 {
    private static p2 a(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String valueOf = String.valueOf(file);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
                        sb2.append("Parsed ");
                        sb2.append(valueOf);
                        p2 p2Var = new p2(hashMap);
                        bufferedReader.close();
                        return p2Var;
                    }
                    String[] split = readLine.split(" ", 3);
                    if (split.length == 3) {
                        String str = split[0];
                        String decode = Uri.decode(split[1]);
                        String decode2 = Uri.decode(split[2]);
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new HashMap());
                        }
                        ((Map) hashMap.get(str)).put(decode, decode2);
                    } else if (readLine.length() != 0) {
                        "Invalid: ".concat(readLine);
                    }
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static k3<p2> b(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z10 = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z10 = true;
        }
        if (!z10) {
            return k3.d();
        }
        if (c2.a() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        k3<File> c10 = c(context);
        return c10.b() ? k3.a(a(c10.c())) : k3.d();
    }

    private static k3<File> c(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? k3.a(file) : k3.d();
        } catch (RuntimeException unused) {
            return k3.d();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
