package a5;

import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;

/* loaded from: classes.dex */
public final class e implements y {

    /* renamed from: f, reason: collision with root package name */
    private final z4.c f203f;

    public e(z4.c cVar) {
        this.f203f = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
        y4.b bVar = (y4.b) aVar.c().getAnnotation(y4.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) b(this.f203f, eVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x<?> b(z4.c cVar, com.google.gson.e eVar, e5.a<?> aVar, y4.b bVar) {
        x<?> lVar;
        Object a10 = cVar.a(e5.a.a(bVar.value())).a();
        if (a10 instanceof x) {
            lVar = (x) a10;
        } else if (a10 instanceof y) {
            lVar = ((y) a10).a(eVar, aVar);
        } else {
            boolean z10 = a10 instanceof s;
            if (!z10 && !(a10 instanceof com.google.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a10.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z10 ? (s) a10 : null, a10 instanceof com.google.gson.j ? (com.google.gson.j) a10 : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }
}
