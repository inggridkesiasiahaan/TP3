package com.unpri.charactermanager.model;

import java.util.ArrayList;
public class CharacterManager {
    private ArrayList<Character> characters;

    // Constructor
    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    // 1. addCharacter() dengan validasi nama duplikat (Bagian A)
    public boolean addCharacter(Character newChar) {
        for (Character c : characters) {
            if (c.equals(newChar)) {
                System.out.println("Gagal menambahkan: Karakter dengan nama '" + newChar.getName() + "' sudah ada!");
                return false;
            }
        }
        characters.add(newChar);
        System.out.println("Berhasil menambahkan karakter: " + newChar.getName());
        return true;
    }

    // 2. findByName() (Bagian A)
    public Character findByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // 3. removeCharacter() (Bagian A)
    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characters.remove(c);
            System.out.println("Karakter '" + name + "' berhasil dihapus.");
            return true;
        }
        System.out.println("Karakter '" + name + "' tidak ditemukan untuk dihapus.");
        return false;
    }

    // 4. getTotalCharacters() (Bagian A)
    public int getTotalCharacters() {
        return characters.size();
    }

    // 5. getAllCharacters() dengan Defensive Copy (Bagian A & Halaman 7)
    public ArrayList<Character> getAllCharacters() {
        // Mengembalikan salinan (new ArrayList) agar list asli aman dari modifikasi luar
        return new ArrayList<>(this.characters);
    }

    // --- MINI-CHALLENGE (Bagian B) ---

    // 1. getAverageLevel() dengan edge case list kosong
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }
        int totalLevel = 0;
        for (Character c : characters) {
            totalLevel += c.getLevel();
        }
        return (double) totalLevel / characters.size();
    }

    // 2. findByType() mengembalikan ArrayList karakter sesuai tipe
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    // --- FITUR ANALITIK RANCANGAN SENDIRI (Bagian C) ---

    /**
     * Mencari karakter dengan Attack Power paling tinggi di dalam manager.
     * @return Objek Character terkuat, atau null jika list kosong.
     */
    public Character findStrongestCharacter() {
        if (characters.isEmpty()) return null;
        
        Character strongest = characters.get(0);
        for (Character c : characters) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }
        return strongest;
    }
}