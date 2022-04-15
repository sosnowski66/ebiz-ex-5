package com.example

interface HelloService {
    fun sayHello(): String
}

class HelloServiceImpl(val helloRepository: HelloRepository): HelloService {
    override fun sayHello(): String = "Hello ${helloRepository.getHello()}!"
}