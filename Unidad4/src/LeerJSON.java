import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LeerJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();
	}

	public static void leer() {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("usuarios.json")) {
			Object obj = jsonParser.parse(reader);

			JSONArray usuariosArray = (JSONArray) obj;
			System.out.println("json: " + usuariosArray);
			for (Object usuario : usuariosArray) {
				mostrar((JSONObject) usuario);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void mostrar(JSONObject jsonObject) {
		JSONObject usuario = (JSONObject) jsonObject.get("usuario");
		System.out.println("Usuario: ");

		String nombreString = (String) usuario.get("nombre");
		System.out.println("Nombre: " + nombreString);

		String correoString = (String) usuario.get("correo");
		System.out.println("Correo: " + correoString);

		String claseString = (String) usuario.get("clase");
		System.out.println("Clase: " + claseString);

	}

	public static void guardar() {

		JSONObject telefono1 = new JSONObject();
		telefono1.put("nombre", "Juan");

		JSONObject telefono2 = new JSONObject();
		telefono2.put("nombre", "Juan");

		JSONArray telefonoArray = new JSONArray();
		telefonoArray.add(telefono1);
		telefonoArray.add(telefono2);

		JSONObject usuario1 = new JSONObject();
		usuario1.put("nombre", "Juan");
		usuario1.put("correo", "henry@uabcs");
		usuario1.put("clase", "Programacion");

		JSONObject usuario2 = new JSONObject();
		usuario2.put("nombre", "Armando");
		usuario2.put("correo", "armando@uabcs");
		usuario2.put("clase", "Estructura de datos");

		JSONObject datos_usuario1 = new JSONObject();
		datos_usuario1.put("usuario", usuario1);

		JSONObject datos_usuario2 = new JSONObject();
		datos_usuario2.put("usuario", usuario2);

		JSONArray lista_usuario = new JSONArray();
		lista_usuario.add(datos_usuario1);
		lista_usuario.add(datos_usuario2);

		try (FileWriter fileWriter = new FileWriter("usuarios.json")) {
			fileWriter.write(lista_usuario.toJSONString());
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
