package me.biubiubiu.one.ui;
import me.biubiubiu.one.R;
import me.biubiubiu.one.ui.view.ValueDateView;
import me.biubiubiu.one.ui.view.ValuePositionButton;
import me.biubiubiu.one.ui.view.ValueSpinner;
import me.biubiubiu.one.ui.view.ValueTimeView;
import me.biubiubiu.one.util.ViewUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class SearchFragment extends BaseFragment implements View.OnClickListener {

    protected String[][] PROJECTION_TYPE = {
        {"自驾车", "0"},
        {"出租车", "1"},
    };

    protected View mSubmitView;
    protected ValuePositionButton mStartLocView;
    protected ValuePositionButton mDestLocView;
    protected ValueSpinner mTypeView;
    protected ValueDateView mDateView;
    protected ValueTimeView mTimeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup parent = (ViewGroup) inflater.inflate(R.layout.search_rides_form,
                                                        container, false);
        initViews(parent);
        mSubmitView = parent.findViewById(R.id.submit);
        mSubmitView.setOnClickListener(this);
        // setActionBarTitle("搜索结果");
        mTypeView.setup(PROJECTION_TYPE);
        return parent;
    }

    private void initViews(View parent) {
        mStartLocView = (ValuePositionButton)parent.findViewById(R.id.start_loc);
        mDestLocView = (ValuePositionButton)parent.findViewById(R.id.dest_loc);
        mTypeView = (ValueSpinner)parent.findViewById(R.id.type);
    }
}
