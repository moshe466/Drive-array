package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public interface k {
    void c(String str, LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T i(String str, Class<T> cls);

    Activity j();

    void startActivityForResult(Intent intent, int i10);
}
