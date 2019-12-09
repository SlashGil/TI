package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chava.ti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    Button btnSignUp, btnSignIn, btnSignOut;
    TextView txtWelcome,txtDetail, txtStatus;
    EditText edtUser, edtPass;
    ImageView home, upaep, login;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtWelcome = findViewById(R.id.txtWelcome);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignOut = findViewById(R.id.btnSignOut);
        txtStatus = findViewById(R.id.statusTxtView);
        txtDetail = findViewById(R.id.detailTxtView);
        mAuth = FirebaseAuth.getInstance();
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        login.setVisibility(View.GONE);
        btnSignUp.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        progressDialog = new ProgressDialog(this);
        btnSignIn.setOnClickListener(this);
        btnSignOut.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void registerUser() {
        String mail = edtUser.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        if (TextUtils.isEmpty(mail)) {
            Toast.makeText(this, "Se debe ingresar un correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando Registro...");
        progressDialog.show();

        //Creating a new user
        mAuth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Se ha registrado el usuario", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    private void login() {
        final String mail = edtUser.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        if (TextUtils.isEmpty(mail)) {
            Toast.makeText(this, "Se debe ingresar un correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        final ProgressDialog progressDialog1 = new ProgressDialog(this);
        progressDialog1.setMessage("Iniciando sesion....");
        progressDialog1.show();

        //Login user
        mAuth.signInWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            int pos = mail.indexOf("@");
                            String user = mail.substring(0, pos);

                            Intent intent = new Intent(getApplication(), Welcome.class);
                            intent.putExtra(Welcome.USER, user);
                            startActivity(intent);

                        }
                        progressDialog1.dismiss();
                    }
                });
    }
    private void updateUI(FirebaseUser user) {
        progressDialog.hide();
        if (user != null) {
            String loged = user.getEmail();
            int ind = loged.indexOf("@");
            int punkt = loged.indexOf(".");
            String userlogged = loged.substring(0,ind);

            txtStatus.setText(getString(R.string.google_status_fmt,userlogged));
            findViewById(R.id.statusTxtView).setVisibility(View.VISIBLE);
            findViewById(R.id.edtUser).setVisibility(View.GONE);
            findViewById(R.id.edtPass).setVisibility(View.GONE);

            findViewById(R.id.btnSignUp).setVisibility(View.GONE);
            findViewById(R.id.btnSignIn).setVisibility(View.GONE);
            findViewById(R.id.btnSignOut).setVisibility(View.VISIBLE);
        } else {
            txtStatus.setText(R.string.signed_out);

            findViewById(R.id.btnSignIn).setVisibility(View.VISIBLE);
            findViewById(R.id.btnSignOut).setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignUp:
                registerUser();
                break;
            case R.id.btnSignIn:
                login();
                break;
            case R.id.btnSignOut: {
                signOut();
            }
                break;
            case R.id.home: {
                finish();
            }
        }
        registerUser();
    }
    private void signOut() {
        mAuth.signOut();
        finish();
    }

}
