package ma.enset.tp3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

import ma.enset.tp3.models.Article;

public class ArticleActivity extends AppCompatActivity {


    private TextView desc;

    private ImageView imageView;
    private Button goBackBtn;


    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_view);
        getSupportActionBar().hide();

        Intent intent=getIntent();
        Article article= (Article) intent.getSerializableExtra("article");
        desc = findViewById( R.id.textView);
        imageView=findViewById(R.id.imageView);
        desc.setText( article.getDescription() );

        Runnable thread= new Runnable(){
            @Override
            public void run() {
                try {
                    Log.i("info",article.getUrlToImage());
                    URL url=new URL(article.getUrlToImage());
                    Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t=new Thread(thread);
        t.start();
    }

}
