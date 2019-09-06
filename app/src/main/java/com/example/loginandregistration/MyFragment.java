package com.example.loginandregistration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends Fragment {
    public static final String TAG = MyFragment.class.getSimpleName();
    private static final int TARGET_FRAGMENT_REQUEST_CODE = 1;
    private static final String EXTRA_GREETING_MESSAGE = "message";

    @BindView(R.id.show_greetings_text_view)
    TextView showGreetingsTextView;

    public static MyFragment getInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    protected void showDialog() {
        MyDialogFragment dialogFragment = MyDialogFragment.getInstance();
        dialogFragment.setTargetFragment(MyFragment.this, TARGET_FRAGMENT_REQUEST_CODE);
        dialogFragment.show(getFragmentManager(), MyDialogFragment.TAG);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode != Activity.RESULT_OK ) {
            return;
        }
        if( requestCode == TARGET_FRAGMENT_REQUEST_CODE ) {
            String greeting = data.getStringExtra(EXTRA_GREETING_MESSAGE);
            showGreetingsTextView.setText(greeting);
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_GREETING_MESSAGE, message);
        return intent;
    }

}
