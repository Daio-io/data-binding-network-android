package io.daio.triviabinding.Trivia;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import io.daio.triviabinding.BR;

public class TriviaViewModel extends BaseObservable {

    @Bindable private String question;
    @Bindable private String answer;
    public static ObservableArrayList<String> options = new ObservableArrayList<>();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
        notifyPropertyChanged(BR.question);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        notifyPropertyChanged(BR.answer);
    }

    public void addOption(String option, int position) {
        options.add(position, option);
    }
}
