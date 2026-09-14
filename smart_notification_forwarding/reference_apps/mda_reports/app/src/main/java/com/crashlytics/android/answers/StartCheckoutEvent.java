package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;

/* loaded from: classes.dex */
public class StartCheckoutEvent extends PredefinedEvent<StartCheckoutEvent> {
    static final BigDecimal d = BigDecimal.valueOf(1000000L);

    long a(BigDecimal bigDecimal) {
        return d.multiply(bigDecimal).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "startCheckout";
    }

    public StartCheckoutEvent putCurrency(Currency currency) {
        if (!this.a.isNull(currency, FirebaseAnalytics.Param.CURRENCY)) {
            this.c.a(FirebaseAnalytics.Param.CURRENCY, currency.getCurrencyCode());
        }
        return this;
    }

    public StartCheckoutEvent putItemCount(int i) {
        this.c.a("itemCount", (Number) Integer.valueOf(i));
        return this;
    }

    public StartCheckoutEvent putTotalPrice(BigDecimal bigDecimal) {
        if (!this.a.isNull(bigDecimal, "totalPrice")) {
            this.c.a("totalPrice", (Number) Long.valueOf(a(bigDecimal)));
        }
        return this;
    }
}
