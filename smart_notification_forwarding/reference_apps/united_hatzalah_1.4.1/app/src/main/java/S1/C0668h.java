package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0668h implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0668h f6270a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6271b = FieldDescriptor.of("prequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f6271b, ((s) ((AbstractC0654E) obj)).f6310a);
    }
}
