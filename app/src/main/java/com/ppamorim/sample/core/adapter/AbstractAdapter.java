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
package com.ppamorim.sample.core.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Filterable;

import java.util.List;

public abstract class AbstractAdapter<T> extends BaseAdapter {

  public final Context mContext;
  private List<T> mDataAll;
  private List<T> mData;

  public AbstractAdapter(Context context, List<T> list) {
    mContext = context;
    mData = list;

    if (this instanceof Filterable) {
      mDataAll = list;
    }
  }

  public final Context getContext(){
    return mContext;
  }

  @Override
  public int getCount() {
    return mData.size();
  }

  @Override
  public T getItem(int i) {
    return mData.get(i);
  }

  public List<T> getDataAll() {
    return mDataAll;
  }

  public int getCountAll() {
    return mDataAll.size();
  }

  public void setData(List<T> mData) {
    this.mData = mData;
  }

  @Override
  public long getItemId(int i) {
    return getItem(i).hashCode();
  }

}
