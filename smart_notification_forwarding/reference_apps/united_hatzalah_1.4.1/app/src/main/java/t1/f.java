package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import w1.C0758f;

/* loaded from: classes.dex */
public final class f implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6406a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6407b = e0.a.a(1, FieldDescriptor.builder("currentCacheSizeBytes"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6408c = e0.a.a(2, FieldDescriptor.builder("maxCacheSizeBytes"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0758f c0758f = (C0758f) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6407b, c0758f.f6724a);
        objectEncoderContext2.add(f6408c, c0758f.f6725b);
    }
}
