package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private LoginButton loginButton;
    AccessTokenTracker accessTokenTracker;
    FirebaseAuth.AuthStateListener authStateListener;
    private  static final String TAG= "FacebookAuthentication";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mAuth=FirebaseAuth.getInstance();
   FacebookSdk.sdkInitialize(getApplicationContext());
    loginButton=findViewById(R.id.login_button);


    loginButton.setReadPermissions("email","public_profile");
    mCallbackManager=CallbackManager.Factory.create();
    loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

          //  Log.d(TAG,"onSuccess"+loginResult);
            handleFacebookToken(loginResult.getAccessToken());
        }


        @Override
        public void onCancel() {
            //Log.d(TAG,"onCancle" );
        }

        @Override
        public void onError(FacebookException error) {
          //  Log.d(TAG,"onError" );
        }
    });

authStateListener=new FirebaseAuth.AuthStateListener() {
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

        FirebaseUser user=firebaseAuth.getCurrentUser();
    }
};

accessTokenTracker=new AccessTokenTracker() {
    @Override
    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

        if (currentAccessToken==null)
        {
            mAuth.signOut();
        }
    }
};

    }

    private void handleFacebookToken(AccessToken token) {
       // Log.d(TAG,"handleFacebookToken"+token);

        AuthCredential credential= FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                  //  Log.d(TAG,"sign in with credential: successful");
                    FirebaseUser user=mAuth.getCurrentUser();
                   // updateUI(user);

                    finish();
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else
                {

                   // Log.d(TAG,"sign in with credential: failure",task.getException());
                    Toast.makeText(getApplicationContext(),"faild",Toast.LENGTH_LONG).show();
                  //  updateUI(null);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      mCallbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener!=null)
        {
           mAuth.removeAuthStateListener(authStateListener);
        }
    }
/*
    private  void updateUI(FirebaseUser user){
        if (user!=null)
        {
            textView.setText(user.getDisplayName());

            if (user.getPhotoUrl() !=null)
            {
                String photoUrl=user.getPhotoUrl().toString();
                photoUrl=photoUrl +"?type=large";

                Picasso.get().load(photoUrl).into(imageView);

            }
            else
            {
                textView.setText("");
                imageView.setImageResource(R.drawable.com_facebook_auth_dialog_background);


            }
        }
}*/
}
