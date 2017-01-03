package xyz.yhsj.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HellospringbootApplication

fun main(args: Array<String>) {
    SpringApplication.run(HellospringbootApplication::class.java, *args)
}
