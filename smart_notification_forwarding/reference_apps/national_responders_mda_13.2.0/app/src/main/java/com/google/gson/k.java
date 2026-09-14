package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class k {
    public int c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public h f() {
        if (t()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n g() {
        if (v()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public q j() {
        if (w()) {
            return (q) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String s() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean t() {
        return this instanceof h;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            f5.c cVar = new f5.c(stringWriter);
            cVar.i0(true);
            z4.l.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean u() {
        return this instanceof m;
    }

    public boolean v() {
        return this instanceof n;
    }

    public boolean w() {
        return this instanceof q;
    }
}
