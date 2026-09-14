package com.google.android.gms.common.api;

import F0.AbstractC0008a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import t.C0685a;
import t.C0686b;
import t.C0689e;

/* loaded from: classes.dex */
public class AvailabilityException extends Exception {
    private final C0689e zaa;

    public AvailabilityException(C0689e c0689e) {
        this.zaa = c0689e;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        C0689e c0689e = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        Object obj = c0689e.get(apiKey);
        String zaa = apiKey.zaa();
        Preconditions.checkArgument(obj != null, AbstractC0008a.v(new StringBuilder(String.valueOf(zaa).length() + 58), "The given API (", zaa, ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0689e.get(apiKey));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        C0689e c0689e = this.zaa;
        Iterator it = ((C0686b) c0689e.keySet()).iterator();
        boolean z3 = true;
        while (true) {
            C0685a c0685a = (C0685a) it;
            if (!c0685a.hasNext()) {
                break;
            }
            ApiKey apiKey = (ApiKey) c0685a.next();
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0689e.get(apiKey));
            z3 &= !connectionResult.isSuccess();
            String zaa = apiKey.zaa();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(zaa).length() + 2 + valueOf.length());
            sb.append(zaa);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z3) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        C0689e c0689e = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        Object obj = c0689e.get(apiKey);
        String zaa = apiKey.zaa();
        Preconditions.checkArgument(obj != null, AbstractC0008a.v(new StringBuilder(String.valueOf(zaa).length() + 58), "The given API (", zaa, ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0689e.get(apiKey));
    }
}
