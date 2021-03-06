package group.tmg.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import group.tmg.App;
import group.tmg.R;
import group.tmg.presenter.LoginPresenter;
import group.tmg.view.LoginView;

public class LoginActivity extends BaseActivity<LoginPresenter>
        implements LoginView, View.OnClickListener {

    @Inject
    LoginPresenter presenter;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = super.instantiatePresenter();

        initViews();
    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, "Error: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void navigateToMainScreen() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.bLogin).setOnClickListener(this);
    }

    @Override
    protected LoginPresenter providePresenter() {

        App.getPresenterComponent().inject(this);

        return presenter;
    }

    @Override
    public void onClick(View view) {
        etUsername.setError(null);

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)) { //если имя пользователя пустое - ошибка
            etUsername.setError("required");
            etUsername.requestFocus();
            return;
        }

        presenter.onLoginClicked(username, password);
    }
}
