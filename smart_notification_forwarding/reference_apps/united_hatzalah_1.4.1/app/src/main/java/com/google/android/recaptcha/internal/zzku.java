package com.google.android.recaptcha.internal;

import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzku {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzkt zzktVar) {
        int zzi = zzi(bArr, i, zzktVar);
        int i3 = zzktVar.zza;
        if (i3 >= 0) {
            if (i3 <= bArr.length - zzi) {
                if (i3 == 0) {
                    zzktVar.zzc = zzle.zzb;
                    return zzi;
                }
                zzktVar.zzc = zzle.zzk(bArr, zzi, i3);
                return zzi + i3;
            }
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static int zzb(byte[] bArr, int i) {
        int i3 = bArr[i] & ForkServer.ERROR;
        int i4 = bArr[i + 1] & ForkServer.ERROR;
        int i5 = bArr[i + 2] & ForkServer.ERROR;
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public static int zzc(zzow zzowVar, byte[] bArr, int i, int i3, int i4, zzkt zzktVar) {
        Object zze = zzowVar.zze();
        int zzm = zzm(zze, zzowVar, bArr, i, i3, i4, zzktVar);
        zzowVar.zzf(zze);
        zzktVar.zzc = zze;
        return zzm;
    }

    public static int zzd(zzow zzowVar, byte[] bArr, int i, int i3, zzkt zzktVar) {
        Object zze = zzowVar.zze();
        int zzn = zzn(zze, zzowVar, bArr, i, i3, zzktVar);
        zzowVar.zzf(zze);
        zzktVar.zzc = zze;
        return zzn;
    }

    public static int zze(zzow zzowVar, int i, byte[] bArr, int i3, int i4, zznk zznkVar, zzkt zzktVar) {
        int zzd = zzd(zzowVar, bArr, i3, i4, zzktVar);
        zznkVar.add(zzktVar.zzc);
        while (zzd < i4) {
            int zzi = zzi(bArr, zzd, zzktVar);
            if (i != zzktVar.zza) {
                break;
            }
            zzd = zzd(zzowVar, bArr, zzi, i4, zzktVar);
            zznkVar.add(zzktVar.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zznk zznkVar, zzkt zzktVar) {
        zzne zzneVar = (zzne) zznkVar;
        int zzi = zzi(bArr, i, zzktVar);
        int i3 = zzktVar.zza + zzi;
        while (zzi < i3) {
            zzi = zzi(bArr, zzi, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        if (zzi == i3) {
            return zzi;
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(byte[] bArr, int i, zzkt zzktVar) {
        int zzi = zzi(bArr, i, zzktVar);
        int i3 = zzktVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzktVar.zzc = "";
                return zzi;
            }
            zzktVar.zzc = new String(bArr, zzi, i3, zznl.zza);
            return zzi + i3;
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static int zzh(int i, byte[] bArr, int i3, int i4, zzpm zzpmVar, zzkt zzktVar) {
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                zzpmVar.zzj(i, Integer.valueOf(zzb(bArr, i3)));
                                return i3 + 4;
                            }
                            throw new zznn("Protocol message contained an invalid tag (zero).");
                        }
                        int i6 = (i & (-8)) | 4;
                        zzpm zzf = zzpm.zzf();
                        int i7 = zzktVar.zze + 1;
                        zzktVar.zze = i7;
                        zzq(i7);
                        int i8 = 0;
                        while (true) {
                            if (i3 >= i4) {
                                break;
                            }
                            int zzi = zzi(bArr, i3, zzktVar);
                            int i9 = zzktVar.zza;
                            if (i9 == i6) {
                                i8 = i9;
                                i3 = zzi;
                                break;
                            }
                            i3 = zzh(i9, bArr, zzi, i4, zzf, zzktVar);
                            i8 = i9;
                        }
                        zzktVar.zze--;
                        if (i3 <= i4 && i8 == i6) {
                            zzpmVar.zzj(i, zzf);
                            return i3;
                        }
                        throw new zznn("Failed to parse the message.");
                    }
                    int zzi2 = zzi(bArr, i3, zzktVar);
                    int i10 = zzktVar.zza;
                    if (i10 >= 0) {
                        if (i10 <= bArr.length - zzi2) {
                            if (i10 == 0) {
                                zzpmVar.zzj(i, zzle.zzb);
                            } else {
                                zzpmVar.zzj(i, zzle.zzk(bArr, zzi2, i10));
                            }
                            return zzi2 + i10;
                        }
                        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                zzpmVar.zzj(i, Long.valueOf(zzp(bArr, i3)));
                return i3 + 8;
            }
            int zzl = zzl(bArr, i3, zzktVar);
            zzpmVar.zzj(i, Long.valueOf(zzktVar.zzb));
            return zzl;
        }
        throw new zznn("Protocol message contained an invalid tag (zero).");
    }

    public static int zzi(byte[] bArr, int i, zzkt zzktVar) {
        int i3 = i + 1;
        byte b4 = bArr[i];
        if (b4 >= 0) {
            zzktVar.zza = b4;
            return i3;
        }
        return zzj(b4, bArr, i3, zzktVar);
    }

    public static int zzj(int i, byte[] bArr, int i3, zzkt zzktVar) {
        byte b4 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i & 127;
        if (b4 >= 0) {
            zzktVar.zza = i5 | (b4 << 7);
            return i4;
        }
        int i6 = i5 | ((b4 & Byte.MAX_VALUE) << 7);
        int i7 = i3 + 2;
        byte b5 = bArr[i4];
        if (b5 >= 0) {
            zzktVar.zza = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & Byte.MAX_VALUE) << 14);
        int i9 = i3 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzktVar.zza = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & Byte.MAX_VALUE) << 21);
        int i11 = i3 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzktVar.zza = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                zzktVar.zza = i12;
                return i13;
            }
        }
    }

    public static int zzk(int i, byte[] bArr, int i3, int i4, zznk zznkVar, zzkt zzktVar) {
        zzne zzneVar = (zzne) zznkVar;
        int zzi = zzi(bArr, i3, zzktVar);
        zzneVar.zzh(zzktVar.zza);
        while (zzi < i4) {
            int zzi2 = zzi(bArr, zzi, zzktVar);
            if (i != zzktVar.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        return zzi;
    }

    public static int zzl(byte[] bArr, int i, zzkt zzktVar) {
        long j2 = bArr[i];
        int i3 = i + 1;
        if (j2 >= 0) {
            zzktVar.zzb = j2;
            return i3;
        }
        int i4 = i + 2;
        byte b4 = bArr[i3];
        long j3 = (j2 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b4 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & Byte.MAX_VALUE) << i5;
            b4 = bArr[i4];
            i4 = i6;
        }
        zzktVar.zzb = j3;
        return i4;
    }

    public static int zzm(Object obj, zzow zzowVar, byte[] bArr, int i, int i3, int i4, zzkt zzktVar) {
        int i5 = zzktVar.zze + 1;
        zzktVar.zze = i5;
        zzq(i5);
        int zzc = ((zzol) zzowVar).zzc(obj, bArr, i, i3, i4, zzktVar);
        zzktVar.zze--;
        zzktVar.zzc = obj;
        return zzc;
    }

    public static int zzn(Object obj, zzow zzowVar, byte[] bArr, int i, int i3, zzkt zzktVar) {
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            i4 = zzj(i5, bArr, i4, zzktVar);
            i5 = zzktVar.zza;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            int i7 = zzktVar.zze + 1;
            zzktVar.zze = i7;
            zzq(i7);
            int i8 = i6 + i5;
            zzowVar.zzi(obj, bArr, i6, i8, zzktVar);
            zzktVar.zze--;
            zzktVar.zzc = obj;
            return i8;
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzo(int i, byte[] bArr, int i3, int i4, zzkt zzktVar) {
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                return i3 + 4;
                            }
                            throw new zznn("Protocol message contained an invalid tag (zero).");
                        }
                        int i6 = (i & (-8)) | 4;
                        int i7 = 0;
                        while (i3 < i4) {
                            i3 = zzi(bArr, i3, zzktVar);
                            i7 = zzktVar.zza;
                            if (i7 == i6) {
                                break;
                            }
                            i3 = zzo(i7, bArr, i3, i4, zzktVar);
                        }
                        if (i3 <= i4 && i7 == i6) {
                            return i3;
                        }
                        throw new zznn("Failed to parse the message.");
                    }
                    return zzi(bArr, i3, zzktVar) + zzktVar.zza;
                }
                return i3 + 8;
            }
            return zzl(bArr, i3, zzktVar);
        }
        throw new zznn("Protocol message contained an invalid tag (zero).");
    }

    public static long zzp(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzq(int i) {
        if (i < zzb) {
        } else {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
