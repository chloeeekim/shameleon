package com.shameleon.backend.repository

import com.shameleon.backend.domain.entity.MockEndpoint
import com.shameleon.backend.domain.enums.HttpMethod
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MockEndpointRepository : JpaRepository<MockEndpoint, Long> {
}
