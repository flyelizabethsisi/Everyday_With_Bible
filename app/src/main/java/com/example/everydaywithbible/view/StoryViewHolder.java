package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.fragment.DetailFragment;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryData;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.network.APIService;
import com.example.everydaywithbible.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class StoryViewHolder extends RecyclerView.ViewHolder {
    private TextView titleFragmentTextView;

    private FragmentInterface fragmentInterface;
    private DetailAdapter detailAdapter;
    private StoryData storyData;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private static final String TAG = "DetailFragment";

    public StoryViewHolder(@NonNull View itemView) {
        super(itemView);
        titleFragmentTextView = itemView.findViewById(R.id.story_title_textView);
    }

    public void onBind(final StoryKey story, FragmentInterface fragmentInterface) {
        titleFragmentTextView.setText(story.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (story.getAccounts().size() != 0) {

                    for (StoryValue storyValue : story.getAccounts()) {
                        fragmentInterface.toDetailFragment(storyValue.getTitle(), storyValue.getAuthor(), storyValue.getBible_ref(), storyValue.getUrl());
                    }
                }
            }
        });
    }
}

//                    for(StoryValue storyValue: storyKey.getAccounts()) {
//                        fragmentInterface.toDetailFragment(storyValue.getTitle());

//                    recyclerView = itemView.findViewById(R.id.detail_recycler_view);
//
//                    final Retrofit retrofit = RetrofitSingleton.getInstance();
//                    Log.d(TAG, "onViewCreated: " + retrofit.toString());
//
//                    APIService apiService = retrofit.create(APIService.class);
//
//                    Log.d(TAG, "onViewCreated: apiservice" + apiService.toString() );
//                    Observable<StoryResponse> responseCall = apiService.getStoryList();
//
//                    Log.d(TAG, "onViewCreated: responsecall" + responseCall.toString());
//
//                    responseCall.subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Consumer<StoryResponse>() {
//                                @Override
//                                public void accept(StoryResponse response) throws Exception {
////                        TitleFragment.this.accept(storyData1);
//
//                                    Log.d(TAG, response.getData().getStoryTitleList().get(0).getTitle() );
//                                    storyList = response.getData().getStoryTitleList();
//                                    detailAdapter = new DetailAdapter(fragmentInterface,storyList);
//                                    recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
//                                    recyclerView.setAdapter(detailAdapter);
//
//                                }
//                            }, new Consumer<Throwable>() {
//                                @Override
//                                public void accept(Throwable throwable) throws Exception {
//
//                                    Log.d(TAG, "?"+ throwable.getMessage());
//
//                                }
//                            });
//
//
//
//                }
//
//
//                }
//
//        });


//                                            if(story.getAccounts().size() ==2){
//                                                fragmentInterface.toDetailFragment(story.getAccounts().get(0).getTitle(), story.getAccounts().get(0).getBible_ref(), story.getAccounts().get(0).getAuthor(), story.getAccounts().get(0).getUrl(), story.getAccounts().get(1).getTitle(), story.getAccounts().get(1).getBible_ref(), story.getAccounts().get(1).getAuthor(),story.getAccounts().get(1).getUrl());
//                                            }

//                                    }
//
//        );
//
//    }
//
//            ;
//
//            }
