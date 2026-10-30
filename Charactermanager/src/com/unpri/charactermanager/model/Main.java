package com.unpri.charactermanager.model;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CHARACTER MANAGER SPRINT #1 ===");

        // Membuat 3 karakter awal (Bagian A)
        Character char1 = new Character("Arthas", CharacterType.WARRIOR, 1, 100, 20, 30);
        Character char2 = new Character("Jaina", CharacterType.MAGE, 1, 80, 25, 100);
        
        // Membuat 1 karakter baru untuk pengujian ekstensi mana & isAlive (Bagian B)
        Character char3 = new Character("Sylvanas", CharacterType.ARCHER, 2, 90, 22, 60);

        // Menampilkan output karakter awal
        System.out.println("\nDaftar Karakter Awal:");
        System.out.println(char1);
        System.out.println(char2);
        System.out.println(char3);

        // Demo Level Up
        System.out.println("\n--- Demo Level Up untuk " + char1.getName() + " ---");
        char1.levelUp();
        System.out.println(char1);

        // Demo Status Hidup (isAlive)
        System.out.println("\n--- Pengujian Status Hidup (isAlive) ---");
        System.out.println(char2.getName() + " masih hidup? " + char2.isAlive());

        // Simulasi karakter HP habis (mati)
        char2.setHitPoints(0);
        System.out.println("Setelah HP menjadi 0, " + char2.getName() + " masih hidup? " + char2.isAlive());
        System.out.println(char2);

        // Pengujian Exception Validasi Mana Negatif (Bagian B)
        try {
            System.out.println("\n--- Pengujian Validasi Mana ---");
            Character testChar = new Character();
            testChar.setMana(-10); // Seharusnya melempar IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Berhasil menangkap error validasi: " + e.getMessage());
        }
    }
}