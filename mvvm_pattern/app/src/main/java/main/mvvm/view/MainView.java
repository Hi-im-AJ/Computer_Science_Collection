package main.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import main.mvvm.R;
import main.mvvm.viewModel.MainViewModel;

public class MainView extends AppCompatActivity {
    private final MainViewModel mainViewModel = new MainViewModel(MainView.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView headerTextView = findViewById(R.id.header);
        headerTextView.setText(mainViewModel.getHeader());

        observeMainViewModel();
    }

    private void observeMainViewModel() {
        mainViewModel.addObserver((o, arg) -> {
            String header = ((MainViewModel) o).getHeader();
            TextView headerTextView = findViewById(R.id.header);
            headerTextView.setText(header);
        });
    }

    public void editText(View view) {
        EditText inputField = findViewById(R.id.inputField);
        String input = inputField.getText().toString();
        mainViewModel.setHeader((!input.equals("")) ? input : " ");
    }
}