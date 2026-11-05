package mx.itson.devops.descuento;
import java.util.Map;

public class Handler {
   private final Descuento descuento = new Descuento();
    private final String version = System.getenv().getOrDefault("APP_VERSION", "local");
   @SuppressWarnings("unchecked")
   public Map<String, Object> handleRequest(Map<String, Object> event) {
       // 1. Leer el evento (botón Test, o la URL del navegador)
       Map<String, Object> datos = event;
       if (event.get("queryStringParameters") instanceof Map) {
           datos = (Map<String, Object>) event.get("queryStringParameters");
       }
       int unidades = Integer.parseInt(datos.get("unidades").toString());
       long precio = Long.parseLong(datos.get("precioCentavos").toString());
       // 2. Llamar a la lógica que ya tenían (Descuento.java no cambia)
       int porcentaje = descuento.porcentaje(unidades);
       long total = descuento.totalCentavos(precio, unidades);
       // 3. Regresar la respuesta: Lambda la convierte a JSON
           return Map.of("unidades", unidades, "porcentaje", porcentaje,
               "totalCentavos", total, "version", version);
   }
}