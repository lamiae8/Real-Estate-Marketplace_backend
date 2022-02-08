package openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTHENTICATION-SERVICE")
public interface userRestClient {
	
	@GetMapping(value = "/api/auth/getid")
	String getUserId(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

}
