package io.daio.triviabinding.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import io.daio.triviabinding.App;
import io.daio.triviabinding.Trivia.TriviaService;
import io.daio.triviabinding.databinding.FragmentTriviaBinding;
import io.daio.triviabinding.Trivia.TriviaViewModel;

public class TriviaFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TriviaViewModel model;
    private TriviaService triviaService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentTriviaBinding binding = FragmentTriviaBinding.inflate(inflater, container, false);
        model = new TriviaViewModel();
        triviaService = new TriviaService();
        binding.setViewModel(model);
        binding.setListener(new Listener());

        return binding.getRoot();

    }

    @Override
    public void onStart() {
        super.onStart();
        triviaService.requestQuestion(model);
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (model.getAnswer().equals(((Button) v).getText().toString())) {
                triviaService.requestQuestion(model);
            } else {
                Toast.makeText(App.getAppContext(), "Incorrect, try again", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
