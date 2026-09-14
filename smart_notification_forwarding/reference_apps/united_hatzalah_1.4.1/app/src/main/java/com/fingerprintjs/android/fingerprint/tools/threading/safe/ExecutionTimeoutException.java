package com.fingerprintjs.android.fingerprint.tools.threading.safe;

import F0.AbstractC0008a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import n1.C0594a;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class ExecutionTimeoutException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final List f3883a;

    public ExecutionTimeoutException(TimeoutException timeoutException, ArrayList arrayList) {
        super(timeoutException);
        this.f3883a = arrayList;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        StringBuilder sb = new StringBuilder("The execution took too long to complete. Original exception: ");
        sb.append(getCause());
        sb.append(", execution thread stacktrace: ");
        List list = this.f3883a;
        if (list != null) {
            str = AbstractC0707i.h0(list, null, null, null, C0594a.f5884a, 31);
        } else {
            str = null;
        }
        return AbstractC0008a.s(sb, str, '.');
    }
}
