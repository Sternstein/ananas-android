package com.example.andreas.ananas;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class Readtext extends AppCompatActivity {
    TextView tRead;
    ImageView imV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readtext);
        TextView tRead  = (TextView) findViewById(R.id.tRead);
        ImageView imV = (ImageView) findViewById(R.id.imV);

        tRead.setText("Равным образом консультация с широким активом играет важную роль в формировании новых предложений. Равным образом сложившаяся структура организации играет важную роль в формировании позиций, занимаемых участниками в отношении поставленных задач. Задача организации, в особенности же постоянное информационно-пропагандистское обеспечение нашей деятельности требуют от нас анализа модели развития. Таким образом дальнейшее развитие различных форм деятельности обеспечивает широкому кругу (специалистов) участие в формировании направлений прогрессивного развития.\n" +
                "\n" +
                "С другой стороны укрепление и развитие структуры позволяет выполнять важные задания по разработке систем массового участия. Товарищи! реализация намеченных плановых заданий позволяет выполнять важные задания по разработке дальнейших направлений развития. Значимость этих проблем настолько очевидна, что реализация намеченных плановых заданий способствует подготовки и реализации системы обучения кадров, соответствует насущным потребностям.\n" +
                "\n" +
                "Равным образом постоянное информационно-пропагандистское обеспечение нашей деятельности влечет за собой процесс внедрения и модернизации системы обучения кадров, соответствует насущным потребностям. С другой стороны укрепление и развитие структуры представляет собой интересный эксперимент проверки позиций, занимаемых участниками в отношении поставленных задач. Разнообразный и богатый опыт дальнейшее развитие различных форм деятельности представляет собой интересный эксперимент проверки соответствующий условий активизации. С другой стороны дальнейшее развитие различных форм деятельности в значительной степени обуславливает создание позиций, занимаемых участниками в отношении поставленных задач. ивет!!!!");
        // imV.setImageURI(Uri.parse("192.168.1.7/eda/pic/20151223_234414.jpg") );
        imV.setImageDrawable(Drawable.createFromPath("/home/andreas/Desktop/Link to html/eda/pic/REII.jpg"));
    }
}
