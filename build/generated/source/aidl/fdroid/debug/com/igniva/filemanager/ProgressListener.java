/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/igniva-android-13/AndroidStudioProjects/AmazeFileManager-master/src/main/aidl/com/igniva/filemanager/ProgressListener.aidl
 */
package com.igniva.filemanager;
public interface ProgressListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.igniva.filemanager.ProgressListener
{
private static final java.lang.String DESCRIPTOR = "com.igniva.filemanager.ProgressListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.igniva.filemanager.ProgressListener interface,
 * generating a proxy if needed.
 */
public static com.igniva.filemanager.ProgressListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.igniva.filemanager.ProgressListener))) {
return ((com.igniva.filemanager.ProgressListener)iin);
}
return new com.igniva.filemanager.ProgressListener.Stub.Proxy(obj);
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
case TRANSACTION_onUpdate:
{
data.enforceInterface(DESCRIPTOR);
com.igniva.filemanager.utils.DataPackage _arg0;
if ((0!=data.readInt())) {
_arg0 = com.igniva.filemanager.utils.DataPackage.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onUpdate(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_refresh:
{
data.enforceInterface(DESCRIPTOR);
this.refresh();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.igniva.filemanager.ProgressListener
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
@Override public void onUpdate(com.igniva.filemanager.utils.DataPackage dataPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((dataPackage!=null)) {
_data.writeInt(1);
dataPackage.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onUpdate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void refresh() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_refresh, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_refresh = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public void onUpdate(com.igniva.filemanager.utils.DataPackage dataPackage) throws android.os.RemoteException;
public void refresh() throws android.os.RemoteException;
}
