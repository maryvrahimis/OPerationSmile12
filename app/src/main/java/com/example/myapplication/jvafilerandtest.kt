import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.security.spec.KeySpec
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

object Cryptography {
    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val encoder = Base64.getUrlEncoder().withoutPadding()
        print("Password: ")
        val strPassword = Scanner(System.`in`).nextLine()
        val bSalt = Salt()
        val strSalt = encoder.encodeToString(bSalt) // Byte to String
        println("Salt: $strSalt")
        println("String to be hashed: $strPassword$strSalt")
        val strHash = encoder.encodeToString(Hash(strPassword, bSalt)) // Byte to String
        println("Hashed value (Password + Salt value): $strHash")
    }

    private fun Salt(): ByteArray {
        val random = SecureRandom()
        val salt = ByteArray(6)
        random.nextBytes(salt)
        return salt
    }

    @Throws(
        NoSuchAlgorithmException::class,
        InvalidKeySpecException::class
    )
    private fun Hash(password: String, salt: ByteArray): ByteArray {
        val spec: KeySpec =
            PBEKeySpec(password.toCharArray(), salt, 65536, 128)
        val factory =
            SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        return factory.generateSecret(spec).encoded
    }
}