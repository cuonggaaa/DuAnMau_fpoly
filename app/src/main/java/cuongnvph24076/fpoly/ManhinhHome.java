package cuongnvph24076.fpoly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import cuongnvph24076.fpoly.Login.Login;

public class ManhinhHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_home);

    }

    public void loo(View view) {
        Intent intent = new Intent(ManhinhHome.this, Login.class);
        startActivity(intent);
    }
}