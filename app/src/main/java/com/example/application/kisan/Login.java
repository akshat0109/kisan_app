package com.example.application.kisan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by HP on 21-01-2018.
 */

public class Login extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private Button loginbutton;
    private Button forgetPassword;
    Context context;
    private SignInButton button;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    private static final int FACEBOOK_REQ_CODE = 9000;
    private CallbackManager callbackManager;
    private LoginButton facebookLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        facebookLoginButton  = findViewById(R.id.facebook_login);
        forgetPassword = findViewById(R.id.forgetPassword);

        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(context,"Welcome " + loginResult.getAccessToken().getUserId(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Main_activity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                Toast.makeText(context,"login failed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        loginbutton = findViewById(R.id.login);
        loginbutton.setOnClickListener(this);
        context = this;
        /*loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main_activity.class);
                startActivity(intent);
            }
        });*/

        button = findViewById(R.id.googleSignIn);
        button.setOnClickListener(this);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();
    }

    public  void click(View view ) {
        if(view.getId() == R.id.forgetPassword) {

        }
        else {
            Intent intent = new Intent("android.intent.action.SIGNUP");
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id  == R.id.login){
            Intent intent = new Intent(context,Main_activity.class);
            startActivity(intent);

        }
        else if(id == R.id.googleSignIn) {
            signin();
        }
    }

    private void signin() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQ_CODE == requestCode) {
            GoogleSignInResult result =  Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
        else
            callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(context,"Failed to login",Toast.LENGTH_SHORT).show();
    }

    private void handleResult(GoogleSignInResult result) {
        if(result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            String name  = account.getDisplayName();
            String email_id = account.getEmail();

            Toast.makeText(context,name,Toast.LENGTH_SHORT).show();
            Toast.makeText(context,email_id,Toast.LENGTH_SHORT).show();

            Intent intent =  new Intent("android.intent.action.MAINACTIVITY");
            startActivity(intent);

        }
    }
}

