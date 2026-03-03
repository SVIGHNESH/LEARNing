class MyStackImplementation{
    int top;
    int capacity;
    int stack[];
    MyStackImplementation(int size){
        this.capacity = size;
        this.stack = new int[capacity];
        this.top = -1;
    }
    void push(int x){
        if(top == capacity - 1){
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = x;

    }
    int pop(){
        if(top == -1){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }
    int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }
    int size(){
        return top + 1;
    }
    

}