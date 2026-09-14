package atlow.chemi.mymada;

import android.view.MenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes.dex */
final /* synthetic */ class InfoActivityKt$onResume$1 extends MutablePropertyReference0 {
    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return InfoActivityKt.access$getDetect$p((InfoActivityKt) this.a);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "detect";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(InfoActivityKt.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getDetect()Landroid/view/MenuItem;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((InfoActivityKt) this.a).detect = (MenuItem) obj;
    }
}
