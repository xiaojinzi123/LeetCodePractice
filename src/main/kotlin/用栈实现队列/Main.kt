package 用栈实现队列

private class MyQueue() {

    private val stack1 = java.util.Stack<Int>()
    private val stack2 = java.util.Stack<Int>()

    fun push(x: Int) {
        stack1.push(x)
    }

    fun pop(): Int {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }

    fun peek(): Int {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.peek()
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

}

fun main() {

}