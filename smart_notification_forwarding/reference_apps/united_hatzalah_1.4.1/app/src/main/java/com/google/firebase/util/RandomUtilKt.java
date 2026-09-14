package com.google.firebase.util;

import I2.e;
import K2.f;
import T.b;
import e0.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }

    public static final String nextAlphanumericString(e eVar, int i) {
        j.e(eVar, "<this>");
        if (i >= 0) {
            f Q3 = b.Q(0, i);
            ArrayList arrayList = new ArrayList(AbstractC0709k.Y(Q3, 10));
            Iterator it = Q3.iterator();
            while (((K2.e) it).f1123c) {
                ((K2.e) it).nextInt();
                arrayList.add(Character.valueOf(ALPHANUMERIC_ALPHABET.charAt(eVar.a(30))));
            }
            return AbstractC0707i.h0(arrayList, "", null, null, null, 62);
        }
        throw new IllegalArgumentException(a.c(i, "invalid length: ").toString());
    }
}
