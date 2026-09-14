package org.apache.tika.embedder;

import F0.RunnableC0064o;
import a3.c;
import b3.d;
import e0.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.external.ExternalParser;

/* loaded from: classes.dex */
public class ExternalEmbedder implements Embedder {
    public static final String METADATA_COMMAND_ARGUMENTS_SERIALIZED_TOKEN = "${METADATA_SERIALIZED}";
    public static final String METADATA_COMMAND_ARGUMENTS_TOKEN = "${METADATA}";
    private static final long serialVersionUID = -2828829275642475697L;
    private final TemporaryResources tmp = new TemporaryResources();
    private Set<MediaType> supportedEmbedTypes = Collections.EMPTY_SET;
    private Map<Property, String[]> metadataCommandArguments = null;
    private String[] command = {"sed", "-e", "$a\\\n${METADATA_SERIALIZED}", ExternalParser.INPUT_FILE_TOKEN};
    private String commandAssignmentOperator = "=";
    private String commandAssignmentDelimeter = ", ";
    private String commandAppendOperator = "=";
    private boolean quoteAssignmentValues = false;

    public static boolean check(String str, int... iArr) {
        return check(new String[]{str}, iArr);
    }

    public static /* synthetic */ void lambda$multiThreadedStreamCopy$0(InputStream inputStream, OutputStream outputStream) {
        try {
            c.b(inputStream, outputStream);
        } catch (IOException e4) {
            System.out.println("ERROR: " + e4.getMessage());
        }
    }

    private void multiThreadedStreamCopy(InputStream inputStream, OutputStream outputStream) {
        new Thread(new RunnableC0064o(11, inputStream, outputStream)).start();
    }

    private void sendInputStreamToStdIn(InputStream inputStream, Process process) {
        multiThreadedStreamCopy(inputStream, process.getOutputStream());
    }

    private void sendStdErrToOutputStream(Process process, OutputStream outputStream) {
        multiThreadedStreamCopy(process.getErrorStream(), outputStream);
    }

    private void sendStdOutToOutputStream(Process process, OutputStream outputStream) {
        try {
            c.b(process.getInputStream(), outputStream);
        } catch (IOException e4) {
            System.out.println("ERROR: " + e4.getMessage());
        }
    }

    public static String serializeMetadata(List<String> list) {
        if (list != null) {
            return Arrays.toString(list.toArray());
        }
        return "";
    }

    @Override // org.apache.tika.embedder.Embedder
    public void embed(Metadata metadata, InputStream inputStream, OutputStream outputStream, ParseContext parseContext) {
        boolean z3;
        List<String> list;
        Process exec;
        TikaInputStream tikaInputStream;
        Map<Property, String[]> map = this.metadataCommandArguments;
        if (map != null && !map.isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        TikaInputStream tikaInputStream2 = TikaInputStream.get(inputStream);
        File file = null;
        if (z3) {
            list = getCommandMetadataSegments(metadata);
        } else {
            list = null;
        }
        String[] strArr = this.command;
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = true;
        while (i < length) {
            String str = strArr[i];
            boolean z8 = z3;
            if (str.contains(ExternalParser.INPUT_FILE_TOKEN)) {
                tikaInputStream = tikaInputStream2;
                str = str.replace(ExternalParser.INPUT_FILE_TOKEN, tikaInputStream2.getFile().toString());
                z6 = false;
            } else {
                tikaInputStream = tikaInputStream2;
            }
            if (str.contains(ExternalParser.OUTPUT_FILE_TOKEN)) {
                File createTemporaryFile = this.tmp.createTemporaryFile();
                str = str.replace(ExternalParser.OUTPUT_FILE_TOKEN, createTemporaryFile.toString());
                file = createTemporaryFile;
                z7 = false;
            }
            if (str.contains(METADATA_COMMAND_ARGUMENTS_SERIALIZED_TOKEN)) {
                z4 = true;
            }
            if (str.contains(METADATA_COMMAND_ARGUMENTS_TOKEN)) {
                if (z8) {
                    arrayList.addAll(list);
                }
                z5 = true;
            } else {
                arrayList.add(str);
            }
            i++;
            z3 = z8;
            tikaInputStream2 = tikaInputStream;
        }
        TikaInputStream tikaInputStream3 = tikaInputStream2;
        if (z3) {
            if (z4) {
                int size = arrayList.size();
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    String str2 = (String) obj;
                    if (str2.contains(METADATA_COMMAND_ARGUMENTS_SERIALIZED_TOKEN)) {
                        arrayList.set(i3, str2.replace(METADATA_COMMAND_ARGUMENTS_SERIALIZED_TOKEN, serializeMetadata(list)));
                    }
                    i3++;
                }
            } else if (!z5 && !z4) {
                arrayList.addAll(list);
            }
        }
        if (arrayList.toArray().length == 1) {
            exec = Runtime.getRuntime().exec(((String[]) arrayList.toArray(new String[0]))[0]);
        } else {
            exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[0]));
        }
        Process process = exec;
        int i5 = f3.c.f4619f;
        new d();
        f3.c cVar = new f3.c();
        try {
            sendStdErrToOutputStream(process, cVar);
            if (z6) {
                sendInputStreamToStdIn(inputStream, process);
            } else {
                process.getOutputStream().close();
            }
            if (z7) {
                sendStdOutToOutputStream(process, outputStream);
            } else {
                this.tmp.dispose();
                try {
                    process.waitFor();
                } catch (InterruptedException unused) {
                }
                c.b(TikaInputStream.get(file), outputStream);
            }
            if (z7) {
                try {
                    process.waitFor();
                } catch (InterruptedException | Exception unused2) {
                }
            } else {
                file.delete();
            }
            if (!z6) {
                c.a(tikaInputStream3);
            }
            c.a(outputStream);
            c.a(cVar);
            if (process.exitValue() == 0) {
                return;
            }
            throw new TikaException("There was an error executing the command line\nExecutable Command:\n\n" + arrayList + "\nExecutable Error:\n\n" + new String(cVar.b(), StandardCharsets.UTF_8.name()));
        } catch (Throwable th) {
            if (z7) {
                try {
                    process.waitFor();
                } catch (InterruptedException | Exception unused3) {
                }
            } else {
                file.delete();
            }
            if (!z6) {
                c.a(tikaInputStream3);
            }
            c.a(outputStream);
            c.a(cVar);
            if (process.exitValue() != 0) {
                throw new TikaException("There was an error executing the command line\nExecutable Command:\n\n" + arrayList + "\nExecutable Error:\n\n" + new String(cVar.b(), StandardCharsets.UTF_8.name()));
            }
            throw th;
        }
    }

    public String[] getCommand() {
        return this.command;
    }

    public String getCommandAppendOperator() {
        return this.commandAppendOperator;
    }

    public String getCommandAssignmentDelimeter() {
        return this.commandAssignmentDelimeter;
    }

    public String getCommandAssignmentOperator() {
        return this.commandAssignmentOperator;
    }

    public List<String> getCommandMetadataSegments(Metadata metadata) {
        String[] strArr;
        String[] strArr2;
        int i;
        ArrayList arrayList = new ArrayList();
        if (metadata != null && metadata.names() != null) {
            String[] names = metadata.names();
            int length = names.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = names[i3];
                for (Property property : getMetadataCommandArguments().keySet()) {
                    if (str.equals(property.getName()) && (strArr = getMetadataCommandArguments().get(property)) != null) {
                        int length2 = strArr.length;
                        int i4 = 0;
                        while (i4 < length2) {
                            String str2 = strArr[i4];
                            if (metadata.isMultiValued(str)) {
                                String[] values = metadata.getValues(str);
                                int length3 = values.length;
                                int i5 = 0;
                                while (true) {
                                    strArr2 = names;
                                    if (i5 >= length3) {
                                        break;
                                    }
                                    String str3 = values[i5];
                                    int i6 = length;
                                    if (this.quoteAssignmentValues) {
                                        str3 = a.e("'", str3, "'");
                                    }
                                    arrayList.add(str2 + this.commandAppendOperator + str3);
                                    i5++;
                                    names = strArr2;
                                    length = i6;
                                }
                                i = length;
                            } else {
                                strArr2 = names;
                                i = length;
                                String str4 = metadata.get(str);
                                if (this.quoteAssignmentValues) {
                                    str4 = a.e("'", str4, "'");
                                }
                                arrayList.add(str2 + this.commandAssignmentOperator + str4);
                            }
                            i4++;
                            names = strArr2;
                            length = i;
                        }
                    }
                    names = names;
                    length = length;
                }
            }
        }
        return arrayList;
    }

    public Map<Property, String[]> getMetadataCommandArguments() {
        return this.metadataCommandArguments;
    }

    @Override // org.apache.tika.embedder.Embedder
    public Set<MediaType> getSupportedEmbedTypes(ParseContext parseContext) {
        return getSupportedEmbedTypes();
    }

    public boolean isQuoteAssignmentValues() {
        return this.quoteAssignmentValues;
    }

    public void setCommand(String... strArr) {
        this.command = strArr;
    }

    public void setCommandAppendOperator(String str) {
        this.commandAppendOperator = str;
    }

    public void setCommandAssignmentDelimeter(String str) {
        this.commandAssignmentDelimeter = str;
    }

    public void setCommandAssignmentOperator(String str) {
        this.commandAssignmentOperator = str;
    }

    public void setMetadataCommandArguments(Map<Property, String[]> map) {
        this.metadataCommandArguments = map;
    }

    public void setQuoteAssignmentValues(boolean z3) {
        this.quoteAssignmentValues = z3;
    }

    public void setSupportedEmbedTypes(Set<MediaType> set) {
        this.supportedEmbedTypes = Collections.unmodifiableSet(new HashSet(set));
    }

    public static boolean check(String[] strArr, int... iArr) {
        Process exec;
        if (iArr.length == 0) {
            iArr = new int[]{127};
        }
        try {
            if (strArr.length == 1) {
                exec = Runtime.getRuntime().exec(strArr[0]);
            } else {
                exec = Runtime.getRuntime().exec(strArr);
            }
            int waitFor = exec.waitFor();
            for (int i : iArr) {
                if (waitFor == i) {
                    return false;
                }
            }
            return true;
        } catch (IOException | InterruptedException unused) {
            return false;
        }
    }

    public Set<MediaType> getSupportedEmbedTypes() {
        return this.supportedEmbedTypes;
    }
}
