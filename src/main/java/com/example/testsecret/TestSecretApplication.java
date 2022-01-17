package com.example.testsecret;

import com.openshift.restclient.ClientBuilder;
import com.openshift.restclient.IClient;
import com.openshift.restclient.ResourceKind;
import com.openshift.restclient.model.IResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class TestSecretApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSecretApplication.class, args);
		testApi();
	}

	public static void testApi() {
		IClient client = new ClientBuilder("https://console-openshift-console.apps.sandbox.x8i5.p1.openshiftapps.com/api-resource/ns/stalko-dev/core~v1~Secret/").withUserName("***")
				.withPassword("***")
				.build();

		client.getAuthorizationContext().setToken("***");

		IResource request = client.getResourceFactory().stub(ResourceKind.SECRET, "test-secret");
		Map<String, String> metadata = request.getMetadata();
		Stream.of(metadata).forEach(System.out::println);
		//IProject project = (IProject) client.create(request);
	}
}
