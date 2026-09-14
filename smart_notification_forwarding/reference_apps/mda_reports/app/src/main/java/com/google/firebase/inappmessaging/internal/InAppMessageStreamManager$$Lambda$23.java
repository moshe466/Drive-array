package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;
import java.util.Locale;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$23 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$23 instance = new InAppMessageStreamManager$$Lambda$23();

    private InAppMessageStreamManager$$Lambda$23() {
    }

    public static Consumer lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(((FetchEligibleCampaignsResponse) obj).getMessagesList().size())));
    }
}
