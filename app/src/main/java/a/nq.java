package a;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class nq implements ln {
    public final Map b;
    public volatile Map c;

    public nq(Map map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @Override // a.ln
    public final Map a() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = ((np) list.get(i)).f196a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof nq) {
            return this.b.equals(((nq) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.b + '}';
    }
}
