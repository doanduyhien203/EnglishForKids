package java.com.example.softheart.englishnumbers;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.englishforkid.R;
import com.example.lenovo.englishforkid.databinding.ActivityControlerBinding;
import com.google.gson.Gson;

import java.com.example.softheart.englishnumbers.adapter.Song;

public class ControlerActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityControlerBinding binding;
    public static final String SONG_OBJECT_KEY="song";
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_controler);
       constraintLayout=findViewById(R.id.welcome_layout);
       binding.playIb.setOnClickListener(this);
    }
    public Song getSong(){
        Gson gson=new Gson();
        String songStringObj=getIntent().getStringExtra(SONG_OBJECT_KEY);
        return gson.fromJson(songStringObj,Song.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_ib:
                MediaPlayer mediaPlayer= MediaPlayer.create(getApplicationContext(),getSong().getMusic());
                mediaPlayer.start();
                displayCongratsMessage();
                break;
            case android.R.id.home:
                finish();
                break;
        }
    }
    public void displayCongratsMessage(){
        binding.congratsTv.setVisibility(View.VISIBLE);
        binding.congratsTv.setText("Congrats you learnt "+getSong().getTitle());
    }
}
