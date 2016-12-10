package com.hxp.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hxp.mvpdemo.R;
import com.hxp.mvpdemo.bean.UserBean;
import com.hxp.mvpdemo.presenter.IUserPresenter;
import com.hxp.mvpdemo.presenter.UserPresenterImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IUserView{

    private EditText nameEditText, sexEditText, signEditText;
    private Button mSaveButton;
    private IUserPresenter mUserPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        mUserPresenter = new UserPresenterImpl(this);
        mSaveButton.setOnClickListener(this);
    }

    private void findViews() {
        nameEditText = (EditText) findViewById(R.id.name_edt);
        sexEditText = (EditText) findViewById(R.id.sex_edt);
        signEditText = (EditText) findViewById(R.id.sign_edt);
        mSaveButton = (Button) findViewById(R.id.saveButton);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mUserPresenter.showUserInfo(getId());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveButton:
                mUserPresenter.saveUserInfo(new UserBean(getId(),getName(),getSex(),getSign()));
                break;
        }
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return nameEditText.getText().toString();
    }

    @Override
    public void setName(String name) {
         nameEditText.setText(name);
    }

    @Override
    public String getSex() {
        return sexEditText.getText().toString();
    }

    @Override
    public void setSex(String sex) {
        sexEditText.setText(sex);
    }

    @Override
    public String getSign() {
        return signEditText.getText().toString();
    }

    @Override
    public void setSign(String sign) {
        signEditText.setText(sign);
    }

    @Override
    public void showProcess() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProcess() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
