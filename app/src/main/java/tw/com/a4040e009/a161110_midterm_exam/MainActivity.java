package tw.com.a4040e009.a161110_midterm_exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView youtubeimage,newsimage,collectionimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findToolBar();
        findImageView();
    }
    private void findImageView(){
        youtubeimage = (ImageView) findViewById(R.id.youtubeimage);
        newsimage = (ImageView) findViewById(R.id.newsimage);
        collectionimage = (ImageView) findViewById(R.id.collection);
        youtubeimage.setOnClickListener(image_onclick);
        newsimage.setOnClickListener(image_onclick);
        collectionimage.setOnClickListener(image_onclick);
    }

    private ImageView.OnClickListener image_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.youtubeimage:
                    startActivity(new Intent().setClass(MainActivity.this,YoutubeActivity.class));
                    break;

                case R.id.newsimage:
                    startActivity(new Intent().setClass(MainActivity.this,NewsActivity.class));
                    break;
                case R.id.activity_collection:
                    startActivity(new Intent().setClass(MainActivity.this,CollectionActivity.class));
                    break;
            }
        }
    };
    private void findToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.smellicon);
        toolbar.setTitle("期中考");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String message = null;
            switch(item.getItemId()){
                case R.id.action_settings:
                    message = "No setting";
                    break;
                case R.id.action_about:
                    message = "No about";
                    break;
                case R.id.action_exit:
                    message = "No exit";
                    break;
            }
            if(!message.equals("null")){
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
