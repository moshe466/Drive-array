package com.google.protobuf;

/* loaded from: classes2.dex */
final class ExtensionRegistryFactory {
    static final Class<?> a = a();

    ExtensionRegistryFactory() {
    }

    static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = a;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    public static ExtensionRegistryLite create() {
        if (a != null) {
            try {
                return invokeSubclassFactory("newInstance");
            } catch (Exception unused) {
            }
        }
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        if (a != null) {
            try {
                return invokeSubclassFactory("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return ExtensionRegistryLite.a;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String str) {
        return (ExtensionRegistryLite) a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
