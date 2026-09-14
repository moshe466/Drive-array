package H0;

import java.net.URL;
import java.util.function.Consumer;
import org.apache.tika.mime.MimeTypesFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f853a;

    public /* synthetic */ g(int i) {
        this.f853a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f853a) {
            case 0:
                Integer num = (Integer) obj;
                if (num != null && num.intValue() == 1) {
                    h hVar = h.f854a;
                    h.a(i.f872o);
                    return;
                }
                return;
            case 1:
                MimeTypesFactory.a((URL) obj);
                return;
            case 2:
                ((Process) obj).destroyForcibly();
                return;
            default:
                ((Process) obj).destroyForcibly();
                return;
        }
    }
}
