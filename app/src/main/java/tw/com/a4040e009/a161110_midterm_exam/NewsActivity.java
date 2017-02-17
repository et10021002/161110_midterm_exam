package tw.com.a4040e009.a161110_midterm_exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
    public void onclickmews1(View view){
        Intent intent = new Intent(this, News1Activity.class);
        startActivity(intent);
    }
    public void onclickmews2(View view){
        Intent intent = new Intent(this, News2Activity.class);
        startActivity(intent);
    }
    public void back(View view){
        finish();
    }
}
