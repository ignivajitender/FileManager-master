/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/igniva-android-13/AndroidStudioProjects/AmazeFileManager-master/src/main/aidl/com/igniva/filemanager/Loadlistener.aidl
 */
package com.igniva.filemanager;
public interface Loadlistener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.igniva.filemanager.Loadlistener
{
private static final java.lang.String DESCRIPTOR = "com.igniva.filemanager.Loadlistener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.igniva.filemanager.Loadlistener interface,
 * generating a proxy if needed.
 */
public static com.igniva.filemanager.Loadlistener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.igniva.filemanager.Loadlistener))) {
return ((com.igniva.filemanager.Loadlistener)iin);
}
return new com.igniva.filemanager.Loadlistener.Stub.Proxy(obj);
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
case TRANSACTION_load:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.igniva.filemanager.ui.Layoutelements> _arg0;
_arg0 = data.createTypedArrayList(com.igniva.filemanager.ui.Layoutelements.CREATOR);
java.lang.String _arg1;
_arg1 = data.readString();
this.load(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_error:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.error(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.igniva.filemanager.Loadlistener
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
@Override public void load(java.util.List<com.igniva.filemanager.ui.Layoutelements> layoutelements, java.lang.String driveId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(layoutelements);
_data.writeString(driveId);
mRemote.transact(Stub.TRANSACTION_load, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void error(java.lang.String message, int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(message);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_error, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_load = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_error = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public void load(java.util.List<com.igniva.filemanager.ui.Layoutelements> layoutelements, java.lang.String driveId) throws android.os.RemoteException;
public void error(java.lang.String message, int mode) throws android.os.RemoteException;
}
