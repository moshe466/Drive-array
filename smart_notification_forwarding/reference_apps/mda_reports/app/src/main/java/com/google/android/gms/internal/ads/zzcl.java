package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzcl extends zzcj<Integer, Object> {
    public String zzmv;
    public long zzmw;
    public String zzmx;
    public String zzmy;
    public String zzmz;

    public zzcl() {
        this.zzmv = ExifInterface.LONGITUDE_EAST;
        this.zzmw = -1L;
        this.zzmx = ExifInterface.LONGITUDE_EAST;
        this.zzmy = ExifInterface.LONGITUDE_EAST;
        this.zzmz = ExifInterface.LONGITUDE_EAST;
    }

    public zzcl(String str) {
        this();
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzmv);
        hashMap.put(4, this.zzmz);
        hashMap.put(3, this.zzmy);
        hashMap.put(2, this.zzmx);
        hashMap.put(1, Long.valueOf(this.zzmw));
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            Object obj = a.get(0);
            String str2 = ExifInterface.LONGITUDE_EAST;
            this.zzmv = obj == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(0);
            this.zzmw = a.get(1) == null ? -1L : ((Long) a.get(1)).longValue();
            this.zzmx = a.get(2) == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(2);
            this.zzmy = a.get(3) == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(3);
            if (a.get(4) != null) {
                str2 = (String) a.get(4);
            }
            this.zzmz = str2;
        }
    }
}
