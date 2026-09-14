package com.google.android.gms.internal.fido;

import io.flutter.Build;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzds {
    public static final zzdr zza(InputStream inputStream, zzdu zzduVar) {
        try {
            return zzb(inputStream, zzduVar);
        } finally {
            try {
                zzduVar.close();
            } catch (IOException unused) {
            }
        }
    }

    private static final zzdr zzb(InputStream inputStream, zzdu zzduVar) {
        long j2;
        try {
            zzdt zzd = zzduVar.zzd();
            if (zzd != null) {
                try {
                    byte zza = zzd.zza();
                    byte zzb = zzd.zzb();
                    int i = 0;
                    if (zzb != Byte.MIN_VALUE) {
                        if (zzb != -96) {
                            if (zzb != -64) {
                                if (zzb != -32) {
                                    if (zzb != 0 && zzb != 32) {
                                        if (zzb != 64) {
                                            if (zzb == 96) {
                                                String zze = zzduVar.zze();
                                                zzc(zza, zze.length(), inputStream, zzduVar);
                                                return new zzdp(zze);
                                            }
                                            throw new zzdl("Unidentifiable major type: " + zzd.zzc());
                                        }
                                        byte[] zzg = zzduVar.zzg();
                                        int length = zzg.length;
                                        zzc(zza, length, inputStream, zzduVar);
                                        return new zzdk(zzcz.zzl(zzg, 0, length));
                                    }
                                    long zzb2 = zzduVar.zzb();
                                    if (zzb2 > 0) {
                                        j2 = zzb2;
                                    } else {
                                        j2 = ~zzb2;
                                    }
                                    zzc(zza, j2, inputStream, zzduVar);
                                    return new zzdm(zzb2);
                                }
                                return new zzdj(zzduVar.zzf());
                            }
                            throw new zzdl("Tags are currently unsupported");
                        }
                        long zzc = zzduVar.zzc();
                        if (zzc <= 1000) {
                            zzc(zza, zzc, inputStream, zzduVar);
                            int i3 = (int) zzc;
                            zzdn[] zzdnVarArr = new zzdn[i3];
                            zzdr zzdrVar = null;
                            int i4 = 0;
                            while (i4 < zzc) {
                                zzdr zzb3 = zzb(inputStream, zzduVar);
                                if (zzdrVar != null && zzb3.compareTo(zzdrVar) <= 0) {
                                    throw new zzdh("Keys in CBOR Map not in strictly ascending natural order:\nPrevious key: " + zzdrVar.toString() + "\nCurrent key: " + zzb3.toString());
                                }
                                zzdnVarArr[i4] = new zzdn(zzb3, zzb(inputStream, zzduVar));
                                i4++;
                                zzdrVar = zzb3;
                            }
                            TreeMap treeMap = new TreeMap();
                            while (i < i3) {
                                zzdn zzdnVar = zzdnVarArr[i];
                                if (!treeMap.containsKey(zzdnVar.zza())) {
                                    treeMap.put(zzdnVar.zza(), zzdnVar.zzb());
                                    i++;
                                } else {
                                    throw new zzdh("Attempted to add duplicate key to canonical CBOR Map.");
                                }
                            }
                            return new zzdo(zzbg.zzf(treeMap));
                        }
                        throw new zzdl("Parser being asked to read a large CBOR map");
                    }
                    long zza2 = zzduVar.zza();
                    if (zza2 <= 1000) {
                        zzc(zza, zza2, inputStream, zzduVar);
                        zzdr[] zzdrVarArr = new zzdr[(int) zza2];
                        while (i < zza2) {
                            zzdrVarArr[i] = zzb(inputStream, zzduVar);
                            i++;
                        }
                        return new zzdi(zzaz.zzi(zzdrVarArr));
                    }
                    throw new zzdl("Parser being asked to read a large CBOR array");
                } catch (IOException e4) {
                    e = e4;
                    throw new zzdl("Error in decoding CborValue from bytes", e);
                } catch (RuntimeException e5) {
                    e = e5;
                    throw new zzdl("Error in decoding CborValue from bytes", e);
                }
            }
            throw new zzdl("Parser being asked to parse an empty input stream");
        } catch (IOException e6) {
            throw new zzdl("Error in decoding CborValue from bytes", e6);
        }
    }

    private static final void zzc(byte b4, long j2, InputStream inputStream, zzdu zzduVar) {
        switch (b4) {
            case 24:
                if (j2 >= 24) {
                    return;
                }
                throw new zzdh("Integer value " + j2 + " after add info could have been represented in 0 additional bytes, but used 1");
            case Build.API_LEVELS.API_25 /* 25 */:
                if (j2 < 256) {
                    throw new zzdh("Integer value " + j2 + " after add info could have been represented in 0-1 additional bytes, but used 2");
                }
                return;
            case Build.API_LEVELS.API_26 /* 26 */:
                if (j2 < 65536) {
                    throw new zzdh("Integer value " + j2 + " after add info could have been represented in 0-2 additional bytes, but used 4");
                }
                return;
            case Build.API_LEVELS.API_27 /* 27 */:
                if (j2 < 4294967296L) {
                    throw new zzdh("Integer value " + j2 + " after add info could have been represented in 0-4 additional bytes, but used 8");
                }
                return;
            default:
                return;
        }
    }
}
