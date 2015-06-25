package wen.sharp.crazyoil;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import wen.sharp.common.DatabaseManager;

/**
 * Created by wenyugang_91 on 2015/6/16.
 */
public class OilBusiness {
    public boolean addRecord(OilBean info) {
        boolean result = false;
        SQLiteDatabase db = DatabaseManager.getManager().get();
        try {
            ContentValues values = new ContentValues();
            values.put(OilBean.COLUMN_PRICE, info.getPrice());
            values.put(OilBean.COLUMN_MONEY, info.getMoney());
            values.put(OilBean.COLUMN_KELOMETER, info.getMoney());
            result = db.insert(OilBean.TABLE_NAME, null, values) != -1;
        } finally {
            DatabaseManager.getManager().close();
        }
        return result;
    }
}
