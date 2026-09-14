package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzle;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class zzke implements zzgt {
    private static volatile zzke zza;
    private zzfu zzb;
    private zzfa zzc;
    private zzac zzd;
    private zzfd zze;
    private zzka zzf;
    private zzn zzg;
    private final zzki zzh;
    private zzid zzi;
    private final zzga zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    @VisibleForTesting
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class zza implements zzae {
        zzbr.zzg a;
        List<Long> b;
        List<zzbr.zzc> c;
        private long zzd;

        private zza() {
        }

        /* synthetic */ zza(zzke zzkeVar, zzkd zzkdVar) {
            this();
        }

        private static long zza(zzbr.zzc zzcVar) {
            return ((zzcVar.zze() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final void zza(zzbr.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.a = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final boolean zza(long j, zzbr.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (this.c.size() > 0 && zza(this.c.get(0)) != zza(zzcVar)) {
                return false;
            }
            long zzbn = this.zzd + zzcVar.zzbn();
            if (zzbn >= Math.max(0, zzap.zzi.zza(null).intValue())) {
                return false;
            }
            this.zzd = zzbn;
            this.c.add(zzcVar);
            this.b.add(Long.valueOf(j));
            return this.c.size() < Math.max(1, zzap.zzj.zza(null).intValue());
        }
    }

    private zzke(zzkj zzkjVar) {
        this(zzkjVar, null);
    }

    private zzke(zzkj zzkjVar, zzga zzgaVar) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkjVar);
        this.zzj = zzga.zza(zzkjVar.a, null);
        this.zzy = -1L;
        zzki zzkiVar = new zzki(this);
        zzkiVar.zzal();
        this.zzh = zzkiVar;
        zzfa zzfaVar = new zzfa(this);
        zzfaVar.zzal();
        this.zzc = zzfaVar;
        zzfu zzfuVar = new zzfu(this);
        zzfuVar.zzal();
        this.zzb = zzfuVar;
        this.zzj.zzq().zza(new zzkd(this, zzkjVar));
    }

    @VisibleForTesting
    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzm r9, com.google.android.gms.measurement.internal.zzg r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.zza(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.zzg, java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public static zzke zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzke.class) {
                if (zza == null) {
                    zza = new zzke(new zzkj(context));
                }
            }
        }
        return zza;
    }

    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String str5;
        String str6;
        int i;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzew.zza(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str5 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str5 = "";
        }
        String str7 = str5;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    applicationLabel.toString();
                }
                str6 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                str6 = "Unknown";
                i = Integer.MIN_VALUE;
            }
            return new zzm(str, str2, str6, i, str7, this.zzj.zzb().zze(), this.zzj.zzi().a(context, str), (String) null, z, false, "", 0L, j, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null, (zzle.zzb() && this.zzj.zzb().zze(str, zzap.zzcc)) ? str4 : null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzew.zza(str), "Unknown");
            return null;
        }
    }

    @WorkerThread
    private final zzm zza(String str) {
        zzg zzb = zze().zzb(str);
        if (zzb == null || TextUtils.isEmpty(zzb.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb2 = zzb(zzb);
        if (zzb2 == null || zzb2.booleanValue()) {
            return new zzm(str, zzb.zze(), zzb.zzl(), zzb.zzm(), zzb.zzn(), zzb.zzo(), zzb.zzp(), (String) null, zzb.zzr(), false, zzb.zzi(), zzb.zzae(), 0L, 0, zzb.zzaf(), zzb.zzag(), false, zzb.zzf(), zzb.zzah(), zzb.zzq(), zzb.zzai(), (zzle.zzb() && this.zzj.zzb().zze(str, zzap.zzcc)) ? zzb.zzg() : null);
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzew.zza(str));
        return null;
    }

    @VisibleForTesting
    private static void zza(zzbr.zzc.zza zzaVar, int i, String str) {
        List<zzbr.zze> zza2 = zzaVar.zza();
        for (int i2 = 0; i2 < zza2.size(); i2++) {
            if ("_err".equals(zza2.get(i2).zza())) {
                return;
            }
        }
        zzaVar.zza((zzbr.zze) zzbr.zze.zzh().zza("_err").zza(Long.valueOf(i).longValue()).zzu()).zza((zzbr.zze) zzbr.zze.zzh().zza("_ev").zzb(str).zzu());
    }

    @VisibleForTesting
    private static void zza(zzbr.zzc.zza zzaVar, @NonNull String str) {
        List<zzbr.zze> zza2 = zzaVar.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(zza2.get(i).zza())) {
                zzaVar.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbr.zzg.zza zzaVar) {
        zzaVar.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zzaVar.zzb(); i++) {
            zzbr.zzc zzb = zzaVar.zzb(i);
            if (zzb.zze() < zzaVar.zzf()) {
                zzaVar.zzb(zzb.zze());
            }
            if (zzb.zze() > zzaVar.zzg()) {
                zzaVar.zzc(zzb.zze());
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzbr.zzg.zza zzaVar, long j, boolean z) {
        String str = z ? "_se" : "_lte";
        zzkn zzc = zze().zzc(zzaVar.zzj(), str);
        zzkn zzknVar = (zzc == null || zzc.e == null) ? new zzkn(zzaVar.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j)) : new zzkn(zzaVar.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc.e).longValue() + j));
        zzbr.zzk zzkVar = (zzbr.zzk) zzbr.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzknVar.e).longValue()).zzu();
        boolean z2 = false;
        int a = zzki.a(zzaVar, str);
        if (a >= 0) {
            zzaVar.zza(a, zzkVar);
            z2 = true;
        }
        if (!z2) {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zze().zza(zzknVar);
            this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzknVar.e);
        }
    }

    @WorkerThread
    private final void zza(zzg zzgVar) {
        ArrayMap arrayMap;
        zzw();
        if (zzle.zzb() && this.zzj.zzb().zze(zzgVar.zzc(), zzap.zzcc)) {
            if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzg()) && TextUtils.isEmpty(zzgVar.zzf())) {
                a(zzgVar.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzf())) {
            a(zzgVar.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzgVar);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzgVar.zzc());
            zzbo.zzb zza3 = zzc().zza(zzgVar.zzc());
            String zzb = zzc().zzb(zzgVar.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzb);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzfa zzd = zzd();
            String zzc = zzgVar.zzc();
            zzkf zzkfVar = new zzkf(this);
            zzd.zzd();
            zzd.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkfVar);
            zzd.zzq().zzb(new zzfe(zzd, zzc, url, null, arrayMap, zzkfVar));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzew.zza(zzgVar.zzc()), zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzkj zzkjVar) {
        this.zzj.zzq().zzd();
        zzac zzacVar = new zzac(this);
        zzacVar.zzal();
        this.zzd = zzacVar;
        this.zzj.zzb().a(this.zzb);
        zzn zznVar = new zzn(this);
        zznVar.zzal();
        this.zzg = zznVar;
        zzid zzidVar = new zzid(this);
        zzidVar.zzal();
        this.zzi = zzidVar;
        zzka zzkaVar = new zzka(this);
        zzkaVar.zzal();
        this.zzf = zzkaVar;
        this.zze = new zzfd(this);
        if (this.zzp != this.zzq) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzk = true;
    }

    @VisibleForTesting
    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzj.zzb().zza(zzap.zzcp) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(zzbr.zzc.zza zzaVar, zzbr.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzbr.zze a = zzki.a((zzbr.zzc) zzaVar.zzu(), "_sc");
        String zzc = a == null ? null : a.zzc();
        zzh();
        zzbr.zze a2 = zzki.a((zzbr.zzc) zzaVar2.zzu(), "_pc");
        String zzc2 = a2 != null ? a2.zzc() : null;
        if (zzc2 == null || !zzc2.equals(zzc)) {
            return false;
        }
        zzb(zzaVar, zzaVar2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
    
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0128, code lost:
    
        if (r8 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x012a, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x01c3, code lost:
    
        if (r5 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0216, code lost:
    
        if (r5 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0269, code lost:
    
        if (r8 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0236, code lost:
    
        if (r8 == null) goto L107;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05a8 A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0683 A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x078a A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x079a A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x07b4 A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x027f A[Catch: all -> 0x0f30, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0f18 A[Catch: all -> 0x0f30, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x0f30, blocks: (B:3:0x0009, B:19:0x0084, B:20:0x026d, B:22:0x0271, B:27:0x027f, B:28:0x02a7, B:31:0x02b5, B:34:0x02db, B:36:0x0314, B:41:0x032a, B:43:0x0334, B:46:0x0801, B:48:0x035c, B:51:0x0374, B:68:0x03d5, B:71:0x03df, B:73:0x03ed, B:75:0x0438, B:76:0x040c, B:78:0x041c, B:85:0x0445, B:87:0x0475, B:88:0x04a3, B:90:0x04d7, B:91:0x04dd, B:94:0x04e9, B:96:0x051e, B:97:0x053b, B:99:0x0541, B:101:0x054f, B:103:0x0562, B:104:0x0557, B:112:0x0569, B:114:0x056f, B:115:0x058d, B:117:0x05a8, B:118:0x05b4, B:120:0x05ba, B:124:0x05e1, B:125:0x05ce, B:133:0x05e7, B:135:0x05f3, B:137:0x05ff, B:142:0x0650, B:143:0x066f, B:145:0x0683, B:147:0x068d, B:150:0x06a2, B:152:0x06b5, B:154:0x06c3, B:158:0x078a, B:160:0x0794, B:162:0x079a, B:163:0x07b0, B:164:0x07b4, B:166:0x07c7, B:167:0x07de, B:168:0x07e7, B:173:0x06d8, B:175:0x06e4, B:178:0x06f9, B:180:0x070c, B:182:0x071a, B:185:0x072a, B:187:0x0742, B:189:0x074e, B:192:0x0761, B:194:0x0774, B:196:0x0622, B:200:0x0636, B:202:0x063c, B:204:0x0647, B:214:0x0396, B:217:0x03a0, B:220:0x03aa, B:229:0x081d, B:231:0x082b, B:233:0x0836, B:235:0x0868, B:236:0x083e, B:238:0x0847, B:240:0x084d, B:242:0x0859, B:244:0x0863, B:251:0x086d, B:254:0x0885, B:255:0x088d, B:257:0x0893, B:262:0x08aa, B:263:0x08b5, B:265:0x08bb, B:267:0x08cd, B:271:0x08da, B:273:0x08e0, B:274:0x091f, B:276:0x0931, B:278:0x0950, B:280:0x095e, B:282:0x0964, B:284:0x096e, B:285:0x09a0, B:287:0x09a6, B:291:0x09b6, B:293:0x09c1, B:289:0x09bb, B:296:0x09c4, B:298:0x09d6, B:299:0x09d9, B:370:0x0a42, B:372:0x0a5d, B:373:0x0a6e, B:375:0x0a72, B:377:0x0a7e, B:378:0x0a88, B:380:0x0a8c, B:382:0x0a94, B:383:0x0aa2, B:384:0x0aad, B:391:0x0aeb, B:392:0x0af3, B:394:0x0af9, B:398:0x0b0b, B:400:0x0b0f, B:404:0x0b45, B:406:0x0b5b, B:409:0x0b8b, B:411:0x0ba1, B:413:0x0bce, B:415:0x0bf4, B:422:0x0c3a, B:424:0x0c4b, B:426:0x0c4f, B:428:0x0c53, B:430:0x0c57, B:433:0x0c6b, B:435:0x0c8c, B:436:0x0c95, B:443:0x0caf, B:458:0x0b1d, B:460:0x0b21, B:462:0x0b2b, B:464:0x0b2f, B:303:0x0d75, B:305:0x0d87, B:306:0x0d8a, B:308:0x0d9c, B:309:0x0e11, B:311:0x0e17, B:313:0x0e2c, B:316:0x0e33, B:317:0x0e66, B:318:0x0e3b, B:320:0x0e47, B:321:0x0e4d, B:322:0x0e77, B:323:0x0e8e, B:326:0x0e96, B:328:0x0e9b, B:331:0x0eab, B:333:0x0ec5, B:334:0x0ede, B:336:0x0ee6, B:337:0x0f08, B:344:0x0ef7, B:345:0x0db6, B:347:0x0dbc, B:349:0x0dc6, B:350:0x0dcd, B:355:0x0ddd, B:356:0x0de4, B:358:0x0e03, B:359:0x0e0a, B:360:0x0e07, B:361:0x0de1, B:363:0x0dca, B:483:0x08fd, B:487:0x0902, B:489:0x0914, B:491:0x0f18, B:506:0x012a, B:522:0x01c5, B:547:0x0f2c, B:548:0x0f2f), top: B:2:0x0009, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0117 A[Catch: SQLiteException -> 0x023a, all -> 0x0f28, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x023a, blocks: (B:502:0x0111, B:504:0x0117, B:507:0x012f, B:509:0x0133, B:510:0x0145, B:512:0x014b, B:513:0x015c, B:515:0x0168, B:516:0x0188, B:550:0x017c, B:554:0x0225), top: B:501:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x012f A[Catch: SQLiteException -> 0x023a, all -> 0x0f28, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x023a, blocks: (B:502:0x0111, B:504:0x0117, B:507:0x012f, B:509:0x0133, B:510:0x0145, B:512:0x014b, B:513:0x015c, B:515:0x0168, B:516:0x0188, B:550:0x017c, B:554:0x0225), top: B:501:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03c2  */
    /* JADX WARN: Type inference failed for: r3v180 */
    /* JADX WARN: Type inference failed for: r3v181 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v34 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zza(java.lang.String r60, long r61) {
        /*
            Method dump skipped, instructions count: 3900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.zza(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final void zzaa() {
        zzw();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.zzo.clear();
    }

    @VisibleForTesting
    @WorkerThread
    private final boolean zzab() {
        zzey zzi;
        String str;
        FileLock fileLock;
        zzw();
        if (this.zzj.zzb().zza(zzap.zzca) && (fileLock = this.zzu) != null && fileLock.isValid()) {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
        try {
            this.zzv = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzu = this.zzv.tryLock();
            if (this.zzu != null) {
                this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                return true;
            }
            this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            e = e;
            zzi = this.zzj.zzr().zzf();
            str = "Failed to acquire storage lock";
            zzi.zza(str, e);
            return false;
        } catch (IOException e2) {
            e = e2;
            zzi = this.zzj.zzr().zzf();
            str = "Failed to access storage lock file";
            zzi.zza(str, e);
            return false;
        } catch (OverlappingFileLockException e3) {
            e = e3;
            zzi = this.zzj.zzr().zzi();
            str = "Storage lock already acquired";
            zzi.zza(str, e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zzac() {
        zzw();
        b();
        return this.zzl;
    }

    @WorkerThread
    private final Boolean zzb(zzg zzgVar) {
        try {
            if (zzgVar.zzm() != -2147483648L) {
                if (zzgVar.zzm() == Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionName;
                if (zzgVar.zzl() != null && zzgVar.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzb(zzbr.zzc.zza zzaVar, zzbr.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzbr.zze a = zzki.a((zzbr.zzc) zzaVar.zzu(), "_et");
        if (!a.zzd() || a.zze() <= 0) {
            return;
        }
        long zze = a.zze();
        zzh();
        zzbr.zze a2 = zzki.a((zzbr.zzc) zzaVar2.zzu(), "_et");
        if (a2 != null && a2.zze() > 0) {
            zze += a2.zze();
        }
        zzh();
        zzki.a(zzaVar2, "_et", Long.valueOf(zze));
        zzh();
        zzki.a(zzaVar, "_fr", 1L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:242|(1:244)(1:267)|245|(7:250|251|(1:253)|254|(0)|43|(0)(0))|259|260|261|262|251|(0)|254|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x023a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x023c, code lost:
    
        r7.zzr().zzf().zza("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzew.zza(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x063d A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0657 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0672 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0741 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0758 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0769 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x07da A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x07eb A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0803 A[Catch: all -> 0x091e, TRY_LEAVE, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x084c A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x08a9 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x08d9 A[Catch: all -> 0x091e, TRY_LEAVE, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x06a9 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x06bf A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x06d9 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0272 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02a9 A[Catch: all -> 0x091e, TRY_LEAVE, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02f7 A[Catch: all -> 0x091e, TryCatch #1 {all -> 0x091e, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b8, B:45:0x02f7, B:47:0x02fc, B:48:0x0315, B:52:0x0326, B:54:0x033b, B:56:0x0342, B:57:0x035b, B:61:0x037e, B:65:0x03a6, B:66:0x03bf, B:69:0x03cf, B:72:0x03f2, B:73:0x0410, B:76:0x041a, B:78:0x042a, B:80:0x0436, B:82:0x043c, B:83:0x0447, B:85:0x044f, B:87:0x045f, B:89:0x046f, B:90:0x047a, B:92:0x0486, B:93:0x049d, B:95:0x04ca, B:98:0x04da, B:101:0x0516, B:102:0x053e, B:104:0x0578, B:105:0x057d, B:107:0x0585, B:108:0x058a, B:110:0x0592, B:111:0x0597, B:113:0x05a0, B:114:0x05a6, B:116:0x05b3, B:117:0x05b8, B:119:0x05be, B:121:0x05ce, B:123:0x05d8, B:125:0x05e0, B:126:0x05e5, B:128:0x05ef, B:130:0x05f9, B:132:0x0601, B:133:0x0603, B:134:0x0635, B:136:0x063d, B:137:0x0642, B:139:0x0657, B:141:0x0661, B:142:0x0664, B:144:0x0672, B:146:0x067c, B:148:0x0680, B:150:0x068b, B:151:0x06f9, B:153:0x0741, B:155:0x074f, B:157:0x0758, B:158:0x075d, B:160:0x0769, B:161:0x07d0, B:163:0x07da, B:164:0x07e1, B:166:0x07eb, B:167:0x07f2, B:168:0x07fd, B:170:0x0803, B:173:0x0834, B:174:0x0844, B:176:0x084c, B:177:0x0852, B:179:0x0858, B:184:0x08a3, B:186:0x08a9, B:187:0x08c5, B:189:0x08d9, B:193:0x086a, B:195:0x088e, B:201:0x08ad, B:202:0x0697, B:204:0x06a9, B:206:0x06ad, B:208:0x06bf, B:209:0x06f6, B:210:0x06d9, B:212:0x06df, B:213:0x0607, B:215:0x0615, B:217:0x061f, B:219:0x0627, B:220:0x062a, B:222:0x0632, B:223:0x0530, B:226:0x0125, B:229:0x0137, B:231:0x014e, B:237:0x016a, B:238:0x0196, B:240:0x019c, B:242:0x01aa, B:244:0x01b6, B:245:0x01c0, B:247:0x01cb, B:250:0x01d2, B:251:0x0268, B:253:0x0272, B:256:0x02a9, B:259:0x0201, B:261:0x021f, B:262:0x024d, B:266:0x023c, B:267:0x01bb, B:269:0x016f, B:270:0x018c), top: B:35:0x0108, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0324  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(com.google.android.gms.measurement.internal.zzan r28, com.google.android.gms.measurement.internal.zzm r29) {
        /*
            Method dump skipped, instructions count: 2346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    private static void zzb(zzkb zzkbVar) {
        if (zzkbVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkbVar.zzaj()) {
            return;
        }
        String valueOf = String.valueOf(zzkbVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private final boolean zze(zzm zzmVar) {
        return (zzle.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzcc)) ? (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzv) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true : (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true;
    }

    private final zzfd zzt() {
        zzfd zzfdVar = this.zze;
        if (zzfdVar != null) {
            return zzfdVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzka zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    @WorkerThread
    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzff zzc = this.zzj.zzc();
        zzc.zzaa();
        zzc.zzd();
        long zza2 = zzc.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + zzc.zzp().zzh().nextInt(86400000);
            zzc.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzy() {
        zzw();
        b();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a4  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzz() {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.zzz():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void a() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0158, code lost:
    
        r8.zzj.zzc().zze.zza(r8.zzj.zzm().currentTimeMillis());
     */
    @com.google.android.gms.common.util.VisibleForTesting
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.a(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(zzan zzanVar, zzm zzmVar) {
        List<zzv> zza2;
        List<zzv> zza3;
        List<zzv> zza4;
        zzey zzf;
        String str;
        Object zza5;
        String zzc;
        Object obj;
        List<String> list;
        zzan zzanVar2 = zzanVar;
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzw();
        b();
        String str2 = zzmVar.zza;
        long j = zzanVar2.zzd;
        if (zzh().a(zzanVar2, zzmVar)) {
            if (!zzmVar.zzh) {
                c(zzmVar);
                return;
            }
            if (this.zzj.zzb().zze(str2, zzap.zzbk) && (list = zzmVar.zzu) != null) {
                if (!list.contains(zzanVar2.zza)) {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str2, zzanVar2.zza, zzanVar2.zzc);
                    return;
                } else {
                    Bundle zzb = zzanVar2.zzb.zzb();
                    zzb.putLong("ga_safelisted", 1L);
                    zzanVar2 = new zzan(zzanVar2.zza, new zzam(zzb), zzanVar2.zzc, zzanVar2.zzd);
                }
            }
            zze().zzf();
            try {
                zzac zze = zze();
                Preconditions.checkNotEmpty(str2);
                zze.zzd();
                zze.zzak();
                if (j < 0) {
                    zze.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzew.zza(str2), Long.valueOf(j));
                    zza2 = Collections.emptyList();
                } else {
                    zza2 = zze.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzv zzvVar : zza2) {
                    if (zzvVar != null) {
                        this.zzj.zzr().zzw().zza("User property timed out", zzvVar.zza, this.zzj.zzj().zzc(zzvVar.zzc.zza), zzvVar.zzc.zza());
                        if (zzvVar.zzg != null) {
                            zzb(new zzan(zzvVar.zzg, j), zzmVar);
                        }
                        zze().zze(str2, zzvVar.zzc.zza);
                    }
                }
                zzac zze2 = zze();
                Preconditions.checkNotEmpty(str2);
                zze2.zzd();
                zze2.zzak();
                if (j < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying expired conditional properties", zzew.zza(str2), Long.valueOf(j));
                    zza3 = Collections.emptyList();
                } else {
                    zza3 = zze2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(zza3.size());
                for (zzv zzvVar2 : zza3) {
                    if (zzvVar2 != null) {
                        this.zzj.zzr().zzw().zza("User property expired", zzvVar2.zza, this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzc.zza());
                        zze().zzb(str2, zzvVar2.zzc.zza);
                        if (zzvVar2.zzk != null) {
                            arrayList.add(zzvVar2.zzk);
                        }
                        zze().zze(str2, zzvVar2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    zzb(new zzan((zzan) obj2, j), zzmVar);
                }
                zzac zze3 = zze();
                String str3 = zzanVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zze3.zzd();
                zze3.zzak();
                if (j < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzew.zza(str2), zze3.zzo().zza(str3), Long.valueOf(j));
                    zza4 = Collections.emptyList();
                } else {
                    zza4 = zze3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(zza4.size());
                for (zzv zzvVar3 : zza4) {
                    if (zzvVar3 != null) {
                        zzkl zzklVar = zzvVar3.zzc;
                        zzkn zzknVar = new zzkn(zzvVar3.zza, zzvVar3.zzb, zzklVar.zza, j, zzklVar.zza());
                        if (zze().zza(zzknVar)) {
                            zzf = this.zzj.zzr().zzw();
                            str = "User property triggered";
                            zza5 = zzvVar3.zza;
                            zzc = this.zzj.zzj().zzc(zzknVar.c);
                            obj = zzknVar.e;
                        } else {
                            zzf = this.zzj.zzr().zzf();
                            str = "Too many active user properties, ignoring";
                            zza5 = zzew.zza(zzvVar3.zza);
                            zzc = this.zzj.zzj().zzc(zzknVar.c);
                            obj = zzknVar.e;
                        }
                        zzf.zza(str, zza5, zzc, obj);
                        if (zzvVar3.zzi != null) {
                            arrayList2.add(zzvVar3.zzi);
                        }
                        zzvVar3.zzc = new zzkl(zzknVar);
                        zzvVar3.zze = true;
                        zze().zza(zzvVar3);
                    }
                }
                zzb(zzanVar2, zzmVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList2.get(i2);
                    i2++;
                    zzb(new zzan((zzan) obj3, j), zzmVar);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(zzan zzanVar, String str) {
        zzg zzb = zze().zzb(str);
        if (zzb == null || TextUtils.isEmpty(zzb.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb2 = zzb(zzb);
        if (zzb2 == null) {
            if (!"_ui".equals(zzanVar.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzew.zza(str));
            }
        } else if (!zzb2.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzew.zza(str));
            return;
        }
        a(zzanVar, new zzm(str, zzb.zze(), zzb.zzl(), zzb.zzm(), zzb.zzn(), zzb.zzo(), zzb.zzp(), (String) null, zzb.zzr(), false, zzb.zzi(), zzb.zzae(), 0L, 0, zzb.zzaf(), zzb.zzag(), false, zzb.zzf(), zzb.zzah(), zzb.zzq(), zzb.zzai(), (zzle.zzb() && this.zzj.zzb().zze(zzb.zzc(), zzap.zzcc)) ? zzb.zzg() : null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzkb zzkbVar) {
        this.zzp++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(zzkl zzklVar, zzm zzmVar) {
        zzaj zza2;
        zzw();
        b();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                c(zzmVar);
                return;
            }
            int zzc = this.zzj.zzi().zzc(zzklVar.zza);
            zzga zzgaVar = this.zzj;
            if (zzc != 0) {
                zzgaVar.zzi();
                String zza3 = zzkm.zza(zzklVar.zza, 24, true);
                String str = zzklVar.zza;
                this.zzj.zzi().a(zzmVar.zza, zzc, "_ev", zza3, str != null ? str.length() : 0);
                return;
            }
            int b = zzgaVar.zzi().b(zzklVar.zza, zzklVar.zza());
            if (b != 0) {
                this.zzj.zzi();
                String zza4 = zzkm.zza(zzklVar.zza, 24, true);
                Object zza5 = zzklVar.zza();
                this.zzj.zzi().a(zzmVar.zza, b, "_ev", zza4, (zza5 == null || !((zza5 instanceof String) || (zza5 instanceof CharSequence))) ? 0 : String.valueOf(zza5).length());
                return;
            }
            Object c = this.zzj.zzi().c(zzklVar.zza, zzklVar.zza());
            if (c == null) {
                return;
            }
            if ("_sid".equals(zzklVar.zza) && this.zzj.zzb().zze(zzmVar.zza, zzap.zzaq)) {
                long j = zzklVar.zzb;
                String str2 = zzklVar.zze;
                long j2 = 0;
                zzkn zzc2 = zze().zzc(zzmVar.zza, "_sno");
                if (zzc2 != null) {
                    Object obj = zzc2.e;
                    if (obj instanceof Long) {
                        j2 = ((Long) obj).longValue();
                        a(new zzkl("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
                    }
                }
                if (zzc2 != null) {
                    this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc2.e);
                }
                if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzat) && (zza2 = zze().zza(zzmVar.zza, "_s")) != null) {
                    j2 = zza2.c;
                    this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                }
                a(new zzkl("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
            }
            zzkn zzknVar = new zzkn(zzmVar.zza, zzklVar.zze, zzklVar.zza, zzklVar.zzb, c);
            this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzknVar.c), c);
            zze().zzf();
            try {
                c(zzmVar);
                boolean zza6 = zze().zza(zzknVar);
                zze().b_();
                if (zza6) {
                    this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzknVar.c), zzknVar.e);
                } else {
                    this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzknVar.c), zzknVar.e);
                    this.zzj.zzi().a(zzmVar.zza, 9, null, null, 0);
                }
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void a(zzm zzmVar) {
        if (this.zzw != null) {
            this.zzx = new ArrayList();
            this.zzx.addAll(this.zzw);
        }
        zzac zze = zze();
        String str = zzmVar.zza;
        Preconditions.checkNotEmpty(str);
        zze.zzd();
        zze.zzak();
        try {
            SQLiteDatabase a = zze.a();
            String[] strArr = {str};
            int delete = a.delete("apps", "app_id=?", strArr) + 0 + a.delete("events", "app_id=?", strArr) + a.delete("user_attributes", "app_id=?", strArr) + a.delete("conditional_properties", "app_id=?", strArr) + a.delete("raw_events", "app_id=?", strArr) + a.delete("raw_events_metadata", "app_id=?", strArr) + a.delete("queue", "app_id=?", strArr) + a.delete("audience_filter_values", "app_id=?", strArr) + a.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze.zzr().zzf().zza("Error resetting analytics data. appId, error", zzew.zza(str), e);
        }
        if (com.google.android.gms.internal.measurement.zzkm.zzb() && this.zzj.zzb().zza(zzap.zzch)) {
            if (zzmVar.zzh) {
                b(zzmVar);
            }
        } else {
            zzm zza2 = zza(this.zzj.zzn(), zzmVar.zza, zzmVar.zzb, zzmVar.zzh, zzmVar.zzo, zzmVar.zzp, zzmVar.zzm, zzmVar.zzr, zzmVar.zzv);
            if (zzmVar.zzh) {
                b(zza2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(zzv zzvVar) {
        zzm zza2 = zza(zzvVar.zza);
        if (zza2 != null) {
            a(zzvVar, zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(zzv zzvVar, zzm zzmVar) {
        zzey zzf;
        String str;
        Object zza2;
        String zzc;
        Object zza3;
        zzey zzf2;
        String str2;
        Object zza4;
        String zzc2;
        Object obj;
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotEmpty(zzvVar.zza);
        Preconditions.checkNotNull(zzvVar.zzb);
        Preconditions.checkNotNull(zzvVar.zzc);
        Preconditions.checkNotEmpty(zzvVar.zzc.zza);
        zzw();
        b();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                c(zzmVar);
                return;
            }
            zzv zzvVar2 = new zzv(zzvVar);
            boolean z = false;
            zzvVar2.zze = false;
            zze().zzf();
            try {
                zzv zzd = zze().zzd(zzvVar2.zza, zzvVar2.zzc.zza);
                if (zzd != null && !zzd.zzb.equals(zzvVar2.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzb, zzd.zzb);
                }
                if (zzd != null && zzd.zze) {
                    zzvVar2.zzb = zzd.zzb;
                    zzvVar2.zzd = zzd.zzd;
                    zzvVar2.zzh = zzd.zzh;
                    zzvVar2.zzf = zzd.zzf;
                    zzvVar2.zzi = zzd.zzi;
                    zzvVar2.zze = zzd.zze;
                    zzvVar2.zzc = new zzkl(zzvVar2.zzc.zza, zzd.zzc.zzb, zzvVar2.zzc.zza(), zzd.zzc.zze);
                } else if (TextUtils.isEmpty(zzvVar2.zzf)) {
                    zzvVar2.zzc = new zzkl(zzvVar2.zzc.zza, zzvVar2.zzd, zzvVar2.zzc.zza(), zzvVar2.zzc.zze);
                    zzvVar2.zze = true;
                    z = true;
                }
                if (zzvVar2.zze) {
                    zzkl zzklVar = zzvVar2.zzc;
                    zzkn zzknVar = new zzkn(zzvVar2.zza, zzvVar2.zzb, zzklVar.zza, zzklVar.zzb, zzklVar.zza());
                    if (zze().zza(zzknVar)) {
                        zzf2 = this.zzj.zzr().zzw();
                        str2 = "User property updated immediately";
                        zza4 = zzvVar2.zza;
                        zzc2 = this.zzj.zzj().zzc(zzknVar.c);
                        obj = zzknVar.e;
                    } else {
                        zzf2 = this.zzj.zzr().zzf();
                        str2 = "(2)Too many active user properties, ignoring";
                        zza4 = zzew.zza(zzvVar2.zza);
                        zzc2 = this.zzj.zzj().zzc(zzknVar.c);
                        obj = zzknVar.e;
                    }
                    zzf2.zza(str2, zza4, zzc2, obj);
                    if (z && zzvVar2.zzi != null) {
                        zzb(new zzan(zzvVar2.zzi, zzvVar2.zzd), zzmVar);
                    }
                }
                if (zze().zza(zzvVar2)) {
                    zzf = this.zzj.zzr().zzw();
                    str = "Conditional property added";
                    zza2 = zzvVar2.zza;
                    zzc = this.zzj.zzj().zzc(zzvVar2.zzc.zza);
                    zza3 = zzvVar2.zzc.zza();
                } else {
                    zzf = this.zzj.zzr().zzf();
                    str = "Too many conditional properties, ignoring";
                    zza2 = zzew.zza(zzvVar2.zza);
                    zzc = this.zzj.zzj().zzc(zzvVar2.zzc.zza);
                    zza3 = zzvVar2.zzc.zza();
                }
                zzf.zza(str, zza2, zzc, zza3);
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(Runnable runnable) {
        zzw();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
    
        r6.zzj.zzc().zze.zza(r6.zzj.zzm().currentTimeMillis());
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132 A[Catch: all -> 0x0179, TryCatch #1 {all -> 0x0179, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x016d, B:24:0x0061, B:31:0x00b0, B:32:0x00c5, B:35:0x00cd, B:37:0x00d9, B:39:0x00df, B:43:0x00ec, B:46:0x011c, B:48:0x0132, B:49:0x015a, B:51:0x0164, B:53:0x016a, B:54:0x0142, B:55:0x0103, B:57:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[Catch: all -> 0x0179, TryCatch #1 {all -> 0x0179, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x016d, B:24:0x0061, B:31:0x00b0, B:32:0x00c5, B:35:0x00cd, B:37:0x00d9, B:39:0x00df, B:43:0x00ec, B:46:0x011c, B:48:0x0132, B:49:0x015a, B:51:0x0164, B:53:0x016a, B:54:0x0142, B:55:0x0103, B:57:0x010d), top: B:4:0x0029, outer: #0 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        zzz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(zzkl zzklVar, zzm zzmVar) {
        zzw();
        b();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                c(zzmVar);
                return;
            }
            if (!this.zzj.zzb().zze(zzmVar.zza, zzap.zzba)) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzklVar.zza));
                zze().zzf();
                try {
                    c(zzmVar);
                    zze().zzb(zzmVar.zza, zzklVar.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzklVar.zza));
                    return;
                } finally {
                }
            }
            if ("_npa".equals(zzklVar.zza) && zzmVar.zzs != null) {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                a(new zzkl("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzmVar.zzs.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                return;
            }
            this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzklVar.zza));
            zze().zzf();
            try {
                c(zzmVar);
                zze().zzb(zzmVar.zza, zzklVar.zza);
                zze().b_();
                this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzklVar.zza));
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0475 A[Catch: all -> 0x04d3, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04aa A[Catch: all -> 0x04d3, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01eb A[Catch: all -> 0x04d3, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0225 A[Catch: all -> 0x04d3, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024f A[Catch: all -> 0x04d3, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x026b A[Catch: all -> 0x04d3, TRY_LEAVE, TryCatch #0 {all -> 0x04d3, blocks: (B:28:0x00ae, B:30:0x00be, B:32:0x00cc, B:34:0x00d6, B:36:0x00da, B:39:0x00eb, B:41:0x0103, B:43:0x012a, B:45:0x0136, B:47:0x014d, B:49:0x0175, B:52:0x017c, B:54:0x01bf, B:58:0x01eb, B:60:0x01f6, B:63:0x0205, B:65:0x020d, B:67:0x0213, B:70:0x0222, B:72:0x0225, B:73:0x024a, B:75:0x024f, B:76:0x0257, B:78:0x026b, B:81:0x027f, B:83:0x02a6, B:84:0x02b4, B:86:0x02eb, B:87:0x02ee, B:89:0x02f2, B:90:0x02f5, B:92:0x0316, B:97:0x03f6, B:98:0x03fb, B:99:0x040b, B:100:0x0465, B:102:0x0475, B:104:0x048f, B:105:0x0496, B:106:0x04a6, B:107:0x04c4, B:112:0x0332, B:114:0x035d, B:116:0x0365, B:118:0x036f, B:123:0x0385, B:125:0x038f, B:128:0x039a, B:130:0x03ad, B:140:0x03c0, B:132:0x03d8, B:134:0x03de, B:135:0x03e3, B:137:0x03e9, B:147:0x0345, B:150:0x0413, B:152:0x044a, B:153:0x044d, B:155:0x0451, B:156:0x0454, B:157:0x04aa, B:159:0x04ae, B:162:0x025f, B:170:0x01d5, B:175:0x010d, B:179:0x0117), top: B:27:0x00ae, inners: #2, #3 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.b(com.google.android.gms.measurement.internal.zzm):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(zzv zzvVar) {
        zzm zza2 = zza(zzvVar.zza);
        if (zza2 != null) {
            b(zzvVar, zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(zzv zzvVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotEmpty(zzvVar.zza);
        Preconditions.checkNotNull(zzvVar.zzc);
        Preconditions.checkNotEmpty(zzvVar.zzc.zza);
        zzw();
        b();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                c(zzmVar);
                return;
            }
            zze().zzf();
            try {
                c(zzmVar);
                zzv zzd = zze().zzd(zzvVar.zza, zzvVar.zzc.zza);
                if (zzd != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzvVar.zza, this.zzj.zzj().zzc(zzvVar.zzc.zza));
                    zze().zze(zzvVar.zza, zzvVar.zzc.zza);
                    if (zzd.zze) {
                        zze().zzb(zzvVar.zza, zzvVar.zzc.zza);
                    }
                    if (zzvVar.zzk != null) {
                        zzb(this.zzj.zzi().a(zzvVar.zza, zzvVar.zzk.zza, zzvVar.zzk.zzb != null ? zzvVar.zzk.zzb.zzb() : null, zzd.zzb, zzvVar.zzk.zzd, true, false), zzmVar);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzew.zza(zzvVar.zza), this.zzj.zzj().zzc(zzvVar.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final zzg c(zzm zzmVar) {
        zzw();
        b();
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzg zzb = zze().zzb(zzmVar.zza);
        String zzb2 = this.zzj.zzc().zzb(zzmVar.zza);
        if (!com.google.android.gms.internal.measurement.zzkn.zzb() || !this.zzj.zzb().zza(zzap.zzck)) {
            return zza(zzmVar, zzb, zzb2);
        }
        if (zzb == null) {
            zzb = new zzg(this.zzj, zzmVar.zza);
            zzb.zza(this.zzj.zzi().zzk());
            zzb.zze(zzb2);
        } else if (!zzb2.equals(zzb.zzh())) {
            zzb.zze(zzb2);
            zzb.zza(this.zzj.zzi().zzk());
        }
        zzb.zzb(zzmVar.zzb);
        zzb.zzc(zzmVar.zzr);
        if (zzle.zzb() && this.zzj.zzb().zze(zzb.zzc(), zzap.zzcc)) {
            zzb.zzd(zzmVar.zzv);
        }
        if (!TextUtils.isEmpty(zzmVar.zzk)) {
            zzb.zzf(zzmVar.zzk);
        }
        long j = zzmVar.zze;
        if (j != 0) {
            zzb.zzd(j);
        }
        if (!TextUtils.isEmpty(zzmVar.zzc)) {
            zzb.zzg(zzmVar.zzc);
        }
        zzb.zzc(zzmVar.zzj);
        String str = zzmVar.zzd;
        if (str != null) {
            zzb.zzh(str);
        }
        zzb.zze(zzmVar.zzf);
        zzb.zza(zzmVar.zzh);
        if (!TextUtils.isEmpty(zzmVar.zzg)) {
            zzb.zzi(zzmVar.zzg);
        }
        zzb.zzp(zzmVar.zzl);
        zzb.zzb(zzmVar.zzo);
        zzb.zzc(zzmVar.zzp);
        if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzba)) {
            zzb.zza(zzmVar.zzs);
        }
        zzb.zzf(zzmVar.zzt);
        if (zzb.zza()) {
            zze().zza(zzb);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void c() {
        zzg zzb;
        String str;
        zzey zzx;
        String str2;
        zzw();
        b();
        this.zzt = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                zzx = this.zzj.zzr().zzi();
                str2 = "Upload data called on the client side before use of service was decided";
            } else {
                if (!zzag.booleanValue()) {
                    if (this.zzn <= 0) {
                        zzw();
                        if (this.zzw != null) {
                            zzx = this.zzj.zzr().zzx();
                            str2 = "Uploading requested multiple times";
                        } else {
                            if (zzd().zzf()) {
                                long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                                zza((String) null, currentTimeMillis - zzx.zzk());
                                long zza2 = this.zzj.zzc().zzc.zza();
                                if (zza2 != 0) {
                                    this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                                }
                                String d_ = zze().d_();
                                if (TextUtils.isEmpty(d_)) {
                                    this.zzy = -1L;
                                    String zza3 = zze().zza(currentTimeMillis - zzx.zzk());
                                    if (!TextUtils.isEmpty(zza3) && (zzb = zze().zzb(zza3)) != null) {
                                        zza(zzb);
                                    }
                                } else {
                                    if (this.zzy == -1) {
                                        this.zzy = zze().zzaa();
                                    }
                                    List<Pair<zzbr.zzg, Long>> zza4 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzap.zzg), Math.max(0, this.zzj.zzb().zzb(d_, zzap.zzh)));
                                    if (!zza4.isEmpty()) {
                                        Iterator<Pair<zzbr.zzg, Long>> it = zza4.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                str = null;
                                                break;
                                            }
                                            zzbr.zzg zzgVar = (zzbr.zzg) it.next().first;
                                            if (!TextUtils.isEmpty(zzgVar.zzad())) {
                                                str = zzgVar.zzad();
                                                break;
                                            }
                                        }
                                        if (str != null) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= zza4.size()) {
                                                    break;
                                                }
                                                zzbr.zzg zzgVar2 = (zzbr.zzg) zza4.get(i).first;
                                                if (!TextUtils.isEmpty(zzgVar2.zzad()) && !zzgVar2.zzad().equals(str)) {
                                                    zza4 = zza4.subList(0, i);
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                        zzbr.zzf.zza zzb2 = zzbr.zzf.zzb();
                                        int size = zza4.size();
                                        ArrayList arrayList = new ArrayList(zza4.size());
                                        boolean z = this.zzj.zzb().zza(zzap.zza) && this.zzj.zzb().zzd(d_);
                                        for (int i2 = 0; i2 < size; i2++) {
                                            zzbr.zzg.zza zzbm = ((zzbr.zzg) zza4.get(i2).first).zzbm();
                                            arrayList.add((Long) zza4.get(i2).second);
                                            zzbr.zzg.zza zza5 = zzbm.zzg(this.zzj.zzb().zze()).zza(currentTimeMillis);
                                            this.zzj.zzu();
                                            zza5.zzb(false);
                                            if (!z) {
                                                zzbm.zzn();
                                            }
                                            if (this.zzj.zzb().zze(d_, zzap.zzbf)) {
                                                zzbm.zzl(zzh().a(((zzbr.zzg) ((com.google.android.gms.internal.measurement.zzfd) zzbm.zzu())).zzbi()));
                                            }
                                            zzb2.zza(zzbm);
                                        }
                                        String a = this.zzj.zzr().zza(2) ? zzh().a((zzbr.zzf) ((com.google.android.gms.internal.measurement.zzfd) zzb2.zzu())) : null;
                                        zzh();
                                        byte[] zzbi = ((zzbr.zzf) ((com.google.android.gms.internal.measurement.zzfd) zzb2.zzu())).zzbi();
                                        String zza6 = zzap.zzq.zza(null);
                                        try {
                                            URL url = new URL(zza6);
                                            Preconditions.checkArgument(!arrayList.isEmpty());
                                            if (this.zzw != null) {
                                                this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                                            } else {
                                                this.zzw = new ArrayList(arrayList);
                                            }
                                            this.zzj.zzc().zzd.zza(currentTimeMillis);
                                            this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", size > 0 ? zzb2.zza(0).zzx() : "?", Integer.valueOf(zzbi.length), a);
                                            this.zzs = true;
                                            zzfa zzd = zzd();
                                            zzkg zzkgVar = new zzkg(this, d_);
                                            zzd.zzd();
                                            zzd.zzak();
                                            Preconditions.checkNotNull(url);
                                            Preconditions.checkNotNull(zzbi);
                                            Preconditions.checkNotNull(zzkgVar);
                                            zzd.zzq().zzb(new zzfe(zzd, d_, url, zzbi, null, zzkgVar));
                                        } catch (MalformedURLException unused) {
                                            this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzew.zza(d_), zza6);
                                        }
                                    }
                                }
                            }
                            this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                        }
                    }
                    zzz();
                }
                zzx = this.zzj.zzr().zzf();
                str2 = "Upload called in the client side when service should be used";
            }
            zzx.zza(str2);
        } finally {
            this.zzt = false;
            zzaa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(zzm zzmVar) {
        try {
            return (String) this.zzj.zzq().zza(new zzkh(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzew.zza(zzmVar.zza), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void d() {
        zzey zzf;
        Integer valueOf;
        Integer valueOf2;
        String str;
        zzw();
        b();
        if (!this.zzm) {
            this.zzm = true;
            zzw();
            b();
            if ((this.zzj.zzb().zza(zzap.zzbc) || zzac()) && zzab()) {
                int zza2 = zza(this.zzv);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    zzf = this.zzj.zzr().zzf();
                    valueOf = Integer.valueOf(zza2);
                    valueOf2 = Integer.valueOf(zzaf);
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza2 < zzaf) {
                    if (zza(zzaf, this.zzv)) {
                        zzf = this.zzj.zzr().zzx();
                        valueOf = Integer.valueOf(zza2);
                        valueOf2 = Integer.valueOf(zzaf);
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzf = this.zzj.zzr().zzf();
                        valueOf = Integer.valueOf(zza2);
                        valueOf2 = Integer.valueOf(zzaf);
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzf.zza(str, valueOf, valueOf2);
            }
        }
        if (this.zzl || this.zzj.zzb().zza(zzap.zzbc)) {
            return;
        }
        this.zzj.zzr().zzv().zza("This instance being marked as an uploader");
        this.zzl = true;
        zzz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.zzq++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzga f() {
        return this.zzj;
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    public final zzfu zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfa zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzac zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    public final zzn zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzid zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzki zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzeu zzi() {
        return this.zzj.zzj();
    }

    public final zzkm zzj() {
        return this.zzj.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzft zzq() {
        return this.zzj.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzew zzr() {
        return this.zzj.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzu() {
        return this.zzj.zzu();
    }
}
