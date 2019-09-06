package com.example.loginandregistration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyDialogFragment extends DialogFragment {
    public static final String TAG = MyDialogFragment.class.getSimpleName();

    @BindView(R.id.edit_text)
    EditText greetingsEditText;

    public static MyDialogFragment getInstance() {
        MyDialogFragment fragment = new MyDialogFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.greet_button)
    protected void sendGreeting() {
        String message = greetingsEditText.getText().toString();
        if( message.isEmpty() ) {
            Toast.makeText(getContext(), "Enter a message", Toast.LENGTH_SHORT).show();
            return;
        }
        sendResult(message);
    }

    private void sendResult(String message) {
        if( getTargetFragment() == null ) {
            return;
        }
        Intent intent = MyFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }
}
