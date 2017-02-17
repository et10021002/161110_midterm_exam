package tw.com.a4040e009.a161110_midterm_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YoutubeActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String,Object>> hashMapList;
    private HashMap<String,Object> map;
    private String keyname[] = {"vedio_image","title_text","launch_text","release_text"};
    private int resid[] = {R.id.vedio_imageview,R.id.title_textview,R.id.launch_textview,R.id.release_textview};
    private int vedio_image[] = {R.drawable.youtube1,R.drawable.youtube2,R.drawable.youtube3,R.drawable.youtube4,R.drawable.youtube5};
    private String title_text[] = {"周杰倫 告白氣球","周杰倫 手寫的從前","周杰倫 怎麼了","周杰倫 天涯過客","周杰倫 哪裡都是你"};
    private String launch_text[] = {"\n觀看次數：4,183,867","\n觀看次數：25,535,997","\n觀看次數：11,403,369","\n觀看次數：8,034,731","\n觀看次數：觀看次數：7,151,616"};
    private String release_text[] = {"發佈日期：2016年10月27日","發佈日期：2014年12月30日","發佈日期：2015年3月4日","發佈日期：2015年1月14日","發佈日期：2013年10月30日"};
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        setadapter();
        findtoolbar();
    }

    private void setadapter(){
        listView = (ListView) findViewById(R.id.youtubelistview);
        simpleAdapter = new SimpleAdapter(this, getmapdata(), R.layout.vedio_item, keyname,resid);
        listView.setAdapter(simpleAdapter);
    }
    private List<HashMap<String,Object>> getmapdata(){
        hashMapList = new ArrayList<HashMap<String, Object>>();
        for(int i = 0;i<vedio_image.length;i++){
            map = new HashMap<String, Object>();
            map.put("vedio_image",vedio_image[i]);
            map.put("title_text",title_text[i]);
            map.put("launch_text",launch_text[i]);
            map.put("release_text",release_text[i]);
            hashMapList.add(map);
        }
        return hashMapList;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void findtoolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("推薦影片");
        setSupportActionBar(toolbar);
    }
}