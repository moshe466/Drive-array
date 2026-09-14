package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4213a;

    public /* synthetic */ a(int i) {
        this.f4213a = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f4213a) {
            case 0:
                return CrashlyticsAppQualitySessionsStore.a(file, str);
            default:
                return CrashlyticsController.a(file, str);
        }
    }
}
