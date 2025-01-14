import java.lang.RuntimeException
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.div

@ExperimentalPathApi
fun Server.startFromConfiguration(fileLocation: String) {
    val path = Path(fileLocation)

    path / "a"
    val lines = path.toFile().readLines()

    val configuration = try {
        JsonParser().server(lines)
    }
    catch (e: RuntimeException) {
        YamlParser().server(lines)
    }

    Server.withPort(configuration.port)
}

class Server private constructor(port: Int) {
    companion object {
        fun withPort(port: Int): Server {
            return Server(port)
        }
    }
}

interface Parser {

    fun property(prop: String): Property

    fun server(propertyStrings: List<String>): ServerConfiguration

}

class YamlParser : Parser {

    // Implementation specific to YAML files
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        TODO("Not yet implemented")
    }

}

class JsonParser : Parser {

    // Implementation specific to JSON files
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        TODO("Not yet implemented")
    }

}

class Property

class ServerConfiguration {
    var port: Int = 8080
}