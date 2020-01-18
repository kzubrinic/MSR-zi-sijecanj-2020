package hr.unidu.kz.msr_zi_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class Zadatak1Activity extends AppCompatActivity {
    private Random r;
    ImageView iv1, iv2, iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadatak1);
        r = new Random();
        iv1 = findViewById(R.id.slika_kocke1);
        iv2 = findViewById(R.id.slika_kocke2);
        iv3 = findViewById(R.id.slika_kocke3);
        setTitle("Prvi zadatak");
    }

    public void baciKocku(View view) {
        iv1.setImageResource(vratiBroj());
        iv2.setImageResource(vratiBroj());
        iv3.setImageResource(vratiBroj());
    }

    private int vratiBroj() {
        switch(r.nextInt(6)+1){
            case 1:
                return R.drawable.k01;
            case 2:
                return R.drawable.k02;
            case 3:
                return R.drawable.k03;
            case 4:
                return R.drawable.k04;
            case 5:
                return R.drawable.k05;
            default:
                return R.drawable.k06;
        }
    }
}
