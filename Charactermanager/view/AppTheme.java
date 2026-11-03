package Charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import com.unpri.charactermanager.model.CharacterType;

public class AppTheme {
    // 3 Warna Utama
    public static final Color COLOR_BG_MAIN = new Color(240, 240, 245);
    public static final Color COLOR_CARD_DEFAULT = Color.WHITE;
    public static final Color COLOR_TEXT_GOLD = new Color(218, 165, 32);

    // 3 Font Utama
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 18);
    public static final Font FONT_REGULAR = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font FONT_BOLD = new Font("SansSerif", Font.BOLD, 12);

    // 1 Border Utama
    public static final Border BORDER_CARD = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);

    // Method colorFor untuk role
    public static Color colorFor(CharacterType role) {
        switch (role) {
            case WARRIOR: return new Color(255, 230, 230);
            case MAGE: return new Color(230, 240, 255);
            case ROGUE: return new Color(230, 255, 230);
            default: return COLOR_CARD_DEFAULT;
        }
    }
} 