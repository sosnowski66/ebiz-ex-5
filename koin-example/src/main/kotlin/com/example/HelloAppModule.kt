package com.example

import org.koin.dsl.module

val helloAppModule = module(createdAtStart = true) {
    single {HelloServiceImpl(get()) as HelloService}
    single {HelloRepository()}
}