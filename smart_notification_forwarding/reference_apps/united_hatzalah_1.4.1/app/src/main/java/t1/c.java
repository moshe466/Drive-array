package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import io.flutter.plugins.firebase.crashlytics.Constants;
import w1.C0756d;

/* loaded from: classes.dex */
public final class c implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6399a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6400b = e0.a.a(1, FieldDescriptor.builder("eventsDroppedCount"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6401c = e0.a.a(3, FieldDescriptor.builder(Constants.REASON));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0756d c0756d = (C0756d) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6400b, c0756d.f6719a);
        objectEncoderContext2.add(f6401c, c0756d.f6720b);
    }
}
