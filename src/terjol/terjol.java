// MOTHERFUKCING TERJOL WHAT THE FUCK

package terjol;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class terjol {
    static public String __cblack = "\u001b[30m";
    static public String __cred = "\u001b[31m";
    static public String __cgreen = "\u001b[32m";
    static public String __cyellow = "\u001b[33m";
    static public String __cblue = "\u001b[34m";
    static public String __cmagenta = "\u001b[35m";
    static public String __ccyan = "\u001b[36m";
    static public String __cwhite = "\u001b[37m";
    static public String __cgray = "\u001b[0;90m";
    static public String __cbgblack = "\u001b[40m";
    static public String __cbgred = "\u001b[41m";
    static public String __cbggreen = "\u001b[42m";
    static public String __cbgyellow = "\u001b[43m";
    static public String __cbgblue = "\u001b[44m";
    static public String __cbgmagenta = "\u001b[45m";
    static public String __cbgcyan = "\u001b[46m";
    static public String __cbgwhite = "\u001b[47m";
    static public String __cbggray = "\u001b[0;100m";
    static public String __sbold = "\u001b[1m";
    static public String __sitalic = "\u001b[3m";
    static public String __sblink = "\u001b[5m";
    static public String __sanotherblink = "\u001b[6m";  // I dunno what the difference between 5m and 6m is but they both blink so I'm adding this just in case someone needs it
    static public String __sfadedout = "\u001b[2m";
    static public String __sunderlined = "\u001b[4m";
    static public String __sinverted = " \u001b[7m";
    static public String __endcolor = "\u001b[0m";
    // i fuckiung cant focus on coding this "terjol" is too funny asjdhgkjsadgh

    public static String rgb(int r, int g, int b, String str) {
        return "\u001b[38;2;" + Integer.toString(r) + ";" + Integer.toString(g) + ";" + Integer.toString(b) + "m" + str + __endcolor; /* jetbrains why are you so stupid
        "unnecessary" my ass IT'LL FUCKING NOT WORK IF I REMOVE THAT SHIT WHAT DO YOU FUCKING MEAN FUCKING IDIoT */
    }

    public static String bgrgb(int r, int g, int b, String str) {
        return "\u001b[48;2;" + Integer.toString(r) + ";" + Integer.toString(g) + ";" + Integer.toString(b) + "m" + str + __endcolor;
    }

    /**
     * Pass in an integer for the color. You can use hex colors with this if you dont put it in a string and replace the # with 0x.
     */
    public static String dec(int color, String str) {
        String hex_repr = String.format("%06X", color); // thank you random answer on stack overflow
        String hex_p1 = hex_repr.substring(0, 2);
        String hex_p2 = hex_repr.substring(2, 4);
        String hex_p3 = hex_repr.substring(4, 6);
        return rgb(Integer.parseInt(hex_p1, 16), Integer.parseInt(hex_p2, 16), Integer.parseInt(hex_p3, 16), str);
    }

    /**
     * Pass in an integer for the color. You can use hex colors with this if you dont put it in a string and replace the # with 0x.
     */
    public static String bgdec(int color, String str) {
        String hex_repr = String.format("%06X", color); // thank you random answer on stack overflow
        String hex_p1 = hex_repr.substring(0, 2);
        String hex_p2 = hex_repr.substring(2, 4);
        String hex_p3 = hex_repr.substring(4, 6);
        return bgrgb(Integer.parseInt(hex_p1, 16), Integer.parseInt(hex_p2, 16), Integer.parseInt(hex_p3, 16), str);
    }

    public static String hsv(double h, double s, double v, String str) {
        double[] to_rgb = hsv_to_rgb(h, s, v);
        return rgb((int) to_rgb[0], (int) to_rgb[1], (int) to_rgb[2], str);
    }

    public static String bghsv(double h, double s, double v, String str) {
        double[] to_rgb = hsv_to_rgb(h, s, v);
        return bgrgb((int) to_rgb[0], (int) to_rgb[1], (int) to_rgb[2], str);
    }

    public static String black(String str) {
        // it's all downhill from here
        return __cblack + str + __endcolor;
    }

    public static String red(String str) {
        return __cred + str + __endcolor;
    }

    public static String green(String str) {
        return __cgreen + str + __endcolor;
    }

    public static String yellow(String str) {
        return __cyellow + str + __endcolor;
    }

    public static String blue(String str) {
        return __cblue + str + __endcolor;
    }

    public static String magenta(String str) {
        return __cmagenta + str + __endcolor;
    }

    public static String cyan(String str) {
        return __ccyan + str + __endcolor;
    }

    public static String white(String str) {
        return __cwhite + str + __endcolor;
    }

    public static String gray(String str) {
        return __cgray + str + __endcolor;
    }

    public static String rainbowtext(String str) {
        // the worst feature here
        String formedstr = "";
        int i = 0;
        int mi;
        char[] ignore = {' ', '\t', '\n', '\r'};
        int[] colors = {0xF33444, 0xFF8901, 0xFAD716, 0x00BA70, 0x00C0DD, 0x00408A, 0x5E2779};
        for (char chr : str.toCharArray()) { // thank you random 15 year old stackoverflow answer
            if (new String(ignore).indexOf(chr) != -1) {
                formedstr += chr; // no i dont wanna convert it to a StringBuilder that shit broke it
                continue;
            }
            mi = i % 7;
            formedstr += dec(colors[mi], Character.toString(chr));
            i++;
        }
        return formedstr;
    }

    public static String bgrainbowtext(String str) {
        String formedstr = "";
        int i = 0;
        int mi;
        char[] ignore = {' ', '\t', '\n', '\r'};
        int[] colors = {0xF33444, 0xFF8901, 0xFAD716, 0x00BA70, 0x00C0DD, 0x00408A, 0x5E2779};
        int[] fgcolors = {0, 0, 0, 0, 0, 0xFFFFFF, 0xFFFFFF};
        for (char chr : str.toCharArray()) { // thank you random 15 year old stackoverflow answer
            mi = i % 7;
            formedstr += bgdec(colors[mi], dec(fgcolors[mi], Character.toString(chr)));
            i++;
        }
        return formedstr;
    }

    // thought that was it? nope!!!! :3

    public static String bgblack(String str) {
        return __cbgblack + str + __endcolor;
    }

    public static String bgred(String str) {
        return __cbgred + str + __endcolor;
    }

    public static String bggreen(String str) {
        return __cbggreen + str + __endcolor;
    }

    public static String bgyellow(String str) {
        return __cbgyellow + str + __endcolor;
    }

    public static String bgblue(String str) {
        return __cbgblue + str + __endcolor;
    }

    public static String bgmagenta(String str) {
        return __cbgmagenta + str + __endcolor;
    }

    public static String bgcyan(String str) {
        return __cbgcyan + str + __endcolor;
    }

    public static String bgwhite(String str) {
        return __cbgwhite + str + __endcolor;
    }

    public static String bggray(String str) {
        return __cbggray + str + __endcolor;
    }

    // still not it!!!!!!!!!!11

    public static String bold(String str) {
        return __sbold + str + __endcolor;
    }

    public static String italic(String str) {
        return __sitalic + str + __endcolor;
    }

    public static String blink(String str) {
        return __sblink + str + __endcolor;
    }

    public static String anotherblink(String str) {
        return __sanotherblink + str + __endcolor;
    }

    public static String fadedout(String str) {
        return __sfadedout + str + __endcolor;
    }

    public static String underlined(String str) {
        return __sunderlined + str + __endcolor;
    }

    public static String inverted(String str) {
        return __sinverted + str + __endcolor;
    }

    /**
     * port of python colorsys.hsv_to_rgb that doesn't take args in 0.0-1.0 values and doesn't return 0.0-1.0 values
     *
     * @param h a double from 0.0 to 360.0
     * @param s a double from 0.0 to 100.0
     * @param v a double from 0.0 to 100.0
     * @return an array of 3 doubles from 0.0 to 255.0
     */
    private static double[] hsv_to_rgb(double h, double s, double v) {
        h /= 360;
        s /= 100;
        v /= 100;

        if (s == 0.0) {
            return new double[]{v * 255, v * 255, v * 255};
        }

        double i = (int) (h * 6.0);
        double f = h * 6.0 - i;
        double p = v * (1.0 - s);
        double q = v * (1.0 - s * f);
        double t = v * (1.0 - s * (1.0 - f));
        i %= 6;
        if (i == 0) {
            return new double[]{v * 255, t * 255, q * 255};
        }
        if (i == 1) {
            return new double[]{q * 255, v * 255, p * 255};
        }
        if (i == 2) {
            return new double[]{p * 255, v * 255, t * 255};
        }
        if (i == 3) {
            return new double[]{p * 255, q * 255, v * 255};
        }
        if (i == 4) {
            return new double[]{t * 255, p * 255, v * 255};
        }
        if (i == 5) {
            return new double[]{v * 255, p * 255, q * 255};
        }
        return new double[]{0.0, 0.0, 0.0}; // intellij i swear to god one of the checks is literally guaranteed to fucking trigger what the fuck is wrong with you
    }

    // ok we're done
}