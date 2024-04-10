package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ModeloTareas extends Conector {
	
	 public ArrayList<Tarea> getTareas() {
	        ArrayList<Tarea> tareas = new ArrayList<>();

	        try {
	            Statement st = conexion.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM tareas");
	            while (rs.next()) {
	                Tarea tarea = new Tarea();
	                tarea.setId(rs.getInt("id"));
	                tarea.setTitulo(rs.getString("titulo"));
	                tarea.setDescripcion(rs.getString("descripcion"));

	                tareas.add(tarea);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return tareas;
	    }

}
