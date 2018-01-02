package info.qazaq.qazaqinfo.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.qazaq.qazaqinfo.R;
import info.qazaq.qazaqinfo.presentation.model.PresentationModel;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.txtFName)
    TextView txtFName;
    @BindView(R.id.txtLName)
    TextView txtLName;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtGender)
    TextView txtGender;
    @BindView(R.id.txtIP)
    TextView txtIP;
    @BindView(R.id.imgPhoto)
    ImageView imgPhoto;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        PresentationModel news = intent.getParcelableExtra("news");
        Log.d(TAG, "onCreate: " + news.getId());

        txtFName.setText(news.getFirst_name());
        txtLName.setText(news.getLast_name());
        txtEmail.setText(news.getEmail());
        txtGender.setText(news.getGender());
        txtIP.setText(news.getIp_address());

        Picasso.with(this)
                .load("https://dummyimage.com/196x219.png")
                .into(imgPhoto);
//        "https://dummyimage.com/196x219.png"
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}