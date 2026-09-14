package com.google.firebase.auth.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* loaded from: classes.dex */
final class zzbv implements zzbs {
    @Override // com.google.firebase.auth.internal.zzbs
    public final Task<RecaptchaTasksClient> zza(Application application, String str) {
        return Recaptcha.fetchTaskClient(application, str);
    }
}
