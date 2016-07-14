package com.example.li.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    private SliderLayout slider;
    private PagerIndicator custom_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        slider = (SliderLayout) findViewById(R.id.slider);
        custom_indicator = (PagerIndicator) findViewById(R.id.custom_indicator);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);

        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://b.hiphotos.baidu.com/image/h%3D300/sign=6012c51c69061d95624631384bf40a5d/5ab5c9ea15ce36d31c2a3f143df33a87e950b1ec.jpg");
        url_maps.put("Big Bang Theory", "http://img1.imgtn.bdimg.com/it/u=3399041745,45562276&fm=21&gp=0.jpg");
        url_maps.put("House of Cards", "http://img3.imgtn.bdimg.com/it/u=3534513302,27144379&fm=21&gp=0.jpg");
        url_maps.put("Game of Thrones", "http://img5.imgtn.bdimg.com/it/u=2857748888,2758603105&fm=21&gp=0.jpg");
        url_maps.put("Game of Thrones2", "http://img3.imgtn.bdimg.com/it/u=4024449971,349164446&fm=21&gp=0.jpg");
        url_maps.put("Game of Thrones3", "http://img0.imgtn.bdimg.com/it/u=3101136660,3048342976&fm=21&gp=0.jpg");


        for (String name : url_maps.keySet()) {
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            slider.addSlider(textSliderView);
        }

        slider.setPresetTransformer(SliderLayout.Transformer.Default);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        slider.stopAutoCycle();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getApplicationContext(), "点击了图片", Toast.LENGTH_LONG).show();
    }
}
