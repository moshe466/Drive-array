package com.google.firebase.auth;

import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MultiFactor {
    public abstract Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str);

    public abstract List<MultiFactorInfo> getEnrolledFactors();

    public abstract Task<MultiFactorSession> getSession();

    public abstract Task<Void> unenroll(MultiFactorInfo multiFactorInfo);

    public abstract Task<Void> unenroll(String str);
}
