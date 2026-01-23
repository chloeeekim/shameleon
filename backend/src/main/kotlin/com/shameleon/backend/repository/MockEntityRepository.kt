package com.shameleon.backend.repository

import com.shameleon.backend.domain.entity.MockEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MockEntityRepository : JpaRepository<MockEntity, Long> {
}
