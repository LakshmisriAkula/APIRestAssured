package Authorization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth_Authentication {

	String req_url = "https://api.github.com/user/repos";

	@Test
	public void oAuthTest() {

		String bToken = "Replace Your Github person Access Token";
		
		Response res = given().auth().oauth2(bToken).when().get(req_url);
		
		res.then().log().body().statusCode(200)
		.body("name[0]", equalTo("APIRestAssured"));
		
	}

}
