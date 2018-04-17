package com.example.emilianocervantes.animalwhistler2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//Chatbot
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.emilianocervantes.animalwhistler2.Adapters.ChatbotAdapter;
import com.example.emilianocervantes.animalwhistler2.Models.ChatbotPojo;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Map;

import ai.api.AIDataService;
import ai.api.AIListener;
import ai.api.AIServiceException;

import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class ChatbotFragment extends Fragment implements AIListener {

    private EditText editText;
    private Button button;

    private AIService aiService;
    private AIDataService aiDataService;

    private ChatbotAdapter adapter;
    private ListView lista;

    public ChatbotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chatbot, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lista = (ListView)view.findViewById(R.id.listaMensajesChatbot);
        adapter = new ChatbotAdapter(getActivity(), R.layout.mensaje_chat_layout, new ArrayList<ChatbotPojo>());
        lista.setAdapter(adapter);

        final AIConfiguration config = new AIConfiguration("0ef07f37054047afb19fffd9ff0786a5",
                AIConfiguration.SupportedLanguages.Spanish,
                AIConfiguration.RecognitionEngine.System);

        aiDataService = new AIDataService(config);
        aiService = AIService.getService(this.getContext(), config);
        aiService.setListener(this);

        editText = (EditText)view.findViewById(R.id.messageText);
        button = (Button)view.findViewById(R.id.sendChatButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SendRequestTask(aiDataService).execute(editText.getText().toString());
                editText.setText("");
            }
        });
    }

    public class SendRequestTask extends AsyncTask<String, String, AIResponse>{

        private AIDataService aiDataService;

        public SendRequestTask(AIDataService aiDataService) {
            this.aiDataService = aiDataService;
        }

        @Override
        protected AIResponse doInBackground(String... strings) {
            AIRequest aiRequest = new AIRequest();
            AIResponse aiResponse = null;
            aiRequest.setQuery(strings[0]);
            try {
                aiResponse = aiDataService.request(aiRequest);
            } catch (AIServiceException e) {
                e.printStackTrace();
            }
            return aiResponse;
        }

        @Override
        protected void onPostExecute(AIResponse aiResponse) {
            super.onPostExecute(aiResponse);
            Result result = aiResponse.getResult();
            /*
            textView.append("You: " + result.getResolvedQuery() + "\r\n");
            textView.append("Bot: " + result.getFulfillment().getSpeech() + "\r\n");*/
            ChatbotPojo mensajepersona = new ChatbotPojo("user", result.getResolvedQuery(), 1);
            adapter.add(mensajepersona);
            ChatbotPojo mensajeBot = new ChatbotPojo("bot", result.getFulfillment().getSpeech(), 0);
            adapter.add(mensajeBot);
         }
    }


    @Override
    public void onResult(AIResponse result) {

    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
