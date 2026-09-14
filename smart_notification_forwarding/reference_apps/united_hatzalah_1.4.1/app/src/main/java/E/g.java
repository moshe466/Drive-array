package e;

import f.AbstractC0365a;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4425a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f4426b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4427c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0365a f4428d;

    public /* synthetic */ g(h hVar, String str, AbstractC0365a abstractC0365a, int i) {
        this.f4425a = i;
        this.f4426b = hVar;
        this.f4427c = str;
        this.f4428d = abstractC0365a;
    }

    @Override // e.c
    public final void a(Object obj) {
        switch (this.f4425a) {
            case 0:
                h hVar = this.f4426b;
                ArrayList arrayList = hVar.f4432d;
                LinkedHashMap linkedHashMap = hVar.f4430b;
                String str = this.f4427c;
                Object obj2 = linkedHashMap.get(str);
                AbstractC0365a abstractC0365a = this.f4428d;
                if (obj2 != null) {
                    int intValue = ((Number) obj2).intValue();
                    arrayList.add(str);
                    try {
                        hVar.b(intValue, abstractC0365a, obj);
                        return;
                    } catch (Exception e4) {
                        arrayList.remove(str);
                        throw e4;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0365a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            default:
                h hVar2 = this.f4426b;
                ArrayList arrayList2 = hVar2.f4432d;
                LinkedHashMap linkedHashMap2 = hVar2.f4430b;
                String str2 = this.f4427c;
                Object obj3 = linkedHashMap2.get(str2);
                AbstractC0365a abstractC0365a2 = this.f4428d;
                if (obj3 != null) {
                    int intValue2 = ((Number) obj3).intValue();
                    arrayList2.add(str2);
                    try {
                        hVar2.b(intValue2, abstractC0365a2, obj);
                        return;
                    } catch (Exception e5) {
                        arrayList2.remove(str2);
                        throw e5;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0365a2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
    }

    public void b() {
        this.f4426b.f(this.f4427c);
    }
}
