package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4251a;

    public /* synthetic */ a(int i) {
        this.f4251a = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f4251a) {
            case 0:
                return CrashlyticsReportPersistence.a(file, str);
            default:
                return CrashlyticsReportPersistence.b(file, str);
        }
    }
}
