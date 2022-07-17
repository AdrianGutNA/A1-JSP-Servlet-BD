package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.Alumnos;
import coneccion.ConexionMySQL;

public class DAOAlumno {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Alumnos alumno;
    
    public ArrayList mostrar() throws ClassNotFoundException
    {
        ArrayList<Alumnos>list= new ArrayList<>();
        String sql="SELECT * FROM alumnos";
        try{
            con = ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                alumno=new Alumnos("","","","",0,0,0,0.0);
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                alumno.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                alumno.setDdi(rs.getInt("Ddi"));
                alumno.setDwi(rs.getInt("Dwi"));
                alumno.setEcbd(rs.getInt("Ecbd"));
                alumno.promedio();
                list.add(alumno);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        }catch(SQLException e){}
        
        return list;
    }
    
    public boolean agregar(Alumnos alumno)
    {
        return true;
    }
    
    public boolean editar(Alumnos alumno, String old)
    {
        return true;
    }
    
    public boolean eliminar(String matricula)
    {
        return true;
    }
    
    public Alumnos buscar(String matricula)
    {
        return new Alumnos("","","","",0,0,0,0.0);
    }
}

