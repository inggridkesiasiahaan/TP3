package com.unpri.charactermanager.model;

import Charactermanager.view.MainWindow;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CHARACTER MANAGER SPRINT #2 & #3 ===");
        
        CharacterManager manager = new CharacterManager();

        // 1. Uji addCharacter & Validasi Duplikat (Bagian A - TP5)
        Character c1 = new Character("Arthas", CharacterType.WARRIOR, 10, 100, 30, 50);
        Character c2 = new Character("Jaina", CharacterType.MAGE, 10, 80, 45, 120);
        Character c3 = new Character("Arthas", CharacterType.ASSASSIN, 5, 90, 35, 40); // Duplikat nama (ditolak)
        
        // 2 Karakter Baru untuk Sprint #3 (Total minimal 5 karakter)
        Character c4 = new Character("Legolas", CharacterType.ARCHER, 12, 85, 40, 60);
        Character c5 = new Character("Gimli", CharacterType.WARRIOR, 9, 120, 35, 20);

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3); // Ditolak
        manager.addCharacter(c4);
        manager.addCharacter(c5);

        // Uji Defensive Copy
        ArrayList<Character> listAwal = manager.getAllCharacters();
        listAwal.clear(); 
        System.out.println("Total karakter aman (Defensive Copy aktif): " + manager.getTotalCharacters()); 

        // Jalankan GUI MainWindow di Event Dispatch Thread (EDT) untuk TP8 / Sprint #3
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow(manager);
                window.setVisible(true);
            }
        });
    }
}