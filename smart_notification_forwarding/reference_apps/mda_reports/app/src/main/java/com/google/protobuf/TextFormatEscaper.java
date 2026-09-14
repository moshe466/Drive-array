package com.google.protobuf;

/* loaded from: classes2.dex */
final class TextFormatEscaper {

    /* renamed from: com.google.protobuf.TextFormatEscaper$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    final class AnonymousClass2 implements ByteSequence {
        final /* synthetic */ byte[] a;

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public byte byteAt(int i) {
            return this.a[i];
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public int size() {
            return this.a.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ByteSequence {
        byte byteAt(int i);

        int size();
    }

    private TextFormatEscaper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(final ByteString byteString) {
        return a(new ByteSequence() { // from class: com.google.protobuf.TextFormatEscaper.1
            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i) {
                return ByteString.this.byteAt(i);
            }

            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return ByteString.this.size();
            }
        });
    }

    static String a(ByteSequence byteSequence) {
        String str;
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i = 0; i < byteSequence.size(); i++) {
            int byteAt = byteSequence.byteAt(i);
            if (byteAt == 34) {
                str = "\\\"";
            } else if (byteAt == 39) {
                str = "\\'";
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (byteAt < 32 || byteAt > 126) {
                            sb.append('\\');
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            byteAt = (byteAt & 7) + 48;
                        }
                        sb.append((char) byteAt);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
