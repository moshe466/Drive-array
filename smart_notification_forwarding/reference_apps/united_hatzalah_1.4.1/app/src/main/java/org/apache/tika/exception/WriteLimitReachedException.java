package org.apache.tika.exception;

import F0.AbstractC0008a;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class WriteLimitReachedException extends SAXException {
    private static final int MAX_DEPTH = 100;
    private final int writeLimit;

    public WriteLimitReachedException(int i) {
        this.writeLimit = i;
    }

    public static boolean isWriteLimitReached(Throwable th) {
        return isWriteLimitReached(th, 0);
    }

    public static void throwIfWriteLimitReached(Exception exc) {
        throwIfWriteLimitReached(exc, 0);
    }

    @Override // org.xml.sax.SAXException, java.lang.Throwable
    public String getMessage() {
        return AbstractC0008a.j(this.writeLimit, "Your document contained more than ", " characters, and so your requested limit has been reached. To receive the full text of the document, increase your limit. (Text up to the limit is however available).");
    }

    private static boolean isWriteLimitReached(Throwable th, int i) {
        if (th == null || i > 100) {
            return false;
        }
        if (th instanceof WriteLimitReachedException) {
            return true;
        }
        return isWriteLimitReached(th.getCause(), i + 1);
    }

    private static void throwIfWriteLimitReached(Throwable th, int i) {
        if (th != null && i <= 100) {
            if (!(th instanceof WriteLimitReachedException)) {
                throwIfWriteLimitReached(th.getCause(), i + 1);
                return;
            }
            throw ((SAXException) th);
        }
    }
}
