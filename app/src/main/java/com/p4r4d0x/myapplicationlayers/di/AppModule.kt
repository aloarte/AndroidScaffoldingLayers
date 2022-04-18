package com.p4r4d0x.myapplicationlayers

import com.p4r4d0x.data.SomethingDatasource
import com.p4r4d0x.data.SomethingDatasourceImpl
import com.p4r4d0x.data.SomethingRepositoryImpl
import com.p4r4d0x.domain.GetSomethingUseCase
import com.p4r4d0x.domain.SomethingRepository
import com.p4r4d0x.myapplicationlayers.viewmodel.SomethingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { SomethingViewModel(get()) }
}
val repositoriesModule = module {
    factory<SomethingRepository> { SomethingRepositoryImpl(get()) }
}

val useCasesModule = module {
    factory { GetSomethingUseCase(get()) }
}

val dataSourcesModule = module {
    factory<SomethingDatasource> { SomethingDatasourceImpl() }

}