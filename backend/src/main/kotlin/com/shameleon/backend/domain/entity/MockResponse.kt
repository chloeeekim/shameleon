package com.shameleon.backend.domain.entity

import com.shameleon.backend.domain.base.BaseEntity
import com.shameleon.backend.domain.enums.HttpStatusCode
import com.shameleon.backend.domain.enums.HttpStatusCodeConverter
import jakarta.persistence.*

@Entity
@Table(name = "mock_response")
class MockResponse(
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endpoint_id", nullable = false)
	val endpoint: MockEndpoint,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entity_id")
	var entity: MockEntity? = null,

	@Column(name = "response_data", columnDefinition = "jsonb")
	var responseData: String? = null,

	@Convert(converter = HttpStatusCodeConverter::class)
	@Column(name = "status_code", nullable = false)
	var statusCode: HttpStatusCode = HttpStatusCode.OK
) : BaseEntity()
