public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[4];

        figures[0] = new Circle(5);
        figures[1] = new Triangle(3, 4, 5);
        figures[2] = new Rectangle(4, 6);
        figures[3] = new Square(4);

        for (int i = 0; i < figures.length; i++) {
            System.out.println("Фигура " + (i + 1) + " - Площадь: " + figures[i].getArea() + ", Периметр: " + figures[i].getPerimeter());
        }
    }
}