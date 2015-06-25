package wen.sharp.common;

import android.content.Context;
import android.content.ContextWrapper;

import java.io.File;

/**
 * Created by code89757 on 2015/6/12.
 */
public class DatabaseContext extends ContextWrapper {
    private String mDirName;

    public DatabaseContext(Context base, String dirName) {
        super(base);
    }

    @Override
    public File getDatabasePath(String name) {
        return new File(getApplicationContext().getExternalCacheDir(), mDirName);
    }
}
