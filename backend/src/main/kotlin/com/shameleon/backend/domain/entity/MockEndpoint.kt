package com.shameleon.backend.domain.entity

import com.shameleon.backend.domain.base.BaseEntity
import com.shameleon.backend.domain.enums.HttpMethod
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(
	name = "mock_endpoint",
	uniqueConstraints = [UniqueConstraint(columnNames = ["path", "http_method"])]
)
class MockEndpoint(
	@NotBlank
	@Size(max = 500)
	@Column(name = "path", nullable = false)
	var path: String,

	@Enumerated(EnumType.STRING)
	@Column(name = "http_method", nullable = false)
	var httpMethod: HttpMethod,

	@Column(name = "description", columnDefinition = "TEXT")
	var description: String? = null
) : BaseEntity() {
	@OneToMany(mappedBy = "endpoint", cascade = [CascadeType.ALL], orphanRemoval = true)
	val responses: MutableList<MockResponse> = mutableListOf()
}
