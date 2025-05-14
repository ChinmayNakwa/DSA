class genericClass<T1, T2> {
    private T1 data1;
    private T2 data2;

    public genericClass(T1 data1, T2 data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public void getData() {
        System.out.println("Data1 " + data1);
        System.out.println("Data2: " + data2);
    }
}

class generic {
    public static void main(String args[]) {
        genericClass<Integer, Double> intObj = new genericClass<>(5, 34.5);
        intObj.getData();

        genericClass<String, Character> stObj = new genericClass<>("java", 'X');
        stObj.getData();
    
    }
}