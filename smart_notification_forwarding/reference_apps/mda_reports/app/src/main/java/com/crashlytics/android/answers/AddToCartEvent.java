package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;

/* loaded from: classes.dex */
public class AddToCartEvent extends PredefinedEvent<AddToCartEvent> {
    static final BigDecimal d = BigDecimal.valueOf(1000000L);

    long a(BigDecimal bigDecimal) {
        return d.multiply(bigDecimal).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "addToCart";
    }

    public AddToCartEvent putCurrency(Currency currency) {
        if (!this.a.isNull(currency, FirebaseAnalytics.Param.CURRENCY)) {
            this.c.a(FirebaseAnalytics.Param.CURRENCY, currency.getCurrencyCode());
        }
        return this;
    }

    public AddToCartEvent putItemId(String str) {
        this.c.a("itemId", str);
        return this;
    }

    public AddToCartEvent putItemName(String str) {
        this.c.a("itemName", str);
        return this;
    }

    public AddToCartEvent putItemPrice(BigDecimal bigDecimal) {
        if (!this.a.isNull(bigDecimal, "itemPrice")) {
            this.c.a("itemPrice", (Number) Long.valueOf(a(bigDecimal)));
        }
        return this;
    }

    public AddToCartEvent putItemType(String str) {
        this.c.a("itemType", str);
        return this;
    }
}
