package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes.dex */
public class x7 extends IOException {
    public x7(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x7 a() {
        return new x7("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x7 b() {
        return new x7("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x7 c() {
        return new x7("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w7 d() {
        return new w7("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x7 e() {
        return new x7("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x7 f() {
        return new x7("Protocol message had invalid UTF-8.");
    }
}
