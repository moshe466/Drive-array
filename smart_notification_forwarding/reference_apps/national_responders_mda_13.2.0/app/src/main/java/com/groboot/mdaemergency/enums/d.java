package com.groboot.mdaemergency.enums;

import il.org.mda.health.R;
import w6.m;

/* loaded from: classes.dex */
public enum d {
    PTT,
    BACK_TO_APP,
    MESSAGE;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7687a;

        static {
            int[] iArr = new int[com.groboot.mdaemergency.enums.a.values().length];
            f7687a = iArr;
            try {
                iArr[com.groboot.mdaemergency.enums.a.MADA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7687a[com.groboot.mdaemergency.enums.a.CREW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7687a[com.groboot.mdaemergency.enums.a.PHILIPINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int getImagePadding() {
        return m.m() == com.groboot.mdaemergency.enums.a.PHILIPINE ? 0 : 12;
    }

    public int getImageRes() {
        if (this == PTT) {
            return R.drawable.ptt_icon;
        }
        int i10 = a.f7687a[m.m().ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? R.mipmap.ic_launcher : R.drawable.red_cross_logo : R.drawable.run_green : R.drawable.mgen_david_red_logo;
    }
}
