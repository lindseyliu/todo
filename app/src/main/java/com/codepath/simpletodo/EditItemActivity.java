package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditItemActivity extends AppCompatActivity {
    @BindView(R.id.etTask)
    EditText mEtTask;

    String newContent;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        ButterKnife.bind(this);
        String taskContent = getIntent().getStringExtra("task");
        pos = getIntent().getIntExtra("pos", 0);
        mEtTask.setText(taskContent);

    }

    public void onEditItem(View v) {
        newContent = mEtTask.getText().toString();
        Intent i = new Intent();
        i.putExtra("new_task", newContent);
        i.putExtra("pos", pos);
        setResult(RESULT_OK, i);
        finish();
    }
}
