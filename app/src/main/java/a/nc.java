package a;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface nc extends nb {
    Object call(Object... objArr);

    Object callBy(Map map);

    List getParameters();

    nj getReturnType();

    List getTypeParameters();

    nk getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();
}
