package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;

/* loaded from: classes.dex */
final class zzgt implements Handler.Callback, zzmc, zzme, zzni {
    private int repeatMode = 0;
    private int state = 1;
    private final zzhf[] zzacq;
    private final zznf zzacr;
    private final zzddu zzact;
    private final zzhl zzacw;
    private final zzhi zzacx;
    private boolean zzacz;
    private boolean zzadd;
    private zzhg zzade;
    private zzhc zzadi;
    private zzgv zzadj;
    private final zzhe[] zzadz;
    private final zzha zzaea;
    private zzmb zzaeb;
    private final zzoo zzaed;
    private final zzddu zzaee;
    private final HandlerThread zzaef;
    private final zzgk zzaeg;
    private zzhf zzaeh;
    private zzog zzaei;
    private zzhf[] zzaej;
    private boolean zzaek;
    private boolean zzael;
    private int zzaem;
    private int zzaen;
    private long zzaeo;
    private int zzaep;
    private zzgu zzaeq;
    private long zzaer;
    private zzgs zzaes;
    private zzgs zzaet;
    private zzgs zzaeu;

    public zzgt(zzhf[] zzhfVarArr, zznf zznfVar, zzha zzhaVar, boolean z, int i, zzddu zzdduVar, zzgv zzgvVar, zzgk zzgkVar) {
        this.zzacq = zzhfVarArr;
        this.zzacr = zznfVar;
        this.zzaea = zzhaVar;
        this.zzacz = z;
        this.zzact = zzdduVar;
        this.zzadj = zzgvVar;
        this.zzaeg = zzgkVar;
        this.zzadz = new zzhe[zzhfVarArr.length];
        for (int i2 = 0; i2 < zzhfVarArr.length; i2++) {
            zzhfVarArr[i2].setIndex(i2);
            this.zzadz[i2] = zzhfVarArr[i2].zzdp();
        }
        this.zzaed = new zzoo();
        this.zzaej = new zzhf[0];
        this.zzacw = new zzhl();
        this.zzacx = new zzhi();
        zznfVar.zza(this);
        this.zzadi = zzhc.zzagb;
        this.zzaef = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzaef.start();
        this.zzaee = new zzddu(this.zzaef.getLooper(), this);
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzact.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final int zza(int i, zzhg zzhgVar, zzhg zzhgVar2) {
        int zzew = zzhgVar.zzew();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzew && i3 == -1; i4++) {
            i2 = zzhgVar.zza(i2, this.zzacx, this.zzacw, this.repeatMode);
            i3 = zzhgVar2.zzc(zzhgVar.zza(i2, this.zzacx, true).zzado);
        }
        return i3;
    }

    private final long zza(int i, long j) {
        zzgs zzgsVar;
        zzek();
        this.zzael = false;
        setState(2);
        zzgs zzgsVar2 = this.zzaeu;
        if (zzgsVar2 == null) {
            zzgs zzgsVar3 = this.zzaes;
            if (zzgsVar3 != null) {
                zzgsVar3.release();
            }
            zzgsVar = null;
        } else {
            zzgsVar = null;
            while (zzgsVar2 != null) {
                if (zzgsVar2.zzads == i && zzgsVar2.zzadv) {
                    zzgsVar = zzgsVar2;
                } else {
                    zzgsVar2.release();
                }
                zzgsVar2 = zzgsVar2.zzadx;
            }
        }
        zzgs zzgsVar4 = this.zzaeu;
        if (zzgsVar4 != zzgsVar || zzgsVar4 != this.zzaet) {
            for (zzhf zzhfVar : this.zzaej) {
                zzhfVar.disable();
            }
            this.zzaej = new zzhf[0];
            this.zzaei = null;
            this.zzaeh = null;
            this.zzaeu = null;
        }
        if (zzgsVar != null) {
            zzgsVar.zzadx = null;
            this.zzaes = zzgsVar;
            this.zzaet = zzgsVar;
            zzb(zzgsVar);
            zzgs zzgsVar5 = this.zzaeu;
            if (zzgsVar5.zzadw) {
                j = zzgsVar5.zzadn.zzeg(j);
            }
            zzdq(j);
            zzeo();
        } else {
            this.zzaes = null;
            this.zzaet = null;
            this.zzaeu = null;
            zzdq(j);
        }
        this.zzaee.sendEmptyMessage(2);
        return j;
    }

    private final Pair<Integer, Long> zza(zzgu zzguVar) {
        zzhg zzhgVar = zzguVar.zzade;
        if (zzhgVar.isEmpty()) {
            zzhgVar = this.zzade;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzhgVar, zzguVar.zzaev, zzguVar.zzaew);
            zzhg zzhgVar2 = this.zzade;
            if (zzhgVar2 == zzhgVar) {
                return zzb;
            }
            int zzc = zzhgVar2.zzc(zzhgVar.zza(((Integer) zzb.first).intValue(), this.zzacx, true).zzado);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzhgVar, this.zzade);
            if (zza == -1) {
                return null;
            }
            this.zzade.zza(zza, this.zzacx, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhb(this.zzade, zzguVar.zzaev, zzguVar.zzaew);
        }
    }

    private final Pair<Integer, Long> zza(zzhg zzhgVar, int i, long j, long j2) {
        zzoc.zzc(i, 0, zzhgVar.zzev());
        zzhgVar.zza(i, this.zzacw, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzacw.zzagy;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzacw.zzagz + j;
        long j4 = zzhgVar.zza(0, this.zzacx, false).zzagj;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zza(long j, long j2) {
        this.zzaee.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zzaee.sendEmptyMessage(2);
        } else {
            this.zzaee.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private static void zza(zzgs zzgsVar) {
        while (zzgsVar != null) {
            zzgsVar.release();
            zzgsVar = zzgsVar.zzadx;
        }
    }

    private static void zza(zzhf zzhfVar) {
        if (zzhfVar.getState() == 2) {
            zzhfVar.stop();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzadj = new zzgv(0, 0L);
        zzb(obj, i);
        this.zzadj = new zzgv(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final void zza(boolean[] zArr, int i) {
        this.zzaej = new zzhf[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhf[] zzhfVarArr = this.zzacq;
            if (i2 >= zzhfVarArr.length) {
                return;
            }
            zzhf zzhfVar = zzhfVarArr[i2];
            zzne zzay = this.zzaeu.zzady.zzbeg.zzay(i2);
            if (zzay != null) {
                int i4 = i3 + 1;
                this.zzaej[i3] = zzhfVar;
                if (zzhfVar.getState() == 0) {
                    zzhh zzhhVar = this.zzaeu.zzady.zzbei[i2];
                    boolean z = this.zzacz && this.state == 3;
                    boolean z2 = !zArr[i2] && z;
                    zzgw[] zzgwVarArr = new zzgw[zzay.length()];
                    for (int i5 = 0; i5 < zzgwVarArr.length; i5++) {
                        zzgwVarArr[i5] = zzay.zzaw(i5);
                    }
                    zzgs zzgsVar = this.zzaeu;
                    zzhfVar.zza(zzhhVar, zzgwVarArr, zzgsVar.zzadp[i2], this.zzaer, z2, zzgsVar.zzef());
                    zzog zzdq = zzhfVar.zzdq();
                    if (zzdq != null) {
                        if (this.zzaei != null) {
                            throw zzgl.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.zzaei = zzdq;
                        this.zzaeh = zzhfVar;
                        this.zzaei.zzb(this.zzadi);
                    }
                    if (z) {
                        zzhfVar.start();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzade, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzhg zzhgVar, int i, long j) {
        return zza(zzhgVar, i, j, 0L);
    }

    private final void zzb(zzgs zzgsVar) {
        if (this.zzaeu == zzgsVar) {
            return;
        }
        boolean[] zArr = new boolean[this.zzacq.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            zzhf[] zzhfVarArr = this.zzacq;
            if (i >= zzhfVarArr.length) {
                this.zzaeu = zzgsVar;
                this.zzact.obtainMessage(3, zzgsVar.zzady).sendToTarget();
                zza(zArr, i2);
                return;
            }
            zzhf zzhfVar = zzhfVarArr[i];
            zArr[i] = zzhfVar.getState() != 0;
            zzne zzay = zzgsVar.zzady.zzbeg.zzay(i);
            if (zzay != null) {
                i2++;
            }
            if (zArr[i] && (zzay == null || (zzhfVar.zzdu() && zzhfVar.zzdr() == this.zzaeu.zzadp[i]))) {
                if (zzhfVar == this.zzaeh) {
                    this.zzaed.zza(this.zzaei);
                    this.zzaei = null;
                    this.zzaeh = null;
                }
                zza(zzhfVar);
                zzhfVar.disable();
            }
            i++;
        }
    }

    private final void zzb(Object obj, int i) {
        this.zzact.obtainMessage(6, new zzgx(this.zzade, obj, this.zzadj, i)).sendToTarget();
    }

    private final void zzdq(long j) {
        zzgs zzgsVar = this.zzaeu;
        this.zzaer = j + (zzgsVar == null ? 60000000L : zzgsVar.zzef());
        this.zzaed.zzel(this.zzaer);
        for (zzhf zzhfVar : this.zzaej) {
            zzhfVar.zzdo(this.zzaer);
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzadj.zzaex < j) {
            return true;
        }
        zzgs zzgsVar = this.zzaeu.zzadx;
        return zzgsVar != null && zzgsVar.zzadv;
    }

    private final void zzej() {
        this.zzael = false;
        this.zzaed.start();
        for (zzhf zzhfVar : this.zzaej) {
            zzhfVar.start();
        }
    }

    private final void zzek() {
        this.zzaed.stop();
        for (zzhf zzhfVar : this.zzaej) {
            zza(zzhfVar);
        }
    }

    private final void zzel() {
        zzgs zzgsVar = this.zzaeu;
        if (zzgsVar == null) {
            return;
        }
        long zzhi = zzgsVar.zzadn.zzhi();
        if (zzhi != -9223372036854775807L) {
            zzdq(zzhi);
        } else {
            zzhf zzhfVar = this.zzaeh;
            if (zzhfVar == null || zzhfVar.zzeu()) {
                this.zzaer = this.zzaed.zzfp();
            } else {
                this.zzaer = this.zzaei.zzfp();
                this.zzaed.zzel(this.zzaer);
            }
            zzhi = this.zzaer - this.zzaeu.zzef();
        }
        this.zzadj.zzaex = zzhi;
        this.zzaeo = SystemClock.elapsedRealtime() * 1000;
        long zzhj = this.zzaej.length == 0 ? Long.MIN_VALUE : this.zzaeu.zzadn.zzhj();
        zzgv zzgvVar = this.zzadj;
        if (zzhj == Long.MIN_VALUE) {
            zzhj = this.zzade.zza(this.zzaeu.zzads, this.zzacx, false).zzagj;
        }
        zzgvVar.zzaey = zzhj;
    }

    private final void zzem() {
        zzi(true);
        this.zzaea.onStopped();
        setState(1);
    }

    private final void zzen() {
        zzgs zzgsVar = this.zzaes;
        if (zzgsVar == null || zzgsVar.zzadv) {
            return;
        }
        zzgs zzgsVar2 = this.zzaet;
        if (zzgsVar2 == null || zzgsVar2.zzadx == zzgsVar) {
            for (zzhf zzhfVar : this.zzaej) {
                if (!zzhfVar.zzds()) {
                    return;
                }
            }
            this.zzaes.zzadn.zzhf();
        }
    }

    private final void zzeo() {
        zzgs zzgsVar = this.zzaes;
        long zzhh = !zzgsVar.zzadv ? 0L : zzgsVar.zzadn.zzhh();
        if (zzhh == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzef = this.zzaer - this.zzaes.zzef();
        boolean zzdt = this.zzaea.zzdt(zzhh - zzef);
        zzh(zzdt);
        if (zzdt) {
            this.zzaes.zzadn.zzef(zzef);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzadd != z) {
            this.zzadd = z;
            this.zzact.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        this.zzaee.removeMessages(2);
        this.zzael = false;
        this.zzaed.stop();
        this.zzaei = null;
        this.zzaeh = null;
        this.zzaer = 60000000L;
        for (zzhf zzhfVar : this.zzaej) {
            try {
                zza(zzhfVar);
                zzhfVar.disable();
            } catch (zzgl | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzaej = new zzhf[0];
        zzgs zzgsVar = this.zzaeu;
        if (zzgsVar == null) {
            zzgsVar = this.zzaes;
        }
        zza(zzgsVar);
        this.zzaes = null;
        this.zzaet = null;
        this.zzaeu = null;
        zzh(false);
        if (z) {
            zzmb zzmbVar = this.zzaeb;
            if (zzmbVar != null) {
                zzmbVar.zzhs();
                this.zzaeb = null;
            }
            this.zzade = null;
        }
    }

    private final boolean zzo(int i) {
        this.zzade.zza(i, this.zzacx, false);
        return !this.zzade.zza(0, this.zzacw, false).zzagv && this.zzade.zza(i, this.zzacx, this.zzacw, this.repeatMode) == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x028d A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0294 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0290 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0721 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x05a3 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x05bf A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, LOOP:9: B:417:0x05bf->B:421:0x05d1, LOOP_START, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0530 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x058f A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0554 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0537 A[Catch: IOException -> 0x08a5, zzgl -> 0x08aa, RuntimeException -> 0x08af, TryCatch #6 {RuntimeException -> 0x08af, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c4, B:143:0x0198, B:144:0x019c, B:146:0x01a0, B:148:0x01a4, B:150:0x01ae, B:155:0x01d0, B:157:0x01d8, B:160:0x01df, B:162:0x01e3, B:164:0x01eb, B:167:0x01f2, B:169:0x0205, B:170:0x0215, B:172:0x0219, B:174:0x0229, B:176:0x022d, B:178:0x023b, B:180:0x0240, B:181:0x0289, B:183:0x028d, B:185:0x0294, B:187:0x029e, B:190:0x02a9, B:191:0x02d1, B:193:0x02d5, B:197:0x02e2, B:201:0x02e5, B:202:0x02f2, B:205:0x0300, B:207:0x0306, B:209:0x0319, B:211:0x031d, B:213:0x032d, B:215:0x033f, B:219:0x034d, B:224:0x0352, B:225:0x0366, B:229:0x036f, B:230:0x0290, B:231:0x0258, B:233:0x0260, B:235:0x0268, B:236:0x026d, B:238:0x0373, B:239:0x037e, B:248:0x0389, B:249:0x038a, B:251:0x038e, B:253:0x0396, B:254:0x03a3, B:256:0x039d, B:257:0x03af, B:259:0x03b7, B:261:0x03c0, B:263:0x03c6, B:264:0x03e6, B:267:0x03ef, B:274:0x0412, B:277:0x0420, B:278:0x0426, B:285:0x0436, B:288:0x0444, B:293:0x044d, B:296:0x045c, B:297:0x0465, B:300:0x0466, B:302:0x046e, B:303:0x06d2, B:305:0x06d8, B:307:0x06e0, B:309:0x06fb, B:311:0x0706, B:314:0x070f, B:316:0x0715, B:321:0x0721, B:326:0x072b, B:333:0x0732, B:334:0x0735, B:336:0x0739, B:338:0x0747, B:339:0x075a, B:343:0x0773, B:345:0x077b, B:347:0x0781, B:348:0x080b, B:350:0x080f, B:352:0x0814, B:354:0x081c, B:356:0x0820, B:358:0x0829, B:359:0x083f, B:360:0x0825, B:362:0x082f, B:364:0x0834, B:365:0x083a, B:366:0x078b, B:368:0x0790, B:371:0x0797, B:373:0x079f, B:376:0x07b2, B:382:0x07e4, B:384:0x07ec, B:385:0x07ba, B:386:0x07c8, B:387:0x07a4, B:389:0x07de, B:390:0x07f0, B:392:0x07f5, B:396:0x0801, B:397:0x07fb, B:398:0x0476, B:400:0x047a, B:401:0x04bd, B:403:0x04c5, B:405:0x059f, B:407:0x05a3, B:410:0x05ac, B:412:0x05b0, B:414:0x05b4, B:415:0x05bb, B:417:0x05bf, B:419:0x05c5, B:421:0x05d1, B:423:0x05fc, B:426:0x0603, B:428:0x0608, B:430:0x0614, B:432:0x061a, B:434:0x0620, B:436:0x0623, B:442:0x0627, B:444:0x062c, B:447:0x063e, B:452:0x0646, B:456:0x0649, B:458:0x064f, B:460:0x0657, B:464:0x067a, B:466:0x067f, B:469:0x068d, B:471:0x0693, B:473:0x06a3, B:475:0x06a9, B:476:0x06b0, B:478:0x06b3, B:480:0x06bc, B:484:0x06cc, B:482:0x06cf, B:490:0x05b8, B:491:0x04cd, B:493:0x04d1, B:495:0x052c, B:497:0x0530, B:499:0x054d, B:502:0x055b, B:504:0x058f, B:505:0x0593, B:506:0x0554, B:507:0x0537, B:508:0x04d7, B:511:0x04e8, B:513:0x051b, B:514:0x047f, B:516:0x0489, B:518:0x0491, B:521:0x04a0, B:523:0x04a4, B:525:0x04b1, B:526:0x0843, B:529:0x084b, B:531:0x0851, B:533:0x0858, B:535:0x085d, B:536:0x0862, B:537:0x0866, B:539:0x086a, B:541:0x086e, B:544:0x087a, B:546:0x0889, B:547:0x0895), top: B:2:0x0005 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            Method dump skipped, instructions count: 2314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgt.handleMessage(android.os.Message):boolean");
    }

    public final synchronized void release() {
        if (this.zzaek) {
            return;
        }
        this.zzaee.sendEmptyMessage(6);
        while (!this.zzaek) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.zzaef.quit();
    }

    public final void stop() {
        this.zzaee.sendEmptyMessage(5);
    }

    public final void zza(zzhg zzhgVar, int i, long j) {
        this.zzaee.obtainMessage(3, new zzgu(zzhgVar, i, j)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzmc
    public final void zza(zzlz zzlzVar) {
        this.zzaee.obtainMessage(8, zzlzVar).sendToTarget();
    }

    public final void zza(zzmb zzmbVar, boolean z) {
        this.zzaee.obtainMessage(0, 1, 0, zzmbVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final /* synthetic */ void zza(zzlz zzlzVar) {
        this.zzaee.obtainMessage(9, zzlzVar).sendToTarget();
    }

    public final void zza(zzgp... zzgpVarArr) {
        if (this.zzaek) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.zzaem++;
            this.zzaee.obtainMessage(11, zzgpVarArr).sendToTarget();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzb(zzhg zzhgVar, Object obj) {
        this.zzaee.obtainMessage(7, Pair.create(zzhgVar, obj)).sendToTarget();
    }

    public final synchronized void zzb(zzgp... zzgpVarArr) {
        if (this.zzaek) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.zzaem;
        this.zzaem = i + 1;
        this.zzaee.obtainMessage(11, zzgpVarArr).sendToTarget();
        while (this.zzaen <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzni
    public final void zzei() {
        this.zzaee.sendEmptyMessage(10);
    }

    public final void zzf(boolean z) {
        this.zzaee.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }
}
