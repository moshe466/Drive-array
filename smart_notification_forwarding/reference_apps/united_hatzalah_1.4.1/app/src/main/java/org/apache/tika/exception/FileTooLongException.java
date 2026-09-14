package org.apache.tika.exception;

import F0.AbstractC0008a;
import e0.a;
import java.io.IOException;

/* loaded from: classes.dex */
public class FileTooLongException extends IOException {
    public FileTooLongException(String str) {
        super(str);
    }

    private static String msg(long j2, long j3) {
        return a.g(AbstractC0008a.x("File is ", " bytes, but ", j2), j3, " is the maximum length allowed.  You can modify maxLength via the setter on the fetcher.");
    }

    public FileTooLongException(long j2, long j3) {
        super(msg(j2, j3));
    }
}
