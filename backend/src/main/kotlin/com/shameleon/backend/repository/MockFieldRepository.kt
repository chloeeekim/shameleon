package com.shameleon.backend.repository

import com.shameleon.backend.domain.entity.MockField
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MockFieldRepository : JpaRepository<MockField, Long> {
}
