enum Color
{
    RED('r'),
    BLUE('b'),
    GREEN('g'),
    YELLOW('y'),
    PINK('p'),
    ORANGE('o');

    private char keyword;

    private Color(char keyword) {
        this.keyword = keyword;
    }

    public static Color valueOf(char character)
    {
        for (Color color: Color.values()) {
            if (color.keyword == character) {
                return color;
            }
        }
        return null;
    }

    public char getColor() {
        return this.keyword;
    }
}