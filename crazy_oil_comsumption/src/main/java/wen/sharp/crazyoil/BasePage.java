package wen.sharp.crazyoil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wenyugang_91 on 2015/6/16.
 */
public abstract class BasePage {
    private View mLayoutView;
    private Activity mAnchorActivity;
    private LayoutInflater mInflater;

    public BasePage(Activity activity) {
        this.mAnchorActivity = activity;
        this.mInflater = activity.getLayoutInflater();
    }

    public View getLayoutView() {
        return mLayoutView;
    }

    protected abstract void create(ViewGroup decorView);
}
