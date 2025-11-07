package com.muhammadfairuzdzaki.frontend;

public class ShapeFactory {

    private final ShapePool pool;

    public ShapeFactory(ShapePool pool) {
        this.pool = pool;
    }

    public Shape createShape(String type) {
        Shape shape = pool.obtain(type);

        if (shape == null) {
            if (type.equals("Circle")) {
                shape = new Circle();
            } else if (type.equals("Square")) {
                shape = new Square();
            }
        }
        return shape;
    }
}
