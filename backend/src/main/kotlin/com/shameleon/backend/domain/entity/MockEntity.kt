package com.shameleon.backend.domain.entity

import com.shameleon.backend.domain.base.BaseEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(
	name = "mock_entity",
	uniqueConstraints = [UniqueConstraint(columnNames = ["name"])]
)
class MockEntity(
	@NotBlank
	@Size(max = 255)
	@Column(name = "name", nullable = false, unique = true)
	var name: String,

	@Column(name = "description", columnDefinition = "TEXT")
	var description: String? = null
) : BaseEntity() {
	@OneToMany(mappedBy = "entity", cascade = [CascadeType.ALL], orphanRemoval = true)
	val fields: MutableList<MockField> = mutableListOf()
}
