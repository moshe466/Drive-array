package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzan {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<zzk> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzan(java.lang.String r14, com.google.android.gms.internal.ads.zzd r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzg
            long r3 = r15.zzh
            long r5 = r15.zzi
            long r7 = r15.zzj
            long r9 = r15.zzk
            java.util.List<com.google.android.gms.internal.ads.zzk> r0 = r15.zzm
            if (r0 == 0) goto L10
        Le:
            r11 = r0
            goto L44
        L10:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzl
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L23:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto Le
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzk r11 = new com.google.android.gms.internal.ads.zzk
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L23
        L44:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.<init>(java.lang.String, com.google.android.gms.internal.ads.zzd):void");
    }

    private zzan(String str, String str2, long j, long j2, long j3, long j4, List<zzk> list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzan a(zzaq zzaqVar) {
        if (zzal.a((InputStream) zzaqVar) == 538247942) {
            return new zzan(zzal.a(zzaqVar), zzal.a(zzaqVar), zzal.b((InputStream) zzaqVar), zzal.b((InputStream) zzaqVar), zzal.b((InputStream) zzaqVar), zzal.b((InputStream) zzaqVar), zzal.b(zzaqVar));
        }
        throw new IOException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(OutputStream outputStream) {
        try {
            zzal.a(outputStream, 538247942);
            zzal.a(outputStream, this.b);
            zzal.a(outputStream, this.c == null ? "" : this.c);
            zzal.a(outputStream, this.d);
            zzal.a(outputStream, this.e);
            zzal.a(outputStream, this.f);
            zzal.a(outputStream, this.g);
            List<zzk> list = this.h;
            if (list != null) {
                zzal.a(outputStream, list.size());
                for (zzk zzkVar : list) {
                    zzal.a(outputStream, zzkVar.getName());
                    zzal.a(outputStream, zzkVar.getValue());
                }
            } else {
                zzal.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.d("%s", e.toString());
            return false;
        }
    }
}
