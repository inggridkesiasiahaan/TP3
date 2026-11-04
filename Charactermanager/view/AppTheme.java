package Charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import com.unpri.charactermanager.model.CharacterType;

public class AppTheme {
    // MODIFIKASI: Mengubah warna latar utama sedikit lebih gelap/kehijauan agar kentara bedanya
    public static final Color COLOR_BG_MAIN = new Color(230, 235, 245);
    public static final Color COLOR_CARD_DEFAULT = Color.WHITE;
    
    // MODIFIKASI: Warna teks gold dibuat sedikit lebih terang dan mencolok
    public static final Color COLOR_TEXT_GOLD = new Color(255, 215, 0);

    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 18);
    public static final Font FONT_REGULAR = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font FONT_BOLD = new Font("SansSerif", Font.BOLD, 12);

    // MODIFIKASI: Border card dibuat sedikit lebih tebal (2 pixel)
    public static final Border BORDER_CARD =
            BorderFactory.createLineBorder(new Color(150, 170, 200), 2);

    public static Color colorFor(CharacterType role) {
        if (role == null) {
            return COLOR_CARD_DEFAULT;
        }

        switch (role) {
            case WARRIOR:
                return new Color(255, 210, 210); // Warna merah muda lebih pekat
            case MAGE:
                return new Color(210, 230, 255); // Warna biru lebih pekat
            case ARCHER:
                return new Color(255, 235, 180); // Warna kuning/oranye lebih pekat
            case ASSASSIN:
                return new Color(255, 210, 235);
            case ROGUE:
                return new Color(210, 255, 210);
            default:
                return COLOR_CARD_DEFAULT;
        }
    }
}