/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stmikamik.mahasiswacrud;

import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class NewClass {
    public static void main(String [] args){
        mahasiswaRepository test = new mahasiswaRepository();
        Mahasiswa ariq = new Mahasiswa("369","Muhammad Ariq Faridzki", "TI","Laki","alamat");
        test.addMahasiswa(ariq);
//        test.updateMahasiswa(ariq);
//        test.deleteMahasiswaByNPM(ariq);
//Object ariqss =  test.getMahasiswaByNPM(ariq);
//Object ariqss =  test.getMahasiswaByNama(ariq);
//
//        System.out.println(ariq.getAlamat());
//        System.out.println(ariq.getJenisKelamin

        List<Mahasiswa> daftarMahasiswa = test.getAllMahasiswa();
      
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            Mahasiswa mahasiswa = daftarMahasiswa.get(i);
            // Lakukan sesuatu dengan setiap objek Mahasiswa
            String nim = mahasiswa.getNpm();
            String nama = mahasiswa.getNamaLengkap();
            System.out.println("NIM: " + nim + ", Nama: " + nama);
        }
    }
    
}
