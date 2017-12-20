package wangxin.example.com.materialdesign;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FruitActivity extends AppCompatActivity {
    public static final String FRUITE_NAME="fruit_name";
    public static final String FRUITE_IMAGE_ID = "fruit_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUITE_NAME);
        int fruitImageId = intent.getIntExtra(FRUITE_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView imageView = (ImageView)findViewById(R.id.fruit_image_view);
        TextView textView = (TextView)findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(fruitName);
        toolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(imageView);
        String fruitContent = generateFruitContent(fruitName);
        textView.setText(fruitContent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    private String generateFruitContent(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<500;i++){
            sb.append(str);
        }
        return sb.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

        }
        return true;
    }
}
