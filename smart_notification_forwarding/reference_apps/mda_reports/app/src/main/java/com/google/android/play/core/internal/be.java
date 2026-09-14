package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class be extends g implements bc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public be(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.internal.bc
    public final void a(String str, int i, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(4, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void a(String str, int i, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        i.a(a, bdVar);
        a(5, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void a(String str, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        i.a(a, bdVar);
        a(6, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void a(String str, List<Bundle> list, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(2, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void b(String str, List<Bundle> list, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(7, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void c(String str, List<Bundle> list, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(8, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void d(String str, List<Bundle> list, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(13, a);
    }

    @Override // com.google.android.play.core.internal.bc
    public final void e(String str, List<Bundle> list, Bundle bundle, bd bdVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, bundle);
        i.a(a, bdVar);
        a(14, a);
    }
}
