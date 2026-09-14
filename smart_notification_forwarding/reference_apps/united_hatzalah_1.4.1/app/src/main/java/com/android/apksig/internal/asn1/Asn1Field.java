package com.android.apksig.internal.asn1;

import S0.h;
import S0.i;
import S0.j;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Asn1Field {
    h cls() default h.f2093c;

    j elementType() default j.f2099a;

    int index() default 0;

    boolean optional() default false;

    int tagNumber() default -1;

    i tagging() default i.f2095a;

    j type();
}
