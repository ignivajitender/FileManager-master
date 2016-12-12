// RegisterCallback.aidl
package com.igniva.filemanager;

// Declare any non-default types here with import statements
import com.igniva.filemanager.ProgressListener;
import com.igniva.filemanager.utils.DataPackage;
interface RegisterCallback {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void registerCallBack(in ProgressListener p);
    List<DataPackage> getCurrent();
}
