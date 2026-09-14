package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class e implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6405a = new Object();

    /* JADX WARN: Type inference failed for: r0v0, types: [t1.e, java.lang.Object] */
    static {
        FieldDescriptor.of("clientMetrics");
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        if (obj == null) {
            throw null;
        }
        throw new ClassCastException();
    }
}
