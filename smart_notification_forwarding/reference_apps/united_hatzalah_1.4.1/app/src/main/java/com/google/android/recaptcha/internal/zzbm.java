package com.google.android.recaptcha.internal;

import K2.a;
import K2.b;
import N2.n;
import android.content.Context;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class zzbm implements zzaq {
    private final Context zza;
    private final String zzb = "rce_";

    public zzbm(Context context) {
        this.zza = context;
        new zzcd(context);
    }

    @Override // com.google.android.recaptcha.internal.zzaq
    public final String zza(String str) {
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str)));
        if (file.exists()) {
            return new String(zzcd.zza(file), StandardCharsets.UTF_8);
        }
        return null;
    }

    @Override // com.google.android.recaptcha.internal.zzaq
    public final void zzb() {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (File file : listFiles) {
                    if (n.M(file.getName(), this.zzb)) {
                        arrayList.add(file);
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((File) obj).delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.recaptcha.internal.zzaq
    public final void zzc(String str, String str2) {
        a aVar = new a('A', 'z');
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(aVar, 10));
        Iterator it = aVar.iterator();
        while (((b) it).f1116c) {
            b bVar = (b) it;
            int i = bVar.f1117d;
            if (i == bVar.f1115b) {
                if (bVar.f1116c) {
                    bVar.f1116c = false;
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                bVar.f1117d = bVar.f1114a + i;
            }
            arrayList.add(Character.valueOf((char) i));
        }
        List t02 = AbstractC0707i.t0(arrayList);
        Collections.shuffle(t02);
        String h02 = AbstractC0707i.h0(((ArrayList) t02).subList(0, 8), "", null, null, null, 62);
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(h02)));
        zzcd.zzb(file, String.valueOf(str2).getBytes(StandardCharsets.UTF_8));
        file.renameTo(new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str))));
    }

    @Override // com.google.android.recaptcha.internal.zzaq
    public final boolean zzd(String str) {
        File file;
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            file = null;
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file2 = listFiles[i];
                    if (j.a(file2.getName(), this.zzb + str)) {
                        file = file2;
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception unused) {
        }
        if (file == null) {
            return false;
        }
        return true;
    }
}
