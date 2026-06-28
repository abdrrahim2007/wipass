package a;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class sn implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((sf) message.obj).recycle();
        return true;
    }
}
