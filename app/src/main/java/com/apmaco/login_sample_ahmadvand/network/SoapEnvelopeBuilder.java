package com.apmaco.login_sample_ahmadvand.network;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SoapEnvelopeBuilder {
    public static RequestBody build(String encryptedJson) {
        String envelope =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
            + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
            + "<soap:Body>"
            + "<AuthenticateUser xmlns=\"http://apmaco.com/\">"
            + "<data>" + encryptedJson + "</data>"
            + "</AuthenticateUser>"
            + "</soap:Body>"
            + "</soap:Envelope>";

        return RequestBody.create(envelope, MediaType.parse("text/xml; charset=utf-8"));
    }
}