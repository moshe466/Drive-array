package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
final /* synthetic */ class j implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final j f7105a = new j();

    private j() {
    }

    public static FilenameFilter a() {
        return f7105a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith(".ae");
        return startsWith;
    }
}
