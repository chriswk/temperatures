package com.chriswk.temperatures.netatmo;

import javax.inject.Named;

import com.chriswk.temperatures.data.AuthToken;
import com.chriswk.temperatures.data.MeasureResponse;
import feign.Headers;
import feign.RequestLine;

public interface NetAtmo {
    @RequestLine("POST /oauth2/token")
    @Headers("Content-type: application/x-www-form-urlencoded")
    AuthToken auth(@Named("client_id") String client_id, @Named("client_secret") String client_secret, @Named("grant_type") String grant_type, @Named("username") String username, @Named("password") String password, @Named("scope") String scope);

    @RequestLine("GET /api/getmeasure?access_token={token}&device_id={device_id}&type={type}&scale={scale}&date_begin={date_begin}")
    MeasureResponse getMeasure(@Named("token") String accessToken,
                               @Named("device_id") String device_id,
                               @Named("scale") String scale,
                               @Named("type") String type,
                               @Named("date_begin") long date_begin);

}
