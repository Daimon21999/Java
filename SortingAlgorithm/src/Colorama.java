public class Colorama {
    /*
     * ___________ USAGE ___________
     * Colorama.println(Fore.RED, )
     *
     * */

    static class Fore {

        static final String RESET = "\u001B[0m";

        static final String BLACK = "\u001B[30m";
        static final String RED = "\u001B[31m";
        static final String GREEN = "\u001B[32m";
        static final String YELLOW = "\u001B[33m";
        static final String ORANGE = "\u001b[38;5;202m";
        static final String BLUE = "\u001B[34m";
        static final String PURPLE = "\u001B[35m";
        static final String CYAN = "\u001B[36m";
        static final String WHITE = "\u001B[37m";
        static final String BROWN = "\u001B[38;5;94m";
        static final String BOLD = "\u001b[1m";


        static final String BRIGHT_BLACK = "\u001B[90m";
        static final String BRIGHT_RED = "\u001B[91m";
        static final String BRIGHT_GREEN = "\u001B[92m";
        static final String BRIGHT_YELLOW = "\u001B[93m";
        static final String BRIGHT_ORANGE = "\u001b[38;5;208m";
        static final String BRIGHT_BLUE = "\u001B[94m";
        static final String BRIGHT_PURPLE = "\u001B[95m";
        static final String BRIGHT_CYAN = "\u001B[96m";
        static final String BRIGHT_WHITE = "\u001B[97m";

        static final String[] FOREGROUNDS = {
                BLACK, RED, GREEN, YELLOW, ORANGE,
                BLUE, PURPLE, CYAN, WHITE,
                BRIGHT_BLACK, BRIGHT_RED, BRIGHT_GREEN, BRIGHT_YELLOW, BRIGHT_ORANGE,
                BRIGHT_BLUE, BRIGHT_PURPLE, BRIGHT_CYAN, BRIGHT_WHITE, BROWN
        };

    }

    static class Back {
        static final String RESET = "\u001B[0m";

        static final String BLACK = "\u001B[40m";
        static final String RED = "\u001B[41m";
        static final String GREEN = "\u001B[42m";
        static final String YELLOW = "\u001B[43m";
        static final String BLUE = "\u001B[44m";
        static final String PURPLE = "\u001B[45m";
        static final String CYAN = "\u001B[46m";
        static final String WHITE = "\u001B[47m";
        static final String ORANGE = "\u001b[48;5;202m";

        static final String BRIGHT_BLACK = "\u001B[100m";
        static final String BRIGHT_RED = "\u001B[101m";
        static final String BRIGHT_GREEN = "\u001B[102m";
        static final String BRIGHT_YELLOW = "\u001B[103m";
        static final String BRIGHT_BLUE = "\u001B[104m";
        static final String BRIGHT_PURPLE = "\u001B[105m";
        static final String BRIGHT_CYAN = "\u001B[106m";
        static final String BRIGHT_WHITE = "\u001B[107m";
        static final String BRIGHT_ORANGE = "\u001b[48;5;208m";
        static final String[] BACKGROUNDS = {
                BLACK, RED, GREEN, YELLOW, ORANGE,
                BLUE, PURPLE, CYAN, WHITE,
                BRIGHT_BLACK, BRIGHT_RED, BRIGHT_GREEN, BRIGHT_YELLOW, BRIGHT_ORANGE,
                BRIGHT_BLUE, BRIGHT_PURPLE, BRIGHT_CYAN, BRIGHT_WHITE};

        Back() {
        }
    }

    private static String reset = "";
    private static boolean set = false;
    private static String foreColor = "";
    private static String backColor = "";
    private static String Bold = "";

    private static void reset() {
        System.out.print(Fore.RESET);
        Bold = "";
        foreColor = "";
        backColor = "";
    }

    static void print(String... string) {
        reset = "";
        if (!set)
            backColor = "";

        for (String s : string) {
            switch (s) {
                case "set":
                    reset = "";
                    set = true;
                    break;
                case "setBack":
                    reset = "";
                    break;
                case "reset":
                    set = false;
                    reset();
                    break;
                case "resetBold":
                    Bold = "";
                    break;
                case "resetFore":
                    foreColor = "";
                    break;
                case "resetBack":
                    backColor = "";
                    break;
                case "\u001b[1m":
                    Bold = Fore.BOLD;
                    break;
                default:

                    if (s.contains("\u001B[")) {
                        for (String i : Fore.FOREGROUNDS) {
                            if (s.equals(i)) {
                                foreColor = s;
                                break;
                            }
                        }
                        for (String i : Back.BACKGROUNDS) {
                            if (s.equals(i)) {
                                backColor = s;
                                    break;
                            }
                        }
                    } else {
                        System.out.print(Fore.RESET);
                        System.out.print(foreColor + backColor + Bold + reset + s);
                    }
            }

        }

        if (!set) {
            reset();
        }

    }

    static void clear() {
        System.out.print("\u001b[2J");
    }

    static void println(String... string) {
        reset = "";
        for (String s : string) {
            switch (s) {
                case "set": reset = ""; set = true; break;
                case "reset": set = false; reset(); break;
                case "resetBold": Bold = ""; break; case "resetFore":foreColor = ""; break;
                case "resetBack": backColor = ""; break;
                case "\u001b[1m": Bold = Fore.BOLD; break;
                default:
                    if (s.contains("\u001B[")) {
                        for (String i : Fore.FOREGROUNDS) {
                            if (s.equals(i)) { foreColor = s; break; }
                        }
                        for (String i : Back.BACKGROUNDS) {
                            if (s.equals(i)) { backColor = s; break; }
                        }
                    }

                    else {
                        System.out.print(foreColor + backColor + Bold + reset + s);
                    }
            }
        }
        if (!set) { reset(); }
        System.out.println();
    }

    public static void main(String[] args) {
// ____________________________ USAGE ___________________________________________
        println(Fore.BLACK, Fore.BOLD, Back.BRIGHT_GREEN, "DIMA GNII");

        println("set", Fore.CYAN, Fore.BOLD, Back.GREEN, "Permanent text in the SET mode");
        println("In the set mode text doesn't change style");
        println(Fore.RED, "You can change something but the rest remains");
        println("reset", "reset makes default style");
        println("permanently!");
        println("set", Fore.BOLD, Fore.BRIGHT_ORANGE, Back.ORANGE, "for another tips");
        println("resetBack", "you can reset what you want reset[Back, Fore, Bold]");
        println("Also you can put reset or set", "resetFore", " anywhere you want!");
        println("set", Fore.RED, Back.BLACK, "This class provides String array of all available colors for Fore and Back ");
        println("So you can iterate through them... Fore example:");
        println("reset",Fore.BOLD, "\t\t\tFore.FOREGROUNDS", "resetBold");
        for (String f : Fore.FOREGROUNDS) {
            println(f, "Java");
        }
        println(Fore.BOLD, "\t\t\tBack.BACKGROUNDS","resetBold");
        for (String b : Back.BACKGROUNDS) {
            println(b, "Java");
        }
        println(Fore.BOLD, "\t\t\tAnd all combinations", "resetBold");
        int current_back = 0;
        for (String background : Back.BACKGROUNDS) {
            int count2 = 1;
            current_back++;
            for (String foreground : Fore.FOREGROUNDS) {
                if (current_back == count2) {
                    count2++;
                    continue;
                }
                print(background, foreground, "Java");
                count2++;
            }
            System.out.println();
        }
        println("set",Fore.BOLD,"\nEnjoy this Class!!!\nGood Luck!!!\nBye-bye","resetBold");
    }

}

