package com.chriswk.temperatures.data;

import java.time.LocalDateTime;

public class AuthToken {
    String token;
    LocalDateTime expires;
    String refresh_token;
    String error;

    public AuthToken(String error) {
        this.error = error;
    }

    public AuthToken(String token, LocalDateTime expires, String refresh_token) {
        this.token = token;
        this.expires = expires;
        this.refresh_token = refresh_token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthToken authToken = (AuthToken) o;

        if (expires != null ? !expires.equals(authToken.expires) : authToken.expires != null) return false;
        if (refresh_token != null ? !refresh_token.equals(authToken.refresh_token) : authToken.refresh_token != null)
            return false;
        if (token != null ? !token.equals(authToken.token) : authToken.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (expires != null ? expires.hashCode() : 0);
        result = 31 * result + (refresh_token != null ? refresh_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "token='" + token + '\'' +
                ", expires=" + expires +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }
}
