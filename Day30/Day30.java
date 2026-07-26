/*Problem: Polynomial Using Linked List - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of terms)
- Next n lines: two integers (coefficient and exponent)

Output:
- Print polynomial in standard form, e.g., 10x^4 + 20x^3 + 30x^2 + 40x + 50*/
import java.util.Scanner;
class Node {
    int coeff;
    int exp;
    Node next;

    public Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
    }
}
class Polynomial {
    private Node head;

    public Polynomial() {
        this.head = null;
    }

    public void addTerm(int coeff, int exp) {
        if (coeff == 0) return;

        Node newNode = new Node(coeff, exp);
        if (head == null || exp > head.exp) {
            newNode.next = head;
            head = newNode;
            return;
        }
        if (head.exp == exp) {
            head.coeff += coeff;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.exp > exp) {
            current = current.next;
        }
        if (current.next != null && current.next.exp == exp) {
            current.next.coeff += coeff;
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public void display() {
        if (head == null) {
            System.out.println("0");
            return;
        }

        Node current = head;
        boolean isFirst = true;

        while (current != null) {
            int c = current.coeff;
            int e = current.exp;

            if (c != 0) {
                if (isFirst) {
                    if (c < 0) {
                        System.out.print("-");
                    }
                    isFirst = false;
                } else {
                    if (c > 0) {
                        System.out.print(" + ");
                    } else {
                        System.out.print(" - ");
                    }
                }

                int absCoeff = Math.abs(c);
                if (absCoeff != 1 || e == 0) {
                    System.out.print(absCoeff);
                }
                if (e == 1) {
                    System.out.print("x");
                } else if (e > 1) {
                    System.out.print("x^" + e);
                }
            }

            current = current.next;
        }
        System.out.println();
    }
}
public class Day30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Polynomial poly = new Polynomial();
        for (int i = 0; i < n; i++) {
            int coeff = sc.nextInt();
            int exp = sc.nextInt();
            poly.addTerm(coeff, exp);
        }
        poly.display();

        sc.close();
    }
}