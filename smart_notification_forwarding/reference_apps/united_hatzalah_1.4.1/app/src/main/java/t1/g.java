package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import w1.C0759g;

/* loaded from: classes.dex */
public final class g implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final g f6409a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6410b = e0.a.a(1, FieldDescriptor.builder("startMs"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6411c = e0.a.a(2, FieldDescriptor.builder("endMs"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0759g c0759g = (C0759g) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6410b, c0759g.f6726a);
        objectEncoderContext2.add(f6411c, c0759g.f6727b);
    }
}
