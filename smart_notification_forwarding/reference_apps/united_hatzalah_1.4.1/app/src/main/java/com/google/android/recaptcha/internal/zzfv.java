package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import android.webkit.WebView;
import java.util.ArrayList;
import s2.C0684i;
import t2.AbstractC0707i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfv extends AbstractC0793i implements p {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzfw zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfv(String[] strArr, zzfw zzfwVar, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zza = strArr;
        this.zzb = zzfwVar;
        this.zzc = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzfv(this.zza, this.zzb, this.zzc, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfv) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        WebView webView;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("\"" + str + "\"");
        }
        zzfw zzfwVar = this.zzb;
        String str2 = this.zzc;
        webView = zzfwVar.zza;
        webView.evaluateJavascript(str2 + "(" + AbstractC0707i.h0(arrayList, ",", null, null, null, 62) + ")", null);
        return C0684i.f6340a;
    }
}
