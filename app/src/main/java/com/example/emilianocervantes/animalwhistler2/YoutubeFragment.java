package com.example.emilianocervantes.animalwhistler2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    final private String key = "AIzaSyCRhzfxNUADl6Kq86X8imeu_P8-dlYDLio"; //llave de API Youtube
    private String uri = "diL3y8Fcflk";
    ArrayList<String> listaDeVideos;
    private YouTubePlayer player;

    public YoutubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_youtube, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        youTubePlayerView = (YouTubePlayerView)view.findViewById(R.id.you);
        listaDeVideos.add(uri);
        uri = listaDeVideos.get(0);
        listaDeVideos.remove(0);
        youTubePlayerView.initialize(key, this);
        listaDeVideos = new ArrayList<>();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.player = youTubePlayer;
        Toast.makeText(getActivity(),"Éxito", Toast.LENGTH_LONG).show();
        if(!b){
            youTubePlayer.cueVideo(uri);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getActivity(), "Youtube Error Not Available", Toast.LENGTH_LONG).show();
    }
}
