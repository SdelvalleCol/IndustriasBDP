package com.company;

public class ListStack implements StackInterface {

    List ram = new List();

    @Override
    public void clear(){
        ram.clear();
    }
    @Override
    public boolean isEmpty(){
        return ram.isEmpty();
    }
    @Override
    public Object peek(){
        return ram.tail.getObject();
    }
    @Override
    public Object pop(){
        Object data = peek();
        ram.remove(ram.tail);
        return data;
    }
    @Override
    public void push(Object object){
        ram.add(object);
    }
    @Override
    public int size(){
        return ram.getSize();
    }
    @Override
    public Object search(Object object){
        return ram.search(object).getObject();
    }
    @Override
    public void sort(){ ram.sortList(); }
    @Override
    public void reverse(){
        ListStack ram2 = new ListStack();
        while(!isEmpty()){
            ram2.push(pop());
        }while (ram2.isEmpty()){
            ram.add(ram2.pop());
        }
    }
    @Override

    public String toString(){
        String alma = "";
        while (!isEmpty()){
            alma += pop().toString();
        }
        return alma;
    }
}
