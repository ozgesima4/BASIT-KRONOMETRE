package com.sima.runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     TextView textview;
     Button button;
     int number;
     Handler handler;
     Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       //while yada for ile de numberi arttırıp yazabilirdik biliyorsun ama androidde bu biraz sıkıntılı çünkü
        textview=findViewById(R.id.TextView);         //birden bire hemen bitiyor ve kullanıcı işlemi görmüyor beklemeli olabilmesi için handler ve runnable kullanırız
        button=findViewById(R.id.button);
        number=0;
    }
    public void baslat(View view){
        button.setEnabled(false);
        handler=new Handler();   //handler ve runnable tanımlanır
         runnable=new Runnable() {
            @Override
            public void run() {  //balşlayınca olacak işlemler yazılır biz sayaç mantığıyla sayı yazdırdık.
                textview.setText("TİME:"+number);
                number++;
                handler.postDelayed(this,1000);  //bir saniye beklemeli diye belirttik ve tabi en önemlisi

            }
        }; handler.post(runnable);  //runnable'i başlattık.
    }
    public void sifirla(View view){
        button.setEnabled(true);  //tuşa basılabilir olsun
        handler.removeCallbacks(runnable); //runnablei durdur
        textview.setText("TİME: 0");  //bittiği için sıfırla
        number=0;
    }
}