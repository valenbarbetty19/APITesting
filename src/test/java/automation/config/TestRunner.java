package automation.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Esta clase carga la configuración del ambiente antes de correr la test suite
@Slf4j
public class TestRunner {

    //PROPERTIES_FILE Ruta del archivo de configuración
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    //PROPERTIES: se usa para cargar los valores de la configuración
    private static final Properties PROPERTIES = new Properties();

    //BaseURL para las solicitudes
    @Getter
    private static String baseurl;

    //Inicializa el ambiente de pruebas antes de ejecutar la test suite - Carga el archivo de propiedades
    @BeforeSuite
    public void setupEnvironment() {
        loadProperties();
        baseurl = PROPERTIES.getProperty("url.base");
    }

    //Carga los valores de configuración del archivo de propiedades
    private void loadProperties() {
        try {
            FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE);
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
