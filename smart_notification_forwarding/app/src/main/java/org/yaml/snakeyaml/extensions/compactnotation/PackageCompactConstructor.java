package org.yaml.snakeyaml.extensions.compactnotation;

/* loaded from: classes2.dex */
public class PackageCompactConstructor extends CompactConstructor {
    private String packageName;

    public PackageCompactConstructor(String str) {
        this.packageName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.constructor.Constructor
    public Class<?> getClassForName(String str) throws ClassNotFoundException {
        if (str.indexOf(46) < 0) {
            try {
                return Class.forName(this.packageName + "." + str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.getClassForName(str);
    }
}
