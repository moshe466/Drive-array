package com.groboot.mdaemergency.models;

import java.util.UUID;
import y8.k;

/* loaded from: classes.dex */
public final class Request {
    private UUID Id;
    public String RequestData;
    public RequestHeader RequestHeader;

    public final UUID getId() {
        return this.Id;
    }

    public final String getRequestData() {
        String str = this.RequestData;
        if (str != null) {
            return str;
        }
        k.o("RequestData");
        return null;
    }

    public final RequestHeader getRequestHeader() {
        RequestHeader requestHeader = this.RequestHeader;
        if (requestHeader != null) {
            return requestHeader;
        }
        k.o("RequestHeader");
        return null;
    }

    public final void setId(UUID uuid) {
        this.Id = uuid;
    }

    public final void setRequestData(String str) {
        k.e(str, "<set-?>");
        this.RequestData = str;
    }

    public final void setRequestHeader(RequestHeader requestHeader) {
        k.e(requestHeader, "<set-?>");
        this.RequestHeader = requestHeader;
    }
}
