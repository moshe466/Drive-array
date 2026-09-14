package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.o0;
import com.google.android.gms.internal.measurement.q0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class y9 {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6645a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f6646b;

    static {
        int[] iArr = new int[o0.a.values().length];
        f6646b = iArr;
        try {
            iArr[o0.a.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6646b[o0.a.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6646b[o0.a.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6646b[o0.a.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[q0.b.values().length];
        f6645a = iArr2;
        try {
            iArr2[q0.b.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6645a[q0.b.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f6645a[q0.b.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f6645a[q0.b.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f6645a[q0.b.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f6645a[q0.b.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
