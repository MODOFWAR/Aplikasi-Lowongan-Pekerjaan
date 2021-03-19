/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowonganPekerjaan;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MODOFWAR
 */
public class Pelamar {
    private List<BerkasLamaran> daftarBerkas = new ArrayList();
    private String idPelamar;
    private int nBerkas= 0;
    private String nama;
    private int usia;
    private long nohp;
 
    public Pelamar(String nama, String idPelamar){
        this.nama = nama;
        setIdPelamar(idPelamar); 
    }
	
    //membuat berkas
    public void createBerkas(String id,String jenisBerkas, String tglMsk){
        BerkasLamaran b = new BerkasLamaran(id,jenisBerkas, tglMsk);//mengambil constructor BerkasLamaran dengan sejumlah parameter
	daftarBerkas.add(b); 
        nBerkas++;//menambah sejumlah n berkas      
    }
    
    public String getNamaOrang() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public long getNohp() {
        return nohp;
    }

    public void setNohp(long nohp) {
        this.nohp = nohp;
    }
    
    public void setIdPelamar(String idPelamar){
        this.idPelamar= idPelamar;
    }
    
    public String getIdPelamar(){
        return this.idPelamar;
    }
    
    public BerkasLamaran getBerkas(int index){
        return this.daftarBerkas.get(index);
    }
    
    //mengembalika berkas dengan paramaeter String
    public BerkasLamaran getBerkas(String id){
        for (int i=0; i< nBerkas; i++){
		if(id.equalsIgnoreCase(this.daftarBerkas.get(i).getIdBerkas())) {//memeriksa jika nama pada indeks berkas sama dengan parameter
			return daftarBerkas.get(i);// akan mengembalikan indeks berkas
                }
        }
        return null;
    }
    
    
    //mencari suatu lowongan sesuai paramater String

   public int getnBerkas(){
        return nBerkas;
    }
    
    public void display() {
        System.out.println();
        System.out.println("Id Pelamar              : "+getIdPelamar());
        System.out.println("Nama                    : "+getNamaOrang());
    }
    
    
}
