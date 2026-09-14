package org.apache.tika.fork;

import java.io.Serializable;
import java.util.Map;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.ParserFactory;

/* loaded from: classes.dex */
public class ParserFactoryFactory implements Serializable {
    private static final long serialVersionUID = 4710974869988895410L;
    private final Map<String, String> args;
    private final String className;

    public ParserFactoryFactory(String str, Map<String, String> map) {
        this.className = str;
        this.args = map;
    }

    public ParserFactory build() {
        try {
            return (ParserFactory) Class.forName(this.className).getConstructor(Map.class).newInstance(this.args);
        } catch (IllegalStateException | ReflectiveOperationException e4) {
            throw new TikaException("Couldn't create factory", e4);
        }
    }
}
