package io.daio.triviabinding.Trivia;

import android.support.annotation.NonNull;

import java.util.List;

import io.daio.trivapiclient.OnFailureListener;
import io.daio.trivapiclient.OnSuccessListener;
import io.daio.trivapiclient.TrivapiClient;
import io.daio.trivapiclient.TrivapiException;
import io.daio.trivapiclient.TrivapiRequest;
import io.daio.trivapiclient.TrivapiResult;
import io.daio.triviabinding.networking.TriviaNetworkClient;

public class TriviaService {

    private TrivapiClient client;
    private TrivapiRequest request;

    public TriviaService() {
        this.client = new TrivapiClient("", new TriviaNetworkClient(), null);
        this.request = new TrivapiRequest().withParam("amount", "1");
    }

    public void requestQuestion(final TriviaViewModel model) {

        client.makeRequest(request, new OnSuccessListener() {
            @Override
            public void onSuccess(String url, @NonNull List<TrivapiResult> results) {
                TrivapiResult result = results.get(0);
                model.setQuestion(result.getQuestion());
                model.setAnswer(result.getAnswer());
                List<String> options = result.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    model.addOption(options.get(i), i);
                }
            }
        }, new OnFailureListener() {
            @Override
            public void onFailure(String url, TrivapiException e) {
                System.out.println(e.getLocalizedMessage());
            }
        });

    }

}
