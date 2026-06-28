package a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class lt extends Binder implements lu {
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;

    public static lu asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(lu.f173a);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof lu)) {
            return (lu) iInterfaceQueryLocalInterface;
        }
        ls lsVar = new ls();
        lsVar.b = iBinder;
        return lsVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str = lu.f173a;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i == 1) {
            notify(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) (parcel.readInt() != 0 ? Notification.CREATOR.createFromParcel(parcel) : null));
        } else if (i == 2) {
            cancel(parcel.readString(), parcel.readInt(), parcel.readString());
        } else {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            cancelAll(parcel.readString());
        }
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
