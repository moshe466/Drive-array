package J0;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.j;
import t2.AbstractC0708j;

/* loaded from: classes.dex */
public final class f extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public final Object readValueOfType(byte b4, ByteBuffer buffer) {
        List list;
        List list2;
        j.e(buffer, "buffer");
        if (b4 == -127) {
            Object readValue = readValue(buffer);
            if (readValue instanceof List) {
                list2 = (List) readValue;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                Object obj = list2.get(0);
                j.c(obj, "null cannot be cast to non-null type kotlin.String");
                return new b((String) obj, (String) list2.get(1), (String) list2.get(2), (String) list2.get(3), (String) list2.get(4));
            }
        } else if (b4 == -126) {
            Object readValue2 = readValue(buffer);
            if (readValue2 instanceof List) {
                list = (List) readValue2;
            } else {
                list = null;
            }
            if (list != null) {
                Object obj2 = list.get(0);
                j.c(obj2, "null cannot be cast to non-null type com.aheaditec.freerasp.generated.PackageInfo");
                Object obj3 = list.get(1);
                j.c(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                return new c((b) obj2, (List) obj3, (List) list.get(2));
            }
        } else {
            return super.readValueOfType(b4, buffer);
        }
        return null;
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public final void writeValue(ByteArrayOutputStream stream, Object obj) {
        j.e(stream, "stream");
        if (obj instanceof b) {
            stream.write(129);
            b bVar = (b) obj;
            writeValue(stream, AbstractC0708j.W(bVar.f1040a, bVar.f1041b, bVar.f1042c, bVar.f1043d, bVar.f1044e));
        } else {
            if (obj instanceof c) {
                stream.write(130);
                c cVar = (c) obj;
                writeValue(stream, AbstractC0708j.W(cVar.f1045a, cVar.f1046b, cVar.f1047c));
                return;
            }
            super.writeValue(stream, obj);
        }
    }
}
