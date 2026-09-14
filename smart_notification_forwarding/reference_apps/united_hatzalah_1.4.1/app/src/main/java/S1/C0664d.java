package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0664d implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0664d f6259a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6260b = FieldDescriptor.of("clientType");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6261c = FieldDescriptor.of("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        C0675o c0675o = (C0675o) ((z) obj);
        c0675o.getClass();
        objectEncoderContext2.add(f6260b, y.f6328a);
        objectEncoderContext2.add(f6261c, c0675o.f6305a);
    }
}
