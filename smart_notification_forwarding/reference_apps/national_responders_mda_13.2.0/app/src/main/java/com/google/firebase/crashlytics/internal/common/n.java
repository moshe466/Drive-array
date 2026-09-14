package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final String f7219a;

    /* renamed from: b, reason: collision with root package name */
    private final z3.h f7220b;

    public n(String str, z3.h hVar) {
        this.f7219a = str;
        this.f7220b = hVar;
    }

    private File b() {
        return new File(this.f7220b.b(), this.f7219a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e10) {
            s3.b.f().e("Error creating marker: " + this.f7219a, e10);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
