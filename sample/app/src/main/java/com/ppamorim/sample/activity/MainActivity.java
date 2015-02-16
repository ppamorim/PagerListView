package com.ppamorim.sample.activity;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ppamorim.library.ItemView;
import com.ppamorim.library.PagerAdapter;
import com.ppamorim.library.PagerListView;
import com.ppamorim.sample.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {



  private ArrayList<ItemView> mListCars = new ArrayList<>();
  private PagerAdapter mPageAdapter;

  @InjectView(R.id.toolbar) Toolbar mToolbar;
  @InjectView(R.id.pager_list_view) PagerListView mPagerListView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    mListCars = generateCars();
    configToolbar();
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        configAdapter();
      }
    }, 500);
  }

  private void configToolbar() {
    mToolbar.setTitle(getResources().getString(R.string.app_name));
  }

  private void configAdapter() {
    mPagerListView.setIsCicular(true);
    mPagerListView.setAlphaFactor(0.8f);
    mPagerListView.setAdapter(mPagerListView, mListCars);
  }

  private ArrayList<ItemView> generateCars() {
    ArrayList<ItemView> mViews = new ArrayList<>();
    for(int i = 0; i < 20; i++) {

      View topView = LayoutInflater.from(this).inflate(R.layout.top_view, null);
      ((TextView)topView.findViewById(R.id.back_text)).setText("TOP VIEW\n" + getCarName(i) + i);



      View containerView = LayoutInflater.from(this).inflate(R.layout.adapter_car, null);
      Picasso.with(this)
          .load(getUrlImage(i))
          .into((ImageView) containerView.findViewById(R.id.image_view));

      View bottomView = LayoutInflater.from(this).inflate(R.layout.bottom_view, null);
      ((TextView)bottomView.findViewById(R.id.next_text)).setText("BOTTOM VIEW" + i);

      mViews.add(new ItemView(topView, containerView, bottomView));
    }
    return mViews;
  }

  private String getUrlImage(int position) {
    switch (position) {
      case 0:
        return "http://autosemotos.com/wp-content/uploads/2011/03/2010-Koenigsegg-Agera-LAD1.jpg";
      case 1:
        return "http://s.petrolicious.com/market/2013/ferrari/testarossa-5.jpg";
      case 2:
        return "http://cdn.lamborghini.com/content/masterpieces/Miura/L1926_1920x1080.jpg";
      case 3:
        return "http://img.favcars.com/porsche/356/porsche_356_1954_images_1_b.jpg";
      default:
        return "http://www.6speedonline.com/wp-content/uploads/2013/03/Front-Left-Corner-Best-small.jpg";
    }
  }

  private String getCarName(int position) {
    switch (position) {
      case 0:
        return "Koenigsegg Agera ";
      case 1:
        return "Ferrari Testarossa ";
      case 2:
        return "Lamborghini Miura ";
      case 3:
        return "Porsche 356 ";
      default:
        return "Porsche 911 993 ";
    }
  }

}
