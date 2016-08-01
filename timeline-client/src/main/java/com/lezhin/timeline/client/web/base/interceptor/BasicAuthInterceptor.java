package com.lezhin.timeline.client.web.base.interceptor;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.Charset;

public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

	private String username;
	private String password;

	public BasicAuthInterceptor(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		String auth = new StringBuilder().append(username).append(":").append(password).toString();
		byte[] authBytes = Base64.encodeBase64(auth.getBytes(Charset.defaultCharset()));
		String authHeader = "Basic " + new String(authBytes);
		request.getHeaders().add("Authorization", authHeader);
		return execution.execute(request, body);
	}

}
