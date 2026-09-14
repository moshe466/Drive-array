package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zziv;
import com.google.common.primitives.Ints;
import com.google.firebase.FirebaseError;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzjt implements zzjd {
    private static final zzji zzanm = new zzjw();
    private static final byte[] zzann = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzano = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzanp = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzagj;
    private final zzka zzang;
    private final zzjr zzanq;
    private final SparseArray<zzjy> zzanr;
    private final boolean zzans;
    private final zzoj zzant;
    private final zzoj zzanu;
    private final zzoj zzanv;
    private final zzoj zzanw;
    private final zzoj zzanx;
    private final zzoj zzany;
    private final zzoj zzanz;
    private final zzoj zzaoa;
    private final zzoj zzaob;
    private ByteBuffer zzaoc;
    private long zzaod;
    private long zzaoe;
    private long zzaof;
    private long zzaog;
    private zzjy zzaoh;
    private boolean zzaoi;
    private int zzaoj;
    private long zzaok;
    private boolean zzaol;
    private long zzaom;
    private long zzaon;
    private long zzaoo;
    private zzod zzaop;
    private zzod zzaoq;
    private boolean zzaor;
    private int zzaos;
    private long zzaot;
    private long zzaou;
    private int zzaov;
    private int zzaow;
    private int[] zzaox;
    private int zzaoy;
    private int zzaoz;
    private int zzapa;
    private int zzapb;
    private boolean zzapc;
    private boolean zzapd;
    private boolean zzape;
    private boolean zzapf;
    private byte zzapg;
    private int zzaph;
    private int zzapi;
    private int zzapj;
    private boolean zzapk;
    private boolean zzapl;
    private zzjf zzapm;

    public zzjt() {
        this(0);
    }

    private zzjt(int i) {
        this(new zzjq(), 0);
    }

    private zzjt(zzjr zzjrVar, int i) {
        this.zzaoe = -1L;
        this.zzaof = -9223372036854775807L;
        this.zzaog = -9223372036854775807L;
        this.zzagj = -9223372036854775807L;
        this.zzaom = -1L;
        this.zzaon = -1L;
        this.zzaoo = -9223372036854775807L;
        this.zzanq = zzjrVar;
        this.zzanq.zza(new zzjv(this, null));
        this.zzans = true;
        this.zzang = new zzka();
        this.zzanr = new SparseArray<>();
        this.zzanv = new zzoj(4);
        this.zzanw = new zzoj(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzanx = new zzoj(4);
        this.zzant = new zzoj(zzoi.zzbga);
        this.zzanu = new zzoj(4);
        this.zzany = new zzoj();
        this.zzanz = new zzoj();
        this.zzaoa = new zzoj(8);
        this.zzaob = new zzoj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final int zza(zzjg zzjgVar, zzjo zzjoVar, int i) {
        int zza;
        int zzin = this.zzany.zzin();
        if (zzin > 0) {
            zza = Math.min(i, zzin);
            zzjoVar.zza(this.zzany, zza);
        } else {
            zza = zzjoVar.zza(zzjgVar, i, false);
        }
        this.zzapb += zza;
        this.zzapj += zza;
        return zza;
    }

    private final void zza(zzjg zzjgVar, zzjy zzjyVar, int i) {
        int i2;
        if ("S_TEXT/UTF8".equals(zzjyVar.zzapp)) {
            int length = zzann.length + i;
            if (this.zzanz.capacity() < length) {
                this.zzanz.data = Arrays.copyOf(zzann, length + i);
            }
            zzjgVar.readFully(this.zzanz.data, zzann.length, i);
            this.zzanz.zzbe(0);
            this.zzanz.zzbd(length);
            return;
        }
        zzjo zzjoVar = zzjyVar.zzaqt;
        if (!this.zzapc) {
            if (zzjyVar.zzapr) {
                this.zzapa &= -1073741825;
                if (!this.zzapd) {
                    zzjgVar.readFully(this.zzanv.data, 0, 1);
                    this.zzapb++;
                    byte[] bArr = this.zzanv.data;
                    if ((bArr[0] & 128) == 128) {
                        throw new zzhd("Extension bit is set in signal byte");
                    }
                    this.zzapg = bArr[0];
                    this.zzapd = true;
                }
                byte b = this.zzapg;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzapa |= Ints.MAX_POWER_OF_TWO;
                    if (!this.zzape) {
                        zzjgVar.readFully(this.zzaoa.data, 0, 8);
                        this.zzapb += 8;
                        this.zzape = true;
                        this.zzanv.data[0] = (byte) ((z ? 128 : 0) | 8);
                        this.zzanv.zzbe(0);
                        zzjoVar.zza(this.zzanv, 1);
                        this.zzapj++;
                        this.zzaoa.zzbe(0);
                        zzjoVar.zza(this.zzaoa, 8);
                        this.zzapj += 8;
                    }
                    if (z) {
                        if (!this.zzapf) {
                            zzjgVar.readFully(this.zzanv.data, 0, 1);
                            this.zzapb++;
                            this.zzanv.zzbe(0);
                            this.zzaph = this.zzanv.readUnsignedByte();
                            this.zzapf = true;
                        }
                        int i3 = this.zzaph << 2;
                        this.zzanv.reset(i3);
                        zzjgVar.readFully(this.zzanv.data, 0, i3);
                        this.zzapb += i3;
                        short s = (short) ((this.zzaph / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaoc;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.zzaoc = ByteBuffer.allocate(i4);
                        }
                        this.zzaoc.position(0);
                        this.zzaoc.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.zzaph;
                            if (i5 >= i2) {
                                break;
                            }
                            int zzis = this.zzanv.zzis();
                            if (i5 % 2 == 0) {
                                this.zzaoc.putShort((short) (zzis - i6));
                            } else {
                                this.zzaoc.putInt(zzis - i6);
                            }
                            i5++;
                            i6 = zzis;
                        }
                        int i7 = (i - this.zzapb) - i6;
                        int i8 = i2 % 2;
                        ByteBuffer byteBuffer2 = this.zzaoc;
                        if (i8 == 1) {
                            byteBuffer2.putInt(i7);
                        } else {
                            byteBuffer2.putShort((short) i7);
                            this.zzaoc.putInt(0);
                        }
                        this.zzaob.zzb(this.zzaoc.array(), i4);
                        zzjoVar.zza(this.zzaob, i4);
                        this.zzapj += i4;
                    }
                }
            } else {
                byte[] bArr2 = zzjyVar.zzaps;
                if (bArr2 != null) {
                    this.zzany.zzb(bArr2, bArr2.length);
                }
            }
            this.zzapc = true;
        }
        int limit = i + this.zzany.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzjyVar.zzapp) && !"V_MPEGH/ISO/HEVC".equals(zzjyVar.zzapp)) {
            while (true) {
                int i9 = this.zzapb;
                if (i9 >= limit) {
                    break;
                } else {
                    zza(zzjgVar, zzjoVar, limit - i9);
                }
            }
        } else {
            byte[] bArr3 = this.zzanu.data;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i10 = zzjyVar.zzaqu;
            int i11 = 4 - i10;
            while (this.zzapb < limit) {
                int i12 = this.zzapi;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzany.zzin());
                    zzjgVar.readFully(bArr3, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzany.zze(bArr3, i11, min);
                    }
                    this.zzapb += i10;
                    this.zzanu.zzbe(0);
                    this.zzapi = this.zzanu.zzis();
                    this.zzant.zzbe(0);
                    zzjoVar.zza(this.zzant, 4);
                    this.zzapj += 4;
                } else {
                    this.zzapi = i12 - zza(zzjgVar, zzjoVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzjyVar.zzapp)) {
            this.zzanw.zzbe(0);
            zzjoVar.zza(this.zzanw, 4);
            this.zzapj += 4;
        }
    }

    private final void zza(zzjy zzjyVar, long j) {
        byte[] zzbm;
        if ("S_TEXT/UTF8".equals(zzjyVar.zzapp)) {
            byte[] bArr = this.zzanz.data;
            long j2 = this.zzaou;
            if (j2 == -9223372036854775807L) {
                zzbm = zzano;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                zzbm = zzoq.zzbm(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r4)) / 1000))));
            }
            System.arraycopy(zzbm, 0, bArr, 19, 12);
            zzjo zzjoVar = zzjyVar.zzaqt;
            zzoj zzojVar = this.zzanz;
            zzjoVar.zza(zzojVar, zzojVar.limit());
            this.zzapj += this.zzanz.limit();
        }
        zzjyVar.zzaqt.zza(j, this.zzapa, this.zzapj, 0, zzjyVar.zzapt);
        this.zzapk = true;
        zzgm();
    }

    private static int[] zza(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }

    private final void zzb(zzjg zzjgVar, int i) {
        if (this.zzanv.limit() >= i) {
            return;
        }
        if (this.zzanv.capacity() < i) {
            zzoj zzojVar = this.zzanv;
            byte[] bArr = zzojVar.data;
            zzojVar.zzb(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.zzanv.limit());
        }
        zzoj zzojVar2 = this.zzanv;
        zzjgVar.readFully(zzojVar2.data, zzojVar2.limit(), i - this.zzanv.limit());
        this.zzanv.zzbd(i);
    }

    private final long zzea(long j) {
        long j2 = this.zzaof;
        if (j2 != -9223372036854775807L) {
            return zzoq.zza(j, j2, 1000L);
        }
        throw new zzhd("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzgm() {
        this.zzapb = 0;
        this.zzapj = 0;
        this.zzapi = 0;
        this.zzapc = false;
        this.zzapd = false;
        this.zzapf = false;
        this.zzaph = 0;
        this.zzapg = (byte) 0;
        this.zzape = false;
        this.zzany.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        zzjm zzjlVar;
        zzod zzodVar;
        zzod zzodVar2;
        int i2;
        if (i == 160) {
            if (this.zzaos != 2) {
                return;
            }
            if (!this.zzapl) {
                this.zzapa |= 1;
            }
            zza(this.zzanr.get(this.zzaoy), this.zzaot);
            this.zzaos = 0;
            return;
        }
        if (i == 174) {
            String str = this.zzaoh.zzapp;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                zzjy zzjyVar = this.zzaoh;
                zzjyVar.zza(this.zzapm, zzjyVar.number);
                SparseArray<zzjy> sparseArray = this.zzanr;
                zzjy zzjyVar2 = this.zzaoh;
                sparseArray.put(zzjyVar2.number, zzjyVar2);
            }
            this.zzaoh = null;
            return;
        }
        if (i == 19899) {
            int i3 = this.zzaoj;
            if (i3 != -1) {
                long j = this.zzaok;
                if (j != -1) {
                    if (i3 == 475249515) {
                        this.zzaom = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzhd("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            zzjy zzjyVar3 = this.zzaoh;
            if (zzjyVar3.zzapr) {
                zzjn zzjnVar = zzjyVar3.zzapt;
                if (zzjnVar == null) {
                    throw new zzhd("Encrypted Track found but ContentEncKeyID was not found");
                }
                zzjyVar3.zzafh = new zziv(new zziv.zza(zzgi.zzacb, "video/webm", zzjnVar.zzand));
                return;
            }
            return;
        }
        if (i == 28032) {
            zzjy zzjyVar4 = this.zzaoh;
            if (zzjyVar4.zzapr && zzjyVar4.zzaps != null) {
                throw new zzhd("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.zzaof == -9223372036854775807L) {
                this.zzaof = 1000000L;
            }
            long j2 = this.zzaog;
            if (j2 != -9223372036854775807L) {
                this.zzagj = zzea(j2);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.zzanr.size() == 0) {
                throw new zzhd("No valid tracks were found");
            }
            this.zzapm.zzgj();
            return;
        }
        if (i == 475249515 && !this.zzaoi) {
            zzjf zzjfVar = this.zzapm;
            if (this.zzaoe == -1 || this.zzagj == -9223372036854775807L || (zzodVar = this.zzaop) == null || zzodVar.size() == 0 || (zzodVar2 = this.zzaoq) == null || zzodVar2.size() != this.zzaop.size()) {
                this.zzaop = null;
                this.zzaoq = null;
                zzjlVar = new zzjl(this.zzagj);
            } else {
                int size = this.zzaop.size();
                int[] iArr = new int[size];
                long[] jArr = new long[size];
                long[] jArr2 = new long[size];
                long[] jArr3 = new long[size];
                for (int i4 = 0; i4 < size; i4++) {
                    jArr3[i4] = this.zzaop.get(i4);
                    jArr[i4] = this.zzaoe + this.zzaoq.get(i4);
                }
                while (true) {
                    i2 = size - 1;
                    if (r1 >= i2) {
                        break;
                    }
                    int i5 = r1 + 1;
                    iArr[r1] = (int) (jArr[i5] - jArr[r1]);
                    jArr2[r1] = jArr3[i5] - jArr3[r1];
                    r1 = i5;
                }
                iArr[i2] = (int) ((this.zzaoe + this.zzaod) - jArr[i2]);
                jArr2[i2] = this.zzagj - jArr3[i2];
                this.zzaop = null;
                this.zzaoq = null;
                zzjlVar = new zzjb(iArr, jArr, jArr2, jArr3);
            }
            zzjfVar.zza(zzjlVar);
            this.zzaoi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, double d) {
        if (i == 181) {
            this.zzaoh.zzafp = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzaog = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                this.zzaoh.zzaqe = (float) d;
                return;
            case 21970:
                this.zzaoh.zzaqf = (float) d;
                return;
            case 21971:
                this.zzaoh.zzaqg = (float) d;
                return;
            case 21972:
                this.zzaoh.zzaqh = (float) d;
                return;
            case 21973:
                this.zzaoh.zzaqi = (float) d;
                return;
            case 21974:
                this.zzaoh.zzaqj = (float) d;
                return;
            case 21975:
                this.zzaoh.zzaqk = (float) d;
                return;
            case 21976:
                this.zzaoh.zzaql = (float) d;
                return;
            case 21977:
                this.zzaoh.zzaqm = (float) d;
                return;
            case 21978:
                this.zzaoh.zzaqn = (float) d;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fd, code lost:
    
        throw new com.google.android.gms.internal.ads.zzhd("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r20, int r21, com.google.android.gms.internal.ads.zzjg r22) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjt.a(int, int, com.google.android.gms.internal.ads.zzjg):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, long j) {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new zzhd(sb.toString());
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new zzhd(sb2.toString());
        }
        switch (i) {
            case 131:
                this.zzaoh.type = (int) j;
                return;
            case 136:
                this.zzaoh.zzaqr = j == 1;
                return;
            case 155:
                this.zzaou = zzea(j);
                return;
            case 159:
                this.zzaoh.zzafo = (int) j;
                return;
            case 176:
                this.zzaoh.width = (int) j;
                return;
            case 179:
                this.zzaop.add(zzea(j));
                return;
            case 186:
                this.zzaoh.height = (int) j;
                return;
            case 215:
                this.zzaoh.number = (int) j;
                return;
            case 231:
                this.zzaoo = zzea(j);
                return;
            case 241:
                if (this.zzaor) {
                    return;
                }
                this.zzaoq.add(j);
                this.zzaor = true;
                return;
            case 251:
                this.zzapl = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzhd(sb3.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzhd(sb4.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzhd(sb5.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhd(sb6.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzhd(sb7.toString());
            case 21420:
                this.zzaok = j + this.zzaoe;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.zzaoh.zzafl = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzaoh.zzafl = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzaoh.zzafl = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzaoh.zzafl = 3;
                    return;
                }
            case 21680:
                this.zzaoh.zzapv = (int) j;
                return;
            case 21682:
                this.zzaoh.zzapx = (int) j;
                return;
            case 21690:
                this.zzaoh.zzapw = (int) j;
                return;
            case 21930:
                this.zzaoh.zzaqs = j == 1;
                return;
            case 22186:
                this.zzaoh.zzaqp = j;
                return;
            case 22203:
                this.zzaoh.zzaqq = j;
                return;
            case 25188:
                this.zzaoh.zzaqo = (int) j;
                return;
            case 2352003:
                this.zzaoh.zzapq = (int) j;
                return;
            case 2807729:
                this.zzaof = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.zzaoh.zzaqb = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.zzaoh.zzaqb = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.zzaoh.zzaqa = 6;
                                return;
                            } else if (i4 == 18) {
                                this.zzaoh.zzaqa = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.zzaoh.zzaqa = 3;
                        return;
                    case 21947:
                        zzjy zzjyVar = this.zzaoh;
                        zzjyVar.zzapy = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            zzjyVar.zzapz = 1;
                            return;
                        }
                        if (i5 == 9) {
                            zzjyVar.zzapz = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                this.zzaoh.zzapz = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.zzaoh.zzaqc = (int) j;
                        return;
                    case 21949:
                        this.zzaoh.zzaqd = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, long j, long j2) {
        if (i == 160) {
            this.zzapl = false;
            return;
        }
        if (i == 174) {
            this.zzaoh = new zzjy(null);
            return;
        }
        if (i == 187) {
            this.zzaor = false;
            return;
        }
        if (i == 19899) {
            this.zzaoj = -1;
            this.zzaok = -1L;
            return;
        }
        if (i == 20533) {
            this.zzaoh.zzapr = true;
            return;
        }
        if (i == 21968) {
            this.zzaoh.zzapy = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                long j3 = this.zzaoe;
                if (j3 != -1 && j3 != j) {
                    throw new zzhd("Multiple Segment elements not supported");
                }
                this.zzaoe = j;
                this.zzaod = j2;
                return;
            }
            if (i == 475249515) {
                this.zzaop = new zzod();
                this.zzaoq = new zzod();
            } else if (i == 524531317 && !this.zzaoi) {
                if (this.zzans && this.zzaom != -1) {
                    this.zzaol = true;
                } else {
                    this.zzapm.zza(new zzjl(this.zzagj));
                    this.zzaoi = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, String str) {
        if (i == 134) {
            this.zzaoh.zzapp = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            zzjy.a(this.zzaoh, str);
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhd(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjg r9, com.google.android.gms.internal.ads.zzjj r10) {
        /*
            r8 = this;
            r0 = 0
            r8.zzapk = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3a
            boolean r3 = r8.zzapk
            if (r3 != 0) goto L3a
            com.google.android.gms.internal.ads.zzjr r2 = r8.zzanq
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L5
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaol
            if (r5 == 0) goto L25
            r8.zzaon = r3
            long r3 = r8.zzaom
            r10.zzamw = r3
            r8.zzaol = r0
        L23:
            r3 = 1
            goto L37
        L25:
            boolean r3 = r8.zzaoi
            if (r3 == 0) goto L36
            long r3 = r8.zzaon
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L36
            r10.zzamw = r3
            r8.zzaon = r5
            goto L23
        L36:
            r3 = 0
        L37:
            if (r3 == 0) goto L5
            return r1
        L3a:
            if (r2 == 0) goto L3d
            return r0
        L3d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjt.zza(com.google.android.gms.internal.ads.zzjg, com.google.android.gms.internal.ads.zzjj):int");
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void zza(zzjf zzjfVar) {
        this.zzapm = zzjfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final boolean zza(zzjg zzjgVar) {
        return new zzjx().zza(zzjgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void zzc(long j, long j2) {
        this.zzaoo = -9223372036854775807L;
        this.zzaos = 0;
        this.zzanq.reset();
        this.zzang.reset();
        zzgm();
    }
}
