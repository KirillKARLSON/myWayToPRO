package MakeOwnTreeWithAbstrList;


import java.io.Serializable;
import java.util.*;

public class AbstrListKid extends AbstractList<String> {

    Entry root; // = new Entry<>("Древо");
    int count;
    int rootCount = 0;




   // Entry r = new Entry("paper");

    //String p = r.getParent().elementName;
    //Entry z = Entry("paper");


    Map<Integer, Entry> objIn = new HashMap<>();

//Сейчас добавляю в дерево элементы, меняя корень системой счетчика корней
    @Override
    public boolean add(String elem) {
        if (root == null) {
            root = new Entry<>(elem);
            objIn.put(count, root);
            count+=1;
            //rootCount++;
            return true;
        } else if (root.isAvailableToAddChildren()) {
                addNewChild(root, elem);
                //root = objIn.get(rootCount++);
        } else if(!root.isAvailableToAddChildren()){
            root = objIn.get(rootCount++);

            if (root.isAvailableToAddChildren()){
                addNewChild(root, elem);
                //root = root.leftChild;

            }/*else if (root.rightChild.isAvailableToAddChildren()){
                //root = root.rightChild;
                addNewChild(root.rightChild, elem);
                //root = root.rightChild;
            }*/
        }

        return true;
    }

    private void addNewChild(Entry root, String elem){
        if (root.availableToAddLeftChildren) {
            root.leftChild = new Entry<>(elem);
            root.leftChild.setParent(root);


            objIn.put(count, root.leftChild);

            count+=1;

            root.availableToAddLeftChildren = false;
            //return true;

        } else if (root.availableToAddRightChildren) {
            root.rightChild = new Entry<>(elem);
            root.rightChild.setParent(root);
            objIn.put(count, root.rightChild);
            count+=1;

            root.availableToAddRightChildren = false;
            //return true;
        }
    }


    @Override
    public String get(int index) {
        return objIn.get(index).elementName;
    }


    //Не вызывается этот метод, хз почему. Разобраться!!! Логика заебок

    public String getParent (String s){



        for (Map.Entry<Integer, Entry> entry:objIn.entrySet()){
            if (s.equals(entry.getValue().elementName)) return entry.getValue().getParent().elementName;


        }
        return null;
    }




    @Override
    public String set(int index, String element){
        return null;
    }

    @Override
    public void add(int index, String element){

    }

    @Override
    public String remove(int index){

        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex){
        return null;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex){

    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        return true;
    }


    @Override
    public int size() {
        return count;
    }



    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry (String name){
            this.elementName = name;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren||availableToAddRightChildren;
        }


        public void setParent(Entry parent){
            this.parent = parent;
        }

        public Entry<T> getParent() {
            return this.parent;
        }

        public String getElementName() {
            return elementName;
        }
    }
}
