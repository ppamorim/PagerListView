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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import java.util.ArrayList;

/**
 * This is the base adapter for the PagerListView, this have 3 layouts and
 * containerView is the principal view
 *
 * @author Pedro Paulo de Amorim.
 */
public class PagerAdapter extends BaseAdapter {

  private int mHeight;
  private ArrayList<ItemView> mViews = new ArrayList<>();
  private LayoutInflater mLayoutInflater;
  private ListViewInterface mListViewInterface;

  public PagerAdapter(Context context, ArrayList<ItemView> views, ListViewInterface listViewInterface) {
    this.mViews = views;
    this.mLayoutInflater = LayoutInflater.from(context);
    this.mListViewInterface = listViewInterface;
  }

  public void setAdapterHeight(int height) {
    this.mHeight = height;
  }

  @Override public int getCount() {
    return mViews.size();
  }

  @Override public ItemView getItem(int position) {
    return mViews.get(position);
  }

  @Override public long getItemId(int position) {
    return getItem(position).hashCode();
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView != null) {
      holder = (ViewHolder) convertView.getTag();
    } else {
      convertView = mLayoutInflater.inflate(R.layout.adapter_pager, parent, false);
      holder = new ViewHolder();
      holder.backButton = (FrameLayout) convertView.findViewById(R.id.back_page);
      holder.containerView = (FrameLayout) convertView.findViewById(R.id.container_view);
      holder.nextButton = (FrameLayout) convertView.findViewById(R.id.next_page);
      convertView.setTag(holder);
    }

    View viewTop = getItem(position).getTopView();
    View viewContainer = getItem(position).getContentView();
    View viewBottom = getItem(position).getBottomView();

    if(viewTop != null) {
      holder.backButton.removeAllViews();
      holder.backButton.addView(viewTop);
    }

    if(viewContainer != null) {
      holder.containerView.removeAllViews();
      holder.containerView.addView(viewContainer);
    }

    if(viewBottom != null) {
      holder.nextButton.removeAllViews();
      holder.nextButton.addView(viewBottom);
    }

    holder.nextButton.setOnClickListener(onClickNext);
    holder.backButton.setOnClickListener(onClickBack);

    ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
    layoutParams.height = mHeight;
    convertView.setLayoutParams(layoutParams);
    return convertView;
  }

  private View.OnClickListener onClickNext = new View.OnClickListener() {
    @Override public void onClick(View v) {
      if(mListViewInterface != null) {
        mListViewInterface.addPosition();
      }
    }
  };

  private View.OnClickListener onClickBack = new View.OnClickListener() {
    @Override public void onClick(View v) {
      if(mListViewInterface != null) {
        mListViewInterface.removePosition();
      }
    }
  };

  private static class ViewHolder {
    private FrameLayout backButton;
    private FrameLayout containerView;
    private FrameLayout nextButton;
  }

  public static interface ListViewInterface {
    void addPosition();
    void removePosition();
  }

}
