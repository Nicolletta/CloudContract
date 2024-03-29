package contacts;

import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.HttpMethods
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

Contract.make {
	description("should return all accounts")
	request {
		url("/accounts")
		method GET()
	}
	response {
		status(HttpStatus.OK.value())
		body([[id: 1, name: "Me"]])
		headers {
			contentType(MediaType.APPLICATION_JSON_VALUE)
		}
	}
}