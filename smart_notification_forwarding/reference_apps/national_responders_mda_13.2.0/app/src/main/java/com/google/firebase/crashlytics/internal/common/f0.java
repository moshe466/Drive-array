package com.google.firebase.crashlytics.internal.common;

import java.util.Comparator;
import w3.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final f0 f7085a = new f0();

    private f0() {
    }

    public static Comparator a() {
        return f7085a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((v.b) obj).b().compareTo(((v.b) obj2).b());
        return compareTo;
    }
}
