package wen.sharp.common;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by code89757 on 2015/6/12.
 */
public class FindViewHelper {
    public static <T extends View> T getView(Activity activity, int containerId, int viewId) {
        return (T) activity.findViewById(containerId).findViewById(viewId);
    }

    public static <T extends View> T getView(View container, int viewId) {
        SparseArray<View> array = null;
        Object obj = container.getTag(R.id.ids_children_list);
        if (null == obj) {
            array = new SparseArray<View>();
        } else {
            array = (SparseArray<View>) obj;
        }

        View view = array.get(viewId);
        if(null == view){
            view = container.findViewById(viewId);
            array.put(viewId,view);
        }

        return (T)view;
    }
}
