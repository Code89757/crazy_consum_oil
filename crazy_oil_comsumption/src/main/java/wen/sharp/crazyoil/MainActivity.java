package wen.sharp.crazyoil;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.melnykov.fab.FloatingActionButton;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.HashMap;
import java.util.List;

import butterknife.InjectView;
import wen.sharp.common.R;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.left_drawer)
    RadioGroup drawerRootView;

    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @InjectView(R.id.progress_wheel)
    ProgressWheel progressWheel;

    @InjectView(R.id.contentLayout)
    ViewGroup mContentPanel;

    private BasePage mCurrentPage;

    private HashMap<String, BasePage> mPageList;


    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar();
        initDrawerView();
        initContentView();
    }

    private void initContentView() {
        mCurrentPage = new OutLinePage(this);
        mCurrentPage.onCreate();
        View currView = mCurrentPage.getLayoutView();
        if (currView != null) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            mContentPanel.addView(currView, params);
        }
    }

    @Override
    protected int getLayoutView() {
        return R.layout.main_activity;
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar(toolbar);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mDrawerLayout.isDrawerOpen(drawerRootView)) {
            mDrawerLayout.closeDrawer(drawerRootView);
            return true;
        }
        moveTaskToBack(true);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openOrCloseDrawer();
                }
            });
        }
    }

    private void openDrawer() {
        if (!mDrawerLayout.isDrawerOpen(drawerRootView)) {
            mDrawerLayout.openDrawer(drawerRootView);
        }
    }

    private void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(drawerRootView)) {
            mDrawerLayout.closeDrawer(drawerRootView);
        }
    }

    private void openOrCloseDrawer() {
        if (mDrawerLayout.isDrawerOpen(drawerRootView)) {
            mDrawerLayout.closeDrawer(drawerRootView);
        } else {
            mDrawerLayout.openDrawer(drawerRootView);
        }
    }

    private void initDrawerView() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                toolbar.setTitle(R.string.app_name);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setScrimColor(getColor(R.color.drawer_scrim_color));

        drawerRootView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                closeDrawer();
                switchPage(checkedId);
            }
        });
    }

    private void switchPage(int checkedId) {
        final ViewGroup contentPanel = mContentPanel;
        BasePage page = mCurrentPage;

        if(page != null){
            View layoutView = page.getLayoutView();
            ViewGroup viewGroup = (ViewGroup) layoutView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(layoutView);
                page.onDestroy();
            }
        }

        switch (checkedId) {
            case R.id.my_struct:
                page = new OutLinePage(this);
                page.onCreate();
                View currView = page.getLayoutView();
                if (currView != null) {
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    contentPanel.addView(currView, params);
                }
                break;
            default:
                page = null;
                break;
        }

        mCurrentPage = page;
    }

}
