package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes.dex */
public final class p {
    @Deprecated
    public p() {
    }

    public static k b(f5.a aVar) {
        boolean O = aVar.O();
        aVar.r0(true);
        try {
            try {
                return z4.l.a(aVar);
            } catch (OutOfMemoryError e10) {
                throw new o("Failed parsing JSON source: " + aVar + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new o("Failed parsing JSON source: " + aVar + " to Json", e11);
            }
        } finally {
            aVar.r0(O);
        }
    }

    public static k c(Reader reader) {
        try {
            f5.a aVar = new f5.a(reader);
            k b10 = b(aVar);
            if (!b10.u() && aVar.m0() != f5.b.END_DOCUMENT) {
                throw new t("Did not consume the entire document.");
            }
            return b10;
        } catch (f5.d e10) {
            throw new t(e10);
        } catch (IOException e11) {
            throw new l(e11);
        } catch (NumberFormatException e12) {
            throw new t(e12);
        }
    }

    public static k d(String str) {
        return c(new StringReader(str));
    }

    @Deprecated
    public k a(String str) {
        return d(str);
    }
}
