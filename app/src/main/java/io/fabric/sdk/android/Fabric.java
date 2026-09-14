package io.fabric.sdk.android;

import android.content.Context;

public class Fabric {
    public static Fabric with(Context context, Object... kits) {
        return new Fabric();
    }
}
