package com.lt.plugin.lt_plugin.utils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4395a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseHelper f4396b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4397c;

    public /* synthetic */ b(FirebaseHelper firebaseHelper, String str, int i) {
        this.f4395a = i;
        this.f4396b = firebaseHelper;
        this.f4397c = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f4395a) {
            case 0:
                FirebaseHelper.e(this.f4396b, this.f4397c, task);
                return;
            case 1:
                FirebaseHelper.i(this.f4396b, this.f4397c, task);
                return;
            default:
                FirebaseHelper.c(this.f4396b, this.f4397c, task);
                return;
        }
    }
}
