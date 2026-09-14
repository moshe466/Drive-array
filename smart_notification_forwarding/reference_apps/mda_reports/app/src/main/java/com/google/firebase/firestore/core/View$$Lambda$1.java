package com.google.firebase.firestore.core;

import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class View$$Lambda$1 implements Comparator {
    private final View arg$1;

    private View$$Lambda$1(View view) {
        this.arg$1 = view;
    }

    public static Comparator lambdaFactory$(View view) {
        return new View$$Lambda$1(view);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return View.a(this.arg$1, (DocumentViewChange) obj, (DocumentViewChange) obj2);
    }
}
