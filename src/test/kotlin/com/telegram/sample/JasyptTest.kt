package com.telegram.sample

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class JasyptTest {

    private lateinit var encryptor: PooledPBEStringEncryptor

    @BeforeEach
    fun setUp() {
        encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig().apply {
            setPassword(System.getenv("JASYPT_KEY"))
            setAlgorithm("PBEWithMD5AndDES")
            setKeyObtentionIterations("1000")
            setPoolSize("1")
            setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
            setStringOutputType("base64")
        }
        encryptor.setConfig(config)
    }

    @Test
    fun `암호화 테스트`() {
        val plainText = "my-secret-value"
        val encrypted = encryptor.encrypt(plainText)

        println("암호화 결과: ENC($encrypted)")
        assertNotEquals(plainText, encrypted)
    }

    @Test
    fun `복호화 테스트`() {
        val plainText = "my-secret-value"
        val encrypted = encryptor.encrypt(plainText)
        val decrypted = encryptor.decrypt(encrypted)

        assertEquals(plainText, decrypted)
    }
}
