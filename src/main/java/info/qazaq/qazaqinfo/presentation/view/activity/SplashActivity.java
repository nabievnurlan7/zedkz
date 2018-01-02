package info.qazaq.qazaqinfo.presentation.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.qazaq.qazaqinfo.R;

public class SplashActivity extends AppCompatActivity
{
    @BindView(R.id.txtLogo)
    TextView txtLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        txtLogo.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_pulse));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                txtLogo.clearAnimation();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }
}