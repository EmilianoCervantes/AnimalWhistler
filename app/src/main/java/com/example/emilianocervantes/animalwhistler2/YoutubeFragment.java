package com.example.emilianocervantes.animalwhistler2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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
public class YoutubeFragment extends Fragment {

    //private YouTubePlayerView youTubePlayerView;
    final private String key = "AIzaSyCRhzfxNUADl6Kq86X8imeu_P8-dlYDLio"; //llave de API Youtube
    private String uri = "diL3y8Fcflk";
    /*ArrayList<String> listaDeVideos;
    private YouTubePlayer player;*/

    public YoutubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_youtube, container, false);
        View view = inflater.inflate(R.layout.fragment_youtube, container, false);
        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.you_layout, youTubePlayerSupportFragment).commit();

        youTubePlayerSupportFragment.initialize(key, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Toast.makeText(getActivity(),"Éxito", Toast.LENGTH_LONG).show();
                if(!b){
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.loadVideo(uri);
                    youTubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("Error message", errorMessage);
            }
        });
        return view;
    }
}
