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

/**
 * Created by pedro on 2/14/15.
 */
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
