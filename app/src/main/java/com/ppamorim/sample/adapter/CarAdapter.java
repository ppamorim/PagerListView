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
package com.ppamorim.sample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ppamorim.sample.R;
import com.ppamorim.sample.core.adapter.AbstractAdapter;
import com.ppamorim.sample.model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends AbstractAdapter<Car> {

  private LayoutInflater mLayoutInflater;

  public CarAdapter(Context context, List<Car> list) {
    super(context, list);
    mLayoutInflater = LayoutInflater.from(mContext);
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    //ViewHolder holder;
    //if (convertView != null) {
    //  holder = (ViewHolder) convertView.getTag();
    //} else {
    //  convertView = mLayoutInflater.inflate(R.layout.adapter_car, parent, false);
    //  holder = new ViewHolder(convertView);
    //  convertView.setTag(holder);
    //}
    //
    //Car car = getItem(position);
    //if(car != null) {
    //  holder.name.setText(car.getName());
    //}

    return convertView;
  }

  //static class ViewHolder {
  //  @InjectView(R.id.car_name) TextView name;
  //
  //  public ViewHolder(View view) {
  //    ButterKnife.inject(this, view);
  //  }
  //}

}
