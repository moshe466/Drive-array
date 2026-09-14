package t1;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import w1.C0753a;
import w1.C0754b;
import w1.C0756d;
import w1.C0757e;
import w1.C0758f;
import w1.C0759g;

/* loaded from: classes.dex */
public final class h implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final h f6412a = new Object();

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(q.class, e.f6405a);
        encoderConfig.registerEncoder(C0753a.class, C0698a.f6392a);
        encoderConfig.registerEncoder(C0759g.class, g.f6409a);
        encoderConfig.registerEncoder(C0757e.class, d.f6402a);
        encoderConfig.registerEncoder(C0756d.class, c.f6399a);
        encoderConfig.registerEncoder(C0754b.class, b.f6397a);
        encoderConfig.registerEncoder(C0758f.class, f.f6406a);
    }
}
