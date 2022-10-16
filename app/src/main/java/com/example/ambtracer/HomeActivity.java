package com.example.ambtracer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class HomeActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name;
    Button SignOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.name);
        SignOutBtn = findViewById(R.id.SignOut);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);



        Button btn = findViewById(R.id.nav);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapView();
            }
        });



        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct !=null){
            String UserName = acct.getDisplayName();
            name.setText(UserName);
        }
        SignOutBtn.setOnClickListener(view -> signOut());
    }

    public void openMapView(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google. android. gms. maps");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }



    void signOut(){
        gsc.signOut().addOnCompleteListener(task -> {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });
    }
    void openMapView(){
        startActivity(new Intent(HomeActivity.this, MapView.class));
    }
}