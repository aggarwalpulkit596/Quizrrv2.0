package com.quizrr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {
    //    @POST("users/otpsend")
//    @FormUrlEncoded
//    Call<JsonObject> sendOtp(@Field("contact") String Number);
//
//    @POST("users/otpcheck")
//    @FormUrlEncoded
//    Call<JsonObject> verifyOtp(@Field("contact") String Number, @Field("otp") String opt);
//
//    @POST("users/signin")
//    @FormUrlEncoded
//    Call<User> signin(@Field("contact") String Number, @Field("otp") String opt);
//
//    @Multipart
//    @POST("users/signup")
//    Call<User> signUp(@Part("contact") RequestBody Number, @Part("otp") RequestBody otp, @Part("username") RequestBody username, @Part("referral") RequestBody refcode, @Part MultipartBody.Part image, @Part("email") RequestBody email, @Part("location") RequestBody location, @Part("name") RequestBody name, @Part("standard") RequestBody standard, @Part("stream") RequestBody stream);
//
//    @PUT("users/updateprofile")
//    @FormUrlEncoded
//    Call<JsonObject> updateProfile(@Header("token") String token, @Field("email") String email, @Field("location") String location, @Field("name") String name, @Field("standard") String standard, @Field("stream") String stream);
//
//    @POST("users/validateuser")
//    @FormUrlEncoded
//    Call<JsonObject> validateuser(@Field("username") String username, @Field("referral") String referral);
//
//    @GET("quiz")
//    Call<Quiz> quiz();
//
//    @GET("quiz/quizreview/{quizid}/{number}")
//    Call<ReviewQuiz> revquestion(@Header("token") String token, @Path("quizid") String quizid, @Path("number") int quizno);
//
//    @GET("users/quiz/leaderboard/{quizid}")
//    Call<Leaderboard> leaderboard(@Header("token") String token, @Path("quizid") String quizid);
//
//    @GET("instruction/{quizid}")
//    Call<List<Instruction>> quizinstructions(@Path("quizid") String quizid);
//
//    @GET("users")
//    Call<userfields> user(@Header("token") String token);
//
//    @Multipart
//    @POST("users/changeprofile")
//    Call<JsonObject> changeprofile(@Header("token") String token, @Part MultipartBody.Part image);
//
    @GET("users/learn")
    Call<List<Learn>> learn(@Header("token") String token);
//
//    @GET("quiz/getfutureevnts")
//    Call<List<Quiz>> futureevents(@Header("token") String token);
//
//    @GET("cms")
//    Call<CMS> cms();
//
//    @GET("users/version")
//    Call<JsonObject> version();
//
//    @GET("notification")
//    Call<List<Notification>> notification(@Header("token") String token);
//
//    @GET("notification/markread")
//    Call<JsonObject> markread(@Header("token") String token);


}
