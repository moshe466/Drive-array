package b2;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0324a implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3803a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3804b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3805c;

    public /* synthetic */ C0324a(String str, int i, Object obj) {
        this.f3803a = i;
        this.f3804b = str;
        this.f3805c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f3803a) {
            case 0:
                return ComponentMonitor.a(this.f3804b, (Component) this.f3805c, componentContainer);
            default:
                return LibraryVersionComponent.a(this.f3804b, (LibraryVersionComponent.VersionExtractor) this.f3805c, componentContainer);
        }
    }
}
