package com.ppamorim.library;

import android.view.View;

public class ItemView {

  private View mTopView;
  private View mContentView;
  private View mBottomView;

  public ItemView(View mTopView, View mContentView, View mBottomView) {
    this.mTopView = mTopView;
    this.mContentView = mContentView;
    this.mBottomView = mBottomView;
  }

  public View getTopView() {
    return mTopView;
  }

  public View getContentView() {
    return mContentView;
  }

  public View getBottomView() {
    return mBottomView;
  }

}
