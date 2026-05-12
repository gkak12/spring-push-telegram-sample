package com.telegram.sample.config

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableEncryptableProperties
class JasyptConfig {

    @Bean("jasyptEncryptor")
    fun stringEncryptor(): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig().apply {
            setPassword(System.getenv("JASYPT_KEY"))
            setAlgorithm("PBEWithMD5AndDES")
            setKeyObtentionIterations("1000")
            setPoolSize("1")
            setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
            setStringOutputType("base64")
        }
        encryptor.setConfig(config)
        return encryptor
    }
}
