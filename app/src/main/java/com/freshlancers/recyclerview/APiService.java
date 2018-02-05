package com.freshlancers.recyclerview;

/**
 * Created by Leon on 05-02-18.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APiService {

    @GET("/api/people/?format=json")
    Call<Result> getdetails();
}