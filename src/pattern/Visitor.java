package pattern;

/**
 * This class is based on the information provided at sourcemaking.com/design_patterns/visitor
 * 
 * The visitor pattern is a way to add external functionality to a set of elements. It is most
 * useful when there are several classes with different interfaces and we want to encapsulate how
 * we get our data from them. It accomplishes this by removing the functionality from the elements
 * and capturing it in it's own object. The only thing that needs to be implemented in our
 * elements is a small "universal method adaptor" function called "accept". This allows us to have
 * complex functionality, while ensuring that our objects remain lightweight. 
 * 
 * The visitor pattern requires us to have a stable element hierarchy with sufficient public
 * interfaces otherwise the work of keeping the visitors up to date will become to cumbersome
 * or the pattern will break down completely if it has insufficient access privileges.
 */
public class Visitor {
	public static void main(String args) {
		
		Visitor v = new Visitor();

		Element[] elements = new Element[2];
		elements[0] = v.new ConcreteElementA();
		elements[1] = v.new ConcreteElementB();

		WorkElementVisitor workVisitor = v.new WorkElementVisitor();
		DataElementVisitor dataVisitor = v.new DataElementVisitor();

		for(Element e : elements) {
			e.accept(workVisitor);
		}

		for(Element e : elements) {
			e.accept(dataVisitor);
		}
	}

	interface Element {
		void accept(ElementVisitor v);
	}

	interface ElementVisitor {
		void visit(ConcreteElementA a);
		void visit(ConcreteElementB b);
	}

	class ConcreteElementA implements Element{
		public void accept(ElementVisitor v) {
			v.visit(this);
		}
	}

	class ConcreteElementB implements Element{
		public void accept(ElementVisitor v) {
			v.visit(this);
		}
	}

	class WorkElementVisitor implements ElementVisitor {
		public void visit(ConcreteElementA a) {
			// do work on a
		}

		public void visit(ConcreteElementB b) {
			// do work on b
		}
	}

	class DataElementVisitor implements ElementVisitor {
		public void visit(ConcreteElementA a) {
			// get data from a
		}

		public void visit(ConcreteElementB b) {
			// get data from b
		}
	}
}