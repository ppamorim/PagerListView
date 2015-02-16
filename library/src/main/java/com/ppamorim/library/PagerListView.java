/*
* Copyright (C) 2015 Pedro Paulo de Amorim.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.ppamorim.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Custom ListView with alpha and parallax effect. When user click on next or back,
 * the ListView will scroll on sexy moviment.
 *
 * @author Pedro Paulo de Amorim.
 */
public class PagerListView extends ListView {

  private Context mContext;
  private PagerAdapter mPagerAdapter;
  private View mRootView;
  private ParallaxListViewHelper helper;

  public PagerListView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mContext = context;
    init(context, attrs);
  }

  public PagerListView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  protected void init(Context context, AttributeSet attrs) {
    helper = new ParallaxListViewHelper(context, attrs, this);
    super.setOnScrollListener(helper);
  }

  public void setAdapter(View rootView, ArrayList<ItemView> views) {
    mPagerAdapter = new PagerAdapter(mContext, views, listViewInterface);
    mPagerAdapter.setAdapterHeight(rootView.getHeight());
    setAdapter(mPagerAdapter);
  }

  public View getRooteView() {
    return mRootView;
  }

  public void setRootView(View mRootView) {
    this.mRootView = mRootView;
  }

  public void setIsCicular(boolean isCicular) {
    helper.setIsCircular(isCicular);
  }

  public void setAlphaFactor(float alphaFactor) {
    helper.setAlphaFactor(alphaFactor);
  }

  @Override public boolean dispatchTouchEvent(@NonNull MotionEvent ev){
    return ev.getAction()==MotionEvent.ACTION_MOVE || super.dispatchTouchEvent(ev);
  }

  @Override public void setOnScrollListener(OnScrollListener scrollListener) {
    helper.setOnScrollListener(scrollListener);
  }

  public void addParallaxedHeaderView(View v) {
    super.addHeaderView(v);
    helper.addParallaxedHeaderView(v);
  }

  public void addParallaxedHeaderView(View v, Object data, boolean isSelectable) {
    super.addHeaderView(v, data, isSelectable);
    helper.addParallaxedHeaderView(v, data, isSelectable);
  }

  private PagerAdapter.ListViewInterface listViewInterface = new PagerAdapter.ListViewInterface() {

    @Override public void addPosition() {
      smoothScrollToPosition(getLastVisiblePosition() + 1);
    }

    @Override public void removePosition() {
      smoothScrollToPosition(getFirstVisiblePosition() - 1);
    }

  };

}
