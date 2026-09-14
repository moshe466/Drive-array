package org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes.dex */
public class TaggedIOException extends IOExceptionWithCause {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5958b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f5959a;

    public TaggedIOException(IOException iOException, Serializable serializable) {
        super(iOException.getMessage(), iOException);
        this.f5959a = serializable;
    }

    @Override // java.lang.Throwable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final synchronized IOException getCause() {
        return (IOException) super.getCause();
    }
}
