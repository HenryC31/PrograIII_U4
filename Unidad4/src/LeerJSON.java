import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LeerJSON {
	static boolean si = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();
	}

	public static boolean leer(String usu, String contra) {
		si = false;
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("usuarios.json")) {
			Object obj = jsonParser.parse(reader);

			JSONArray usuariosArray = (JSONArray) obj;
			System.out.println("json: " + usuariosArray);
			for (Object usuario : usuariosArray) {
				if (evaluar((JSONObject) usuario, usu, contra)) {
					si = true;
					return si;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return si;
	}

	public static boolean evaluar(JSONObject json, String usu, String contra) {
		JSONObject usuario = (JSONObject) json.get("usuario");
//		System.out.println("Usuario: ");
		if (usu.equals((String) usuario.get("usu")) && contra.equals((String) usuario.get("contra"))) {
//			System.out.println("Si jala");
			return true;
		} else {
//			System.out.println("No jala");
			return false;
		}
//
////		String nombreString = (String) usuario.get("nombre");
//		System.out.println("Nombre: " + (String) usuario.get("nombre"));
//
////		String correoString = (String) usuario.get("correo");
//		System.out.println("Usuario: " + (String) usuario.get("usu"));
//
////		String claseString = (String) usuario.get("clase");
//		System.out.println("Contraseña: " + (usuario.get("contra")));
	}

	public static void mostrar(JSONObject jsonObject) {
		JSONObject usuario = (JSONObject) jsonObject.get("usuario");
		System.out.println("Usuario: ");

//		String nombreString = (String) usuario.get("nombre");
		System.out.println("Nombre: " + (String) usuario.get("nombre"));

//		String correoString = (String) usuario.get("correo");
		System.out.println("Usuario: " + (String) usuario.get("usu"));

//		String claseString = (String) usuario.get("clase");
		System.out.println("Contraseña: " + (usuario.get("contra")));

	}

	public static void guardar() {

		JSONObject usuario1 = new JSONObject();
		usuario1.put("nombre", "Henry");
		usuario1.put("usu", "henryc22");
		usuario1.put("contra", "hola123");

		JSONObject usuario2 = new JSONObject();
		usuario2.put("nombre", "Armando");
		usuario2.put("usu", "armando33");
		usuario2.put("contra", "adios123");

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
