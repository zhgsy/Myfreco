package com.bw.com.myfreco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.butn_rodio)
    Button butnRodio;
    @BindView(R.id.butn_xing)
    Button butnXing;
    @BindView(R.id.butn_bi)
    Button butnBi;
    @BindView(R.id.butn_jian)
    Button butnJian;
    @BindView(R.id.butn_cipan)
    Button butnCipan;
    @BindView(R.id.butn_jia)
    Button butnJia;
    @BindView(R.id.butn_zai)
    Button butnZai;
    @BindView(R.id.butn_pei)
    Button butnPei;
    @BindView(R.id.shop_icon)
    SimpleDraweeView shopIcon;
    private SimpleDraweeView draweeView;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        uri = Uri.parse("https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg");
        draweeView = (SimpleDraweeView) findViewById(R.id.shop_icon);
        draweeView.setImageURI(uri);
    }

    @OnClick({R.id.butn_rodio, R.id.butn_xing, R.id.butn_bi, R.id.butn_jian, R.id.butn_cipan, R.id.butn_jia, R.id.butn_zai, R.id.butn_pei})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butn_rodio:
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setCornersRadius(50f);
                draweeView.getHierarchy().setRoundingParams(roundingParams);
                break;
            case R.id.butn_xing:
                RoundingParams rounding = RoundingParams.fromCornersRadius(5f);
                rounding.setRoundAsCircle(true);
                draweeView.getHierarchy().setRoundingParams(rounding);
                break;
            case R.id.butn_bi:
                RoundingParams round = RoundingParams.fromCornersRadius(5f);
                draweeView.setAspectRatio(1.2f);
                draweeView.getHierarchy().setRoundingParams(round);
                break;
            case R.id.butn_jian:

              /*  RoundingParams roundingPara = new RoundingParams();
                roundingPara.setRoundAsCircle(true);
                GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setRoundingParams(roundingPara)
                        .setFadeDuration(9000)
                        .build();
                draweeView.setHierarchy(hierarchy);*/

                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(draweeView.getController())
                        .build();
                draweeView.setController(controller);

                break;
            case R.id.butn_cipan:

                break;
            case R.id.butn_jia:
                DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                        .setAutoPlayAnimations(true)
                        //加载drawable里的一张gif图
                        .setUri(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549986214299&di=6303bcd1e2aa4069b37ed338d66217c1&imgtype=0&src=http%3A%2F%2Fs8.sinaimg.cn%2Fmw690%2F4296c130td5315239ae27%26690"))//设置uri
                        .build();
                //设置Controller
                draweeView.setController(mDraweeController);

                break;
            case R.id.butn_zai:
                break;
            case R.id.butn_pei:
                break;
        }
    }
}
