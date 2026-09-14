package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzle;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class zzke {
    private static final int zzauw = zzoq.zzbn("vide");
    private static final int zzaux = zzoq.zzbn("soun");
    private static final int zzauy = zzoq.zzbn("text");
    private static final int zzauz = zzoq.zzbn("sbtl");
    private static final int zzava = zzoq.zzbn("subt");
    private static final int zzavb = zzoq.zzbn("clcp");
    private static final int zzavc = zzoq.zzbn("cenc");
    private static final int zzatw = zzoq.zzbn("meta");

    private static int zza(zzoj zzojVar, int i, int i2, zzkf zzkfVar, int i3) {
        zzkr zzkrVar;
        int position = zzojVar.getPosition();
        while (true) {
            if (position - i >= i2) {
                return 0;
            }
            zzojVar.zzbe(position);
            int readInt = zzojVar.readInt();
            zzoc.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzojVar.readInt() == zzjz.zzasq) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzkr zzkrVar2 = null;
                boolean z = false;
                while (i4 - position < readInt) {
                    zzojVar.zzbe(i4);
                    int readInt2 = zzojVar.readInt();
                    int readInt3 = zzojVar.readInt();
                    if (readInt3 == zzjz.zzasw) {
                        num = Integer.valueOf(zzojVar.readInt());
                    } else if (readInt3 == zzjz.zzasr) {
                        zzojVar.zzbf(4);
                        z = zzojVar.readInt() == zzavc;
                    } else if (readInt3 == zzjz.zzass) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzkrVar = null;
                                break;
                            }
                            zzojVar.zzbe(i5);
                            int readInt4 = zzojVar.readInt();
                            if (zzojVar.readInt() == zzjz.zzast) {
                                zzojVar.zzbf(6);
                                boolean z2 = zzojVar.readUnsignedByte() == 1;
                                int readUnsignedByte = zzojVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzojVar.zze(bArr, 0, 16);
                                zzkrVar = new zzkr(z2, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzkrVar2 = zzkrVar;
                    }
                    i4 += readInt2;
                }
                if (z) {
                    zzoc.checkArgument(num != null, "frma atom is mandatory");
                    zzoc.checkArgument(zzkrVar2 != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzkrVar2);
                }
                if (pair != null) {
                    zzkfVar.zzavd[i3] = (zzkr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:400:0x00a3, code lost:
    
        if (r14 == 0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0471 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzks zza(com.google.android.gms.internal.ads.zzkc r43, com.google.android.gms.internal.ads.zzkb r44, long r45, com.google.android.gms.internal.ads.zziv r47, boolean r48) {
        /*
            Method dump skipped, instructions count: 1820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzke.zza(com.google.android.gms.internal.ads.zzkc, com.google.android.gms.internal.ads.zzkb, long, com.google.android.gms.internal.ads.zziv, boolean):com.google.android.gms.internal.ads.zzks");
    }

    public static zzku zza(zzks zzksVar, zzkc zzkcVar, zzjh zzjhVar) {
        zzkg zzkhVar;
        boolean z;
        int i;
        int i2;
        int i3;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i4;
        long j;
        long j2;
        int[] iArr3;
        int[] iArr4;
        int i5;
        long[] jArr3;
        boolean z2;
        int[] iArr5;
        long[] jArr4;
        int i6;
        int i7;
        zzks zzksVar2 = zzksVar;
        zzkb zzao = zzkcVar.zzao(zzjz.zzatl);
        if (zzao != null) {
            zzkhVar = new zzki(zzao);
        } else {
            zzkb zzao2 = zzkcVar.zzao(zzjz.zzatm);
            if (zzao2 == null) {
                throw new zzhd("Track has no sample table size information");
            }
            zzkhVar = new zzkh(zzao2);
        }
        int zzgq = zzkhVar.zzgq();
        if (zzgq == 0) {
            return new zzku(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzkb zzao3 = zzkcVar.zzao(zzjz.zzatn);
        if (zzao3 == null) {
            zzao3 = zzkcVar.zzao(zzjz.zzato);
            z = true;
        } else {
            z = false;
        }
        zzoj zzojVar = zzao3.zzaul;
        zzoj zzojVar2 = zzkcVar.zzao(zzjz.zzatk).zzaul;
        zzoj zzojVar3 = zzkcVar.zzao(zzjz.zzath).zzaul;
        zzkb zzao4 = zzkcVar.zzao(zzjz.zzati);
        zzoj zzojVar4 = zzao4 != null ? zzao4.zzaul : null;
        zzkb zzao5 = zzkcVar.zzao(zzjz.zzatj);
        zzoj zzojVar5 = zzao5 != null ? zzao5.zzaul : null;
        zzkd zzkdVar = new zzkd(zzojVar2, zzojVar, z);
        zzojVar3.zzbe(12);
        int zzis = zzojVar3.zzis() - 1;
        int zzis2 = zzojVar3.zzis();
        int zzis3 = zzojVar3.zzis();
        if (zzojVar5 != null) {
            zzojVar5.zzbe(12);
            i = zzojVar5.zzis();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (zzojVar4 != null) {
            zzojVar4.zzbe(12);
            i2 = zzojVar4.zzis();
            if (i2 > 0) {
                i8 = zzojVar4.zzis() - 1;
            } else {
                zzojVar4 = null;
            }
        } else {
            i2 = 0;
        }
        long j3 = 0;
        if (zzkhVar.zzgs() && "audio/raw".equals(zzksVar2.zzafz.zzafe) && zzis == 0 && i == 0 && i2 == 0) {
            i3 = zzgq;
            zzkg zzkgVar = zzkhVar;
            int i9 = zzkdVar.length;
            long[] jArr5 = new long[i9];
            int[] iArr6 = new int[i9];
            while (zzkdVar.zzgp()) {
                int i10 = zzkdVar.index;
                jArr5[i10] = zzkdVar.zzauq;
                iArr6[i10] = zzkdVar.zzaup;
            }
            int zzgr = zzkgVar.zzgr();
            long j4 = zzis3;
            int i11 = 8192 / zzgr;
            int i12 = 0;
            for (int i13 : iArr6) {
                i12 += zzoq.zzf(i13, i11);
            }
            long[] jArr6 = new long[i12];
            int[] iArr7 = new int[i12];
            long[] jArr7 = new long[i12];
            int[] iArr8 = new int[i12];
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i14 < iArr6.length) {
                int i18 = iArr6[i14];
                long j5 = jArr5[i14];
                int i19 = i15;
                int i20 = i17;
                while (i18 > 0) {
                    int min = Math.min(i11, i18);
                    jArr6[i16] = j5;
                    iArr7[i16] = zzgr * min;
                    i20 = Math.max(i20, iArr7[i16]);
                    jArr7[i16] = i19 * j4;
                    iArr8[i16] = 1;
                    j5 += iArr7[i16];
                    i19 += min;
                    i18 -= min;
                    i16++;
                    iArr6 = iArr6;
                    jArr5 = jArr5;
                }
                i14++;
                i17 = i20;
                i15 = i19;
            }
            zzkm zzkmVar = new zzkm(jArr6, iArr7, i17, jArr7, iArr8);
            jArr = zzkmVar.zzamq;
            iArr = zzkmVar.zzamp;
            int i21 = zzkmVar.zzawo;
            jArr2 = zzkmVar.zzawp;
            iArr2 = zzkmVar.zzawq;
            i4 = i21;
            j = 0;
        } else {
            jArr = new long[zzgq];
            iArr = new int[zzgq];
            jArr2 = new long[zzgq];
            int i22 = i2;
            iArr2 = new int[zzgq];
            int i23 = i22;
            int i24 = zzis3;
            int i25 = i;
            int i26 = i8;
            long j6 = 0;
            long j7 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = zzis2;
            int i32 = zzis;
            int i33 = 0;
            while (i33 < zzgq) {
                long j8 = j6;
                int i34 = i27;
                while (i34 == 0) {
                    zzoc.checkState(zzkdVar.zzgp());
                    j8 = zzkdVar.zzauq;
                    i34 = zzkdVar.zzaup;
                    i32 = i32;
                    i24 = i24;
                }
                int i35 = i32;
                int i36 = i24;
                if (zzojVar5 != null) {
                    while (i30 == 0 && i25 > 0) {
                        i30 = zzojVar5.zzis();
                        i29 = zzojVar5.readInt();
                        i25--;
                    }
                    i30--;
                }
                int i37 = i29;
                jArr[i33] = j8;
                iArr[i33] = zzkhVar.zzgr();
                if (iArr[i33] > i28) {
                    i6 = zzgq;
                    i28 = iArr[i33];
                } else {
                    i6 = zzgq;
                }
                zzkg zzkgVar2 = zzkhVar;
                jArr2[i33] = j7 + i37;
                iArr2[i33] = zzojVar4 == null ? 1 : 0;
                if (i33 == i26) {
                    iArr2[i33] = 1;
                    i23--;
                    if (i23 > 0) {
                        i26 = zzojVar4.zzis() - 1;
                    }
                }
                int i38 = i23;
                int i39 = i26;
                int i40 = i36;
                j7 += i40;
                i31--;
                if (i31 != 0 || i35 <= 0) {
                    i7 = i35;
                } else {
                    i7 = i35 - 1;
                    i31 = zzojVar3.zzis();
                    i40 = zzojVar3.zzis();
                }
                int i41 = i7;
                long j9 = j8 + iArr[i33];
                i33++;
                i26 = i39;
                zzgq = i6;
                i27 = i34 - 1;
                i29 = i37;
                i32 = i41;
                j6 = j9;
                i24 = i40;
                i23 = i38;
                zzkhVar = zzkgVar2;
            }
            i3 = zzgq;
            int i42 = i32;
            zzoc.checkArgument(i30 == 0);
            while (i25 > 0) {
                zzoc.checkArgument(zzojVar5.zzis() == 0);
                zzojVar5.readInt();
                i25--;
            }
            if (i23 == 0 && i31 == 0 && i27 == 0 && i42 == 0) {
                zzksVar2 = zzksVar;
            } else {
                int i43 = i23;
                zzksVar2 = zzksVar;
                int i44 = zzksVar2.id;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i44);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i43);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i31);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i27);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i42);
                Log.w("AtomParsers", sb.toString());
            }
            j = j7;
            i4 = i28;
        }
        if (zzksVar2.zzaxl == null || zzjhVar.zzgk()) {
            int[] iArr9 = iArr;
            zzoq.zza(jArr2, 1000000L, zzksVar2.zzcv);
            return new zzku(jArr, iArr9, i4, jArr2, iArr2);
        }
        long[] jArr8 = zzksVar2.zzaxl;
        if (jArr8.length == 1 && zzksVar2.type == 1 && jArr2.length >= 2) {
            long j10 = zzksVar2.zzaxm[0];
            long zza = zzoq.zza(jArr8[0], zzksVar2.zzcv, zzksVar2.zzaxi) + j10;
            if (jArr2[0] <= j10 && j10 < jArr2[1] && jArr2[jArr2.length - 1] < zza && zza <= j) {
                long j11 = j - zza;
                long zza2 = zzoq.zza(j10 - jArr2[0], zzksVar2.zzafz.zzafp, zzksVar2.zzcv);
                long zza3 = zzoq.zza(j11, zzksVar2.zzafz.zzafp, zzksVar2.zzcv);
                if ((zza2 != 0 || zza3 != 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zzjhVar.zzafr = (int) zza2;
                    zzjhVar.zzafs = (int) zza3;
                    zzoq.zza(jArr2, 1000000L, zzksVar2.zzcv);
                    return new zzku(jArr, iArr, i4, jArr2, iArr2);
                }
            }
        }
        long[] jArr9 = zzksVar2.zzaxl;
        if (jArr9.length == 1) {
            char c = 0;
            if (jArr9[0] == 0) {
                int i45 = 0;
                while (i45 < jArr2.length) {
                    jArr2[i45] = zzoq.zza(jArr2[i45] - zzksVar2.zzaxm[c], 1000000L, zzksVar2.zzcv);
                    i45++;
                    c = 0;
                }
                return new zzku(jArr, iArr, i4, jArr2, iArr2);
            }
        }
        boolean z3 = zzksVar2.type == 1;
        int i46 = 0;
        boolean z4 = false;
        int i47 = 0;
        int i48 = 0;
        while (true) {
            long[] jArr10 = zzksVar2.zzaxl;
            j2 = -1;
            if (i46 >= jArr10.length) {
                break;
            }
            int[] iArr10 = iArr;
            long j12 = zzksVar2.zzaxm[i46];
            if (j12 != -1) {
                long zza4 = zzoq.zza(jArr10[i46], zzksVar2.zzcv, zzksVar2.zzaxi);
                int zzb = zzoq.zzb(jArr2, j12, true, true);
                int zzb2 = zzoq.zzb(jArr2, j12 + zza4, z3, false);
                i47 += zzb2 - zzb;
                z4 |= i48 != zzb;
                i48 = zzb2;
            }
            i46++;
            iArr = iArr10;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i47 != i3) | z4;
        long[] jArr11 = z5 ? new long[i47] : jArr;
        int[] iArr12 = z5 ? new int[i47] : iArr11;
        if (z5) {
            i4 = 0;
        }
        int[] iArr13 = z5 ? new int[i47] : iArr2;
        long[] jArr12 = new long[i47];
        int i49 = i4;
        int i50 = 0;
        int i51 = 0;
        while (true) {
            long[] jArr13 = zzksVar2.zzaxl;
            if (i50 >= jArr13.length) {
                break;
            }
            long[] jArr14 = jArr11;
            long[] jArr15 = jArr12;
            long j13 = zzksVar2.zzaxm[i50];
            long j14 = jArr13[i50];
            if (j13 != j2) {
                iArr4 = iArr13;
                i5 = i50;
                long zza5 = zzoq.zza(j14, zzksVar2.zzcv, zzksVar2.zzaxi) + j13;
                int zzb3 = zzoq.zzb(jArr2, j13, true, true);
                int zzb4 = zzoq.zzb(jArr2, zza5, z3, false);
                if (z5) {
                    int i52 = zzb4 - zzb3;
                    jArr3 = jArr14;
                    System.arraycopy(jArr, zzb3, jArr3, i51, i52);
                    z2 = z3;
                    iArr5 = iArr11;
                    System.arraycopy(iArr5, zzb3, iArr12, i51, i52);
                    System.arraycopy(iArr2, zzb3, iArr4, i51, i52);
                } else {
                    jArr3 = jArr14;
                    z2 = z3;
                    iArr5 = iArr11;
                }
                int i53 = i49;
                while (zzb3 < zzb4) {
                    long[] jArr16 = jArr;
                    int[] iArr14 = iArr2;
                    long j15 = j13;
                    jArr15[i51] = zzoq.zza(j3, 1000000L, zzksVar2.zzaxi) + zzoq.zza(jArr2[zzb3] - j13, 1000000L, zzksVar2.zzcv);
                    if (z5 && iArr12[i51] > i53) {
                        i53 = iArr5[zzb3];
                    }
                    i51++;
                    zzb3++;
                    jArr = jArr16;
                    j13 = j15;
                    iArr2 = iArr14;
                }
                jArr4 = jArr;
                iArr3 = iArr2;
                i49 = i53;
            } else {
                iArr3 = iArr2;
                iArr4 = iArr13;
                i5 = i50;
                jArr3 = jArr14;
                z2 = z3;
                iArr5 = iArr11;
                jArr4 = jArr;
            }
            j3 += j14;
            i50 = i5 + 1;
            jArr = jArr4;
            iArr11 = iArr5;
            iArr13 = iArr4;
            jArr11 = jArr3;
            z3 = z2;
            iArr2 = iArr3;
            jArr12 = jArr15;
            j2 = -1;
        }
        long[] jArr17 = jArr11;
        long[] jArr18 = jArr12;
        int[] iArr15 = iArr13;
        boolean z6 = false;
        for (int i54 = 0; i54 < iArr15.length && !z6; i54++) {
            z6 |= (iArr15[i54] & 1) != 0;
        }
        if (z6) {
            return new zzku(jArr17, iArr12, i49, jArr18, iArr15);
        }
        throw new zzhd("The edited sample sequence does not contain a sync sample.");
    }

    public static zzle zza(zzkb zzkbVar, boolean z) {
        if (z) {
            return null;
        }
        zzoj zzojVar = zzkbVar.zzaul;
        zzojVar.zzbe(8);
        while (zzojVar.zzin() >= 8) {
            int position = zzojVar.getPosition();
            int readInt = zzojVar.readInt();
            if (zzojVar.readInt() == zzjz.zzatw) {
                zzojVar.zzbe(position);
                int i = position + readInt;
                zzojVar.zzbf(12);
                while (true) {
                    if (zzojVar.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzojVar.getPosition();
                    int readInt2 = zzojVar.readInt();
                    if (zzojVar.readInt() == zzjz.zzatx) {
                        zzojVar.zzbe(position2);
                        int i2 = position2 + readInt2;
                        zzojVar.zzbf(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzojVar.getPosition() < i2) {
                            zzle.zza zzd = zzkl.zzd(zzojVar);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzle(arrayList);
                        }
                    } else {
                        zzojVar.zzbf(readInt2 - 8);
                    }
                }
                return null;
            }
            zzojVar.zzbf(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzoj zzojVar, int i) {
        zzojVar.zzbe(i + 8 + 4);
        zzojVar.zzbf(1);
        zzc(zzojVar);
        zzojVar.zzbf(2);
        int readUnsignedByte = zzojVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzojVar.zzbf(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzojVar.zzbf(zzojVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzojVar.zzbf(2);
        }
        zzojVar.zzbf(1);
        zzc(zzojVar);
        int readUnsignedByte2 = zzojVar.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzojVar.zzbf(12);
        zzojVar.zzbf(1);
        int zzc = zzc(zzojVar);
        byte[] bArr = new byte[zzc];
        zzojVar.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zzc(zzoj zzojVar) {
        int readUnsignedByte = zzojVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzojVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
