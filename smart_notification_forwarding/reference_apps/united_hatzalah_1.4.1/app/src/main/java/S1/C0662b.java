package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* renamed from: s1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0662b implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0662b f6245a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6246b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6247c = FieldDescriptor.of("model");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f6248d = FieldDescriptor.of("hardware");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f6249e = FieldDescriptor.of("device");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f6250f = FieldDescriptor.of("product");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f6251g = FieldDescriptor.of("osBuild");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f6252h = FieldDescriptor.of("manufacturer");
    public static final FieldDescriptor i = FieldDescriptor.of("fingerprint");

    /* renamed from: j, reason: collision with root package name */
    public static final FieldDescriptor f6253j = FieldDescriptor.of("locale");

    /* renamed from: k, reason: collision with root package name */
    public static final FieldDescriptor f6254k = FieldDescriptor.of("country");

    /* renamed from: l, reason: collision with root package name */
    public static final FieldDescriptor f6255l = FieldDescriptor.of("mccMnc");

    /* renamed from: m, reason: collision with root package name */
    public static final FieldDescriptor f6256m = FieldDescriptor.of("applicationBuild");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        C0673m c0673m = (C0673m) ((AbstractC0661a) obj);
        objectEncoderContext2.add(f6246b, c0673m.f6293a);
        objectEncoderContext2.add(f6247c, c0673m.f6294b);
        objectEncoderContext2.add(f6248d, c0673m.f6295c);
        objectEncoderContext2.add(f6249e, c0673m.f6296d);
        objectEncoderContext2.add(f6250f, c0673m.f6297e);
        objectEncoderContext2.add(f6251g, c0673m.f6298f);
        objectEncoderContext2.add(f6252h, c0673m.f6299g);
        objectEncoderContext2.add(i, c0673m.f6300h);
        objectEncoderContext2.add(f6253j, c0673m.i);
        objectEncoderContext2.add(f6254k, c0673m.f6301j);
        objectEncoderContext2.add(f6255l, c0673m.f6302k);
        objectEncoderContext2.add(f6256m, c0673m.f6303l);
    }
}
