/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/igniva-android-21/AndroidStudioProjects/FileManager/FileManager-master/src/main/aidl/com/igniva/filemanager/RegisterCallback.aidl
 */
package com.igniva.filemanager;
public interface RegisterCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.igniva.filemanager.RegisterCallback
{
private static final java.lang.String DESCRIPTOR = "com.igniva.filemanager.RegisterCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.igniva.filemanager.RegisterCallback interface,
 * generating a proxy if needed.
 */
public static com.igniva.filemanager.RegisterCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.igniva.filemanager.RegisterCallback))) {
return ((com.igniva.filemanager.RegisterCallback)iin);
}
return new com.igniva.filemanager.RegisterCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerCallBack:
{
data.enforceInterface(DESCRIPTOR);
com.igniva.filemanager.ProgressListener _arg0;
_arg0 = com.igniva.filemanager.ProgressListener.Stub.asInterface(data.readStrongBinder());
this.registerCallBack(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrent:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.igniva.filemanager.utils.DataPackage> _result = this.getCurrent();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.igniva.filemanager.RegisterCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
@Override public void registerCallBack(com.igniva.filemanager.ProgressListener p) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((p!=null))?(p.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.util.List<com.igniva.filemanager.utils.DataPackage> getCurrent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.igniva.filemanager.utils.DataPackage> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrent, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.igniva.filemanager.utils.DataPackage.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_registerCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getCurrent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public void registerCallBack(com.igniva.filemanager.ProgressListener p) throws android.os.RemoteException;
public java.util.List<com.igniva.filemanager.utils.DataPackage> getCurrent() throws android.os.RemoteException;
}
