package s1;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* renamed from: s1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0672l implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final C0672l f6292a = new Object();

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        C0663c c0663c = C0663c.f6257a;
        encoderConfig.registerEncoder(x.class, c0663c);
        encoderConfig.registerEncoder(C0674n.class, c0663c);
        C0670j c0670j = C0670j.f6281a;
        encoderConfig.registerEncoder(AbstractC0656G.class, c0670j);
        encoderConfig.registerEncoder(u.class, c0670j);
        C0664d c0664d = C0664d.f6259a;
        encoderConfig.registerEncoder(z.class, c0664d);
        encoderConfig.registerEncoder(C0675o.class, c0664d);
        C0662b c0662b = C0662b.f6245a;
        encoderConfig.registerEncoder(AbstractC0661a.class, c0662b);
        encoderConfig.registerEncoder(C0673m.class, c0662b);
        C0669i c0669i = C0669i.f6272a;
        encoderConfig.registerEncoder(AbstractC0655F.class, c0669i);
        encoderConfig.registerEncoder(t.class, c0669i);
        C0665e c0665e = C0665e.f6262a;
        encoderConfig.registerEncoder(AbstractC0651B.class, c0665e);
        encoderConfig.registerEncoder(p.class, c0665e);
        C0668h c0668h = C0668h.f6270a;
        encoderConfig.registerEncoder(AbstractC0654E.class, c0668h);
        encoderConfig.registerEncoder(s.class, c0668h);
        C0667g c0667g = C0667g.f6268a;
        encoderConfig.registerEncoder(AbstractC0653D.class, c0667g);
        encoderConfig.registerEncoder(r.class, c0667g);
        C0671k c0671k = C0671k.f6289a;
        encoderConfig.registerEncoder(AbstractC0659J.class, c0671k);
        encoderConfig.registerEncoder(w.class, c0671k);
        C0666f c0666f = C0666f.f6265a;
        encoderConfig.registerEncoder(AbstractC0652C.class, c0666f);
        encoderConfig.registerEncoder(q.class, c0666f);
    }
}
