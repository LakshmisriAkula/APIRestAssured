package Assignments;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Assignment3 {
//	Q.3 Write a test script to verify the authentication process of an API using OAuth 2.0.

	String req_url = "https://api.github.com/user/repos";

	@Test
	public void oAuthTest() {

		String bToken = "Replace Your Github person Access Token";

		Response res = given().auth().oauth2(bToken).when().get(req_url);

		res.then().log().body().statusCode(200)
		.body("name[0]", equalTo("APIRestAssured"));
	}

}
