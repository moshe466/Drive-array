package com.google.android.gms.fido.u2f.api.messagebased;

@Deprecated
/* loaded from: classes.dex */
public enum RequestType {
    REGISTER("u2f_register_request"),
    SIGN("u2f_sign_request");

    private final String zzb;

    /* loaded from: classes.dex */
    public static class UnsupportedRequestTypeException extends Exception {
        public UnsupportedRequestTypeException(String str) {
            super("Unsupported request type ".concat(String.valueOf(str)));
        }
    }

    RequestType(String str) {
        this.zzb = str;
    }

    public static RequestType fromString(String str) {
        for (RequestType requestType : values()) {
            if (str.equals(requestType.zzb)) {
                return requestType;
            }
        }
        throw new UnsupportedRequestTypeException(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zzb;
    }
}
