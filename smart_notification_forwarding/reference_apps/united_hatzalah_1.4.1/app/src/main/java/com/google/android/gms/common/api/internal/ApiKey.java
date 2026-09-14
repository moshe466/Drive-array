package com.google.android.gms.common.api.internal;

import android.os.UserHandle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class ApiKey<O extends Api.ApiOptions> {
    private final int zaa;
    private final Api zab;
    private final Api.ApiOptions zac;
    private final String zad;
    private final UserHandle zae;

    private ApiKey(Api api, Api.ApiOptions apiOptions, String str, UserHandle userHandle) {
        this.zab = api;
        this.zac = apiOptions;
        this.zad = str;
        this.zae = userHandle;
        this.zaa = Objects.hashCode(api, apiOptions, str, userHandle);
    }

    public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(Api<O> api, O o2, String str) {
        return getSharedApiKey(api, o2, str, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!Objects.equal(this.zab, apiKey.zab) || !Objects.equal(this.zac, apiKey.zac) || !Objects.equal(this.zad, apiKey.zad) || !Objects.equal(this.zae, apiKey.zae)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }

    public final String zaa() {
        return this.zab.zad();
    }

    public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(Api<O> api, O o2, String str, UserHandle userHandle) {
        return new ApiKey<>(api, o2, str, userHandle);
    }
}
