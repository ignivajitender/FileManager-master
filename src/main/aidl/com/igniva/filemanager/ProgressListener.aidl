// ProgressListener.aidl
package com.igniva.filemanager;

// Declare any non-default types here with import statements
import com.igniva.filemanager.utils.DataPackage;
interface ProgressListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
        void onUpdate(in DataPackage dataPackage);
        void refresh();
}
