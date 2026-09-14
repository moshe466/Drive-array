package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes.dex */
public class w extends RuntimeException {
    public w(q qVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public k a() {
        return new k(getMessage());
    }
}
