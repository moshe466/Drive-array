package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpu extends IllegalArgumentException {
    public zzpu(int i, int i3) {
        super(AbstractC0008a.k("Unpaired surrogate at index ", i, i3, " of "));
    }
}
