package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CHARACTER MANAGER SPRINT #2 (TP5) ===");
        
        CharacterManager manager = new CharacterManager();

        // 1. Uji addCharacter & Validasi Duplikat Nama (Bagian A)
        System.out.println("\n--- Pengujian Tambah Karakter & Validasi Duplikat ---");
        Character c1 = new Character("Arthas", CharacterType.WARRIOR, 1, 100, 30, 50);
        Character c2 = new Character("Jaina", CharacterType.MAGE, 2, 80, 45, 120);
        Character c3 = new Character("Arthas", CharacterType.ASSASSIN, 3, 90, 35, 40); // Nama sama (duplikat)

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3); // Seharusnya ditolak oleh sistem

        // 2. Uji findByName dan removeCharacter (Bagian A)
        System.out.println("\n--- Pengujian Pencarian & Penghapusan ---");
        Character found = manager.findByName("Jaina");
        if (found != null) {
            System.out.println("Ditemukan: " + found.getName() + " (" + found.getType() + ")");
        }
        
        manager.removeCharacter("Jaina");
        System.out.println("Total karakter setelah dihapus: " + manager.getTotalCharacters());

        // Kembalikan Jaina untuk pengujian selanjutnya
        manager.addCharacter(c2);

        // 3. Uji Defensive Copy pada getAllCharacters (Bagian A / Eksperimen Halaman 7)
        System.out.println("\n--- Pengujian Defensive Copy ---");
        ArrayList<Character> listAwal = manager.getAllCharacters();
        listAwal.clear(); // Mencoba menghapus list dari luar
        System.out.println("Total karakter di manager setelah list luar di-clear: " + manager.getTotalCharacters()); 
        // Hasil harus tetap 2 karena manager menggunakan defensive copy!

        // 4. Uji Mini-Challenge: getAverageLevel & findByType (Bagian B)
        System.out.println("\n--- Pengujian Mini-Challenge ---");
        System.out.println("Rata-rata level karakter: " + manager.getAverageLevel());
        
        System.out.println("Pencarian berdasarkan tipe MAGE:");
        for (Character c : manager.findByType(CharacterType.MAGE)) {
            System.out.println(" - " + c.getName() + " (Level " + c.getLevel() + ")");
        }

        // 5. Uji Fitur Rancangan Sendiri: findStrongestCharacter (Bagian C)
        System.out.println("\n--- Pengujian Fitur Mandiri (Karakter Terkuat) ---");
        Character strongest = manager.findStrongestCharacter();
        if (strongest != null) {
            System.out.println("Karakter dengan attack terkuat: " + strongest.getName() + " (Attack: " + strongest.getAttackPower() + ")");
        }
    }
}