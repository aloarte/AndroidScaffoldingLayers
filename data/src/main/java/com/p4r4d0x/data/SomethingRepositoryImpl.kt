package com.p4r4d0x.data

import com.p4r4d0x.domain.SomethingRepository

class SomethingRepositoryImpl(private val datasource: SomethingDatasource): SomethingRepository {
    override fun doSomething(): Boolean {
        return datasource.doSomething()
    }
}