package ca.acculizer.darkstarportal.security;

import ca.acculizer.darkstarportal.model.Account;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Francois Dickey on 2016-01-19.
 */
public class Token implements JsonSerializable {
    private String token;
    private int expiryMs;
    private int expireInMs;
    private Account account;

    public Token(Account account, int expiryMs) {
        this.token = UUID.randomUUID().toString();
        this.expiryMs = expiryMs;
        this.expireInMs = expiryMs;
        this.account = account;
    }


    public String getToken() {
        return token;
    }

    public int getExpiryMs() {
        return expiryMs;
    }

    public void kickExpiry() {
        expireInMs = expiryMs;
    }

    public boolean expires(int elapsed) {
        expireInMs -= elapsed;

        //Expires if this goes below zero
        return expireInMs <= 0;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("token", getToken());
        gen.writeObjectField("account", getAccount());
        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(gen, serializers);
    }
}
