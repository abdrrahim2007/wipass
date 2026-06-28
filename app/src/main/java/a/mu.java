package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class mu extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient na f190a;

    public mu(String str, Throwable th, na naVar) {
        super(str);
        this.f190a = naVar;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof mu)) {
            return false;
        }
        mu muVar = (mu) obj;
        return mk.a(muVar.getMessage(), getMessage()) && mk.a(muVar.f190a, this.f190a) && mk.a(muVar.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        mk.c(message);
        int iHashCode = (this.f190a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f190a;
    }
}
