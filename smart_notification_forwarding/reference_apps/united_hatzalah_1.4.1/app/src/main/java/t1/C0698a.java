package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import w1.C0753a;

/* renamed from: t1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0698a implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0698a f6392a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6393b = e0.a.a(1, FieldDescriptor.builder("window"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6394c = e0.a.a(2, FieldDescriptor.builder("logSourceMetrics"));

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f6395d = e0.a.a(3, FieldDescriptor.builder("globalMetrics"));

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f6396e = e0.a.a(4, FieldDescriptor.builder("appNamespace"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0753a c0753a = (C0753a) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6393b, c0753a.f6705a);
        objectEncoderContext2.add(f6394c, c0753a.f6706b);
        objectEncoderContext2.add(f6395d, c0753a.f6707c);
        objectEncoderContext2.add(f6396e, c0753a.f6708d);
    }
}
