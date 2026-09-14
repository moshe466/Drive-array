package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzaoe extends zzaoo {
    private static final Set<String> zzdfh = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height;
    private final Object lock;
    private int width;
    private zzaon zzcxq;
    private final zzbdi zzcza;
    private final Activity zzdex;
    private String zzdfi;
    private boolean zzdfj;
    private int zzdfk;
    private int zzdfl;
    private int zzdfm;
    private int zzdfn;
    private zzbey zzdfo;
    private ImageView zzdfp;
    private LinearLayout zzdfq;
    private PopupWindow zzdfr;
    private RelativeLayout zzdfs;
    private ViewGroup zzdft;

    public zzaoe(zzbdi zzbdiVar, zzaon zzaonVar) {
        super(zzbdiVar, "resize");
        this.zzdfi = "top-right";
        this.zzdfj = true;
        this.zzdfk = 0;
        this.zzdfl = 0;
        this.height = -1;
        this.zzdfm = 0;
        this.zzdfn = 0;
        this.width = -1;
        this.lock = new Object();
        this.zzcza = zzbdiVar;
        this.zzdex = zzbdiVar.zzyn();
        this.zzcxq = zzaonVar;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdfk = i;
            this.zzdfl = i2;
            PopupWindow popupWindow = this.zzdfr;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            if (this.zzdfr != null) {
                this.zzdfr.dismiss();
                this.zzdfs.removeView(this.zzcza.getView());
                if (this.zzdft != null) {
                    this.zzdft.removeView(this.zzdfp);
                    this.zzdft.addView(this.zzcza.getView());
                    this.zzcza.zza(this.zzdfo);
                }
                if (z) {
                    zzdu("default");
                    if (this.zzcxq != null) {
                        this.zzcxq.zzti();
                    }
                }
                this.zzdfr = null;
                this.zzdfs = null;
                this.zzdft = null;
                this.zzdfq = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0423 A[Catch: all -> 0x04aa, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:72:0x0227, B:77:0x028f, B:78:0x0294, B:80:0x0296, B:82:0x02b8, B:84:0x02bc, B:86:0x02cc, B:87:0x0300, B:90:0x0336, B:91:0x036a, B:103:0x03c0, B:104:0x03c3, B:105:0x03e4, B:107:0x03fc, B:108:0x041b, B:110:0x0423, B:111:0x042c, B:112:0x0452, B:116:0x0455, B:118:0x0465, B:119:0x046f, B:121:0x0481, B:122:0x049a, B:124:0x046a, B:125:0x03c7, B:126:0x03cb, B:127:0x03ce, B:128:0x03d2, B:129:0x03d6, B:130:0x03dc, B:131:0x03e0, B:132:0x036e, B:135:0x0378, B:138:0x0382, B:141:0x038c, B:144:0x0396, B:147:0x03a0, B:151:0x02fb, B:152:0x049c, B:153:0x04a1, B:155:0x022f, B:157:0x0233, B:158:0x0244, B:161:0x0272, B:163:0x0276, B:164:0x0286, B:165:0x0279, B:167:0x0280, B:168:0x0268, B:170:0x026d, B:172:0x0150, B:174:0x0154, B:175:0x015a, B:184:0x01a7, B:185:0x0205, B:186:0x0210, B:188:0x0213, B:190:0x0216, B:192:0x021a, B:195:0x01b3, B:196:0x01d0, B:197:0x01de, B:198:0x01c1, B:199:0x01d4, B:200:0x01e1, B:201:0x01f8, B:202:0x0208, B:203:0x015e, B:206:0x0168, B:209:0x0172, B:212:0x017c, B:215:0x0186, B:218:0x0190, B:224:0x04a3, B:225:0x04a8), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x022f A[Catch: all -> 0x04aa, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:72:0x0227, B:77:0x028f, B:78:0x0294, B:80:0x0296, B:82:0x02b8, B:84:0x02bc, B:86:0x02cc, B:87:0x0300, B:90:0x0336, B:91:0x036a, B:103:0x03c0, B:104:0x03c3, B:105:0x03e4, B:107:0x03fc, B:108:0x041b, B:110:0x0423, B:111:0x042c, B:112:0x0452, B:116:0x0455, B:118:0x0465, B:119:0x046f, B:121:0x0481, B:122:0x049a, B:124:0x046a, B:125:0x03c7, B:126:0x03cb, B:127:0x03ce, B:128:0x03d2, B:129:0x03d6, B:130:0x03dc, B:131:0x03e0, B:132:0x036e, B:135:0x0378, B:138:0x0382, B:141:0x038c, B:144:0x0396, B:147:0x03a0, B:151:0x02fb, B:152:0x049c, B:153:0x04a1, B:155:0x022f, B:157:0x0233, B:158:0x0244, B:161:0x0272, B:163:0x0276, B:164:0x0286, B:165:0x0279, B:167:0x0280, B:168:0x0268, B:170:0x026d, B:172:0x0150, B:174:0x0154, B:175:0x015a, B:184:0x01a7, B:185:0x0205, B:186:0x0210, B:188:0x0213, B:190:0x0216, B:192:0x021a, B:195:0x01b3, B:196:0x01d0, B:197:0x01de, B:198:0x01c1, B:199:0x01d4, B:200:0x01e1, B:201:0x01f8, B:202:0x0208, B:203:0x015e, B:206:0x0168, B:209:0x0172, B:212:0x017c, B:215:0x0186, B:218:0x0190, B:224:0x04a3, B:225:0x04a8), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0213 A[Catch: all -> 0x04aa, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:72:0x0227, B:77:0x028f, B:78:0x0294, B:80:0x0296, B:82:0x02b8, B:84:0x02bc, B:86:0x02cc, B:87:0x0300, B:90:0x0336, B:91:0x036a, B:103:0x03c0, B:104:0x03c3, B:105:0x03e4, B:107:0x03fc, B:108:0x041b, B:110:0x0423, B:111:0x042c, B:112:0x0452, B:116:0x0455, B:118:0x0465, B:119:0x046f, B:121:0x0481, B:122:0x049a, B:124:0x046a, B:125:0x03c7, B:126:0x03cb, B:127:0x03ce, B:128:0x03d2, B:129:0x03d6, B:130:0x03dc, B:131:0x03e0, B:132:0x036e, B:135:0x0378, B:138:0x0382, B:141:0x038c, B:144:0x0396, B:147:0x03a0, B:151:0x02fb, B:152:0x049c, B:153:0x04a1, B:155:0x022f, B:157:0x0233, B:158:0x0244, B:161:0x0272, B:163:0x0276, B:164:0x0286, B:165:0x0279, B:167:0x0280, B:168:0x0268, B:170:0x026d, B:172:0x0150, B:174:0x0154, B:175:0x015a, B:184:0x01a7, B:185:0x0205, B:186:0x0210, B:188:0x0213, B:190:0x0216, B:192:0x021a, B:195:0x01b3, B:196:0x01d0, B:197:0x01de, B:198:0x01c1, B:199:0x01d4, B:200:0x01e1, B:201:0x01f8, B:202:0x0208, B:203:0x015e, B:206:0x0168, B:209:0x0172, B:212:0x017c, B:215:0x0186, B:218:0x0190, B:224:0x04a3, B:225:0x04a8), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x028f A[Catch: all -> 0x04aa, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:72:0x0227, B:77:0x028f, B:78:0x0294, B:80:0x0296, B:82:0x02b8, B:84:0x02bc, B:86:0x02cc, B:87:0x0300, B:90:0x0336, B:91:0x036a, B:103:0x03c0, B:104:0x03c3, B:105:0x03e4, B:107:0x03fc, B:108:0x041b, B:110:0x0423, B:111:0x042c, B:112:0x0452, B:116:0x0455, B:118:0x0465, B:119:0x046f, B:121:0x0481, B:122:0x049a, B:124:0x046a, B:125:0x03c7, B:126:0x03cb, B:127:0x03ce, B:128:0x03d2, B:129:0x03d6, B:130:0x03dc, B:131:0x03e0, B:132:0x036e, B:135:0x0378, B:138:0x0382, B:141:0x038c, B:144:0x0396, B:147:0x03a0, B:151:0x02fb, B:152:0x049c, B:153:0x04a1, B:155:0x022f, B:157:0x0233, B:158:0x0244, B:161:0x0272, B:163:0x0276, B:164:0x0286, B:165:0x0279, B:167:0x0280, B:168:0x0268, B:170:0x026d, B:172:0x0150, B:174:0x0154, B:175:0x015a, B:184:0x01a7, B:185:0x0205, B:186:0x0210, B:188:0x0213, B:190:0x0216, B:192:0x021a, B:195:0x01b3, B:196:0x01d0, B:197:0x01de, B:198:0x01c1, B:199:0x01d4, B:200:0x01e1, B:201:0x01f8, B:202:0x0208, B:203:0x015e, B:206:0x0168, B:209:0x0172, B:212:0x017c, B:215:0x0186, B:218:0x0190, B:224:0x04a3, B:225:0x04a8), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0296 A[Catch: all -> 0x04aa, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:72:0x0227, B:77:0x028f, B:78:0x0294, B:80:0x0296, B:82:0x02b8, B:84:0x02bc, B:86:0x02cc, B:87:0x0300, B:90:0x0336, B:91:0x036a, B:103:0x03c0, B:104:0x03c3, B:105:0x03e4, B:107:0x03fc, B:108:0x041b, B:110:0x0423, B:111:0x042c, B:112:0x0452, B:116:0x0455, B:118:0x0465, B:119:0x046f, B:121:0x0481, B:122:0x049a, B:124:0x046a, B:125:0x03c7, B:126:0x03cb, B:127:0x03ce, B:128:0x03d2, B:129:0x03d6, B:130:0x03dc, B:131:0x03e0, B:132:0x036e, B:135:0x0378, B:138:0x0382, B:141:0x038c, B:144:0x0396, B:147:0x03a0, B:151:0x02fb, B:152:0x049c, B:153:0x04a1, B:155:0x022f, B:157:0x0233, B:158:0x0244, B:161:0x0272, B:163:0x0276, B:164:0x0286, B:165:0x0279, B:167:0x0280, B:168:0x0268, B:170:0x026d, B:172:0x0150, B:174:0x0154, B:175:0x015a, B:184:0x01a7, B:185:0x0205, B:186:0x0210, B:188:0x0213, B:190:0x0216, B:192:0x021a, B:195:0x01b3, B:196:0x01d0, B:197:0x01de, B:198:0x01c1, B:199:0x01d4, B:200:0x01e1, B:201:0x01f8, B:202:0x0208, B:203:0x015e, B:206:0x0168, B:209:0x0172, B:212:0x017c, B:215:0x0186, B:218:0x0190, B:224:0x04a3, B:225:0x04a8), top: B:3:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoe.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.zzdfk = i;
        this.zzdfl = i2;
    }

    public final boolean zztg() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdfr != null;
        }
        return z;
    }
}
