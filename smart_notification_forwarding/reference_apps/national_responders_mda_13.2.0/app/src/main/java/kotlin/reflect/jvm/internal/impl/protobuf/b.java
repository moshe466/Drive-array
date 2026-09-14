package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes.dex */
public abstract class b<MessageType extends q> implements s<MessageType> {
    static {
        g.c();
    }

    private MessageType e(MessageType messagetype) {
        if (messagetype == null || messagetype.k()) {
            return messagetype;
        }
        throw f(messagetype).a().i(messagetype);
    }

    private w f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).f() : new w(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, g gVar) {
        return e(j(inputStream, gVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType b(InputStream inputStream, g gVar) {
        return e(k(inputStream, gVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType d(d dVar, g gVar) {
        return e(l(dVar, gVar));
    }

    public MessageType j(InputStream inputStream, g gVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return k(new a.AbstractC0232a.C0233a(inputStream, e.B(read, inputStream)), gVar);
        } catch (IOException e10) {
            throw new k(e10.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, g gVar) {
        e g10 = e.g(inputStream);
        MessageType messagetype = (MessageType) c(g10, gVar);
        try {
            g10.a(0);
            return messagetype;
        } catch (k e10) {
            throw e10.i(messagetype);
        }
    }

    public MessageType l(d dVar, g gVar) {
        try {
            e z10 = dVar.z();
            MessageType messagetype = (MessageType) c(z10, gVar);
            try {
                z10.a(0);
                return messagetype;
            } catch (k e10) {
                throw e10.i(messagetype);
            }
        } catch (k e11) {
            throw e11;
        }
    }
}
