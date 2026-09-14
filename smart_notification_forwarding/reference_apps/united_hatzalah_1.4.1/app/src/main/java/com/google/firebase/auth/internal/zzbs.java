package com.google.firebase.auth.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* loaded from: classes.dex */
public interface zzbs {
    Task<RecaptchaTasksClient> zza(Application application, String str);
}
