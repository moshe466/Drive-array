package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* loaded from: classes.dex */
public final class zaae extends RemoteCreator {
    private static final zaae zaa = new zaae();

    private zaae() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i, int i3) {
        zaae zaaeVar = zaa;
        try {
            zaac zaacVar = new zaac(1, i, i3, null);
            return (View) ObjectWrapper.unwrap(((zar) zaaeVar.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zaacVar));
        } catch (Exception e4) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 42 + String.valueOf(i3).length());
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e4);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zar) {
            return (zar) queryLocalInterface;
        }
        return new zar(iBinder);
    }
}
