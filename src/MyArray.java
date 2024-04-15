public class MyArray {
    private int[] numbers;
    private int count;


    MyArray(int length){
        this.numbers = new int[length];
    }

    public void insert(int item){
        if (this.count == this.numbers.length){
            int[] newNumbers = new int [count * 2];
            for (int i = 0; i < this.count; i++){
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        this.numbers[count++] = item;
    }

    public void removeAt(int index){
        if (index < 0 || index >= this.count){
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count; i++){
            numbers[i] = numbers[i+1];
        }
        count--;
    }

    public int indexOf(int item){
        for (int i = 0; i < this.count; i++){
            if (numbers[i] == item){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < this.count; i++){
            System.out.println(numbers[i]);
        }
    }
}
