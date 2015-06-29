package wen.sharp.crazyoil;

import android.app.Activity;
import android.text.Html;
import android.widget.TextView;

import wen.sharp.common.R;

/**
 * Created by wenyugang_91 on 2015/6/29.
 */
public class OutLinePage extends BasePage{

    public OutLinePage(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate() {
        setContentView(R.layout.outline_page);
        initView();
    }

    @Override
    protected void onDestroy() {

    }

    @Override
    protected void initView() {
       TextView outlineTxt = (TextView) findViewById(R.id.outline);
        outlineTxt.setText(Html.fromHtml("<font face='微软黑雅'>你共行驶了<font color='red' size=16 ><b>5129</b></font>公里，" +
                "花费了<font color='red'><b>589</b></font>元钱，百公里油耗<font color='red'><b>5L</b></font></font>"));
    }
}
