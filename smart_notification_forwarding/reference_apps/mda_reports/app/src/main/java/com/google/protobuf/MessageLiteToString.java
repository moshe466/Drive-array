package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";

    MessageLiteToString() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        String obj2;
        String a;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            a = TextFormatEscaper.a((String) obj);
        } else {
            if (!(obj instanceof ByteString)) {
                if (obj instanceof GeneratedMessageLite) {
                    sb.append(" {");
                    reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i + 2);
                    sb.append("\n");
                    for (int i3 = 0; i3 < i; i3++) {
                        sb.append(' ');
                    }
                    obj2 = "}";
                } else {
                    sb.append(": ");
                    obj2 = obj.toString();
                }
                sb.append(obj2);
                return;
            }
            sb.append(": \"");
            a = TextFormatEscaper.a((ByteString) obj);
        }
        sb.append(a);
        sb.append(Typography.quote);
    }

    private static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean isDefaultValue(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            obj2 = "";
        } else {
            if (!(obj instanceof ByteString)) {
                return obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
            }
            obj2 = ByteString.EMPTY;
        }
        return obj.equals(obj2);
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (java.lang.reflect.Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String replaceFirst = ((String) it.next()).replaceFirst("get", "");
            if (replaceFirst.endsWith(LIST_SUFFIX) && !replaceFirst.endsWith(BUILDER_LIST_SUFFIX)) {
                String str = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) hashMap.get("get" + replaceFirst);
                if (method2 != null) {
                    a(sb, i, camelCaseToSnakeCase(str), GeneratedMessageLite.a(method2, messageLite, new Object[0]));
                }
            }
            if (((java.lang.reflect.Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith(BYTES_SUFFIX)) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                java.lang.reflect.Method method3 = (java.lang.reflect.Method) hashMap.get("get" + replaceFirst);
                java.lang.reflect.Method method4 = (java.lang.reflect.Method) hashMap.get("has" + replaceFirst);
                if (method3 != null) {
                    Object a = GeneratedMessageLite.a(method3, messageLite, new Object[0]);
                    if (method4 == null ? !isDefaultValue(a) : ((Boolean) GeneratedMessageLite.a(method4, messageLite, new Object[0])).booleanValue()) {
                        a(sb, i, camelCaseToSnakeCase(str2), a);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it2 = ((GeneratedMessageLite.ExtendableMessage) messageLite).d.iterator();
            while (it2.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next = it2.next();
                a(sb, i, "[" + next.getKey().getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).b;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.a(sb, i);
        }
    }
}
