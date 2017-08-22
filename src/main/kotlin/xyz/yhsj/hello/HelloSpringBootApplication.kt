package xyz.yhsj.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloSpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(HelloSpringBootApplication::class.java, *args)
}
