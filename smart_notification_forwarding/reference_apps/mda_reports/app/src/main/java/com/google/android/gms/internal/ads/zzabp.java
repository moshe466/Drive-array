package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzabp extends zzabz {
    private static final int zzcva = Color.rgb(12, 174, 206);
    private static final int zzcvb;
    private static final int zzcvc;
    private static final int zzcvd;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzcve;
    private final List<zzabu> zzcvf = new ArrayList();
    private final List<zzaci> zzcvg = new ArrayList();
    private final int zzcvh;
    private final int zzcvi;
    private final boolean zzcvj;

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzcvb = rgb;
        zzcvc = rgb;
        zzcvd = zzcva;
    }

    public zzabp(String str, List<zzabu> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzcve = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzabu zzabuVar = list.get(i3);
                this.zzcvf.add(zzabuVar);
                this.zzcvg.add(zzabuVar);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzcvc;
        this.textColor = num2 != null ? num2.intValue() : zzcvd;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzcvh = i;
        this.zzcvi = i2;
        this.zzcvj = z;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final String getText() {
        return this.zzcve;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final List<zzaci> zzqx() {
        return this.zzcvg;
    }

    public final List<zzabu> zzqy() {
        return this.zzcvf;
    }

    public final int zzqz() {
        return this.zzcvh;
    }

    public final int zzra() {
        return this.zzcvi;
    }
}
