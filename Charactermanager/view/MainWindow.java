package Charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterManager manager;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #3 (GUI)");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menggunakan BorderLayout untuk tata letak utama
        setLayout(new BorderLayout(10, 10));

        // Judul di bagian atas
        JLabel titleLabel = new JLabel("Daftar Karakter Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // Panel tengah untuk daftar karakter (menggunakan BoxLayout secara vertikal)
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Data Dinamis: Melakukan perulangan (loop) untuk menampilkan semua karakter
        for (Character c : manager.getAllCharacters()) {
            JLabel charLabel = new JLabel("• " + c.getName() + " [" + c.getType() + "] - Level: " + c.getLevel());
            charLabel.setFont(new Font("Arial", Font.PLAIN, 13));
            charLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            listPanel.add(charLabel);
            listPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Jarak antar baris
        }

        // Membungkus listPanel dengan JScrollPane agar bisa di-scroll jika datanya banyak
        JScrollPane scrollPane = new JScrollPane(listPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Mini-Challenge: JLabel statistik "Rata-rata Level" di bagian bawah
        double avgLevel = calculateAverageLevel();
        JLabel statsLabel = new JLabel("Statistik - Rata-rata Level Karakter: " + String.format("%.2f", avgLevel), JLabel.CENTER);
        statsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        statsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statsLabel, BorderLayout.SOUTH);
    }

    // Method pembantu untuk menghitung rata-rata level
    private double calculateAverageLevel() {
        if (manager.getAllCharacters().isEmpty()) return 0.0;
        int total = 0;
        for (Character c : manager.getAllCharacters()) {
            total += c.getLevel();
        }
        return (double) total / manager.getAllCharacters().size();
    }
}
