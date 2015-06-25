package wen.sharp.crazyoil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by code89757 on 2015/6/12.
 */
public class DatabaseOperHelper extends SQLiteOpenHelper {
    public DatabaseOperHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(OilBean.TABLE_NAME);
        sb.append(" (");
        sb.append(OilBean.COLUMN_ID);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(OilBean.COLUMN_MONEY);
        sb.append(" INTEGER,");
        sb.append(OilBean.COLUMN_PRICE);
        sb.append(" INTEGER,");
        sb.append(OilBean.COLUMN_KELOMETER);
        sb.append(" INTEGER,");
        sb.append(");");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
