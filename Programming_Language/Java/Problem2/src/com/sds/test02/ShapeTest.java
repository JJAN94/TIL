package com.sds.test02;


public class ShapeTest {

	public static void main(String[] args) {
		
		Shape[] sm = new Shape[6];
		
		sm[0] = new Triangle(7, 5, "Blue");
		sm[1] = new Rectangle(4, 6, "Blue");
		sm[2] = new Triangle(6, 7, "Red");
		sm[3] = new Rectangle(8, 3, "Red");
		sm[4] = new Triangle(9, 8, "White");
		sm[5] = new Rectangle(5, 7, "White");
				
		System.out.println("�⺻����");
		System.out.println();
		String shapeType = null;
		
		for (int i=0;i<sm.length;i++) {
			Shape s = (Shape) sm[i];
			
			if (s instanceof Triangle) {
				shapeType = "Triangle";
			}
			if (s instanceof Rectangle) {
				shapeType = "Rectangle";
			}
			
			System.out.println(shapeType + "\t" + s.getArea() + "\t" + s.getColors());
		}

		System.out.println();
		System.out.println("����� ���� �� ����");
		System.out.println();
		
		//����� 5�� ������ ������ ����ϼ���
	}

}
