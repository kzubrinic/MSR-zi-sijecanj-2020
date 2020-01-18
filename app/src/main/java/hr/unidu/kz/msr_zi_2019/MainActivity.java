package hr.unidu.kz.msr_zi_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prviZadatak(View view) {
        Intent intent = new Intent(this, Zadatak1Activity.class);
        startActivity(intent);
    }
    public void drugiZadatak(View view) {
        Intent intent = new Intent(this, Zadatak2Activity.class);
        startActivity(intent);
    }

    public void treciZadatak(View view) {
        Intent intent = new Intent(this, Zadatak3Activity.class);
        startActivity(intent);
    }


}
