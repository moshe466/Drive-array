package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzle;
import com.google.common.net.HttpHeaders;

/* loaded from: classes.dex */
final class zzkl {
    private static final int zzavk = zzoq.zzbn("nam");
    private static final int zzavl = zzoq.zzbn("trk");
    private static final int zzavm = zzoq.zzbn("cmt");
    private static final int zzavn = zzoq.zzbn("day");
    private static final int zzavo = zzoq.zzbn("ART");
    private static final int zzavp = zzoq.zzbn("too");
    private static final int zzavq = zzoq.zzbn("alb");
    private static final int zzavr = zzoq.zzbn("com");
    private static final int zzavs = zzoq.zzbn("wrt");
    private static final int zzavt = zzoq.zzbn("lyr");
    private static final int zzavu = zzoq.zzbn("gen");
    private static final int zzavv = zzoq.zzbn("covr");
    private static final int zzavw = zzoq.zzbn("gnre");
    private static final int zzavx = zzoq.zzbn("grp");
    private static final int zzavy = zzoq.zzbn("disk");
    private static final int zzavz = zzoq.zzbn("trkn");
    private static final int zzawa = zzoq.zzbn("tmpo");
    private static final int zzawb = zzoq.zzbn("cpil");
    private static final int zzawc = zzoq.zzbn("aART");
    private static final int zzawd = zzoq.zzbn("sonm");
    private static final int zzawe = zzoq.zzbn("soal");
    private static final int zzawf = zzoq.zzbn("soar");
    private static final int zzawg = zzoq.zzbn("soaa");
    private static final int zzawh = zzoq.zzbn("soco");
    private static final int zzawi = zzoq.zzbn("rtng");
    private static final int zzawj = zzoq.zzbn("pgap");
    private static final int zzawk = zzoq.zzbn("sosn");
    private static final int zzawl = zzoq.zzbn("tvsh");
    private static final int zzawm = zzoq.zzbn("----");
    private static final String[] zzawn = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzll zza(int i, String str, zzoj zzojVar, boolean z, boolean z2) {
        int zze = zze(zzojVar);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze >= 0) {
            return z ? new zzlo(str, null, Integer.toString(zze)) : new zzlk("und", str, Integer.toString(zze));
        }
        String valueOf = String.valueOf(zzjz.zzam(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzlo zza(int i, String str, zzoj zzojVar) {
        int readInt = zzojVar.readInt();
        if (zzojVar.readInt() == zzjz.zzaua) {
            zzojVar.zzbf(8);
            return new zzlo(str, null, zzojVar.zzbg(readInt - 16));
        }
        String valueOf = String.valueOf(zzjz.zzam(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzlo zzb(int i, String str, zzoj zzojVar) {
        int readInt = zzojVar.readInt();
        if (zzojVar.readInt() == zzjz.zzaua && readInt >= 22) {
            zzojVar.zzbf(10);
            int readUnsignedShort = zzojVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzojVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzlo(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzjz.zzam(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static zzle.zza zzd(zzoj zzojVar) {
        String str;
        zzlo zzloVar;
        int position = zzojVar.getPosition() + zzojVar.readInt();
        int readInt = zzojVar.readInt();
        int i = readInt >>> 24;
        zzll zzllVar = null;
        try {
            if (i == 169 || i == 65533) {
                int i2 = 16777215 & readInt;
                if (i2 == zzavm) {
                    int readInt2 = zzojVar.readInt();
                    if (zzojVar.readInt() == zzjz.zzaua) {
                        zzojVar.zzbf(8);
                        String zzbg = zzojVar.zzbg(readInt2 - 16);
                        zzllVar = new zzlk("und", zzbg, zzbg);
                    } else {
                        String valueOf = String.valueOf(zzjz.zzam(readInt));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzllVar;
                }
                if (i2 != zzavk && i2 != zzavl) {
                    if (i2 != zzavr && i2 != zzavs) {
                        if (i2 == zzavn) {
                            return zza(readInt, "TDRC", zzojVar);
                        }
                        if (i2 == zzavo) {
                            return zza(readInt, "TPE1", zzojVar);
                        }
                        if (i2 == zzavp) {
                            return zza(readInt, "TSSE", zzojVar);
                        }
                        if (i2 == zzavq) {
                            return zza(readInt, "TALB", zzojVar);
                        }
                        if (i2 == zzavt) {
                            return zza(readInt, "USLT", zzojVar);
                        }
                        if (i2 == zzavu) {
                            return zza(readInt, "TCON", zzojVar);
                        }
                        if (i2 == zzavx) {
                            return zza(readInt, "TIT1", zzojVar);
                        }
                    }
                    return zza(readInt, "TCOM", zzojVar);
                }
                return zza(readInt, "TIT2", zzojVar);
            }
            if (readInt == zzavw) {
                int zze = zze(zzojVar);
                String str2 = (zze <= 0 || zze > zzawn.length) ? null : zzawn[zze - 1];
                if (str2 != null) {
                    zzloVar = new zzlo("TCON", null, str2);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzloVar = null;
                }
                return zzloVar;
            }
            if (readInt == zzavy) {
                return zzb(readInt, "TPOS", zzojVar);
            }
            if (readInt == zzavz) {
                return zzb(readInt, "TRCK", zzojVar);
            }
            if (readInt == zzawa) {
                return zza(readInt, "TBPM", zzojVar, true, false);
            }
            if (readInt == zzawb) {
                return zza(readInt, "TCMP", zzojVar, true, true);
            }
            if (readInt == zzavv) {
                int readInt3 = zzojVar.readInt();
                if (zzojVar.readInt() == zzjz.zzaua) {
                    int zzal = zzjz.zzal(zzojVar.readInt());
                    String str3 = zzal == 13 ? "image/jpeg" : zzal == 14 ? "image/png" : null;
                    if (str3 != null) {
                        zzojVar.zzbf(4);
                        byte[] bArr = new byte[readInt3 - 16];
                        zzojVar.zze(bArr, 0, bArr.length);
                        zzllVar = new zzli(str3, null, 3, bArr);
                        return zzllVar;
                    }
                    StringBuilder sb = new StringBuilder(41);
                    sb.append("Unrecognized cover art flags: ");
                    sb.append(zzal);
                    str = sb.toString();
                } else {
                    str = "Failed to parse cover art attribute";
                }
                Log.w("MetadataUtil", str);
                return zzllVar;
            }
            if (readInt == zzawc) {
                return zza(readInt, "TPE2", zzojVar);
            }
            if (readInt == zzawd) {
                return zza(readInt, "TSOT", zzojVar);
            }
            if (readInt == zzawe) {
                return zza(readInt, "TSO2", zzojVar);
            }
            if (readInt == zzawf) {
                return zza(readInt, "TSOA", zzojVar);
            }
            if (readInt == zzawg) {
                return zza(readInt, "TSOP", zzojVar);
            }
            if (readInt == zzawh) {
                return zza(readInt, "TSOC", zzojVar);
            }
            if (readInt == zzawi) {
                return zza(readInt, "ITUNESADVISORY", zzojVar, false, false);
            }
            if (readInt == zzawj) {
                return zza(readInt, "ITUNESGAPLESS", zzojVar, false, true);
            }
            if (readInt == zzawk) {
                return zza(readInt, "TVSHOWSORT", zzojVar);
            }
            if (readInt == zzawl) {
                return zza(readInt, "TVSHOW", zzojVar);
            }
            if (readInt == zzawm) {
                String str4 = null;
                String str5 = null;
                int i3 = -1;
                int i4 = -1;
                while (zzojVar.getPosition() < position) {
                    int position2 = zzojVar.getPosition();
                    int readInt4 = zzojVar.readInt();
                    int readInt5 = zzojVar.readInt();
                    zzojVar.zzbf(4);
                    if (readInt5 == zzjz.zzaty) {
                        str4 = zzojVar.zzbg(readInt4 - 12);
                    } else if (readInt5 == zzjz.zzatz) {
                        str5 = zzojVar.zzbg(readInt4 - 12);
                    } else {
                        if (readInt5 == zzjz.zzaua) {
                            i3 = position2;
                            i4 = readInt4;
                        }
                        zzojVar.zzbf(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str4) && "iTunSMPB".equals(str5) && i3 != -1) {
                    zzojVar.zzbe(i3);
                    zzojVar.zzbf(16);
                    zzllVar = new zzlk("und", str5, zzojVar.zzbg(i4 - 16));
                }
                return zzllVar;
            }
            String valueOf2 = String.valueOf(zzjz.zzam(readInt));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzojVar.zzbe(position);
        }
    }

    private static int zze(zzoj zzojVar) {
        zzojVar.zzbf(4);
        if (zzojVar.readInt() == zzjz.zzaua) {
            zzojVar.zzbf(8);
            return zzojVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
