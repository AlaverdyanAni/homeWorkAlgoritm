package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class IntegerListImpl implements IntegerList {
    private int size;
    private Integer[] items;

    public IntegerListImpl(){
        items=new Integer[10];
    }

    public IntegerListImpl(int initsize) {
        items = new Integer[initsize];
    }


    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(Integer item) {
        validateItem(item);
        return add(size,item);
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        if (size == items.length) {
           items = Arrays.copyOf(items, size + 1);
        }
        System.arraycopy(items,index,items,index+1,size-index);
        items[index] = item;
        size++;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        items[index] = item;
        return item;
    }


    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }


    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item=items[index];
        size--;
        if(!(index==size)){
            System.arraycopy(items,index+1,items,index,size-index);
        }
        return items[index];
    }


    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(Integer item) {
       Integer[]itemsCopy=toArray();
       sortInsertion(itemsCopy);
        return binarySearch(itemsCopy,item);
    }


    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size; i > -1; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }


    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public Integer get(int index) {
        validateIndex(index);
        return items[index];
    }


    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }


    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(items,size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private Integer[] grow(int newSize){
        return items=Arrays.copyOf(items,newSize);
    }
    private void swapElements(Integer[]arr,int indexA, int indexB){
        int tmp=arr[indexA];
        arr[indexA]=arr[indexB];
        arr[indexB]=tmp;
    }

    public void sortBubble(Integer arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    swapElements(arr,j,j+1);
                }
            }
        }
    }

    public void sortSelection(Integer[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minElementIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minElementIndex]){
                    minElementIndex=j;
                }
            }
            swapElements(arr,i,minElementIndex);

        }
    }

    public void sortInsertion(Integer[]arr){
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i];
            int j=i;
            while (j>0 && arr[j-1]>=temp){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;

        }
    }



    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arr[mid]) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    public  Integer[] createRandomArray(int size){
        Random random = new Random();
        Integer[]arr = new Integer[size];
        for (int i = 0; i < arr.length ; i++) {
            arr[i]=random.nextInt(size);
        }
        return arr;
    }

}







