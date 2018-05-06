package code.growth.error;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * 尽量不要传递 null 值
 */
public class NotNull {

    // 如果传入 null 值就完蛋了
    public double xProduce(Point p1, Point p2) {
        return (p1.getX() - p2.getX()) * 1.5;
    }

    // 针对 null 的抛出
    public double xProduce1(Point p1, Point p2) throws InvalidArgumentException {
        if(p1 == null || p2 == null) {
            throw new InvalidArgumentException(new String[]{"Invalid argument."});
        }
        return (p1.getX() - p2.getX()) * 1.5;
    }

    // 使用断言的方式处理 null
    public double xProduce2(Point p1, Point p2) {
        assert p1 != null : "p1 should not be null.";
        assert p2 != null : "p2 should not be null.";
        return (p1.getX() - p2.getX()) * 1.5;
    }

    public static void main(String[] args) {

        Point p1 = new Point(1.2, 1.0);
        Point p2 = new Point(4.5, 9.0);

        double val = new NotNull().xProduce(p1, p2);
        System.out.println(val);

        try{
            double val1 = new NotNull().xProduce1(p1, p2);
            System.out.println(val1);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

        double val2 = new NotNull().xProduce2(null, p2);
        System.out.println(val2);
    }
}
