package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public enum t {
    NONE,
    JAVA_ONLY,
    ALL;

    static final int REPORT_UPLOAD_VARIANT_DATATRANSPORT = 2;
    static final int REPORT_UPLOAD_VARIANT_LEGACY = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t getState(g4.b bVar) {
        return getState(bVar.f9782g == 2, bVar.f9783h == 2);
    }

    static t getState(boolean z10, boolean z11) {
        return !z10 ? NONE : !z11 ? JAVA_ONLY : ALL;
    }
}
