package wen.sharp.common;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by code89757 on 2015/6/5.
 */
public class DatabaseManager {
    private static DatabaseManager mManage;

    public static void setManager(DatabaseManager instance) {
        mManage = instance;
    }

    public static DatabaseManager getManager() {
        if (mManage == null) {
            throw new NullPointerException("Database Manage is null,please call setManager for Data");
        }
        return mManage;
    }

    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mOpenHelper;
    private AtomicInteger mOpenAtomic = new AtomicInteger();

    /**
     * 构造函数
     * @param openHelper
     */
    public DatabaseManager(SQLiteOpenHelper openHelper) {
        this.mOpenHelper = openHelper;
    }

    /**
     * 获取数据库读写对象
     * @return
     */
    public SQLiteDatabase get() {
        if (this.mOpenAtomic.incrementAndGet() == 1) {
            this.mDatabase = this.mOpenHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    /**
     * 关闭数据库
     */
    public void close() {
        if (this.mOpenAtomic.decrementAndGet() == 0 && this.mDatabase != null) {
            this.mDatabase.close();
        }
    }

}
