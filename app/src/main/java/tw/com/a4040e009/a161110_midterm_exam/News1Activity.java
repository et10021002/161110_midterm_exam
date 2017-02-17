package tw.com.a4040e009.a161110_midterm_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class News1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news1);
    }
    public void onclickmews1back(View view){
        finish();
    }
}
