package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0671k implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0671k f6289a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6290b = FieldDescriptor.of("networkType");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6291c = FieldDescriptor.of("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        w wVar = (w) ((AbstractC0659J) obj);
        objectEncoderContext2.add(f6290b, wVar.f6326a);
        objectEncoderContext2.add(f6291c, wVar.f6327b);
    }
}
