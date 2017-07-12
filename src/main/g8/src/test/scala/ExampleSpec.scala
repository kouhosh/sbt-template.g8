import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {
  trait Stack[A] {
    def push(a: A): (Unit, Stack[A])
    def pop: (A, Stack[A])
  }

  case class ListStack[A](l: List[A]) extends Stack[A] {
    def push(a: A): (Unit, Stack[A]) = ((), ListStack(a :: l))
    def pop: (A, Stack[A]) = (l.head, ListStack(l.tail))
  }

  "A Stack" should "pop values in last-in-first-out order" in {
    val s = ListStack(List.empty[Int])
    val (_, s1) = s.push(1)
    val (_, s2) = s1.push(2)
    val (a1, s3) =  s2.pop
    val (a2, _) = s3.pop
    a1 should be (2)
    a2 should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = ListStack(List.empty[Int])
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop
    }
  }
}
