package com.stmikamik.mahasiswacrud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luminescenents
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;

public class MahasiswaRepository {
 databaseConnector connector = new databaseConnector();
 Connection connection = connector.getConnection();
 

    
//    Connection connection = connector.getConnection();
        
//    public MahasiswaRepository(){
//           try {
//            connector.checkConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    public int addMahasiswa(Mahasiswa mahasiswa){
            String query = "INSERT INTO tb_mahasiswa VALUES (?,?,?,?,?)";
           
            String npm = mahasiswa.getNpm();
            String namaLengkap = mahasiswa.getNamaLengkap();
            String jurusan = mahasiswa.getJurusan();
            String jenisKelamin = mahasiswa.getJenisKelamin();
            String alamat = mahasiswa.getAlamat();
            int RowsAffected = 0;
            
             try {
                connector.checkConnection();
                RowsAffected  = connector.executeQueryDML(
                        query, 
                        npm,
                        namaLengkap,
                        jurusan,
                        jenisKelamin,
                        alamat);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }
//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return RowsAffected;
    }
    
    public int updateMahasiswa(Mahasiswa mahasiswa){
        String query = "UPDATE tb_mahasiswa SET nama=?, jurusan=?,jenis_kelamin=?,alamat=? WHERE npm = ?";
           
            String npm = mahasiswa.getNpm();
            String namaLengkap = mahasiswa.getNamaLengkap();
            String jurusan = mahasiswa.getJurusan();
            String jenisKelamin = mahasiswa.getJenisKelamin();
            String alamat = mahasiswa.getAlamat();
            int RowsAffected = 0;
            
             try {
                connector.checkConnection();
                RowsAffected  = connector.executeQueryDML(
                        query, 
                        namaLengkap,
                        jurusan,
                        jenisKelamin,
                        alamat,
                        npm);
   
            System.out.println("Success Update");

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }
                          return RowsAffected;

    }
    
    public int deleteMahasiswaByNPM(Mahasiswa mahasiswa){
           String query = "DELETE FROM tb_mahasiswa WHERE npm = ?";
           
            String npm = mahasiswa.getNpm();
            

            int RowsAffected=0;
             try {
                connector.checkConnection();
                RowsAffected  = connector.executeQueryDML(
                        query, 
                        npm);
   
            System.out.println("Success Hapus Data");

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }
             
             return RowsAffected;
        
    }
    
    
    public Mahasiswa getMahasiswaByNPM(Mahasiswa mahasiswa){
        String query = "SELECT * FROM tb_mahasiswa WHERE npm = ?";
        String npm = mahasiswa.getNpm();
        
        
        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, 
                    npm);
            
            if(result.next()){
                String namalengkap = result.getString("nama");
                String jurusan = result.getString("jurusan");
                String jenisKelamin = result.getString("jenis_kelamin");
                String alamat = result.getString("alamat");
                
                return new Mahasiswa(npm, namalengkap, jurusan, jenisKelamin, alamat);
            }
            
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
        return null;
    }
    
    public Mahasiswa getMahasiswaByNama(Mahasiswa mahasiswa){
        String query = "SELECT * FROM tb_mahasiswa WHERE nama = ?";
        String namaLengkap = mahasiswa.getNamaLengkap();
        
        
        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, 
                    namaLengkap);
            
            if(result.next()){
                String npm = result.getString("npm");
                String jurusan = result.getString("jurusan");
                String jenisKelamin = result.getString("jenis_kelamin");
                String alamat = result.getString("alamat");
                
                return new Mahasiswa(npm, namaLengkap, jurusan, jenisKelamin, alamat);
            }
            
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
        return null;
    }
    
    public List<Mahasiswa> getAllMahasiswa(){
       List<Mahasiswa> mahasiswaList = new ArrayList<>();
       String query = "SELECT * FROM tb_mahasiswa";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     String npm = result.getString("npm");
                     String namalengkap = result.getString("nama");
                     String jurusan = result.getString("jurusan");
                     String jenisKelamin = result.getString("jenis_kelamin");
                     String alamat = result.getString("alamat");
                     Mahasiswa mahasiswa = new Mahasiswa(npm, namalengkap, jurusan, jenisKelamin, alamat);
                     mahasiswaList.add(mahasiswa);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  mahasiswaList;
    }
    
    
}
