package PronosticoDeportivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProDep {

	public static void main(String[] args) {
		
		System.out.println("Ingrese su Usuario de la Base de Datos");
		Scanner usuario = new Scanner(System.in);
		String user = usuario.next();
		
		System.out.println("Ahora ingrese la contraseña");
		Scanner contraseña = new Scanner(System.in);
		String password = contraseña.next();
		
		System.out.println("Bienvenido a PRONOSTICO DEPORTIVO\n\nA continuacion cada participante debera ingresar su pronostico\n"
				+ "siendo\n'l' GANADOR equipo local\n'v' GANADOR equipo visitante\n'e' para EMPATE.");
		
		try {
			Connection reset = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticodeportivo",
					user, password);
			Statement enCero = reset.createStatement();
			
			String resetPuntos = "update pronosticos set puntos = 0";
			enCero.executeUpdate(resetPuntos);
			
			Statement sql0 = reset.createStatement();
			
			String partido = "select * from partidos";
			ResultSet part = sql0.executeQuery(partido);
			System.out.println("\n");
			while (part.next()) {
				
				System.out.println(part.getString(2).toUpperCase()+"(l) - (e) - (v)"+part.getString(4).toUpperCase()+"\n");
				
				
				Connection connmostr1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticodeportivo",
						user, password);
				Statement sql1 = connmostr1.createStatement();
				
				String particip = "select participante from pronosticos";
				ResultSet mostrar = sql1.executeQuery(particip);
				System.out.println("Ingrese su pronostico para este partido\n");
				while (mostrar.next()) {
				
					System.out.println(mostrar.getString(1));
				
					Statement sql2 = connmostr1.createStatement();
					Scanner pron = new Scanner(System.in);
					String partido1 = "update pronosticos set result"+part.getInt(1)+" = '"+pron.next()+"' where participante = '"+mostrar.getString(1)+"'";
					sql2.executeUpdate(partido1);
				}
				
				System.out.println("Esperemos el resultado real del partido...");
				
				Statement sql = reset.createStatement();
				Scanner resultPart = new Scanner(System.in);
				String result = resultPart.next();
				String gana = "update partidos set resultado = '"+result+"' where partido = "+part.getInt(1);
				sql.executeUpdate(gana);
				if(result.equals("l")||result.equals("v")) {
					System.out.println("\nEl ganador fue el equipo ("+result+")\n\n"
							+ "-----------------------------------");
				} else {
					System.out.println("\nEl resultado fue empate ("+result+")\n\n"
							+ "-----------------------------------");					
				}
				
				Statement sqlS = reset.createStatement();
					
					String suma = "update pronosticos set puntos=(puntos+1) where result"+part.getInt(1)+" = '"+result+"'";
					sqlS.executeUpdate(suma);
					
					String sumaPart = "UPDATE participantes \r\n"
							+ "SET puntosP = (\r\n"
							+ "    SELECT puntos \r\n"
							+ "    FROM pronosticos \r\n"
							+ "    WHERE pronosticos.idP = participantes.idP\r\n"
							+ ")\r\n"
							+ "WHERE participantes.idP IN (1,2,3,4,5,6);";
					sqlS.executeUpdate(sumaPart);
			
			}
			
			Statement puntaje = reset.createStatement();
			String posiciones = "select * from participantes order by puntosP desc";
			ResultSet mostrPuntos = puntaje.executeQuery(posiciones);
			System.out.println("\nTabla de posiciones");
			while(mostrPuntos.next()) {
				System.out.println(mostrPuntos.getString(4)+"\t"+mostrPuntos.getString(2)+" "+mostrPuntos.getString(3));
			}
			Statement partFinal = reset.createStatement();
			String partidos = "select * from partidos";
			ResultSet mostrParFin = partFinal.executeQuery(partidos);
			System.out.println("\nTodos los partidos finalizados\n");
			while(mostrParFin.next()) {
				System.out.println(mostrParFin.getInt(1)+"\t"+mostrParFin.getString(2).toUpperCase()+" vs "+mostrParFin.getString(4).toUpperCase()
						+"  RESULTADO ("+mostrParFin.getString(3)+")");
	  }
			catch (Exception e) {
				System.out.println("La conexion no pudo realizarse");
				e.printStackTrace();
			}
        
	  }
	
}
