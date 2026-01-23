package com.shameleon.backend.domain.enums

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

enum class HttpStatusCode(val code: Int) {
	// 2xx Success
	OK(200),
	CREATED(201),
	ACCEPTED(202),
	NO_CONTENT(204),
    RESET_CONTENT(205),

	// 3xx Redirection
	MOVED_PERMANENTLY(301),
	FOUND(302),
    SEE_OTHER(303),
	NOT_MODIFIED(304),

	// 4xx Client Error
	BAD_REQUEST(400),
	UNAUTHORIZED(401),
	FORBIDDEN(403),
	NOT_FOUND(404),
	METHOD_NOT_ALLOWED(405),
	CONFLICT(409),
	TOO_MANY_REQUESTS(429),

	// 5xx Server Error
	INTERNAL_SERVER_ERROR(500),
	BAD_GATEWAY(502),
	SERVICE_UNAVAILABLE(503),
	GATEWAY_TIMEOUT(504);

	companion object {
        private val cache = entries.associateBy { it.code }

		fun fromCode(code: Int): HttpStatusCode? = cache[code]
	}
}

@Converter(autoApply = true)
class HttpStatusCodeConverter : AttributeConverter<HttpStatusCode, Int> {
    override fun convertToDatabaseColumn(attribute: HttpStatusCode?): Int? {
        return attribute?.code
    }

    override fun convertToEntityAttribute(dbData: Int?): HttpStatusCode? {
        return dbData?.let { HttpStatusCode.fromCode(it) }
    }
}