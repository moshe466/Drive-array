package com.groboot.mdaemergency.alwaysOn;

import com.groboot.mdaemergency.models.FirstResponderPayload;
import java.lang.reflect.Constructor;
import java.util.Objects;
import m8.g;
import v6.o;
import y8.k;

/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public static final class a {
        public static b a(c cVar, e eVar) {
            k.e(cVar, "this");
            k.e(eVar, "viewType");
            Constructor<?>[] declaredConstructors = w8.a.b(eVar.getViewTypeClass()).getDeclaredConstructors();
            k.d(declaredConstructors, "viewType.getViewTypeClas…java.declaredConstructors");
            Object newInstance = ((Constructor) g.p(declaredConstructors)).newInstance(cVar, cVar.B());
            Objects.requireNonNull(newInstance, "null cannot be cast to non-null type com.groboot.mdaemergency.alwaysOn.AlwaysOnBaseView");
            return (b) newInstance;
        }

        public static b b(c cVar, e eVar) {
            k.e(cVar, "this");
            k.e(eVar, "viewType");
            com.groboot.mdaemergency.ui.views.b bVar = (com.groboot.mdaemergency.ui.views.b) cVar.t(eVar);
            if (eVar.getObjectAny() instanceof String) {
                Object objectAny = eVar.getObjectAny();
                Objects.requireNonNull(objectAny, "null cannot be cast to non-null type kotlin.String");
                bVar.f((String) objectAny);
            }
            return bVar;
        }

        public static b c(c cVar, e eVar) {
            k.e(cVar, "this");
            k.e(eVar, "viewType");
            o oVar = (o) cVar.t(eVar);
            if (eVar.getObjectAny() instanceof FirstResponderPayload) {
                Object objectAny = eVar.getObjectAny();
                Objects.requireNonNull(objectAny, "null cannot be cast to non-null type com.groboot.mdaemergency.models.FirstResponderPayload");
                oVar.setFirstResponderCall((FirstResponderPayload) objectAny);
            }
            return oVar;
        }
    }

    d B();

    b t(e eVar);
}
