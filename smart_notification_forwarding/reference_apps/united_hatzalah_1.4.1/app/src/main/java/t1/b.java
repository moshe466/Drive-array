package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import w1.C0754b;

/* loaded from: classes.dex */
public final class b implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6397a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6398b = e0.a.a(1, FieldDescriptor.builder("storageMetrics"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f6398b, ((C0754b) obj).f6709a);
    }
}
