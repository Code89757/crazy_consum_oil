package wen.sharp.crazyoil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

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

    public void setContentView(int layouId) {
        mLayoutView = mInflater.inflate(layouId, null, false);
    }

    public View getLayoutView() {
        return mLayoutView;
    }

    protected View findViewById(int id) {
        return mLayoutView.findViewById(id);
    }

    protected abstract void onCreate() ;

    protected abstract void onDestroy();

    protected abstract void initView();

}
