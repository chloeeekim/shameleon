package com.shameleon.backend.repository

import com.shameleon.backend.domain.entity.MockResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MockResponseRepository : JpaRepository<MockResponse, Long> {
}
