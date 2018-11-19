public class TestSquare {
    public static void main(String[] args) {
        SquareStack stack = new SquareStack();
        stack.push(new Square(1));
        stack.push(new Square(2));
        stack.push(new Square(3));
        stack.push(new Square(4));
        stack.push(new Square(5));
        stack.push(new Square(6));
        double sum = 0, last = 0;
        while (!stack.isEmpty()){
            Square s = stack.pop();
            sum += s.area();
            last = s.area();
        }
        System.out.println("The sum of the area of all squares are "
                           + sum);
        System.out.println("The last one out is " + last);
    }
}
