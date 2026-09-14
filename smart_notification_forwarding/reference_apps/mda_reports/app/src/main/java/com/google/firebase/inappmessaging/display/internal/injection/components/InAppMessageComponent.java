package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import dagger.Component;

@Component(modules = {InflaterModule.class})
@InAppMessageScope
/* loaded from: classes2.dex */
public interface InAppMessageComponent {
    @InAppMessageScope
    BannerBindingWrapper bannerBindingWrapper();

    @InAppMessageScope
    CardBindingWrapper cardBindingWrapper();

    @InAppMessageScope
    ImageBindingWrapper imageBindingWrapper();

    @InAppMessageScope
    ModalBindingWrapper modalBindingWrapper();
}
