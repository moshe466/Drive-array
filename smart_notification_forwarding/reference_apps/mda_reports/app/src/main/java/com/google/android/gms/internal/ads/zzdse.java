package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzdse extends IOException {
    private zzdte zzhnl;

    public zzdse(String str) {
        super(str);
        this.zzhnl = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse a() {
        return new zzdse("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse b() {
        return new zzdse("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse c() {
        return new zzdse("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse d() {
        return new zzdse("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse e() {
        return new zzdse("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdsd f() {
        return new zzdsd("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse g() {
        return new zzdse("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse h() {
        return new zzdse("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdse i() {
        return new zzdse("Protocol message had invalid UTF-8.");
    }

    public final zzdse zzl(zzdte zzdteVar) {
        this.zzhnl = zzdteVar;
        return this;
    }
}
