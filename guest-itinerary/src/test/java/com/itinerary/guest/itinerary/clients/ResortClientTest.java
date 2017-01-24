/*package com.itinerary.guest.itinerary.clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.easymock.EasyMock;
import org.hibernate.engine.jdbc.ReaderInputStream;
import org.junit.Test;

public class ResortClientTest {

	@Test
	public void test1() throws Exception {

		ResortClient resortClient = new ResortClient();

		HttpClient httpClient = EasyMock.createMock(HttpClient.class);

		resortClient.setHttpClient(httpClient);

		HttpResponse httpResponse = EasyMock.createMock(HttpResponse.class);

		StatusLine statusLine = EasyMock.createMock(StatusLine.class);
		
		HttpEntity httpEntity=EasyMock.createMock(HttpEntity.class);
		
		StringReader reader=new StringReader("hi this is deepika");
		InputStream inputStream = new ReaderInputStream(reader);
		
		EasyMock.expect(statusLine.getStatusCode()).andReturn(200);

		EasyMock.expect(httpResponse.getStatusLine()).andReturn(statusLine);
		
		EasyMock.expect(httpResponse.getEntity()).andReturn(httpEntity);
		
		EasyMock.expect(httpEntity.getContent()).andReturn(inputStream);
		
		EasyMock.expect(httpClient.execute(EasyMock.anyObject(HttpGet.class))).andReturn(httpResponse);
		
		EasyMock.replay(statusLine, httpResponse, httpClient,httpEntity);

		resortClient.getResort(5l);
	}

	@Test
	public void test2() throws ClientProtocolException, IOException {

		ResortClient resortClient = new ResortClient();

		HttpClient httpClient = EasyMock.createMock(HttpClient.class);

		resortClient.setHttpClient(httpClient);

		HttpResponse httpResponse = EasyMock.createMock(HttpResponse.class);

		StatusLine statusLine = EasyMock.createMock(StatusLine.class);
		
		HttpEntity httpEntity=EasyMock.createMock(HttpEntity.class);
		
		StringReader reader=new StringReader("hi this is deepika");
		InputStream inputStream = new ReaderInputStream(reader);
		
		EasyMock.expect(statusLine.getStatusCode()).andReturn(200);

		EasyMock.expect(httpResponse.getStatusLine()).andReturn(statusLine);
		
		EasyMock.expect(httpResponse.getEntity()).andReturn(httpEntity);
		
		EasyMock.expect(httpEntity.getContent()).andReturn(inputStream);
		
		EasyMock.expect(httpClient.execute(EasyMock.anyObject(HttpGet.class))).andThrow(new ClientProtocolException());
		
		EasyMock.replay(statusLine, httpResponse, httpClient,httpEntity);

		resortClient.getResort(3l);
	}
	
	@Test
	public void test3() throws ClientProtocolException, IOException {

		ResortClient resortClient = new ResortClient();

		HttpClient httpClient = EasyMock.createMock(HttpClient.class);

		resortClient.setHttpClient(httpClient);

		HttpResponse httpResponse = EasyMock.createMock(HttpResponse.class);

		StatusLine statusLine = EasyMock.createMock(StatusLine.class);
		
		HttpEntity httpEntity=EasyMock.createMock(HttpEntity.class);
		
		StringReader reader=new StringReader("hi this is deepika");
		InputStream inputStream = new ReaderInputStream(reader);
		
		EasyMock.expect(statusLine.getStatusCode()).andReturn(200);

		EasyMock.expect(httpResponse.getStatusLine()).andReturn(statusLine);
		
		EasyMock.expect(httpResponse.getEntity()).andReturn(httpEntity);
		
		EasyMock.expect(httpEntity.getContent()).andReturn(inputStream);
		
		EasyMock.expect(httpClient.execute(EasyMock.anyObject(HttpGet.class))).andThrow(new IOException());
		
		EasyMock.replay(statusLine, httpResponse, httpClient,httpEntity);

		resortClient.getResort(3l);
	}
	
	@Test(expected=AssertionError.class)
	public void test4() throws Exception {

		ResortClient resortClient = new ResortClient();

		HttpClient httpClient = EasyMock.createMock(HttpClient.class);

		resortClient.setHttpClient(httpClient);

		HttpResponse httpResponse = EasyMock.createMock(HttpResponse.class);

		StatusLine statusLine = EasyMock.createMock(StatusLine.class);
		
		HttpEntity httpEntity=EasyMock.createMock(HttpEntity.class);
		
		StringReader reader=new StringReader("hi this is deepika");
		InputStream inputStream = new ReaderInputStream(reader);
		
		EasyMock.expect(statusLine.getStatusCode()).andReturn(400);

		EasyMock.expect(httpResponse.getStatusLine()).andReturn(statusLine);
		
		EasyMock.expect(httpResponse.getEntity()).andReturn(httpEntity);
		
		EasyMock.expect(httpEntity.getContent()).andReturn(inputStream);
		
		EasyMock.expect(httpClient.execute(EasyMock.anyObject(HttpGet.class))).andReturn(httpResponse);
		
		EasyMock.replay(statusLine, httpResponse, httpClient,httpEntity);

		resortClient.getResort(3l);
	}
}
*/