package com.shameleon.backend.domain.entity

import com.shameleon.backend.domain.base.BaseEntity
import com.shameleon.backend.domain.enums.FieldType
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(
    name = "mock_field",
    uniqueConstraints = [UniqueConstraint(columnNames = ["entity_id", "name"])]
)
class MockField(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", nullable = false)
    val entity: MockEntity,

    @NotBlank
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    var type: FieldType,

    @Size(max = 255)
    @Column(name = "raw_value", nullable = false)
    var rawValue: String,

    @Column(name = "order_index", nullable = false)
    var orderIndex: Int
) : BaseEntity() {

    val actualValue: Any?
        get() = when (type) {
            FieldType.STRING -> rawValue
            FieldType.INTEGER -> rawValue.toInt()
            FieldType.LONG -> rawValue.toLong()
            FieldType.DOUBLE -> rawValue.toDouble()
            FieldType.BOOLEAN -> rawValue.toBoolean()
            FieldType.DATE -> LocalDate.parse(rawValue)
            FieldType.DATETIME -> LocalDateTime.parse(rawValue)
            FieldType.UUID -> UUID.fromString(rawValue)
            else -> rawValue
        }
}
