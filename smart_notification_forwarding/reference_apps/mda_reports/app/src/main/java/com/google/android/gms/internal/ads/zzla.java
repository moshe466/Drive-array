package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzla {
    private static final SparseIntArray zzazj;
    private static final SparseIntArray zzazk;
    private static final Map<String, Integer> zzazl;
    private static final zzkt zzazg = zzkt.zzbd("OMX.google.raw.decoder");
    private static final Pattern zzazh = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzkt>> zzazi = new HashMap<>();
    private static int zzazm = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zza {
        public final String mimeType;
        public final boolean zzaxo;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzaxo = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zzaVar = (zza) obj;
                if (TextUtils.equals(this.mimeType, zzaVar.mimeType) && this.zzaxo == zzaVar.zzaxo) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzaxo ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzazj = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzazj.put(77, 2);
        zzazj.put(88, 4);
        zzazj.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzazk = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzazk.put(11, 4);
        zzazk.put(12, 8);
        zzazk.put(13, 16);
        zzazk.put(20, 32);
        zzazk.put(21, 64);
        zzazk.put(22, 128);
        zzazk.put(30, 256);
        zzazk.put(31, 512);
        zzazk.put(32, 1024);
        zzazk.put(40, 2048);
        zzazk.put(41, 4096);
        zzazk.put(42, 8192);
        zzazk.put(50, 16384);
        zzazk.put(51, 32768);
        zzazk.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzazl = hashMap;
        hashMap.put("L30", 1);
        zzazl.put("L60", 4);
        zzazl.put("L63", 16);
        zzazl.put("L90", 64);
        zzazl.put("L93", 256);
        zzazl.put("L120", 1024);
        zzazl.put("L123", 4096);
        zzazl.put("L150", 16384);
        zzazl.put("L153", 65536);
        zzazl.put("L156", 262144);
        zzazl.put("L180", 1048576);
        zzazl.put("L183", 4194304);
        zzazl.put("L186", 16777216);
        zzazl.put("H30", 2);
        zzazl.put("H60", 8);
        zzazl.put("H63", 32);
        zzazl.put("H90", 128);
        zzazl.put("H93", 512);
        zzazl.put("H120", 2048);
        zzazl.put("H123", 8192);
        zzazl.put("H150", 32768);
        zzazl.put("H153", 131072);
        zzazl.put("H156", 524288);
        zzazl.put("H180", 2097152);
        zzazl.put("H183", 8388608);
        zzazl.put("H186", 33554432);
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        String valueOf3;
        StringBuilder sb;
        String str2;
        if (strArr.length < 2) {
            String valueOf4 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf4) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf5 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                valueOf = valueOf5;
            } else {
                if (strArr.length < 3) {
                    String valueOf6 = String.valueOf(str);
                    Log.w("MediaCodecUtil", valueOf6.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf6) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            }
            Integer valueOf7 = Integer.valueOf(zzazj.get(valueOf.intValue()));
            if (valueOf7 == null) {
                valueOf3 = String.valueOf(valueOf);
                sb = new StringBuilder(String.valueOf(valueOf3).length() + 21);
                str2 = "Unknown AVC profile: ";
            } else {
                Integer valueOf8 = Integer.valueOf(zzazk.get(valueOf2.intValue()));
                if (valueOf8 != null) {
                    return new Pair<>(valueOf7, valueOf8);
                }
                valueOf3 = String.valueOf(valueOf2);
                sb = new StringBuilder(String.valueOf(valueOf3).length() + 19);
                str2 = "Unknown AVC level: ";
            }
            sb.append(str2);
            sb.append(valueOf3);
            Log.w("MediaCodecUtil", sb.toString());
            return null;
        } catch (NumberFormatException unused) {
            String valueOf9 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf9) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzlb.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.zzkz):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b2 A[Catch: Exception -> 0x02ae, TryCatch #1 {Exception -> 0x02ae, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:27:0x0068, B:29:0x006e, B:32:0x0078, B:34:0x007c, B:36:0x0084, B:39:0x0090, B:41:0x0096, B:43:0x009e, B:45:0x00a8, B:47:0x00b2, B:49:0x00bc, B:51:0x00c6, B:53:0x00d0, B:55:0x00da, B:57:0x00e4, B:59:0x00ee, B:61:0x00f8, B:63:0x0102, B:65:0x010c, B:68:0x0118, B:70:0x011c, B:72:0x0124, B:74:0x012e, B:76:0x0138, B:78:0x0142, B:81:0x014d, B:84:0x0155, B:86:0x015d, B:88:0x0167, B:90:0x0171, B:92:0x017b, B:94:0x0183, B:96:0x018d, B:99:0x0198, B:101:0x019c, B:103:0x01a4, B:108:0x01b2, B:110:0x01ba, B:143:0x0232, B:146:0x023a, B:148:0x0240, B:151:0x0264, B:152:0x0298), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fd A[Catch: Exception -> 0x01f8, TryCatch #3 {Exception -> 0x01f8, blocks: (B:158:0x01d2, B:160:0x01dc, B:162:0x01e6, B:164:0x01ee, B:121:0x01fd, B:125:0x020b, B:128:0x0206, B:134:0x0219), top: B:157:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzkt> zza(com.google.android.gms.internal.ads.zzla.zza r17, com.google.android.gms.internal.ads.zzld r18) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzla.zza(com.google.android.gms.internal.ads.zzla$zza, com.google.android.gms.internal.ads.zzld):java.util.List");
    }

    public static zzkt zzb(String str, boolean z) {
        List<zzkt> zzc = zzc(str, z);
        if (zzc.isEmpty()) {
            return null;
        }
        return zzc.get(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0029, code lost:
    
        if (r3.equals("hev1") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbg(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzla.zzbg(java.lang.String):android.util.Pair");
    }

    private static synchronized List<zzkt> zzc(String str, boolean z) {
        synchronized (zzla.class) {
            zza zzaVar = new zza(str, z);
            List<zzkt> list = zzazi.get(zzaVar);
            if (list != null) {
                return list;
            }
            List<zzkt> zza2 = zza(zzaVar, zzoq.SDK_INT >= 21 ? new zzlf(z) : new zzlc());
            if (z && zza2.isEmpty() && 21 <= zzoq.SDK_INT && zzoq.SDK_INT <= 23) {
                zza2 = zza(zzaVar, new zzlc());
                if (!zza2.isEmpty()) {
                    String str2 = zza2.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzkt> unmodifiableList = Collections.unmodifiableList(zza2);
            zzazi.put(zzaVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static zzkt zzhb() {
        return zzazg;
    }

    public static int zzhc() {
        int i;
        if (zzazm == -1) {
            int i2 = 0;
            zzkt zzb = zzb("video/avc", false);
            if (zzb != null) {
                MediaCodecInfo.CodecProfileLevel[] zzgu = zzb.zzgu();
                int length = zzgu.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzgu[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzoq.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzazm = i2;
        }
        return zzazm;
    }
}
