package com.stmikamik.mahasiswacrud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luminescenents
 * 
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mahasiswa {
    
    private String npm;
    private String namaLengkap;
    private String jurusan;
    private String jenisKelamin;
    private String alamat;

    // Constructor
    public Mahasiswa(String npm, String namaLengkap, String jurusan, String jenisKelamin, String alamat) {
        this.npm = npm;
        this.namaLengkap = namaLengkap;
        this.jurusan = jurusan;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }
    
    public Mahasiswa(String npm, String namaLengkap) {
        this.npm = npm;
        this.namaLengkap = namaLengkap;
    }

    // Getters and Setters
    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    

}

//    public static void main(String[] args){
//        databaseConnector connector = new databaseConnector();
//        Connection connection = connector.getConnection();
//        
//      
//            try {
//                connector.checkConnection();
//                String query = "SELECT * FROM tb_tindakan";
//                ResultSet resultSet = connector.executeQueryRead(query);
//                
//                while (resultSet.next()){
//                    String id = resultSet.getString("id_plgr_tindakan");
//                    String tindakan = resultSet.getString("tindakan");
//
//            // Process the retrieved data
//                  System.out.println("ID: " + id + "\n, tindakan : " + tindakan);
//                }
//           // Close resource
//           connector.closeResultSet(resultSet);
//           
//            } catch (SQLException e) {
//               e.printStackTrace();
//               
//            } finally {
//                connector.closeConnection();
//        }
//            
    
    

