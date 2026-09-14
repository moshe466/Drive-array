package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0665e implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0665e f6262a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6263b = FieldDescriptor.of("privacyContext");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6264c = FieldDescriptor.of("productIdOrigin");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6263b, ((p) ((AbstractC0651B) obj)).f6306a);
        objectEncoderContext2.add(f6264c, EnumC0650A.f6237a);
    }
}
