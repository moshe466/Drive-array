package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;

/* loaded from: classes.dex */
public class PurchaseEvent extends PredefinedEvent<PurchaseEvent> {
    static final BigDecimal d = BigDecimal.valueOf(1000000L);

    long a(BigDecimal bigDecimal) {
        return d.multiply(bigDecimal).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "purchase";
    }

    public PurchaseEvent putCurrency(Currency currency) {
        if (!this.a.isNull(currency, FirebaseAnalytics.Param.CURRENCY)) {
            this.c.a(FirebaseAnalytics.Param.CURRENCY, currency.getCurrencyCode());
        }
        return this;
    }

    public PurchaseEvent putItemId(String str) {
        this.c.a("itemId", str);
        return this;
    }

    public PurchaseEvent putItemName(String str) {
        this.c.a("itemName", str);
        return this;
    }

    public PurchaseEvent putItemPrice(BigDecimal bigDecimal) {
        if (!this.a.isNull(bigDecimal, "itemPrice")) {
            this.c.a("itemPrice", (Number) Long.valueOf(a(bigDecimal)));
        }
        return this;
    }

    public PurchaseEvent putItemType(String str) {
        this.c.a("itemType", str);
        return this;
    }

    public PurchaseEvent putSuccess(boolean z) {
        this.c.a(FirebaseAnalytics.Param.SUCCESS, Boolean.toString(z));
        return this;
    }
}
