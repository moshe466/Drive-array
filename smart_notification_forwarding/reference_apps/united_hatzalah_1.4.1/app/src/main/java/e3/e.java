package e3;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;

/* loaded from: classes.dex */
public abstract class e extends d {
    private final Serializable tag;

    public e(InputStream inputStream) {
        super(inputStream);
        this.tag = UUID.randomUUID();
    }

    @Override // e3.d
    public void handleIOException(IOException iOException) {
        throw new TaggedIOException(iOException, this.tag);
    }

    public boolean isCauseOf(Throwable th) {
        Serializable serializable = this.tag;
        int i = TaggedIOException.f5958b;
        if (serializable != null && (th instanceof TaggedIOException) && serializable.equals(((TaggedIOException) th).f5959a)) {
            return true;
        }
        return false;
    }

    public void throwIfCauseOf(Throwable th) {
        Serializable serializable = this.tag;
        int i = TaggedIOException.f5958b;
        if (serializable != null && (th instanceof TaggedIOException) && serializable.equals(((TaggedIOException) th).f5959a)) {
            throw ((TaggedIOException) th).getCause();
        }
    }
}
