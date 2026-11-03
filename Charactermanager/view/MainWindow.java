package Charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterManager manager;
    
    // Konstanta untuk batas level Mini-Challenge (Bagian B)
    private static final int HIGHER_LEVEL_THRESHOLD = 5;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #4 (Themed)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menggunakan BorderLayout untuk tata letak utama
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(AppTheme.COLOR_BG_MAIN);

        // Judul di bagian atas menggunakan AppTheme
        JLabel titleLabel = new JLabel("Daftar Karakter Game", JLabel.CENTER);
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Panel tengah untuk daftar karakter (menggunakan BoxLayout secara vertikal)
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        listPanel.setBackground(AppTheme.COLOR_BG_MAIN);

        // Data Dinamis: Melakukan perulangan (loop) untuk menampilkan semua karakter
        for (Character c : manager.getAllCharacters()) {
            // Membuat panel kecil/kartu per karakter agar setOpaque dan colorFor berfungsi optimal
            JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            cardPanel.setOpaque(true); // Wajib agar background panel terlihat
            cardPanel.setBackground(AppTheme.colorFor(c.getType()));
            cardPanel.setBorder(AppTheme.BORDER_CARD);
            cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Properti Tambahan 1: Tooltip detail informasi karakter
            cardPanel.setToolTipText("Role: " + c.getType() + " | Level: " + c.getLevel());

            JLabel charLabel = new JLabel("• " + c.getName() + " [" + c.getType() + "] - Level: " + c.getLevel());
            
            // Mini-Challenge: Level >= 5 tampil dengan teks emas dan tebal menggunakan konstanta
            if (c.getLevel() >= HIGHER_LEVEL_THRESHOLD) {
                charLabel.setFont(AppTheme.FONT_BOLD);
                charLabel.setForeground(AppTheme.COLOR_TEXT_GOLD);
            } else {
                charLabel.setFont(AppTheme.FONT_REGULAR);
            }

            cardPanel.add(charLabel);
            
            listPanel.add(cardPanel);
            listPanel.add(Box.createRigidArea(new Dimension(0, 8))); // Jarak antar baris
        }

        // Membungkus listPanel dengan JScrollPane agar bisa di-scroll jika datanya banyak
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Statistik di bagian bawah menggunakan AppTheme
        double avgLevel = calculateAverageLevel();
        JLabel statsLabel = new JLabel("Statistik - Rata-rata Level Karakter: " + String.format("%.2f", avgLevel), JLabel.CENTER);
        statsLabel.setFont(AppTheme.FONT_BOLD);
        statsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statsLabel, BorderLayout.SOUTH);

        // Mengganti setSize statis dengan pack() agar ukuran jendela menyesuaikan komponen secara rapi
        pack();
        
        // Atur ukuran minimum atau pastikan jendela tidak terlalu kecil saat pertama kali dibuka
        setMinimumSize(new Dimension(420, 350));
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