package com.s10plusArtifacts.sesion

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import com.google.gson.Gson
import com.s10plusArtifacts.utils.PersonalInformation
import android.util.Base64


val Context.dataStore by preferencesDataStore(name = "sessionAmadCore")

// Inicializar Tink para cifrado
object EncryptionManager {
    private const val KEYSET_NAME = "master_keyset_Amad"
    private const val PREF_FILE = "master_key_preference"
    private const val MASTER_KEY_URI = "android-keystore://my_master_key"

    fun getAead(context: Context): Aead {
        try {
            AeadConfig.register() // Registra la configuración de Aead
            val keysetHandle = AndroidKeysetManager.Builder()
                .withSharedPref(context.applicationContext, KEYSET_NAME, PREF_FILE)
                .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
                .withMasterKeyUri(MASTER_KEY_URI)
                .build()
                .keysetHandle

            return keysetHandle.getPrimitive(Aead::class.java)
        } catch (e: Exception) {
            println("Error al inicializar Tink: ${e.message}")
            throw e
        }
    }
}

fun encrypt(context: Context, data: String): String {
    return try {
        val aead = EncryptionManager.getAead(context)
        println("Datos originales: $data")
        val encryptedBytes = aead.encrypt(data.toByteArray(), null)
        val base64Encrypted = Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
        println("Datos cifrados (Base64): $base64Encrypted")
        base64Encrypted
    } catch (e: Exception) {
        println("Error en encrypt: ${e.message}")
        throw e
    }
}


fun decrypt(context: Context, encryptedData: String): String {
    val aead = EncryptionManager.getAead(context)
    return try {
        val decodedBytes = Base64.decode(encryptedData, Base64.DEFAULT)
        aead.decrypt(decodedBytes, null).decodeToString()

    } catch (e: Exception) {
        println("Error al descifrar: ${e.message}")
        "" // Retorna una cadena vacía si falla
    }
}

fun saveEncryptedPersonalInformation(context: Context, personalInfo: PersonalInformation) {
    val gson = Gson()
    val jsonString = gson.toJson(personalInfo) // Convertir objeto a JSON
    val encryptedData = encrypt(context, jsonString) // Cifrar JSON
    runBlocking {
        context.dataStore.edit { preferences ->
            preferences[PERSONALINFO] = encryptedData
        }
    }
}

fun getEncryptedPersonalInformation(context: Context): PersonalInformation? {
    val gson = Gson()
    return runBlocking {
        val encryptedData = context.dataStore.data.map { preferences ->
            preferences[PERSONALINFO]
        }.firstOrNull()

        val decryptedJson = encryptedData?.let { decrypt(context, it) } // Desencriptar JSON
        decryptedJson?.let {
            gson.fromJson(
                it,
                PersonalInformation::class.java
            )
        } // Convertir JSON a objeto
    }
}


val ACTIVEGEOLOCALIZATION = booleanPreferencesKey("ACTIVEGEOLOCALIZATION")
val INTERCEPTORPHONE = booleanPreferencesKey("INTERCEPTORPHONE")
val OFLINE = booleanPreferencesKey("OFLINE")
val SHOWESTATE = booleanPreferencesKey("SHOWESTATE")
val URLANALYTICS = stringPreferencesKey("URLANALYTICS")
val URLSOUND = stringPreferencesKey("URLSOUND")
val STATUS = stringPreferencesKey("STATUS")
val VIEWS = stringPreferencesKey("VIEWS")
val ISFIRSTSESSION = booleanPreferencesKey("ISFIRSTSESSION")
val PHONE = stringPreferencesKey("PHONE")
val CURRENT_PHONE = stringPreferencesKey("CURRENTPHONE")
val LAT = stringPreferencesKey("LAT")
val LNG = stringPreferencesKey("LNG")
val STATE = stringPreferencesKey("STATE")
val SERIAL = stringPreferencesKey("SERIAL")
val TOKENCLICK = stringPreferencesKey("TOKENCLICK")
val PERSONALINFO = stringPreferencesKey("PERSONALINFO")
val WELCOMEVIDEO = stringPreferencesKey("WELCOMEVIDEO")
val IDAPP = stringPreferencesKey("IDAPP")
val ANALITICOPEN = stringPreferencesKey("ANALITICOPEN")


fun Context.AnaliticOpen(): String = runBlocking {
    this@AnaliticOpen.dataStore.data.map { preference ->
        preference[ANALITICOPEN]?.let { decrypt(this@AnaliticOpen,it) }
    }.firstOrNull() ?: ""
}
fun Context.AnaliticOpen(value: String) {
    runBlocking {
        this@AnaliticOpen.dataStore.edit {
            it[ANALITICOPEN] = encrypt(this@AnaliticOpen,value)
        }
    }
}

fun Context.IdApp(): String = runBlocking {
    this@IdApp.dataStore.data.map { preference ->
        preference[IDAPP]?.let { decrypt(this@IdApp, it) }
    }.firstOrNull() ?: ""
}

fun Context.IdApp(value: String) {
    runBlocking {
        this@IdApp.dataStore.edit {
            it[IDAPP] = encrypt(this@IdApp, value)
        }
    }
}

fun Context.PersonalInfo(): PersonalInformation? = getEncryptedPersonalInformation(this)

fun Context.PersonalInfo(value: PersonalInformation) {
    saveEncryptedPersonalInformation(this, value)
}

fun Context.WelcomeVideo(): String = runBlocking {
    this@WelcomeVideo.dataStore.data.map { preference ->
        preference[WELCOMEVIDEO]
    }.firstOrNull() ?: ""
}

fun Context.WelcomeVideo(value: String) {
    runBlocking {
        this@WelcomeVideo.dataStore.edit {
            it[WELCOMEVIDEO] = value
        }
    }
}

fun Context.TokenClick(): String = runBlocking {
    this@TokenClick.dataStore.data.map { preferences ->
        preferences[TOKENCLICK]?.let { decrypt(this@TokenClick, it) }
    }.firstOrNull() ?: ""
}

fun Context.TokenClick(value: String) {
    runBlocking {
        this@TokenClick.dataStore.edit {
            it[TOKENCLICK] = encrypt(this@TokenClick, value)
        }
    }
}

fun Context.Serial(): String = runBlocking {
    this@Serial.dataStore.data.map { preference ->
        preference[SERIAL]
    }.firstOrNull() ?: ""
}

fun Context.Serial(value: String) {
    runBlocking {
        this@Serial.dataStore.edit {
            it[SERIAL] = value
        }
    }
}

fun Context.State(): String = runBlocking {
    this@State.dataStore.data.map { preference ->
        preference[STATE]
    }.firstOrNull() ?: ""
}

fun Context.State(value: String) {
    runBlocking {
        this@State.dataStore.edit {
            it[STATE] = value
        }
    }
}

fun Context.Lng(): String = runBlocking {
    this@Lng.dataStore.data.map { preference ->
        preference[LNG]?.let { decrypt(this@Lng, it) }
    }.firstOrNull() ?: ""
}

fun Context.Lng(value: String) {
    runBlocking {
        this@Lng.dataStore.edit {
            it[LNG] = encrypt(this@Lng, value)
        }
    }
}

fun Context.Lat(): String = runBlocking {
    this@Lat.dataStore.data.map { preference ->
        preference[LAT]?.let { decrypt(this@Lat, it) }
    }.firstOrNull() ?: ""
}

fun Context.Lat(value: String) {
    runBlocking {
        this@Lat.dataStore.edit {
            it[LAT] = encrypt(this@Lat, value)
        }
    }
}

fun Context.CurrentPhone(): String = runBlocking {
    this@CurrentPhone.dataStore.data.map { preference ->
        preference[CURRENT_PHONE]?.let { decrypt(this@CurrentPhone, it) }
    }.firstOrNull() ?: ""
}

fun Context.CurrentPhone(value: String) {
    runBlocking {
        this@CurrentPhone.dataStore.edit {
            it[CURRENT_PHONE] = encrypt(this@CurrentPhone, value)
        }
    }
}

fun Context.Phone(value: String) {
    runBlocking {
        this@Phone.dataStore.edit {
            it[PHONE] = encrypt(this@Phone, value)
        }
    }
}

fun Context.Phone(): String = runBlocking {
    this@Phone.dataStore.data.map { preference ->
        preference[PHONE]?.let { decrypt(this@Phone, it) }
    }.firstOrNull() ?: ""
}

fun Context.Views(value: String) {
    runBlocking {
        this@Views.dataStore.edit {
            it[VIEWS] = encrypt(this@Views, value)
        }
    }
}

fun Context.Views(): String = runBlocking {
    this@Views.dataStore.data.map { preference ->
        preference[VIEWS]?.let { decrypt(this@Views, it) }
    }.firstOrNull() ?: ""
}

fun Context.Status(value: Int) {
    runBlocking {
        this@Status.dataStore.edit {
            it[STATUS] = encrypt(this@Status, value.toString())
        }
    }
}

fun Context.Status(): Int = runBlocking {
    this@Status.dataStore.data.map { preference ->
        preference[STATUS]?.let { decrypt(this@Status, it).toInt() }
    }.firstOrNull() ?: 0
}

fun Context.UrlSound(value: String) {
    runBlocking {
        this@UrlSound.dataStore.edit {
            it[URLSOUND] = encrypt(this@UrlSound, value)
        }
    }
}

fun Context.UrlSound(): String = runBlocking {
    this@UrlSound.dataStore.data.map { preference ->
        preference[URLSOUND]?.let { decrypt(this@UrlSound, it) }
    }.firstOrNull() ?: ""
}

fun Context.UrlAnalytics(value: String) {
    runBlocking {
        this@UrlAnalytics.dataStore.edit {
            it[URLANALYTICS] = value
        }
    }
}

fun Context.UrlAnalytics(): String = runBlocking {
    this@UrlAnalytics.dataStore.data.map { preference ->
        preference[URLANALYTICS]
    }.firstOrNull() ?: ""
}

fun Context.isFirstSession(): Boolean = runBlocking {
    this@isFirstSession.dataStore.data.map { preference ->
        preference[ISFIRSTSESSION]
    }.firstOrNull() ?: true
}

fun Context.isFirstSession(value: Boolean) {
    runBlocking {
        this@isFirstSession.dataStore.edit {
            it[ISFIRSTSESSION] = value
        }
    }
}

fun Context.ShowState(value: Boolean) {
    runBlocking {
        this@ShowState.dataStore.edit {
            it[SHOWESTATE] = value
        }
    }
}

fun Context.ShowState(): Boolean = runBlocking {
    this@ShowState.dataStore.data.map { preference ->
        preference[SHOWESTATE]
    }.firstOrNull() ?: false
}

fun Context.Offline(value: Boolean) {
    runBlocking {
        this@Offline.dataStore.edit {
            it[OFLINE] = value
        }
    }
}

fun Context.Offline(): Boolean = runBlocking {
    this@Offline.dataStore.data.map { preference ->
        preference[OFLINE]
    }.firstOrNull() ?: false
}

fun Context.InterceptorPhone(value: Boolean) {
    runBlocking {
        this@InterceptorPhone.dataStore.edit {
            it[INTERCEPTORPHONE] = value
        }
    }
}

fun Context.InterceptorPhone(): Boolean = runBlocking {
    this@InterceptorPhone.dataStore.data.map { preference ->
        preference[INTERCEPTORPHONE]
    }.firstOrNull() ?: false
}

fun Context.ActiveGeoLocalization(value: Boolean) {
    runBlocking {
        this@ActiveGeoLocalization.dataStore.edit {
            it[ACTIVEGEOLOCALIZATION] = value
        }
    }
}

fun Context.ActiveGeoLocalization(): Boolean = runBlocking {
    this@ActiveGeoLocalization.dataStore.data.map { preference ->
        preference[ACTIVEGEOLOCALIZATION]
    }.firstOrNull() ?: true
}