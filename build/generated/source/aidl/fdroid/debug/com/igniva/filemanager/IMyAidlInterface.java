/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/igniva-android-13/AndroidStudioProjects/AmazeFileManager-master/src/main/aidl/com/igniva/filemanager/IMyAidlInterface.aidl
 */
package com.igniva.filemanager;
// Declare any non-default types here with import statements

public interface IMyAidlInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.igniva.filemanager.IMyAidlInterface
{
private static final java.lang.String DESCRIPTOR = "com.igniva.filemanager.IMyAidlInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.igniva.filemanager.IMyAidlInterface interface,
 * generating a proxy if needed.
 */
public static com.igniva.filemanager.IMyAidlInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.igniva.filemanager.IMyAidlInterface))) {
return ((com.igniva.filemanager.IMyAidlInterface)iin);
}
return new com.igniva.filemanager.IMyAidlInterface.Stub.Proxy(obj);
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
case TRANSACTION_loadlist:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.loadlist(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_loadRoot:
{
data.enforceInterface(DESCRIPTOR);
this.loadRoot();
reply.writeNoException();
return true;
}
case TRANSACTION_goback:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.goback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_create:
{
data.enforceInterface(DESCRIPTOR);
this.create();
reply.writeNoException();
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.igniva.filemanager.Loadlistener _arg0;
_arg0 = com.igniva.filemanager.Loadlistener.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.igniva.filemanager.IMyAidlInterface
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
@Override public void loadlist(java.lang.String id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_loadlist, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void loadRoot() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_loadRoot, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void goback(java.lang.String id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_goback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void create() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_create, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void registerCallback(com.igniva.filemanager.Loadlistener load) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((load!=null))?(load.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_loadlist = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_loadRoot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_goback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_create = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public void loadlist(java.lang.String id) throws android.os.RemoteException;
public void loadRoot() throws android.os.RemoteException;
public void goback(java.lang.String id) throws android.os.RemoteException;
public void create() throws android.os.RemoteException;
public void registerCallback(com.igniva.filemanager.Loadlistener load) throws android.os.RemoteException;
}
