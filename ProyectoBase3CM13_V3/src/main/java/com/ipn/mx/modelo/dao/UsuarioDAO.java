/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kimi
 */
public class UsuarioDAO {
    
    private static final String SQL_INSERT = "insert into usuario (Nombre, Paterno, Materno, email, nombreUsuario, claveUsuario) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update usuario set Nombre = ?, Paterno = ?, Materno = ?, email = ?, nombreUsuario = ?, claveUsuario = ? where idUsuario = ?;";
    private static final String SQL_DELETE = "delete from usuario where idUsuario = ?";
    private static final String SQL_READ = "select idUsuario, Nombre, Paterno, Materno, email, nombreUsuario, claveUsuario from usuario where idUsuario = ?";
    private static final String SQL_READ_ALL = "select idUsuario, Nombre, Paterno, Materno, email, nombreUsuario, claveUsuario from usuario";

    private Connection conexion;
    
    public Connection conectar() {
        String user = "postgres";
        String pwd = "Bowser:7";
        String url = "jdbc:postgresql://localhost:5432/Base3CM13";
        String pgDriver = "org.postgresql.Driver";
        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
    public void create(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombre());
            ps.setString(2, dto.getEntidad().getPaterno());
            ps.setString(3, dto.getEntidad().getMaterno());
            ps.setString(4, dto.getEntidad().getEmail());
            ps.setString(5, dto.getEntidad().getNombreUsuario());
            ps.setString(6, dto.getEntidad().getClaveUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }

        }
    }
    
    public void update(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombre());
            ps.setString(2, dto.getEntidad().getPaterno());
            ps.setString(3, dto.getEntidad().getMaterno());
            ps.setString(4, dto.getEntidad().getEmail());
            ps.setString(5, dto.getEntidad().getNombreUsuario());
            ps.setString(6, dto.getEntidad().getClaveUsuario());
            ps.setInt(7, dto.getEntidad().getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public void delete(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public UsuarioDTO read(UsuarioDTO dto)throws SQLException{
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return (UsuarioDTO)resultados.get(0);
            }else{
                return null;
            }
            
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while(rs.next()){
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsuario(rs.getInt("idusuario"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
            dto.getEntidad().setClaveUsuario(rs.getString("claveUsuario"));
            resultados.add(dto);
        }
        return resultados;
    }
    
     public List readAll()throws SQLException{
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return resultados;
            }else{
                return null;
            }
            
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }
     
     public static void main(String[] args){
        UsuarioDAO dao = new UsuarioDAO();
        
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(2);
        //dto.getEntidad().setNombre("mon");
        //dto.getEntidad().setPaterno("iso");
        //dto.getEntidad().setMaterno("oooo");
        //dto.getEntidad().setEmail("aaaa");
        //dto.getEntidad().setNombreUsuario("jiji");
        //dto.getEntidad().setClaveUsuario("owo");
        
        try{
            //dao.create(dto);
            //dao.update(dto);
            System.out.println(dao.readAll());
            //System.out.println(dao.read(dto));
            //dao.delete(dto);
        }catch(SQLException ex){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    } 
    
}
