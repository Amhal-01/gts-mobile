package gts.com.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.Date;

import gts.com.mobile.models.Chauffeur;
import gts.com.mobile.models.Etudiant;

public class LoginActivity extends AppCompatActivity {
    private Button map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        map = findViewById(R.id.sign_in_btn);
        map.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MapActivity.class);
                Chauffeur c = new Chauffeur();
                c.setId(1);
                c.setPrenom("Hamza");
                c.setNom("Amhal");
                c.setEmail("amhalhamza@gmail.com");
                c.setPassword("123456");
                c.setDateEmbauche(new Date("25/10/2017"));
                c.setOk(true);
                c.setTelephone("0661666736");
                c.setActive(true);
                intent.putExtra("chauffeur",c);

                Etudiant e = new Etudiant();
                e.setId(1);
                e.setPrenom("Younes");
                e.setNom("Zaid");
                e.setEmail("zaidyounes@gmail.com");
                e.setPassword("123456");
                e.getDateNaissance(new Date("07/03/1994"));
                intent.putExtra("etudiant",e);
                startActivity(intent);
            }
        });
    }

}

