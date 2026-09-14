package com.google.android.gms.internal.ads;

import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjq implements zzjr {
    private final byte[] zzane = new byte[8];
    private final Stack<zzjs> zzanf = new Stack<>();
    private final zzka zzang = new zzka();
    private zzju zzanh;
    private int zzani;
    private int zzanj;
    private long zzank;

    private final long zza(zzjg zzjgVar, int i) {
        zzjgVar.readFully(this.zzane, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.zzane[i2] & 255);
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzjr
    public final void reset() {
        this.zzani = 0;
        this.zzanf.clear();
        this.zzang.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzjr
    public final void zza(zzju zzjuVar) {
        this.zzanh = zzjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjr
    public final boolean zzb(zzjg zzjgVar) {
        String str;
        int zzan;
        int zza;
        long j;
        int i;
        zzoc.checkState(this.zzanh != null);
        while (true) {
            if (!this.zzanf.isEmpty()) {
                long position = zzjgVar.getPosition();
                j = this.zzanf.peek().zzanl;
                if (position >= j) {
                    zzju zzjuVar = this.zzanh;
                    i = this.zzanf.pop().zzanj;
                    zzjuVar.zzaj(i);
                    return true;
                }
            }
            if (this.zzani == 0) {
                long zza2 = this.zzang.zza(zzjgVar, true, false, 4);
                if (zza2 == -2) {
                    zzjgVar.zzgi();
                    while (true) {
                        zzjgVar.zza(this.zzane, 0, 4);
                        zzan = zzka.zzan(this.zzane[0]);
                        if (zzan != -1 && zzan <= 4) {
                            zza = (int) zzka.zza(this.zzane, zzan, false);
                            if (this.zzanh.zzai(zza)) {
                                break;
                            }
                        }
                        zzjgVar.zzac(1);
                    }
                    zzjgVar.zzac(zzan);
                    zza2 = zza;
                }
                if (zza2 == -1) {
                    return false;
                }
                this.zzanj = (int) zza2;
                this.zzani = 1;
            }
            if (this.zzani == 1) {
                this.zzank = this.zzang.zza(zzjgVar, false, true, 8);
                this.zzani = 2;
            }
            int zzah = this.zzanh.zzah(this.zzanj);
            if (zzah != 0) {
                if (zzah == 1) {
                    long position2 = zzjgVar.getPosition();
                    this.zzanf.add(new zzjs(this.zzanj, this.zzank + position2));
                    this.zzanh.zzd(this.zzanj, position2, this.zzank);
                    this.zzani = 0;
                    return true;
                }
                if (zzah == 2) {
                    long j2 = this.zzank;
                    if (j2 <= 8) {
                        this.zzanh.zzc(this.zzanj, zza(zzjgVar, (int) j2));
                        this.zzani = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzhd(sb.toString());
                }
                if (zzah == 3) {
                    long j3 = this.zzank;
                    if (j3 > 2147483647L) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j3);
                        throw new zzhd(sb2.toString());
                    }
                    zzju zzjuVar2 = this.zzanh;
                    int i2 = this.zzanj;
                    int i3 = (int) j3;
                    if (i3 == 0) {
                        str = "";
                    } else {
                        byte[] bArr = new byte[i3];
                        zzjgVar.readFully(bArr, 0, i3);
                        str = new String(bArr);
                    }
                    zzjuVar2.zza(i2, str);
                    this.zzani = 0;
                    return true;
                }
                if (zzah == 4) {
                    this.zzanh.zza(this.zzanj, (int) this.zzank, zzjgVar);
                    this.zzani = 0;
                    return true;
                }
                if (zzah != 5) {
                    StringBuilder sb3 = new StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(zzah);
                    throw new zzhd(sb3.toString());
                }
                long j4 = this.zzank;
                if (j4 != 4 && j4 != 8) {
                    StringBuilder sb4 = new StringBuilder(40);
                    sb4.append("Invalid float size: ");
                    sb4.append(j4);
                    throw new zzhd(sb4.toString());
                }
                zzju zzjuVar3 = this.zzanh;
                int i4 = this.zzanj;
                int i5 = (int) this.zzank;
                zzjuVar3.zza(i4, i5 == 4 ? Float.intBitsToFloat((int) r7) : Double.longBitsToDouble(zza(zzjgVar, i5)));
                this.zzani = 0;
                return true;
            }
            zzjgVar.zzac((int) this.zzank);
            this.zzani = 0;
        }
    }
}
