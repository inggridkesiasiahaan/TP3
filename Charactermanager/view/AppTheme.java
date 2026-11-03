package Charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import com.unpri.charactermanager.model.CharacterType;

public class AppTheme {
    // 3 Warna Utama (Cyberpunk Dark & Neon)
    public static final Color COLOR_BG_MAIN = new Color(15, 15, 25);       // Hitam keunguan pekat
    public static final Color COLOR_CARD_DEFAULT = new Color(25, 25, 40);  // Kartu gelap bertekstur
    public static final Color COLOR_TEXT_GOLD = new Color(0, 255, 204);    // Cyan Neon yang mencolok

    // 3 Font Utama
    public static final Font FONT_TITLE = new Font("Consolas", Font.BOLD, 18);
    public static final Font FONT_REGULAR = new Font("Consolas", Font.PLAIN, 12);
    public static final Font FONT_BOLD = new Font("Consolas", Font.BOLD, 12);

    // 1 Border Utama
    public static final Border BORDER_CARD = BorderFactory.createLineBorder(new Color(0, 255, 204), 1);

    // Method colorFor untuk role (Warna role bergaya neon futuristik)
    public static Color colorFor(CharacterType role) {
        switch (role) {
            case WARRIOR: return new Color(60, 20, 30);   // Merah Neon Gelap
            case MAGE: return new Color(20, 40, 70);      // Biru Neon Gelap
            case ROGUE: return new Color(20, 60, 40);     // Hijau Neon Gelap
            default: return COLOR_CARD_DEFAULT;
        }
    }
}