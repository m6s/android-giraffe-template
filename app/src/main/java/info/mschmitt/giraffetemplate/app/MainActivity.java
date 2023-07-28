package info.mschmitt.giraffetemplate.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import info.mschmitt.giraffetemplate.Calculator;
import info.mschmitt.giraffetemplate.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var binding = ActivityMainBinding.inflate(getLayoutInflater());
        var calculator = new Calculator();
        var text = String.format(Locale.getDefault(), "%d", calculator.ce());
        binding.textView.setText(text);
        setContentView(binding.getRoot());
    }
}